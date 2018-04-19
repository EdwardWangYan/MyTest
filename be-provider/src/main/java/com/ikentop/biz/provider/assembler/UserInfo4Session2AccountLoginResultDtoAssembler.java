package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.provider.model.OperatorLoginResultDto;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author tac
 * @since 2017/9/12
 */
@Component
public class UserInfo4Session2AccountLoginResultDtoAssembler extends Assembler<UserInfo4Session, OperatorLoginResultDto> {
    @Autowired
    public UserInfo4Session2AccountLoginResultDtoAssembler(AssemblerFactory factory) {
        factory.put(this, UserInfo4Session.class, OperatorLoginResultDto.class);
    }

    @Override
    public OperatorLoginResultDto assemble(UserInfo4Session userInfo4Session) {
        OperatorLoginResultDto dto = new OperatorLoginResultDto();
        dto.setOperatorId(userInfo4Session.getId());
        dto.setActive(Objects.equals(userInfo4Session.getStatus(), OperatorStatus.ACTIVE.val));
        return dto;
    }
}
