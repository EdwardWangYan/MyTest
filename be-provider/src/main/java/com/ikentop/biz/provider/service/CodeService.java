package com.ikentop.biz.provider.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author tac
 * @since 18/09/2017
 */

@Service
@Profile({"dev", "test", "prod"})
@Transactional
public class CodeService {
    public String generateStaffCode(){
        //todo::
        throw new NotImplementedException();
    }
}
