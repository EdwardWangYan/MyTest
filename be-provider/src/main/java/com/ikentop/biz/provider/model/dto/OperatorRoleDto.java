package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
public class OperatorRoleDto {
    @ApiModelProperty(name = "当前操作员id", required = true)
    @NotBlank(message = "操作员id不能为空")
    private String id;

    @ApiModelProperty(name = "角色id的list集合", required = true)
    @NotNull(message = "角色id集合不能为空")
    private List<String> roleIDs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRoleIDs() {
        return roleIDs;
    }

    public void setRoleIDs(List<String> roleIDs) {
        this.roleIDs = roleIDs;
    }


}
