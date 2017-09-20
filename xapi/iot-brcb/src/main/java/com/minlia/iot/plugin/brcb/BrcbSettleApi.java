package com.minlia.iot.plugin.brcb;

import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleRequestBody;
import com.minlia.iot.plugin.brcb.signature.BrcbSignatureVerificationProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.api.AbstractApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.http.JsonApiHttpExecutor;
import com.minlia.iot.marshal.deserialize.JsonApiDeserializer;
import com.minlia.iot.marshal.serialize.JsonApiSerializer;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleQueryRequestBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleResponseBody;
import com.minlia.iot.plugin.brcb.requestor.BrcbSettleApiHttpRequestor;
import com.minlia.iot.plugin.brcb.scope.BrcbApiScope;
import com.minlia.iot.plugin.brcb.signature.BrcbSettleSignatureProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;
import com.minlia.iot.scope.HttpMediaType;

/**
 * Created by will on 9/10/17.
 * BRCB进件接口为示例, 将继续添加其它接口进来
 */
public class BrcbSettleApi extends AbstractApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public BrcbSettleApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public BrcbSettleApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);

    apiRuntimeContext.setEncoding("UTF-8");
    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(BrcbStatefulApiResponseBody.class);

    //需要特别指定的
    apiRuntimeContext.setHttpMediaType(HttpMediaType.Json);
    apiRuntimeContext.setApiDeserializer(new JsonApiDeserializer<>());    //可以使用默认配置
    apiRuntimeContext.setApiSerializer(new JsonApiSerializer<>());
    apiRuntimeContext.setApiHttpExecutor(new JsonApiHttpExecutor());

    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new BrcbSettleSignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext
        .setSignatureVerificationProcessor(new BrcbSignatureVerificationProcessor());   //可以使用默认配置
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody t0Settle(BrcbT0SettleRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.T0_SETTLE.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbT0SettleResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbSettleApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody t0SettleQuery(BrcbT0SettleQueryRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.T0_SETTLE_QUERY.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbT0SettleResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbSettleApiHttpRequestor(processor).request(body);
  }

}
