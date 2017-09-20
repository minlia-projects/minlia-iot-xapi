//package com.minlia.module.xapi.plugin.kuaidiniao;
//
//import com.minlia.module.xapi.api.Api;
//import com.minlia.module.xapi.api.annotation.ApiBundle;
//import com.minlia.module.xapi.api.annotation.ApiRequest;
//import com.minlia.module.xapi.body.response.StatefulApiResponseBody;
//import com.minlia.module.xapi.http.FormDataWithJsonApiHttpExecutor;
//import com.minlia.module.xapi.marshal.deserialize.JsonApiDeserializer;
//import com.minlia.module.xapi.plugin.kuaidiniao.body.KuaidiniaoQueryRequestBody;
//import com.minlia.module.xapi.plugin.kuaidiniao.body.KuaidiniaoQueryResponseBody;
//import com.minlia.module.xapi.plugin.kuaidiniao.body.KuaidiniaoStatefulApiResponseBody;
//import com.minlia.module.xapi.plugin.kuaidiniao.config.KuaidiniaoApiCredentialConfiguration;
//import com.minlia.module.xapi.plugin.kuaidiniao.marshal.KuaidiniaoSerializer;
//import com.minlia.module.xapi.requestor.HttpRequestMethod;
//import com.minlia.module.xapi.scope.HttpMediaType;
//
///**
// * Created by will on 9/17/17.
// */
//@ApiBundle(
//    name = "kuaidiniaoApi",
//    runtimeProfile = KuaidiniaoApiCredentialConfiguration.class,
//    statefulResponseBodyClass = KuaidiniaoStatefulApiResponseBody.class,
//    httpMediaType = HttpMediaType.Hybrid,
//    deserializer = JsonApiDeserializer.class,
//    serializer = KuaidiniaoSerializer.class,
//    executor = FormDataWithJsonApiHttpExecutor.class,
//    httpRequestMethod= HttpRequestMethod.POST
//)
//
//public interface KdnApi extends Api {
//
//  /**
//   * 查询接口
//   */
//  @ApiRequest(scope = {"query"},httpRequestMethod = HttpRequestMethod.POST,response = KuaidiniaoQueryResponseBody.class)
//  public StatefulApiResponseBody<KuaidiniaoQueryResponseBody> query(KuaidiniaoQueryRequestBody body);
//
//
//  /**
//   * 创建新的API处理器
//   */
//  @ApiRequest(scope = {"create"},httpRequestMethod = HttpRequestMethod.POST,response = KuaidiniaoQueryResponseBody.class)
//  public StatefulApiResponseBody<KuaidiniaoQueryResponseBody> create(KuaidiniaoQueryRequestBody body);
//
//
//}