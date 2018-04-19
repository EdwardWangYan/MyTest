package com.ikentop.biz.provider.service;

import com.ikentop.biz.constant.VerificationCodeStatus;
import com.ikentop.biz.model.entity.VerificationCode;
import com.ikentop.biz.provider.dao.VerificationCodeDao;
import com.ikentop.biz.provider.util.SmsUtils;
import com.ikentop.biz.provider.util.VerificationCodeUtils;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author Huqiao
 * @since 2017/12/20
 */
@Service
@Transactional
public class VerificationCodeService extends GenericServiceSupport<VerificationCodeDao> {
    private final int EXPIRATION_TIME = 30;
    private final String API_KEY = "4931c6ab7f2c4a2ef31b8f5ab71f00df";
    private final int TPL_ID = 2135766;
    private final String ENCODING = "UTF-8";

    @Autowired
    public VerificationCodeService(VerificationCodeDao verificationCodeDao) {
        super(verificationCodeDao);
    }

    /**
     * 发送验证码
     */
    public String sendCode(String receiver) throws IOException {
        verifyReceiver(receiver);
        VerificationCode code = getCodeByReceiver(receiver);
        String vCode = VerificationCodeUtils.verificationCode(4, 1);
        if (null == code) {
            code = new VerificationCode();
            getDao().insert(packageCode(code, receiver, vCode));
        } else {
            //当上一条验证码还没有过期且没有被使用时,验证码沿用上条验证码
            if (Objects.equals(code.getStatus(), VerificationCodeStatus.UNUSED.val) && new Date().compareTo(code.getExpirationTime()) < 0)
                vCode = code.getVerificationCode();
            getDao().update(packageCode(code, receiver, vCode));
        }
        SmsUtils.tplSendSms(API_KEY, TPL_ID, getTplValue(vCode), receiver);
        return code.getPk();
    }

    /**
     * 校验验证码
     */
    public Boolean verifyCode(String receiver, String vCode) {
        verifyReceiver(receiver);
        VerificationCode codeByReceiver = getCodeByReceiver(receiver);
        boolean flag = false;
        if (null != codeByReceiver && Objects.equals(codeByReceiver.getVerificationCode(), vCode)) {
            flag = true;
            codeByReceiver.setStatus(VerificationCodeStatus.USED.val);
            getDao().update(codeByReceiver);
        }
        return flag;
    }

    private VerificationCode packageCode(VerificationCode code, String receiver, String vCode) {
        code.setReceiver(receiver);
        code.setExpirationTime(getDate());
        code.setStatus(VerificationCodeStatus.UNUSED.val);
        code.setVerificationCode(vCode);
        return code;
    }

    private void verifyReceiver(String receiver) {
        // todo:: 通过正则验证手机号
    }

    private String getTplValue(String vCode) throws UnsupportedEncodingException {
        return URLEncoder.encode("#code#", ENCODING) + "="
                + URLEncoder.encode(vCode, ENCODING);
    }

    private VerificationCode getCodeByReceiver(String receiver) {
        VerificationCode code = new VerificationCode();
        code.setReceiver(receiver);
        return getDao().selectOne(code, false);
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
        return calendar.getTime();
    }
}
