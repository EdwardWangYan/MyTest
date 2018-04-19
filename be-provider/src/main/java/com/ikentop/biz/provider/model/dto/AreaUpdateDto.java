package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/22
 */
public class AreaUpdateDto {
    @ApiModelProperty(value = "地区id", required = true)
    @NotBlank(message = "id不能为空")
    private String id;
    @ApiModelProperty(value = "行政代码")
    private String areaCode;
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;
    @ApiModelProperty(value = "区号")
    private String cityCode;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String areaName;
    @ApiModelProperty(value = "简称")
    private String shortName;
    @ApiModelProperty(value = "拼音")
    private String pinyin;
    @ApiModelProperty(value = "地图类型")
    private Integer mapType;
    @ApiModelProperty(value = "地图坐标经度")
    private Double mapLng;
    @ApiModelProperty(value = "地图坐标维度")
    private Double mapLat;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getMapType() {
        return mapType;
    }

    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    public Double getMapLng() {
        return mapLng;
    }

    public void setMapLng(Double mapLng) {
        this.mapLng = mapLng;
    }

    public Double getMapLat() {
        return mapLat;
    }

    public void setMapLat(Double mapLat) {
        this.mapLat = mapLat;
    }
}
