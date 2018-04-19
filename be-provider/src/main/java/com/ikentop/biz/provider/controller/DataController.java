package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.DateTest;
import com.ikentop.biz.provider.model.dto.MofangProtocolInfo;
import com.ikentop.biz.provider.service.StaffService;
import com.ikentop.biz.provider.util.PasswordUtils;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/23
 */
@RestController
@Api(description = "获取数据的api")
@RequestMapping(DataController.PATH)
public class DataController {
    public final static String PATH = "data";

    @Autowired
    private StaffService staffService;

    @ApiOperation("获取随机密码")
    @RequestMapping(value = "getPassword", method = RequestMethod.GET)
    public RestfulApiResponse<String> getPassword() {
        return RestfulApiResponse.success("获取成功", PasswordUtils.createPassWord());
    }

    @ApiOperation("验证手机号是否唯一")
    @RequestMapping(value = "verifyMobile", method = RequestMethod.GET)
    public RestfulApiResponse<String> verifyMobile(@RequestParam @ApiParam(value = "手机号", required = true) String mobile) {
        return RestfulApiResponse.success("获取成功", staffService.verifyMobile(mobile));
    }

    @ApiOperation("获取磨房赛事平台服务协议书")
    @RequestMapping(value = "getProtocol", method = RequestMethod.GET)
    public RestfulApiResponse<MofangProtocolInfo> getProtocol() {
        return RestfulApiResponse.success("获取成功", createProtocol());
    }

    @ApiOperation("联系我们")
    @RequestMapping(value = "contactUs", method = RequestMethod.GET)
    public RestfulApiResponse<String> contactUs() {
        return RestfulApiResponse.success("获取成功", createContactUs());
    }

    @ApiOperation(value = "test", hidden = true)
    @RequestMapping(value = "dateTest", method = RequestMethod.GET)
    public RestfulApiResponse<DateTest> dateTest() {
        DateTest date = new DateTest();
        date.setDate1(new Date());
        date.setDate2(new Date());
        date.setDate3(new Date());
        return RestfulApiResponse.success("获取成功", date);
    }

    @ApiOperation("获取『关于我们』相关内容")
    @RequestMapping(value = "getAboutUs", method = RequestMethod.GET)
    public RestfulApiResponse<MofangProtocolInfo> getAboutUs() {
        return RestfulApiResponse.success("获取成功", createProtocol());
    }

