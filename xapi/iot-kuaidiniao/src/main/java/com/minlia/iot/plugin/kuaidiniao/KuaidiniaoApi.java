package com.minlia.iot.plugin.kuaidiniao;

import com.minlia.iot.api.AbstractJsonApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.http.FormDataWithJsonApiHttpExecutor;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryRequestBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoQueryResponseBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoStatefulApiResponseBody;
import com.minlia.iot.plugin.kuaidiniao.marshal.KuaidiniaoDeserializer;
import com.minlia.iot.plugin.kuaidiniao.marshal.KuaidiniaoSerializer;
import com.minlia.iot.plugin.kuaidiniao.requestor.KuaidiniaoDefaultApiHttpRequestor;
import com.minlia.iot.plugin.kuaidiniao.scope.KuaidiniaoProductionApiScope;
import com.minlia.iot.plugin.kuaidiniao.signature.KuaidiniaoSignatureProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;
import com.minlia.iot.scope.HttpMediaType;

/**
 * Created by will on 9/10/17.
 * 最终Api样例
 */
public class KuaidiniaoApi extends AbstractJsonApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public KuaidiniaoApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public KuaidiniaoApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);
    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(KuaidiniaoStatefulApiResponseBody.class);

    //需要特别指定的
    apiRuntimeContext.setHttpMediaType(HttpMediaType.Hybrid);
    apiRuntimeContext.setApiDeserializer(new KuaidiniaoDeserializer<>());    //可以使用默认配置
    apiRuntimeContext.setApiSerializer(new KuaidiniaoSerializer<>());
    apiRuntimeContext.setApiHttpExecutor(new FormDataWithJsonApiHttpExecutor());

    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new KuaidiniaoSignatureProcessor());

  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody query(KuaidiniaoQueryRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(KuaidiniaoProductionApiScope.KUAIDINIAO_QUERY.name());

    apiRuntimeContext.setBusinessResponseBodyClass(KuaidiniaoQueryResponseBody.class);

    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    return new KuaidiniaoDefaultApiHttpRequestor(processor).request(body);
  }

}
