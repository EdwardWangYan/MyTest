package com.ikentop.biz.provider.config.shiro;

import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.dao.FunctionDao;
import com.ikentop.biz.provider.dao.OperatorDao;
import com.ikentop.biz.provider.dao.RoleDao;
import com.ikentop.biz.provider.exception.OperatorIsForbiddenException;
import com.ikentop.biz.provider.exception.OperatorIsFreezingException;
import com.ikentop.biz.provider.exception.OperatorIsNotBelongToCurrentOrg;
import com.ikentop.biz.provider.exception.UserAccountOrPasswordException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author : tac
 * @since : 06/09/2017
 */
public class CustomRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    private OperatorDao operatorDao;
    private FunctionDao functionDao;
    private RoleDao roleDao;

    public CustomRealm(OperatorDao operatorDao, FunctionDao functionDao, RoleDao roleDao) {
        this.operatorDao = operatorDao;
        this.functionDao = functionDao;
        this.roleDao = roleDao;
    }

    @Override
    public String getName() {
        return "custom realm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Operator operator = (Operator) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleDao.getRoleNames(operator.getPk()));
        info.setStringPermissions(functionDao.getFunctionValues(operator.getPk()));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        logger.debug("尝试根据用户名获取操作员");
        Operator operator = getAccountByName(t);
        if (!existAccount(operator)) {
            logger.debug("获取失败");
            logger.debug("尝试根据手机号码获取操作员");
            Operator operator4Phone = operatorDao.selectByPhone(t.getUsername());
            if (!existAccount(operator4Phone)) {
                logger.debug("获取失败");
                throw new UserAccountOrPasswordException();
            }else {
                logger.debug("获取成功");
            }
            operator = operator4Phone;
        }else {
            logger.debug("获取成功");
        }
        logger.debug("执行校验");
        verifyOperatorStatus(operator);
        logger.debug("校验账号所属机构是否失效");
        if (isDisabledOrg(operator)) {
            throw new OperatorIsNotBelongToCurrentOrg();
        }

        return new SimpleAuthenticationInfo(operator, operator.getPassword(), ByteSource.Util.bytes(operator.getSalt()), getName());
    }

    protected Operator getAccountByName(UsernamePasswordToken t) {
        return operatorDao.selectByUsername(t.getUsername());
    }

    // TODO: 2017/11/6 校验组织是否有效

    protected boolean isDisabledOrg(Operator operator) {
        return false;
    }

    protected boolean existAccount(Operator operator) {
        return operator != null;
    }

    protected void verifyOperatorStatus(Operator operator) {
        logger.debug("校验账号是否被禁用");
        if (Objects.equals(operator.getStatus(), OperatorStatus.FORBIDDEN.val))
            throw new OperatorIsForbiddenException();
        logger.debug("校验账号是否被冻结");
        if (Objects.equals(operator.getStatus(), OperatorStatus.FREEZING.val))
            throw new OperatorIsFreezingException();
    }
}
