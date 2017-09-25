package com.minlia.iot.plugin.brcb;


import com.minlia.iot.api.AbstractJsonApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.app.BrcbPaymentAlipayAppRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.app.BrcbPaymentAlipayAppResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.micropay.BrcbPaymentAlipayMicropayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.micropay.BrcbPaymentAlipayMicropayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.qrpay.BrcbPaymentAlipayQrpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.qrpay.BrcbPaymentAlipayQrpayResponseBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.webpay.BrcbPaymentAlipayWebpayRequestBody;
import com.minlia.iot.plugin.brcb.body.api.payment.alipay.webpay.BrcbPaymentAlipayWebpayResponseBody;
import com.minlia.iot.plugin.brcb.requestor.BrcbPaymentAlipayApiHttpRequestor;
import com.minlia.iot.plugin.brcb.scope.BrcbApiScope;
import com.minlia.iot.plugin.brcb.signature.BrcbPaymentAlipaySignatureProcessor;
import com.minlia.iot.plugin.brcb.signature.BrcbPaymentWechatSignatureProcessor;
import com.minlia.iot.plugin.brcb.signature.BrcbSignatureVerificationProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;


/**
 * Created by will on 9/10/17.
 * BRCB进件接口为示例, 将继续添加其它接口进来
 */
public class BrcbAlipayPaymentApi extends AbstractJsonApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public BrcbAlipayPaymentApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public BrcbAlipayPaymentApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);

    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(BrcbStatefulApiResponseBody.class);

    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new BrcbPaymentAlipaySignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext
        .setSignatureVerificationProcessor(new BrcbSignatureVerificationProcessor());   //可以使用默认配置
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody micropay(BrcbPaymentAlipayMicropayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentAlipayMicropayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("ALIPAY_MICRO");
    //创建请求器并发起请求
    return new BrcbPaymentAlipayApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody qrpay(BrcbPaymentAlipayQrpayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentAlipayQrpayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("ALIPAY_SCANNED");
    //创建请求器并发起请求
    return new BrcbPaymentAlipayApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody webpay(BrcbPaymentAlipayWebpayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentAlipayWebpayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("ALIPAY_WEBPAY");
    //创建请求器并发起请求
    return new BrcbPaymentAlipayApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody app(BrcbPaymentAlipayAppRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentAlipayAppResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("ALIPAY_APP");
    //创建请求器并发起请求
    return new BrcbPaymentAlipayApiHttpRequestor(processor).request(body);
  }

}
