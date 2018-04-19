package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class ResourceListDto extends PaginationRequest {
    @ApiModelProperty(value = "点击资源的id")
    private String id;
    @ApiModelProperty(value = "资源名称")
    private String resourceTitle;
    @ApiModelProperty(value = "资源简介")
    private String summary;

    @ApiModelProperty(value = "操作员id", hidden = true)
    private String operatorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
