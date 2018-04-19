package com.ikentop.biz.provider.service.dev;

import com.ikentop.biz.provider.service.CodeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author tac
 * @since 18/09/2017
 */

@Service
@Profile("ut")
public class CodeService4UT extends CodeService {

    public String generateStaffCode(){
        return "SF" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (new Random().nextInt(8999999) + 1000000);
    }

}
