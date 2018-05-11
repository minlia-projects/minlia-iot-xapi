package com.minlia.iot.plugin.swiftpass.test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.minlia.iot.plugin.pooulcloud.body.jspay.SwiftpassWechatJspayPaymentRequestBody;
import com.minlia.iot.plugin.pooulcloud.body.jspay.SwiftpassWechatJspayPaymentResponseBody;
import com.minlia.iot.plugin.swiftpass.SwiftpassAbstractTest;
import com.minlia.iot.plugin.pooulcloud.body.SwiftpassStatefulApiResponseBody;
import com.minlia.iot.plugin.pooulcloud.body.micropay.SwiftpassWechatMicropayRequestBody;
import com.minlia.iot.plugin.pooulcloud.body.micropay.SwiftpassWechatMicropayResponseBody;
import com.minlia.iot.plugin.pooulcloud.body.nativepayment.SwiftpassWechatNativePaymentResponseBody;
import com.minlia.iot.plugin.pooulcloud.body.nativepayment.SwiftpassWechatNativePaymentRequestBody;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class SwiftpassApiTest extends SwiftpassAbstractTest {

  @Test
  public void test_micripay_with_success_result() {

    SwiftpassWechatMicropayRequestBody requestBody = new SwiftpassWechatMicropayRequestBody();

    requestBody.setAuthCode("134967598248771757");
    requestBody.setSpbillCreateIp("127.0.0.1");
    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(true);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatMicropay(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());

    assertEquals("0", statefulApiResponseBody.getStatus());

    SwiftpassWechatMicropayResponseBody apiHttpResponseBody = (SwiftpassWechatMicropayResponseBody) statefulApiResponseBody
        .getPayload();

//    String appid = apiHttpResponseBody.getAppid();
//    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());

  }
  @Test
  public void test_jspay_with_success_result() {


    //body=测试支付&charset=UTF-8&mch_id=8444812501217143&nonce_str=qXSWWJdIbuCOPGdyKXvlvNbcVKZLxj&out_trade_no=MINLIA-TEST-ORDER-5359822683&payType=wechat.jsapi&sign_type=MD5&total_fee=1&version=2.0&key=7B8CC56D58F81D7DACCE67C4D6C90E4D

    SwiftpassWechatJspayPaymentRequestBody requestBody = new SwiftpassWechatJspayPaymentRequestBody();
//    requestBody.setAuthCode("134967598248771757");
//    requestBody.setSpbillCreateIp("127.0.0.1");
    requestBody.setSubAppid("wx469ffdb81de47e4d");
    requestBody.setSubOpenid("oZtcE0aIoRluOZ4XbfdHZFB6zG");
    requestBody.setOpenid("oZtcE0aIoRluOZ4XbfdHZFB6zG");
    requestBody.setMchTradeId("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(false);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatJspay(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());

    assertEquals("0", statefulApiResponseBody.getStatus());

    SwiftpassWechatJspayPaymentResponseBody apiHttpResponseBody = (SwiftpassWechatJspayPaymentResponseBody) statefulApiResponseBody
        .getPayload();

//    String appid = apiHttpResponseBody.getAppid();
//    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());

  }

  @Test
  public void test_with_success_result() {

    SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
    requestBody.setMchCreateIp("127.0.0.1");
    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(true);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatNativePayment(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());

    assertEquals("0", statefulApiResponseBody.getStatus());

    SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody
        .getPayload();

    String appid = apiHttpResponseBody.getAppid();
    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());

  }

  @Test
  public void test_with_order_already_paid_error_result() {

    SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
    requestBody.setMchCreateIp("127.0.0.1");
    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
    requestBody.setOutTradeNo("141903606228");//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(true);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatNativePayment(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());
    assertEquals("0", statefulApiResponseBody.getStatus());
    SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody
        .getPayload();
    assertEquals("Order paid", apiHttpResponseBody.getErrCode());
    assertEquals("订单已支付", apiHttpResponseBody.getErrMsg());

  }


}