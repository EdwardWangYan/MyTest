package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
public class SearchForAreaDto extends PaginationRequest {
    @ApiModelProperty(value = "父级id", required = true)
    @NotBlank(message = "父级id不能为空")
    private String parentId;
    @ApiModelProperty(value = "行政id号")
    private String id;
    @ApiModelProperty(value = "行政代码")
    private String areaCode;
    @ApiModelProperty(value = "行政地区名称")
    private String areaName;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
