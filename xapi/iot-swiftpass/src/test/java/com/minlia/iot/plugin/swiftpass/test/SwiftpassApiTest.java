package com.minlia.iot.plugin.swiftpass.test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.minlia.iot.plugin.swiftpass.SwiftpassAbstractTest;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassStatefulApiResponseBody;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassQueryResponseBody;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassQueryRequestBody;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class SwiftpassApiTest extends SwiftpassAbstractTest {

  @Test
  public void test_with_success_result() {

    SwiftpassQueryRequestBody requestBody = new SwiftpassQueryRequestBody();
    requestBody.setMchCreateIp("127.0.0.1");
    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(true);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.query(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());

    assertEquals("0", statefulApiResponseBody.getStatus());

    SwiftpassQueryResponseBody apiHttpResponseBody = (SwiftpassQueryResponseBody) statefulApiResponseBody
        .getPayload();

    String appid = apiHttpResponseBody.getAppid();
    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());

  }

  @Test
  public void test_with_order_already_paid_error_result() {

    SwiftpassQueryRequestBody requestBody = new SwiftpassQueryRequestBody();
    requestBody.setMchCreateIp("127.0.0.1");
    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
    requestBody.setOutTradeNo("141903606228");//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(true);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.query(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());
    assertEquals("0", statefulApiResponseBody.getStatus());
    SwiftpassQueryResponseBody apiHttpResponseBody = (SwiftpassQueryResponseBody) statefulApiResponseBody
        .getPayload();
    assertEquals("Order paid", apiHttpResponseBody.getErrCode());
    assertEquals("订单已支付", apiHttpResponseBody.getErrMsg());

  }


}