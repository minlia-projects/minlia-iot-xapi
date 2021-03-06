package com.minlia.iot.plugin.brcb;

/**
 * Created by will on 9/19/17.
 */

import com.minlia.iot.api.AbstractJsonApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.config.BrcbCustomerConfigQueryRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.config.BrcbCustomerConfigQueryResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.config.BrcbCustomerConfigRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.config.BrcbCustomerConfigResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.enter.BrcbCustomerEnterRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.enter.BrcbCustomerEnterResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.query.BrcbCustomerQueryRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.query.BrcbCustomerQueryResponseBody;
import com.minlia.iot.plugin.brcb.signature.BrcbCustomerServiceSignatureProcessor;
import com.minlia.iot.plugin.brcb.signature.BrcbSignatureVerificationProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;
import com.minlia.iot.plugin.brcb.requestor.BrcbCustomerServiceApiHttpRequestor;
import com.minlia.iot.plugin.brcb.scope.BrcbApiScope;

/**
 * Created by will on 9/10/17.
 * BRCB进件接口为示例, 将继续添加其它接口进来
 */
public class BrcbCustomerServiceApi extends AbstractJsonApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public BrcbCustomerServiceApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public BrcbCustomerServiceApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);

    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(BrcbStatefulApiResponseBody.class);


    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new BrcbCustomerServiceSignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext.setSignatureVerificationProcessor(new BrcbSignatureVerificationProcessor());   //可以使用默认配置
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody customerEnter(BrcbCustomerEnterRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.CUSTOMER_ENTER.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbCustomerEnterResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbCustomerServiceApiHttpRequestor(processor).request(body);
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody customerQuery(BrcbCustomerQueryRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.CUSTOMER_ENTER.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbCustomerQueryResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbCustomerServiceApiHttpRequestor(processor).request(body);
  }

  /**
   * 商户公众账号配置
   * http://note.youdao.com/share/?token=44AF662F83914546B6F7F93FFBBE69F0&gid=47293425#/
   * @param body
   * @return
   */
  public StatefulApiResponseBody customerConfig(BrcbCustomerConfigRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.CUSTOMER_ENTER.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbCustomerConfigResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbCustomerServiceApiHttpRequestor(processor).request(body);
  }

  /**
   * 商户公众账号配置查询
   * http://note.youdao.com/share/?token=44AF662F83914546B6F7F93FFBBE69F0&gid=47293425#/
   * @param body
   * @return
   */
  public StatefulApiResponseBody customerConfig(BrcbCustomerConfigQueryRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.CUSTOMER_ENTER.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbCustomerConfigQueryResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbCustomerServiceApiHttpRequestor(processor).request(body);
  }

}
