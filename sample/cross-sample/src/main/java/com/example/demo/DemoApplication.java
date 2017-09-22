package com.example.demo;

import com.minlia.cloud.body.StatefulBody;
import com.minlia.cloud.body.impl.SuccessResponseBody;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.BrcbCustomerServiceApi;
import com.minlia.iot.plugin.brcb.BrcbSettleApi;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerEnterRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerEnterResponseBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleRequestBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleResponseBody;
import com.minlia.iot.plugin.kuaidiniao.KuaidiniaoApi;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryRequestBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryResponseBody;
import com.minlia.iot.plugin.kuaidiniao.body.query.RequestData;
import com.minlia.iot.plugin.swiftpass.SwiftpassApi;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassStatefulApiResponseBody;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassWechatNativePaymentRequestBody;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassWechatNativePaymentResponseBody;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  private KuaidiniaoApi kuaidiniaoApi;

  @Autowired
  private SwiftpassApi swiftpassApi;

  @Autowired
  private BrcbCustomerServiceApi brcbCustomerServiceApi;

  @Autowired
  private BrcbSettleApi brcbSettleApi;


  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @RestController
  public class RouteEndpoint {


    public StatefulApiResponseBody kdn() {

      KuaidiniaoQueryRequestBody apiRequestBody = new KuaidiniaoQueryRequestBody();
      apiRequestBody.setDataType("2");
      apiRequestBody.setRequestType("1002");
      RequestData requestData = new RequestData();
      requestData.setOrderCode("");
      requestData.setShipperCode("YTO");
      requestData.setLogisticCode("885336485979984406");
      apiRequestBody.setRequestDataObject(requestData);

      StatefulApiResponseBody<KuaidiniaoQueryResponseBody> kuaidiniaoQueryResponseBodyStatefulApiResponseBody = kuaidiniaoApi
          .sandbox(true) //设置为沙箱模式
          .query(apiRequestBody);
      return kuaidiniaoQueryResponseBodyStatefulApiResponseBody;
    }

    public StatefulApiResponseBody swiftpass() {

//
      SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
      requestBody.setMchCreateIp("127.0.0.1");
      requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
      requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
      requestBody.setTotalFee("1");
      requestBody.setBody("测试支付");
      requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

      SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi
          .sandbox(true)
          //微信APP支付
          .wechatNativePayment(requestBody);

      SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody

          .getPayload();
//
      return statefulApiResponseBody;
    }


    public StatefulApiResponseBody brcb() {

      //创建请求体
      BrcbCustomerEnterRequestBody body = new BrcbCustomerEnterRequestBody();

      //设置请求参数
      body.setServiceType("CUSTOMER_ENTER");
      body.setOutMchId("OUTMCHID000000001");

      //返回被封装成2层
      //1. 状态化的返回体, 负责整体api调用是否成功型封装
      //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
      BrcbStatefulApiResponseBody<BrcbCustomerEnterResponseBody> brcbCustomerEnterResponseBodyBrcbStatefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbCustomerServiceApi
          .sandbox(true)
          .customerEnter(body);

      //创建请求体
      BrcbT0SettleRequestBody brcbT0SettleRequestBody = new BrcbT0SettleRequestBody();

      //设置请求参数
      brcbT0SettleRequestBody.setOrderNum("ORDERNUM-000000001");

      //返回被封装成2层
      //1. 状态化的返回体, 负责整体api调用是否成功型封装
      //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
      BrcbStatefulApiResponseBody<BrcbT0SettleResponseBody> brcbT0SettleResponseBodyBrcbStatefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbSettleApi
          .sandbox(true)
          .t0Settle(brcbT0SettleRequestBody);

      return brcbT0SettleResponseBodyBrcbStatefulApiResponseBody;
    }


    @GetMapping(value = {"/{type}", "index", "default"})
    public StatefulBody route(@PathVariable String type) {

      SuccessResponseBody body = SuccessResponseBody.builder().message("OK").build();

      switch (type) {
        case "brcb":
          body.setPayload(brcb());
          break;
        case "swiftpass":
          body.setPayload(swiftpass());
          break;
        case "kdn":
          body.setPayload(kdn());
          break;
        default:
          break;
      }

      return body;
    }
  }
}