    private MofangProtocolInfo createProtocol() {
        MofangProtocolInfo info = new MofangProtocolInfo();
        info.setTitle("磨房赛事平台服务协议书");
        info.setContent("磨房赛事平台服务协议书\n" +
                "\n" +
                "欢迎您使用磨房赛事平台！\n" +
                "磨房赛事平台提示您，您应当仔细阅读《磨房赛事平台服务协议》(以下简称\"本协议\")，特别是免除或限制责任相关条款。当您确认接受本服务协议或开始使用本协议项下磨房赛事平台服务时，即表示您与磨房赛事平台已达成协议关系，自愿接受并遵守相关协议内容。\n" +
                "您对磨房赛事平台服务的登录、查看、发布信息等行为即视为您已阅读并同意本协议的约定，接受本协议的约束。\n" +
                "\n" +
                "\n" +
                "我在此授权赛事组委会、主办方、执行方以及任何可能代表我提起赔偿请求或诉讼的相关方做出以下列明的行为，并视为我自愿做出的行为：\n" +
                "\n" +
                "1. 我同意遵守磨房赛事平台关于赛事发布的相关规定；\n" +
                "2. 授权磨房为赛事报名合作伙伴，允许赛事信息等内容在磨房赛事平台发布；\n" +
                "3. 保证赛事符合赛事举办国家当地法律的规定，具备举办赛事所需的所有手续，保证赛事是合法正规赛事；\n" +
                "4. 保证通过磨房赛事平台报名的队员参赛资格有效；同时需保证选手信息不外泄及用于其他商业交易；\n" +
                "5. 如果有队员需要发票，我有义务为通过磨房赛事平台报名赛事的选手提供有效发票凭据，如因我无法开具有效发票引发选手索赔等纠纷，由我自行承担；\n" +
                "6. 保证拥有许可磨房赛事平台转载我的赛事信息的权利，且保证赛事信息(含作品中的图片)不会侵犯第三方的任何权利，包括但不限于著作权、肖像权、名誉权或有导致法律纠纷的情形；\n" +
                "7. 我不会将磨房赛事平台设计的赛事图片、赛事宣传等资料授予其他组织或个人使用；\n" +
                "8 .因我或赛事组委会、执行方、协办方在运营赛事、组织不力等方面的原因，导致赛事取消、无法如期举办或出现其他严重不良后果，我须独立承担由此引发的选手索赔纠纷及相关法律责任。同时磨房赛事平台保留追究由此带来的名誉损失等权利；\n" +
                "9. 我将使用磨房赛事平台自带的安级公司支付宝进行对应代收代付队员的报名费，但赛事的一切组织、运营等事项与磨房赛事平台以及安级公司并无关系；磨房赛事平台及安级公司也无须为我或选手提供发票。如果使用磨房赛事平台自带的安级公司支付宝收取报名费，赛事结束后，我将提供收据作为收到报名费的凭证；\n" +
                "10. 东软赛客平台以及安级公司不收取任何服务费，也不需向我、选手、组委会、执行方、协办方提供任何发票。支付宝平台收取的费用并不由磨房赛事平台以及安级公司收取，而是由支付宝公司直接收取，支付宝收费标准请到支付宝公司网站查看；\n" +
                "11 .我和磨房赛事平台、安级公司都是本协议的独立合同方，不得因本协议规定而被解释为设立形成法律上的代理、合伙、合资、聘用或任何种类的正式商业组织。任何一方对其他方的商业行为、法律行为及经营损失不承担任何责任；\n" +
                "12. 我理解并同意，磨房赛事平台一直致力于为用户提供文明健康、规范有序的网络环境，我在此承诺不利用磨房赛事平台服务制作、复制、发布、传播干扰赛客平台正常运营，侵犯其他用户或第三方合法权益；\n" +
                "13. 我确认并同意不发布、传送、传播、储存违反国家法律法规禁止的内容：\n" +
                "(1)违反宪法确定的基本原则的；\n" +
                "(2)危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家同意的；\n" +
                "(3)损害国家荣誉和利益的；\n" +
                "(4)煽动民族仇恨、民族歧视、破坏民族团结的；\n" +
                "(5)破坏国家宗教政策，宣扬邪教和封建迷信的；\n" +
                "(6)散布谣言、扰乱社会秩序、破坏社会稳定的；\n" +
                "(7)散布淫秽、色情、读博、暴力、恐怖或者教唆犯罪的；\n" +
                "(8)侮辱或者诽谤他人，侵害他人合法权益的；\n" +
                "(9)煽动非法集会、结社、游行、示威、聚众扰乱社会秩序；\n" +
                "(10)以非法民间组织名义活动的；\n" +
                "(11)违反《即时通信工具公众信息服务发展管理暂行规定》及遵守法律法规、社会主义制度、国家利益、公民合法利益、公共秩序、社会道德风尚和信息 真实性等\"七条底线\"要求的行为的；\n" +
                "(12)含有法律、行政法规禁止的其他内容的。\n" +
                "14.我使用磨房赛事平台服务即视为我已阅读并同意接受本协议的约束。磨房赛事平台有权在必要时修改本协议条款，我可以在相关服务页面查阅最新版本的协议条款，如果我继续使用赛客平台服务，即视为我已接受修改后的协议；\n" +
                "15.本协议签订地为中华人名共和国上海市闵行区；\n" +
                "16.本协议的成立、生效、履行、解释及纠纷解决，适用中华人民共和国大陆地区法律(不包括冲突法)；\n" +
                "17.若我和磨房赛事平台之间发生任何纠纷或争议，首先应友好协商解决；协商不成的，我同意将纠纷或争议提交本协议签订地有管辖权的人民法院管辖；\n" +
                "18.本协议条款无论因何种原因部分无效或不可执行，其余条款仍有效，对各方均具有约束力；\n" +
                "19.因下列原因导致东软赛客无法正常提供服务，东软赛客不承担任何责任：\n" +
                "(1)磨房赛事平台停机维护或升级；\n" +
                "(2)因台风、地震、洪水、雷电或恐怖袭击等不可抗力原因；\n" +
                "(3)用户的电脑软硬件和通信线路、供电线路出现故障的；\n" +
                "(4)用户操作不当或通过非赛客授权或认可的方式使用赛客服务的；\n" +
                "(5)因病毒、木马、恶意程序攻击、网络拥堵、系统不稳定、系统或设备故障、通讯故障、电力故障、银行原因、第三方服务瑕疵或政府行为等原因。尽管有签署约定，磨房赛事平台将采取合理行动积极促使服务恢复正常。");
        return info;
    }

    private String createContactUs() {
        return "我们的联系方式:18700001234";
    }
}
