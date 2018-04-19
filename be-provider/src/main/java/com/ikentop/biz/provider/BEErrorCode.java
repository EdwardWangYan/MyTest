package com.ikentop.biz.provider;

import com.ikentop.framework.core.pojo.ErrorCode;
import com.ikentop.framework.core.pojo.ErrorMessage;

import java.util.HashMap;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public enum BEErrorCode implements ErrorCode {
    DATA_NOT_EXIST("1001"),
    PARAM_IS_NULL("1002"),
    USER_ACCOUNT_OR_PASSWORD_ERROR("1003"),
    ACCOUNT_DISABLED_ERROR("1004"),
    USER_NOT_LOGIN("1005"),
    ACCOUNT_TYPE_IS_NULL("1006"),
    STAFF_NOT_EXIST_ERROR("1007"),
    DEPARTMENT_IS_NULL("1008"),
    ACCOUNT_IS_ALREADY_EXIST("1009"),
    OPERATOR_IS_NOT_BELONG_TO_CURRENT_ORG("1010"),
    ACCOUNT_IS_ALREADY_ACTIVE("1011"),
    STAFF_NOT_BELONG_TO_CURRENT_ORG("1012"),
    ACCOUNT_UNAUTHENTICATED_ERROR("1013"),
    SESSION_NULL_ERROR("1014"),
    ORGANIZATION_NOT_FOUND_ERROR("1015"),
    RESOURCE_NOT_FOUND_ERROR("1016"),
    RESOURCE_CREATE_ERROR("1017"),
    ROLE_CODE_REPEAT_ERROR("1018"),
    REPEATED_DEPARTMENT_CODE_ERROR("1019"),
    ROLE_NOT_FOUND_ERROR("1020"),
    DEPARTMENT_NOT_FOUND_ERROR("1021"),
    ACCOUNT_UNAUTHORIZED_ERROR("1022"),
    ACCOUNT_NOT_FOUND_ERROR("1023"),
    FUNCTION_CONNOT_CREATE("1024"),
    FUNCTION_PARENTID_IS_WRONG("1025"),
    FUNCTION_NOT_FOUND("1026"),
    ORGTYPE_TITLE_IS_ALREADY("1027"),
    DICTIONARY_IS_NOT_EXIST("1028"),
    DICTIONARY_IS_CHILD("1029"),
    ORGTYPE_CODE_ALREADY_EXIST("1030"),
    ORGTYPE_CONNOT_NULl("1031"),
    ORGTYPE_IS_NOT_EXIST("1032"),
    DEPARTMENT_IS_NOT_EXIST("1033"),
    RESOURCE_UPDATE_ERROR("1034"),
    FUNCTION_PERMISSION_VALUE_IS_ALREADY_EXIST("1035"),
    OPERATOR_HAVE_NO_PERMISSION("1036"),
    OPERATOR_STATUS_IS_INVALID("1037"),
    ROLEIDS_CAN_NOT_BE_NULL("1038"),
    STAFF_IS_ALREADY_RELATED_OPERATOR("1039"),
    ORG_APPROVE_IS_ALREADY_EXIST("1040"),
    STAFF_ALREADY_HAVE_OPERATOR("1041"),
    OPERATOR_IS_INACTIVE("1042"),
    OPERATOR_IS_FORBIDDEN("1043"),
    OPERATOR_IS_FREEZING("1044"),
    ROLE_NOT_BELONG_TO_CURRENT_ORG("1045"),
    DICTIONARY_CODE_IS_ALREADY_EXIST("1046"),
    OPERATOR_OLD_PASSWORD_IS_WRONG("1047"),
    DICTIONARY_CODE_IS_WRONG("1048"),
    WORK_ORDER_EXT_JSON_IS_WRONG("1049"),
    WORK_ORDER_NOT_FOUND("1050"),
    WORK_ORDER_IS_ALREADY_DISPOSED("1051"),
    WORK_ORDER_TYPE_IS_MISMATCHING("1052"),
    OPERATOR_NOT_HAVE_STAFF("1053"),
    MEMBER_TYPE_IS_NOT_EXIST("1054"),
    AREA_IS_NOT_EXIST("1055"),
    STAFF_MOBILE_IS_ALREADY_EXIST("1056"),
    OPERATOR_ID_NOT_BE_NULL("1057"),
    EVENT_TYPE_CON_NOT_NULL("1058"),
    EVENT_TYPE_IS_WRONG("1059"),
    EVENT_STATUS_IS_NOT_MATCHING("1060"),
    EVENT_CON_NOT_FOUND("1061"),
    EVENT_UPDATE_PERMISSION("1062"),
    GROUP_CON_NOT_FOUND("1063"),
    GROUP_APPLY_TIME("1064"),
    GROUP_PAY_TIME("1065"),
    GROUP_TYPE_IS_WRONG("1066"),
    STINT_MODEL_IS_WRONG("1067"),
    STINT_MAX_COUNT_IS_WRONG("1068"),
    OPTION_CON_NOT_FOUND("1069"),
    EVENT_COMMIT_PERMISSION("1070"),
    GROUP_NOT_BE_CREATED("1071"),
    OPTION_NOT_BE_CREATED("1072"),
    AGE_LIMIT_IS_WRONG("1073"),
    AGE_RANGE_IS_WRONG("1074"),
    GENDER_LIMIT_IS_WRONG("1075"),
    FEE_MODE_IS_WRONG("1076"),
    FEE_IS_WRONG("1077"),
    TEAM_COUNT_IS_WRONG("1078"),
    TEAM_GENDER_LIMIT_IS_WRONG("1079"),
    FEMALE_COUNT_IS_WRONG("1080"),
    CHILD_COUNT_IS_WRONG("1081"),
    PARENT_COUNT_IS_WRONG("1082"),
    APPLY_WAY_IS_WRONG("1083"),
    OPTION_TYPE_IS_WRONG("1084"),
    APPLY_CON_NOT_FOUND("1085"),
    APPLY_IS_ALREADY_CHECK("1086"),
    USER_LOGIN_NAME_IS_WRONG("1087"),
    USER_PASSWORD_IS_WRONG("1088"),
    BIRTHDAY_IS_WRONG("1089"),
    USER_NOT_FOUND("1090"),
    USER_CHANGE_PASSWORD("1091"),
    USER_CHANGE_PHONE("1092"),
    PC_USER_ACCOUNT_IS_ALREADY_EXIST("1093"),
    GROUP_APPLY_TIMES("1094"),
    EVENT_APPLY_TIME("1095"),
    GROUP_ROLE_CON_NOT_FOUNT("1096"),
    GROUP_ROLE_IS_ALREADY_RELATED("1097"),
    EVENT_COMMIT_VERIFY("1098"),
    VERIFICATION_CODE_TYPE_IS_WRONG("1099"),
    UNSUPPORTED_PAYMENT_METHOD_ERROR("1100"),
    IMAGE_CODE_VERIFY_FAILED("1101"),
    PAGE_PAYMENT_CREATION_ERROR("1102"),
    VERIFICATION_CODE_IS_WRONG("1103"),
    REFUND_CONDITION_IS_WRONG("1104"),
    REFUND_IS_WRONG("1105"),
    USER_CHANGE_MAIL("1106"),
    UNSUPPORTED_CERTIFICATION_ERROR("1107"),
    USER_CERTIFICATION_ERROR("1108"),
    FORBIDDEN_EVENT_OPERATION_ERROR("1109"),
    APPLY_NOT_BELONG_TO_USER_ERROR("1110"),
    PAY_VALID_TIME_IS_WRONG("1111"),
    GROUP_CONFIG_NODE_VALUE_FORMAT_ERROR("1112"),
    EVENT_APPLY_VALIDATION_ERROR("1113"),
    GROUP_ROLE_ID_CON_NOT_BE_NULL("1114"),
    GROUP_FIELDS_NOT_FOUND("1115"),
    GROUP_ROLE_FEE_ID_IS_NULL("1116"),
    SUBMIT_APPLY_ERROR("1117"),
    CONFIRM_MEMBER_ERROR("1118"),
    REMOVE_MEMBER_ERROR("1119"),
    APPLY_MEMBER_STATUS_CHANGING_ERROR("1120"),
    APPLY_ORDER_NOT_EXIST_ERROR("1121"),
    APPLY_ORDER_PAYMENT_ERROR("1122"),
    APPLY_ORDER_ALREADY_EXIST_ERROR("1123"),
    EVENT_TIME_IS_WRONG("1124"),
    APPLY_MEMBER_IS_NOT_UNIQUE("1125"),
    EVENT_APPLY_ORDER_NOT_FOUND("1126"),
    APPLY_REFUND_ERROR("1127"),
    APPLY_PAYMENT_NOT_FOUND("1128");

    private static HashMap<ErrorCode, String> map = new HashMap<>();

    static {
        map.put(BEErrorCode.DATA_NOT_EXIST, "数据不存在");
        map.put(BEErrorCode.PARAM_IS_NULL, "参数为空");
        map.put(BEErrorCode.USER_ACCOUNT_OR_PASSWORD_ERROR, "用户名或密码错误");
        map.put(BEErrorCode.ACCOUNT_DISABLED_ERROR, "用户已注销");
        map.put(BEErrorCode.USER_NOT_LOGIN, "用户没有登录");
        map.put(BEErrorCode.ACCOUNT_TYPE_IS_NULL, "账号的类型为空");
        map.put(BEErrorCode.STAFF_NOT_EXIST_ERROR, "员工信息为空");
        map.put(BEErrorCode.DEPARTMENT_IS_NULL, "部门信息为空");
        map.put(BEErrorCode.ACCOUNT_IS_ALREADY_EXIST, "用户名已存在");
        map.put(BEErrorCode.OPERATOR_IS_NOT_BELONG_TO_CURRENT_ORG, "账户组织ID与当前组织不匹配");
        map.put(BEErrorCode.ACCOUNT_IS_ALREADY_ACTIVE, "账号已激活");
        map.put(BEErrorCode.STAFF_NOT_BELONG_TO_CURRENT_ORG, "该员工不属于当前组织");
        map.put(BEErrorCode.ACCOUNT_UNAUTHENTICATED_ERROR, "用户未登陆");
        map.put(BEErrorCode.SESSION_NULL_ERROR, "Session不存在");
        map.put(BEErrorCode.ORGANIZATION_NOT_FOUND_ERROR, "组织机构未找到");
        map.put(BEErrorCode.RESOURCE_NOT_FOUND_ERROR, "未找到指定资源");
        map.put(BEErrorCode.RESOURCE_CREATE_ERROR, "资源创建失败：%s");
        map.put(BEErrorCode.ROLE_CODE_REPEAT_ERROR, "角色code重复");
        map.put(BEErrorCode.REPEATED_DEPARTMENT_CODE_ERROR, "部门code重复");
        map.put(BEErrorCode.ROLE_NOT_FOUND_ERROR, "角色不存在");
        map.put(BEErrorCode.DEPARTMENT_NOT_FOUND_ERROR, "部门不存在");
        map.put(BEErrorCode.ACCOUNT_UNAUTHORIZED_ERROR, "账号权限不足");
        map.put(BEErrorCode.ACCOUNT_NOT_FOUND_ERROR, "账号不存在");
        map.put(BEErrorCode.FUNCTION_CONNOT_CREATE, "功能为操作,不能创建功能");
        map.put(BEErrorCode.FUNCTION_PARENTID_IS_WRONG, "功能父id错误");
        map.put(BEErrorCode.FUNCTION_NOT_FOUND, "该权限不存在");
        map.put(BEErrorCode.ORGTYPE_TITLE_IS_ALREADY, "机构类型名称已存在");
        map.put(BEErrorCode.DICTIONARY_IS_NOT_EXIST, "该数据字典不存在");
        map.put(BEErrorCode.DICTIONARY_IS_CHILD, "该数据字典为子类,不能创建下级字典");
        map.put(BEErrorCode.ORGTYPE_CODE_ALREADY_EXIST, "机构类型的编码已存在");
        map.put(BEErrorCode.ORGTYPE_CONNOT_NULl, "机构类型的orgTypeCode不能为空");
        map.put(BEErrorCode.ORGTYPE_IS_NOT_EXIST, "机构类型不存在");
        map.put(BEErrorCode.DEPARTMENT_IS_NOT_EXIST, "该部门不存在");
        map.put(BEErrorCode.RESOURCE_UPDATE_ERROR, "资源修改失败：%s");
        map.put(BEErrorCode.FUNCTION_PERMISSION_VALUE_IS_ALREADY_EXIST, "权限字符串已经存在");
        map.put(BEErrorCode.OPERATOR_HAVE_NO_PERMISSION, "你没有权限执行此操作");
        map.put(BEErrorCode.OPERATOR_STATUS_IS_INVALID, "帐号的状态无效");
        map.put(BEErrorCode.ROLEIDS_CAN_NOT_BE_NULL, "角色id列表不能为空");
        map.put(BEErrorCode.STAFF_IS_ALREADY_RELATED_OPERATOR, "该员工已开通账号");
        map.put(BEErrorCode.ORG_APPROVE_IS_ALREADY_EXIST, "该组织已经存在认证信息");
        map.put(BEErrorCode.STAFF_ALREADY_HAVE_OPERATOR, "该员工已拥有账号");
        map.put(BEErrorCode.OPERATOR_IS_INACTIVE, "该账号未激活");
        map.put(BEErrorCode.OPERATOR_IS_FORBIDDEN, "该账号被禁用");
        map.put(BEErrorCode.OPERATOR_IS_FREEZING, "该账号被冻结");
        map.put(BEErrorCode.ROLE_NOT_BELONG_TO_CURRENT_ORG, "该角色不属于当前组织");
        map.put(BEErrorCode.DICTIONARY_CODE_IS_ALREADY_EXIST, "数据字典code已存在");
        map.put(BEErrorCode.OPERATOR_OLD_PASSWORD_IS_WRONG, "账号旧密码错误");
        map.put(BEErrorCode.DICTIONARY_CODE_IS_WRONG, "数据字典code错误");
        map.put(BEErrorCode.WORK_ORDER_EXT_JSON_IS_WRONG, "工单扩展字段信息错误");
        map.put(BEErrorCode.WORK_ORDER_NOT_FOUND, "工单不存在");
        map.put(BEErrorCode.WORK_ORDER_IS_ALREADY_DISPOSED, "工单已被处理");
        map.put(BEErrorCode.WORK_ORDER_TYPE_IS_MISMATCHING, "工单类型不匹配");
        map.put(BEErrorCode.OPERATOR_NOT_HAVE_STAFF, "该账号没有员工");
        map.put(BEErrorCode.MEMBER_TYPE_IS_NOT_EXIST, "机构会员类型不存在");
        map.put(BEErrorCode.AREA_IS_NOT_EXIST, "行政地区不存在");
        map.put(BEErrorCode.STAFF_MOBILE_IS_ALREADY_EXIST, "员工手机号已存在");
        map.put(BEErrorCode.OPERATOR_ID_NOT_BE_NULL, "账号id不能为空");
        map.put(BEErrorCode.EVENT_TYPE_CON_NOT_NULL, "赛事类型不能为空");
        map.put(BEErrorCode.EVENT_TYPE_IS_WRONG, "赛事类型不匹配");
        map.put(BEErrorCode.EVENT_STATUS_IS_NOT_MATCHING, "赛事状态不匹配:%s");
        map.put(BEErrorCode.EVENT_CON_NOT_FOUND, "找不到该赛事");
        map.put(BEErrorCode.EVENT_UPDATE_PERMISSION, "该状态下不能更新");
        map.put(BEErrorCode.GROUP_CON_NOT_FOUND, "找不到该组别");
        map.put(BEErrorCode.GROUP_APPLY_TIME, "报名结束时间小于开始时间");
        map.put(BEErrorCode.GROUP_PAY_TIME, "支付结束时间小于开始时间");
        map.put(BEErrorCode.GROUP_TYPE_IS_WRONG, "组别类型不正确");
        map.put(BEErrorCode.STINT_MODEL_IS_WRONG, "数量限制错误");
        map.put(BEErrorCode.STINT_MAX_COUNT_IS_WRONG, "报名总数错误");
        map.put(BEErrorCode.OPTION_CON_NOT_FOUND, "找不到该报名表单");
        map.put(BEErrorCode.EVENT_COMMIT_PERMISSION, "该状态下不能提交审核");
        map.put(BEErrorCode.GROUP_NOT_BE_CREATED, "赛事的组别为空");
        map.put(BEErrorCode.OPTION_NOT_BE_CREATED, "赛事的报名表单为空");
        map.put(BEErrorCode.AGE_LIMIT_IS_WRONG, "年龄限制参数错误");
        map.put(BEErrorCode.AGE_RANGE_IS_WRONG, "年龄范围参数错误:%s");
        map.put(BEErrorCode.GENDER_LIMIT_IS_WRONG, "性别限制参数错误");
        map.put(BEErrorCode.FEE_MODE_IS_WRONG, "收费类型参数错误:%s");
        map.put(BEErrorCode.FEE_IS_WRONG, "收费额参数错误");
        map.put(BEErrorCode.TEAM_COUNT_IS_WRONG, "队伍数量参数错误:%s");
        map.put(BEErrorCode.TEAM_GENDER_LIMIT_IS_WRONG, "队伍性别错误:%s");
        map.put(BEErrorCode.FEMALE_COUNT_IS_WRONG, "女队员数量错误:%s");
        map.put(BEErrorCode.CHILD_COUNT_IS_WRONG, "小孩数量错误:%s");
        map.put(BEErrorCode.PARENT_COUNT_IS_WRONG, "家长数量错误:%s");
        map.put(BEErrorCode.APPLY_WAY_IS_WRONG, "报名方式错误:%s");
        map.put(BEErrorCode.OPTION_TYPE_IS_WRONG, "报名表单类型错误");
        map.put(BEErrorCode.APPLY_CON_NOT_FOUND, "找不到该报名表单");
        map.put(BEErrorCode.APPLY_IS_ALREADY_CHECK, "该报名表单已被审核");
        map.put(BEErrorCode.USER_LOGIN_NAME_IS_WRONG, "没有该用户");
        map.put(BEErrorCode.USER_PASSWORD_IS_WRONG, "用户名或密码错误");
        map.put(BEErrorCode.BIRTHDAY_IS_WRONG, "生日大于当前日期");
        map.put(BEErrorCode.USER_NOT_FOUND, "找不到该用户信息");
        map.put(BEErrorCode.USER_CHANGE_PASSWORD, "修改密码错误:%s");
        map.put(BEErrorCode.USER_CHANGE_PHONE, "手机号错误:%s");
        map.put(BEErrorCode.GROUP_APPLY_TIMES, "报名组别相关时间错误:%s");
        map.put(BEErrorCode.EVENT_APPLY_TIME, "报名组别相关时间错误:%s");
        map.put(BEErrorCode.PC_USER_ACCOUNT_IS_ALREADY_EXIST, "用户名\"%s\"已存在");
        map.put(BEErrorCode.GROUP_ROLE_CON_NOT_FOUNT, "找不到该组别角色");
        map.put(BEErrorCode.GROUP_ROLE_IS_ALREADY_RELATED, "该组别角色已被应用");
        map.put(BEErrorCode.EVENT_COMMIT_VERIFY, "赛事提交审核校验失败:%s");
        map.put(BEErrorCode.VERIFICATION_CODE_TYPE_IS_WRONG, "验证码类型错误");
        map.put(BEErrorCode.UNSUPPORTED_PAYMENT_METHOD_ERROR, "暂不支持的支付方式：%s");
        map.put(BEErrorCode.IMAGE_CODE_VERIFY_FAILED, "图片验证码错误");
        map.put(BEErrorCode.PAGE_PAYMENT_CREATION_ERROR, "创建网页支付订单失败：%s");
        map.put(BEErrorCode.VERIFICATION_CODE_IS_WRONG, "验证码错误");
        map.put(BEErrorCode.REFUND_CONDITION_IS_WRONG, "退款条件错误：%s");
        map.put(BEErrorCode.REFUND_IS_WRONG, "退款错误：%s");
        map.put(BEErrorCode.USER_CHANGE_MAIL, "修改用户邮箱时发生错误：%s");
        map.put(BEErrorCode.UNSUPPORTED_CERTIFICATION_ERROR, "暂不支付的实名认证方式：%s");
        map.put(BEErrorCode.USER_CERTIFICATION_ERROR, "用户实名认证错误：%s");
        map.put(BEErrorCode.FORBIDDEN_EVENT_OPERATION_ERROR, "\"%s\"状态下的赛事不允许执行%s操作");
        map.put(BEErrorCode.APPLY_NOT_BELONG_TO_USER_ERROR, "该报名信息不属性此用户");
        map.put(BEErrorCode.PAY_VALID_TIME_IS_WRONG, "有效时间错误: %s");
        map.put(BEErrorCode.GROUP_CONFIG_NODE_VALUE_FORMAT_ERROR, "组别配置项\"%s\"的值格式有误");
        map.put(BEErrorCode.EVENT_APPLY_VALIDATION_ERROR, "赛事报名信息填写有误：%s");
        map.put(BEErrorCode.GROUP_ROLE_ID_CON_NOT_BE_NULL, "组别角色表不能为空");
        map.put(BEErrorCode.GROUP_FIELDS_NOT_FOUND, "找不到该组别配置项");
        map.put(BEErrorCode.GROUP_ROLE_FEE_ID_IS_NULL, "亲子组组别角色关联的费用为空");
        map.put(BEErrorCode.SUBMIT_APPLY_ERROR, "提交报名信息失败：%s");
        map.put(BEErrorCode.CONFIRM_MEMBER_ERROR, "确认报名成员失败：%s");
        map.put(BEErrorCode.REMOVE_MEMBER_ERROR, "移除报名成员失败：%s");
        map.put(BEErrorCode.APPLY_MEMBER_STATUS_CHANGING_ERROR, "当前成员处于%s状态，无法变更为%s状态");
        map.put(BEErrorCode.APPLY_ORDER_NOT_EXIST_ERROR, "赛事报名订单未找到");
        map.put(BEErrorCode.APPLY_ORDER_PAYMENT_ERROR, "赛事报名订单支付失败：%s");
        map.put(BEErrorCode.APPLY_ORDER_ALREADY_EXIST_ERROR, "赛事报名订单已存在");
        map.put(BEErrorCode.EVENT_TIME_IS_WRONG, "赛事时间错误: %s");
        map.put(BEErrorCode.APPLY_MEMBER_IS_NOT_UNIQUE, "该 %s 成员已经报名该赛事");
        map.put(BEErrorCode.EVENT_APPLY_ORDER_NOT_FOUND, "找不到该订单");
        map.put(BEErrorCode.APPLY_REFUND_ERROR, "申请报名退款失败：%s");
        map.put(BEErrorCode.APPLY_PAYMENT_NOT_FOUND, "找不到该支付流水信息");
    }

    private static ErrorMessage errorMessage = new ErrorMessage(map);

    private String code;

    BEErrorCode(String code) {
        this.code = code;
    }

    public String getMessage(Object... args) {
        return errorMessage.getErrorMessage(this, args);
    }

    public String getCode() {
        return code;
    }
}
