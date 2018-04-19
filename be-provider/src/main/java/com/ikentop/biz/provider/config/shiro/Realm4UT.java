package com.ikentop.biz.provider.config.shiro;

import com.ikentop.biz.constant.DeletedFlag;
import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.util.EncryptUtils;
import com.ikentop.framework.core.util.IDUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author : tac
 * @since : 06/09/2017
 */
public class Realm4UT extends CustomRealm {
    public Realm4UT() {
        super(null, null, null);
    }


    @Override
    public String getName() {
        return "custom realm for test";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //todo::
        return null;
    }

    @Override
    protected Operator getAccountByName(UsernamePasswordToken t) {
        String salt = "abcd";
        Operator operator = new Operator();
        operator.setPk(IDUtils.UUID());
        operator.setLoginName("tac");
        operator.setPassword(EncryptUtils.encryptPassword("123456", salt));
        operator.setSalt(salt);
        operator.setStatus(OperatorStatus.ACTIVE.val);
        operator.setDeletedFlag(DeletedFlag.ENABLE.getVal());
        return operator;
    }

    @Override
    protected boolean existAccount(Operator operator) {
        return true;
    }

    @Override
    protected void verifyOperatorStatus(Operator operator) {
        return;
    }

    @Override
    protected boolean isDisabledOrg(Operator operator) {
        return false;
    }
}
