package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/17
 */
public class CityRanking {
    @ApiModelProperty(value = "排名")
    private Integer pank;
    @ApiModelProperty(value = "城市名")
    private String city;
    @ApiModelProperty(value = "次数/年")
    private Integer num;

    public Integer getPank() {
        return pank;
    }

    public void setPank(Integer pank) {
        this.pank = pank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
