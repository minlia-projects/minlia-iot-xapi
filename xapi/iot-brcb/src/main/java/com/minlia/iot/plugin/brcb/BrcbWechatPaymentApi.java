package com.minlia.iot.plugin.brcb;

import com.minlia.iot.api.AbstractJsonApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
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
import com.minlia.iot.plugin.brcb.requestor.BrcbPaymentWechatApiHttpRequestor;
import com.minlia.iot.plugin.brcb.scope.BrcbApiScope;
import com.minlia.iot.plugin.brcb.signature.BrcbPaymentWechatSignatureProcessor;
import com.minlia.iot.plugin.brcb.signature.BrcbSignatureVerificationProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;

/**
 * Created by will on 9/10/17.
 * BRCB进件接口为示例, 将继续添加其它接口进来
 */
public class BrcbWechatPaymentApi extends AbstractJsonApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public BrcbWechatPaymentApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public BrcbWechatPaymentApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);

    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(BrcbStatefulApiResponseBody.class);


    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new BrcbPaymentWechatSignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext
        .setSignatureVerificationProcessor(new BrcbSignatureVerificationProcessor());   //可以使用默认配置
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody micropay(BrcbPaymentWechatMicropayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentWechatMicropayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("WECHAT_MICRO");
    //创建请求器并发起请求
    return new BrcbPaymentWechatApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody qrpay(BrcbPaymentWechatQrpayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentWechatQrpayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("WECHAT_SCANNED");
    //创建请求器并发起请求
    return new BrcbPaymentWechatApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody webpay(BrcbPaymentWechatWebpayRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentWechatWebpayResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("WECHAT_WEBPAY");
    //创建请求器并发起请求
    return new BrcbPaymentWechatApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody app(BrcbPaymentWechatAppRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentWechatAppResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("WECHAT_APP");
    //创建请求器并发起请求
    return new BrcbPaymentWechatApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody unifiedOrder(BrcbPaymentWechatUnifiedOrderRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.PAYMENT_GATEWAY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbPaymentWechatUnifiedOrderResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    body.setServiceType("WECHAT_UNIFIEDORDER");
    //创建请求器并发起请求
    return new BrcbPaymentWechatApiHttpRequestor(processor).request(body);
  }

}
