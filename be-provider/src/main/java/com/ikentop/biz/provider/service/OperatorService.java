package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.model.entity.OperatorStaff;
import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.config.BizDataInterfaceExt;
import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.dao.OperatorDao;
import com.ikentop.biz.provider.exception.*;
import com.ikentop.biz.provider.model.OperatorLoginResultDto;
import com.ikentop.biz.provider.model.bo.ListByPageBo;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.util.EncryptUtils;
import com.ikentop.biz.provider.util.PasswordUtils;
import com.ikentop.biz.provider.util.ShiroUtils;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Objects;

/**
 * @author Huqiao
 * @author tac
 * @since : 2017/9/5
 */

@Service
@Transactional
public class OperatorService extends GenericServiceSupport<OperatorDao> {
    private static final int ADJUST_MAX_TIMES = 10;
    @Autowired
    private StaffService staffService;
    @Autowired
    private BizDataInterface bizDataInterface;
    @Autowired
    private OperatorStaffService operatorStaffService;
    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    public OperatorService(OperatorDao operatorDao) {
        super(operatorDao);
    }

    /**
     * 为员工创建账号
     */
    public MinOperatorInfo createOperator4Staff(OperatorCreateDto dto) {
        Operator o = verifyCreateDto(dto);
        verifyStaffIsBelongToCurrentOrg(dto.getStaffId());
        String psd = supplementPsd(o);
        getDao().insert(o);
        relateOperatorStaff(o.getPk(), dto.getStaffId());
        return convertOperator2MinOperatorInfo(o, psd);
    }

    /**
     * 为机构创建账号
     */
    public MinOperatorInfo createOperator4Org(OperatorCreateDto dto, String id) {
        Operator o = verifyCreateDto(dto);
        o.setOrgId(id);
        String psd = supplementPsd(o);
        getDao().insert(o);
        relateOperatorStaff(o.getPk(), dto.getStaffId());
        return convertOperator2MinOperatorInfo(o, psd);
    }

    /**
     * 获取当前账号信息
     */
    public OperatorDetailInfo getCurrentOperator() {
        return getDao().getDetail(bizDataInterface.currentUserId());
    }

