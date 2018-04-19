package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/22
 */
public class AreaDetailInfo {
    @ApiModelProperty(value = "地区id")
    private String id;
    @ApiModelProperty(value = "父id")
    private String parentId;
    @ApiModelProperty(value = "父名称")
    private String parentName;
    @ApiModelProperty(value = "层别")
    private Integer areaLevel;
    @ApiModelProperty(value = "行政代码")
    private String areaCode;
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;
    @ApiModelProperty(value = "区号")
    private String cityCode;
    @ApiModelProperty(value = "名称")
    private String areaName;
    @ApiModelProperty(value = "简称")
    private String shortName;
    @ApiModelProperty(value = "组合名")
    private String mergerName;
    @ApiModelProperty(value = "拼音")
    private String pinyin;
    @ApiModelProperty(value = "gps经度")
    private Double gpsLng;
    @ApiModelProperty(value = "gps维度")
    private Double gpsLat;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
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

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Double getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(Double gpsLng) {
        this.gpsLng = gpsLng;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
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
