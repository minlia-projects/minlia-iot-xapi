package com.minlia.iot.plugin.brcb.test;



import static org.junit.Assert.assertNotNull;

import com.minlia.iot.plugin.brcb.BrcbAlipayAbstractTest;
import com.minlia.iot.plugin.brcb.BrcbWechatAbstractTest;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.app.BrcbPaymentAlipayAppRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.app.BrcbPaymentAlipayAppResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.micropay.BrcbPaymentAlipayMicropayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.micropay.BrcbPaymentAlipayMicropayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.qrpay.BrcbPaymentAlipayQrpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.qrpay.BrcbPaymentAlipayQrpayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.webpay.BrcbPaymentAlipayWebpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.webpay.BrcbPaymentAlipayWebpayResponseBody;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;


/**
 * Created by will on 9/10/17.
 */
public class BrcbWechatPaymentAlipayApiTest extends BrcbAlipayAbstractTest {

  @Test
  public void test_payment_app_with_success_result() {

    //创建请求体
    BrcbPaymentAlipayAppRequestBody body = new BrcbPaymentAlipayAppRequestBody();


    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("测试支付");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentAlipayAppResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbAlipayPaymentApi
        .sandbox(true)
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
    BrcbPaymentAlipayWebpayRequestBody body = new BrcbPaymentAlipayWebpayRequestBody();


    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("测试支付");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentAlipayWebpayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbAlipayPaymentApi

        .sandbox(true)
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
    BrcbPaymentAlipayQrpayRequestBody body = new BrcbPaymentAlipayQrpayRequestBody();

    body.setSubject("测试支付");
    body.setNotifyUrl("http://will.dev.pufubao.net/n/brcb");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("测试支付");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));
    body.setDeviceInfo("WEB");

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentAlipayQrpayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbAlipayPaymentApi

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

    //创建请求体
    BrcbPaymentAlipayMicropayRequestBody body = new BrcbPaymentAlipayMicropayRequestBody();

    body.setAuthCode("135012455576441715");

    body.setSubject("测试支付");
    body.setOutTradeNo("OUTTRADENO-" + RandomStringUtils.randomNumeric(4));
    body.setSpbillCreateIp("127.0.0.1");
    body.setOutTradeNo("TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    body.setTotalFee("1");
    body.setBody("测试支付");
    body.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbPaymentAlipayMicropayResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbAlipayPaymentApi

        .sandbox(true)
        .micropay(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);

//
//    //由于提交的参数不全, 所以预期出现以下错误
//    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
//    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());

  }


}