    /**
     * 登录
     */
    public OperatorLoginResultDto login(OperatorLoginDto dto) {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(dto.getUsername(), dto.getPassword(), dto.getRememberMe()));
        return assemble(ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class), OperatorLoginResultDto.class);
    }

    /**
     * 登出
     */
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 激活
     */
    public Integer active(OperatorActiveDto dto) {
        UserInfo4Session info4Session = ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class);
        if (isActive(info4Session.getStatus()))
            throw new AccountIsActiveException();
        Operator operator = getDao().selectByPrimaryKey(info4Session.getId());
        verifyOldPassword(operator, dto.getOldPassword());
        Integer integer = supplementOperatorInfo(operator, dto);
        logout();
        return integer;
    }

    /**
     * 禁用账号
     */
    public Integer forbidden(String id) {
        assertOperatorIsExist(id);
        Operator operator = new Operator();
        operator.setPk(id);
        operator.setStatus(OperatorStatus.FORBIDDEN.val);
        return getDao().updateByPrimaryKeySelective(operator);
    }

    /**
     * 解除禁用
     */
    public Integer relieveForbidden(String id) {
        assertOperatorIsExist(id);
        Operator operator = new Operator();
        operator.setPk(id);
        operator.setStatus(OperatorStatus.ACTIVE.val);
        return getDao().updateByPrimaryKeySelective(operator);
    }

    /**
     * 修改密码
     */
    public Integer alterPassword(AlterPasswordDto dto) {
        UserInfo4Session info4Session = ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class);
        Operator operator = getDao().selectByPrimaryKey(info4Session.getId());
        verifyOldPassword(operator, dto.getOldPassword());
        operator.setPassword(EncryptUtils.encryptPassword(dto.getNewPassword(), operator.getSalt()));
        int i = getDao().updateByPrimaryKeySelective(operator);
        //修改密码后清空session
        logout();
        return i;
    }

    public DataTableResponse<OperatorListInfo> list(OperatorListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        dto.setOrgId(bizDataInterface.currentOrgId());
        dto.setCurrentOrgType(currentOrgType());
        List<OperatorListInfo> list = getDao().list(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(list));
    }

    /**
     * 重置密码
     */
    public MinOperatorInfo resetPassword(String id) {
        assertOperatorIsExist(id);
        Operator o = getDao().selectByPrimaryKey(id, false);
        String psw = PasswordUtils.createPassWord();
        o.setPassword(EncryptUtils.encryptPassword(psw, o.getSalt()));
        getDao().updateByPrimaryKeySelective(o);
        return convertOperator2MinOperatorInfo(o, psw);
    }

    public OperatorDetailInfo getUserInfo(String id) {
        //todo::
        throw new NotImplementedException();
    }

    public String createWorkOrder(RetrievePasswordDto dto) {
        WorkOrderCreate4RetrievePasswordDto createDto = new WorkOrderCreate4RetrievePasswordDto();
        createDto.setExtJson(dto);
        return workOrderService.create4RetrievePassword(createDto);
    }

    /**
     * 找回密码
     */
    public MinOperatorInfo retrievePassword(RetrievePasswordDto dto, RetrievePasswordExtDto dtoDto) {
        Operator operator = getDao().selectByUsername(dto.getLoginName());
        if (null == operator)
            throw new OperatorNotFoundException();
        MinOperatorInfo operatorInfo = resetPasswordAndStatus(operator.getPk(), dtoDto.getPassword());
        // TODO: 2017/11/17 短信发送
        return operatorInfo;
    }

    /**
     * 更新个人信息
     */
    public Integer updateCurrentOperator(CurrentOperatorUpdateDto dto) {
        int num = 0;
        Operator operator = new Operator();
        operator.setPk(bizDataInterface.currentUserId());
        operator.setPortraitFileId(dto.getPortraitFileId());
        num += getDao().updateByPrimaryKeySelective(operator);
        if (null != getStaffId(operator.getPk())) {
            dto.setId(getStaffId(operator.getPk()));
        } else {
            throw new OperatorNotHaveStaffException();
        }
        num += staffService.update4Operator(dto);
        return num;
    }

    public DataTableResponse<AccountInfo> listByPage(OperatorListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        ListByPageBo bo = assemble(dto, ListByPageBo.class);
        PageInfo<AccountInfo> info = new PageInfo<>(getDao().listByPage(bo));
        return DataTableResponse.fromPageInfo(info);
    }


    protected boolean isActive(Integer status) {
        return Objects.equals(status, OperatorStatus.ACTIVE.val);
    }

    protected String currentOrgType() {
        return ((BizDataInterfaceExt) bizDataInterface).currentOrgType();
    }

    private void verifyStaffIsBelongToCurrentOrg(String staffId) {
        Staff staff = getStaff(staffId);
        if (!isCurrentOrgStaff(staff)) {
            throw new StaffNotBelongToCurrentOrgException();
        }
    }

    protected Operator getOperator(String id) {
        return getDao().selectByPrimaryKey(id, false);
    }

    protected boolean isCurrentOrgStaff(Staff staff) {
        return staffService.isCurrentOrg(staff);
    }

    protected Staff getStaff(String staffId) {
        return staffService.getDao().selectByPrimaryKey(staffId, false);
    }

    protected void throwIfExistAccount(String username) {
        if (existUsername(username)) {
            throw new AccountIsAlreadyExistException();
        }
    }


    protected boolean existUsername(String username) {
        return getDao().selectByUsername(username) != null;
    }

    protected String supplementPsd(Operator o) {
        String psd = o.getPassword();
        if (null == psd || "".equals(psd.trim()))
            psd = PasswordUtils.createPassWord();
        String salt = EncryptUtils.getSalt(o.getLoginName());
        o.setPassword(EncryptUtils.encryptPassword(psd, salt));
        o.setSalt(salt);
        o.setStatus(OperatorStatus.INACTIVE.val);
        return psd;
    }

    void assertOperatorIsExist(String id) {
        if (null == id)
            throw new OperatorIdNotBeNullException();
        Boolean flag = false;
        OperatorListDto dto = new OperatorListDto();
        dto.setOrgId(bizDataInterface.currentOrgId());
        dto.setCurrentOrgType(currentOrgType());
        List<OperatorListInfo> list = getDao().list(dto);
        for (OperatorListInfo o : list) {
            if (Objects.equals(id, o.getId())) {
                flag = true;
                break;
            }
        }
        if (!flag)
            throw new OperatorNotFoundException();
    }

    protected MinOperatorInfo convertOperator2MinOperatorInfo(Operator o, String psd) {
        MinOperatorInfo info = new MinOperatorInfo();
        info.setId(o.getPk());
        info.setLoginName(o.getLoginName());
        info.setPassword(psd);
        return info;
    }


    /**
     * 关联操作员和员工
     */
    private void relateOperatorStaff(String pk, String staffId) {
        operatorStaffService.relateOperatorStaff(pk, staffId);
    }

    private String getStaffId(String pk) {
        return operatorStaffService.getStaffId(pk);
    }


    private void verifyStaffIsAlreadyRelatedOperator(String staffId) {
        OperatorStaff o = new OperatorStaff();
        o.setStaffId(staffId);
        if (operatorStaffService.getDao().selectCount(o) > 0)
            throw new StaffIsAlreadyRelatedOperatorException();
    }

    private Operator verifyCreateDto(OperatorCreateDto dto) {
        throwIfExistAccount(dto.getLoginName());
        verifyStaffIsNull(dto.getStaffId());
        verifyStaffIsAlreadyRelatedOperator(dto.getStaffId());
        return assemble(dto, Operator.class);
    }

    private MinOperatorInfo resetPasswordAndStatus(String id, String password) {
        assertOperatorIsExist(id);
        Operator o = getDao().selectByPrimaryKey(id, false);
        if (StringUtils.isBlank(password))
            password = PasswordUtils.createPassWord();
        o.setPassword(EncryptUtils.encryptPassword(password, o.getSalt()));
        o.setStatus(OperatorStatus.INACTIVE.val);
        getDao().updateByPrimaryKeySelective(o);
        return convertOperator2MinOperatorInfo(o, password);
    }

    private void verifyOldPassword(Operator operator, String oldPassword) {
        if (!Objects.equals(operator.getPassword(), EncryptUtils.encryptPassword(oldPassword, operator.getSalt())))
            throw new OperatorOldPasswordIsWrongException();
    }

    private void verifyStaffIsNull(String staffId) {
        Staff staff = getStaff(staffId);
        if (staff == null) {
            throw new StaffNotExistException();
        }
    }

    private Integer supplementOperatorInfo(Operator operator, OperatorActiveDto dto) {
        operator.setPassword(EncryptUtils.encryptPassword(dto.getNewPassword(), operator.getSalt()));
        operator.setStatus(OperatorStatus.ACTIVE.val);
        return getDao().updateByPrimaryKeySelective(operator);
    }
}
