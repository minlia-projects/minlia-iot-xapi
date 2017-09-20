package com.minlia.iot.plugin.kuaidiniao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.minlia.iot.plugin.kuaidiniao.KuaidiniaoAbstractTest;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryRequestBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryResponseBody;
import com.minlia.iot.plugin.kuaidiniao.body.query.RequestData;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class KuaidiniaoApiTest extends KuaidiniaoAbstractTest {


  @Test
  public void test_with_success_result() {

    KuaidiniaoQueryRequestBody apiRequestBody = new KuaidiniaoQueryRequestBody();
    apiRequestBody.setDataType("2");
    apiRequestBody.setRequestType("1002");
    RequestData requestData = new RequestData();
    requestData.setOrderCode("");
    requestData.setShipperCode("YTO");
    requestData.setLogisticCode("885336485979984406");
    apiRequestBody.setRequestDataObject(requestData);

    StatefulApiResponseBody<KuaidiniaoQueryResponseBody> x = kuaidiniaoApi
        .sandbox(true) //设置为沙箱模式
        .query(apiRequestBody);

    assertNotNull(x);
    KuaidiniaoQueryResponseBody responseBody = null;

    assertTrue(x.isSuccess());
    if (x.isSuccess()) {
      responseBody = x.getPayload();
    }
    assertNotNull(responseBody);

    System.out.println(x);
    System.out.println(responseBody);


  }


  /**
   * {  "EBusinessID": "1256193",  "ShipperCode": "YTO",  "Success": true,  "Reason": "此单无物流信息",
   * "LogisticCode": "885336485979984401",  "State": "0",  "Traces": []}
   */
  @Test
  public void test_with_failure_result() {

    KuaidiniaoQueryRequestBody apiRequestBody = new KuaidiniaoQueryRequestBody();

    apiRequestBody.setDataType("2");
    apiRequestBody.setRequestType("1002");
    RequestData requestData = new RequestData();
    requestData.setOrderCode("");
    requestData.setShipperCode("YTO");
    requestData.setLogisticCode("885336485979984401");
    apiRequestBody.setRequestDataObject(requestData);

    StatefulApiResponseBody<KuaidiniaoQueryResponseBody> statefulApiResponseBody = kuaidiniaoApi
        .sandbox(false)
        .query(apiRequestBody);

    assertNotNull(statefulApiResponseBody);
    System.out.println(statefulApiResponseBody);

  }


}