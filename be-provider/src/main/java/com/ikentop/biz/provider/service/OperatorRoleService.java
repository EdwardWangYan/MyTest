package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.model.entity.OperatorRole;
import com.ikentop.biz.provider.dao.OperatorRoleDao;
import com.ikentop.biz.provider.exception.OperatorIsNotBelongToCurrentOrg;
import com.ikentop.biz.provider.exception.OperatorNotFoundException;
import com.ikentop.biz.provider.exception.RoleIdCanNotNullException;
import com.ikentop.biz.provider.model.dto.OperatorRoleDto;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Huqiao
 * @since : 2017/9/8
 */
@Service
@Transactional
public class OperatorRoleService extends GenericServiceSupport<OperatorRoleDao> {

    @Autowired
    public OperatorRoleService(OperatorRoleDao operatorRoleDao) {
        super(operatorRoleDao);
    }

    @Autowired
    private BizDataInterface bizDataInterface;
    @Autowired
    private OperatorService operatorService;


    /**
     * 为操作员分配角色
     *
     * @param dto 包含操作员id和角色id集合
     */
    public Integer allotRole4Operator(OperatorRoleDto dto) {
        throwIfNotBelongToCurrentOrg(dto.getId());
        verifyRoleIdsIsNull(dto.getRoleIDs());
        emptyOperatorRole(dto.getId());
        OperatorRole operatorRole = null;
        List<OperatorRole> list = new ArrayList<>();
        for (String roleId : dto.getRoleIDs()) {
            operatorRole = new OperatorRole();
            operatorRole.setOperatorId(dto.getId());
            operatorRole.setRoleId(roleId);
            list.add(operatorRole);
        }
        return getDao().insertBatch(list);
    }

    private void emptyOperatorRole(String id) {
        getDao().emptyOperatorRole(id);
    }

    /**
     * 判断操作员是否属于当前组织
     */
    protected void throwIfNotBelongToCurrentOrg(String id) {
        if (NotBelongToCurrentOrg(id)) {
            throw new OperatorIsNotBelongToCurrentOrg();
        }
    }

    protected boolean NotBelongToCurrentOrg(String id) {
        Operator operator = operatorService.getOperator(id);
        if (operator == null) {
            throw new OperatorNotFoundException();
        }
        return !Objects.equals(operator.getOrgId(), bizDataInterface.currentOrgId());
    }

    protected void relateOperatorRole(String id, String roleId) {
        OperatorRole o = new OperatorRole();
        o.setOperatorId(id);
        o.setRoleId(roleId);
        getDao().insert(o);
    }


    private void verifyRoleIdsIsNull(List<String> roleIDs) {
        if (null == roleIDs)
            throw new RoleIdCanNotNullException();
    }
}
