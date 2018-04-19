package com.ikentop.biz.constant;

/**
 * @author : tac
 * @since : 14/09/2017
 */
public enum ResourceLevel {
    MODULE(1, null, "模块"),
    MENU(2, MODULE, "菜单"),
    PAGE(3, MENU, "页面"),
    OPERATION(4, PAGE, "操作"),;

    private int val;
    private ResourceLevel parent;
    private String desc;

    public int getVal() {
        return val;
    }

    public ResourceLevel getParent() {
        return parent;
    }

    public String getDesc() {
        return desc;
    }

    ResourceLevel(int val, ResourceLevel parent, String desc) {
        this.val = val;
        this.parent = parent;
        this.desc = desc;
    }
}
