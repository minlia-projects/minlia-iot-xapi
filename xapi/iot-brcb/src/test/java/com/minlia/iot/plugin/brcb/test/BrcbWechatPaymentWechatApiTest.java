package com.minlia.iot.plugin.brcb.test;

import static org.junit.Assert.assertNotNull;

import com.minlia.iot.plugin.brcb.BrcbWechatAbstractTest;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.app.BrcbPaymentWechatAppRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.app.BrcbPaymentWechatAppResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.micropay.BrcbPaymentWechatMicropayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.micropay.BrcbPaymentWechatMicropayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.qrpay.BrcbPaymentWechatQrpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.qrpay.BrcbPaymentWechatQrpayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.unifiedorder.BrcbPaymentWechatUnifiedOrderRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.unifiedorder.BrcbPaymentWechatUnifiedOrderResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.webpay.BrcbPaymentWechatWebpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.wechat.webpay.BrcbPaymentWechatWebpayResponseBody;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class BrcbWechatPaymentWechatApiTest extends BrcbWechatAbstractTest {

  @Test
  public void test_payment_app_with_success_result() {

    //创建请求体
    BrcbPaymentWechatAppRequestBody body = new BrcbPaymentWechatAppRequestBody();

    body.setMchId("C150226031936310846");
    body.setMchKey("98abac04672549cfa651a9e52b08fc62");
    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("APPPAY");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentWechatAppResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbWechatPaymentApi
        .sandbox(false)
        .app(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);
//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }

  @Test
  public void test_payment_webpay_with_success_result() {

    //创建请求体
    BrcbPaymentWechatWebpayRequestBody body = new BrcbPaymentWechatWebpayRequestBody();

    body.setMchId("C150226031936310846");
    body.setMchKey("98abac04672549cfa651a9e52b08fc62");
    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee(1);
    body.setBody("Webpay");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentWechatWebpayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbWechatPaymentApi

        .sandbox(false)
        .webpay(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);
//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }


  @Test
  public void test_payment_qrpay_with_success_result() {

    //创建请求体
    BrcbPaymentWechatQrpayRequestBody body = new BrcbPaymentWechatQrpayRequestBody();


    body.setAppid("");
    body.setMchId("C150226031936310846");
    body.setMchKey("98abac04672549cfa651a9e52b08fc62");
    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setDeviceInfo("ABC");
    body.setBody("Qrpay");
//    body.setDeviceInfo("WEB");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentWechatQrpayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbWechatPaymentApi

        .sandbox(false)
        .qrpay(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);
//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }


  @Test
  public void test_payment_micropay_with_success_result() {


    //
//    private String ebusinessIdSandbox = "C149628461779610201";
//    private String appKeySandbox = "acc503c56b0c4fd399f7f7093d25223c";
    //创建请求体
    BrcbPaymentWechatMicropayRequestBody body = new BrcbPaymentWechatMicropayRequestBody();
    body.setMchId("C149628461779610201");
    body.setMchKey("acc503c56b0c4fd399f7f7093d25223c");
    body.setAuthCode("136290895107835475");

    body.setAppid("");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("测试支付");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentWechatMicropayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbWechatPaymentApi

        .sandbox(true)
        .micropay(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);
//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }

  @Test
  public void test_payment_unifiedOrder_with_success_result() {

    //创建请求体
//    BrcbPaymentWechatUnifiedOrderRequestBody body = new BrcbPaymentWechatUnifiedOrderRequestBody();


    //调用支付模块支付 TODO
    BrcbPaymentWechatUnifiedOrderRequestBody orderRequestBody = new BrcbPaymentWechatUnifiedOrderRequestBody();
    orderRequestBody.setMchId("C149628461779610201");
    orderRequestBody.setMchKey("acc503c56b0c4fd399f7f7093d25223c");
//    orderRequestBody.setAppid("wx320814777dbe3788");
    orderRequestBody.setOpenid("oa6cB0Rnf00D00YfucJyE75bTLrI");
    orderRequestBody.setBody("测试");
    orderRequestBody.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));
    orderRequestBody.setTotalFee(1);
    orderRequestBody.setSpbillCreateIp("120.0.0.1");
    orderRequestBody.setNotifyUrl("http://www.baidu.com");



//    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
//    body.setSpbillCreateIp("127.0.0.1");
//    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
//    body.setTotalFee(1);
//    body.setBody("测试支付");
//    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentWechatUnifiedOrderResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbWechatPaymentApi
        .sandbox(true)
        .unifiedOrder(orderRequestBody);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);
//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }


}