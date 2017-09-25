package com.example.demo.endpoint;

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
import java.net.URI;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 测试而以, 所有接口放在一个文件里面
 */
@RestController
public class RouteEndpoint {

  @Autowired
  private KuaidiniaoApi kuaidiniaoApi;

  @Autowired
  private SwiftpassApi swiftpassApi;

  @Autowired
  private BrcbCustomerServiceApi brcbCustomerServiceApi;

  @Autowired
  private BrcbSettleApi brcbSettleApi;

  //  @GetMapping(value = {"/","/index.htm"})
//  public StatefulBody welcome() {
//    return SuccessResponseBody.builder().message("API请求已成功,请查阅RouteEndpoint.welcome()").build();
//  }

  public static String getCurrentUrl() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    URL url = null;
    URI uri = null;
    try {
      String uri1=request.getRequestURI();
      url = new URL(request.getRequestURL().toString());
      String host = url.getHost();
      String userInfo = url.getUserInfo();
      String scheme = url.getProtocol();
      int port = url.getPort();
      String path=request.getRequestURI();
      String query=request.getQueryString();
      uri = new URI(scheme, userInfo, host, port, path, query, null);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return uri.toString();
  }

  @GetMapping(value = {"/api/{type}"})
  public StatefulBody api(@PathVariable String type) {

//
//    String url = "";
//    url = request.getScheme() + "://" + request.getServerName()
//        + ":" + request.getServerPort()
//        + request.getServletPath();
//    if (request.getQueryString() != null) {
//      url += "?" + request.getQueryString();
//    }
//
    System.out.println(getCurrentUrl());
//    System.out.println(url);

    SuccessResponseBody body = SuccessResponseBody.builder().message("OK").build();
    switch (type) {
      case "brcb1":
        body.setPayload(brcb1());
        break;
      case "brcb2":
        body.setPayload(brcb2());
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


  public StatefulApiResponseBody kdn() {
    KuaidiniaoQueryRequestBody apiRequestBody = new KuaidiniaoQueryRequestBody();
    apiRequestBody.setDataType("2");
    apiRequestBody.setRequestType("1002");
    RequestData requestData = new RequestData();
    requestData.setOrderCode("");
    requestData.setShipperCode("YTO");
    requestData.setLogisticCode("885336485979984406");
    apiRequestBody.setRequestDataObject(requestData);

    //调用接口
    StatefulApiResponseBody<KuaidiniaoQueryResponseBody> kuaidiniaoQueryResponseBody = kuaidiniaoApi
        //设置为沙箱模式
        .sandbox(true)
        //调用查询接口
        .query(apiRequestBody);

    return kuaidiniaoQueryResponseBody;
  }

  public StatefulApiResponseBody swiftpass() {
    SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
    requestBody.setMchCreateIp("127.0.0.1");
    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //调用接口
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi
        //设置为沙箱模式
        .sandbox(true)
        //微信APP支付
        .wechatNativePayment(requestBody);

    //获取到真实的业务返回
    SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody
        .getPayload();

    return statefulApiResponseBody;
  }


  public StatefulApiResponseBody brcb1() {
    //创建请求体
    BrcbCustomerEnterRequestBody body = new BrcbCustomerEnterRequestBody();

    //设置请求参数
    body.setServiceType("CUSTOMER_ENTER");
    body.setOutMchId("OUTMCHID000000001");

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbCustomerEnterResponseBody> statefulApiResponseBody1 = (BrcbStatefulApiResponseBody) brcbCustomerServiceApi
        .sandbox(true)
        .customerEnter(body);

    return statefulApiResponseBody1;
  }

  public StatefulApiResponseBody brcb2() {
    //创建请求体
    BrcbT0SettleRequestBody brcbT0SettleRequestBody = new BrcbT0SettleRequestBody();
//      设置请求参数
    brcbT0SettleRequestBody.setOrderNum("ORDERNUM-000000001");

//      返回被封装成2层
//      1. 状态化的返回体, 负责整体api调用是否成功型封装
//      2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbT0SettleResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbSettleApi
        .sandbox(true)
        .t0Settle(brcbT0SettleRequestBody);
    return statefulApiResponseBody;
  }


}