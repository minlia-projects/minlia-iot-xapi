//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.minlia.iot.plugin.pooulcloud.marshal;

import com.alibaba.fastjson.JSONObject;
import com.minlia.cloud.marshall.JsonHelper;
import com.minlia.iot.body.ApiHttpResponseBody;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.context.ApiRuntimeContext;
import com.minlia.iot.marshal.ApiMarshalWrappedBody;
import com.minlia.iot.marshal.deserialize.JsonApiDeserializer;
import com.minlia.iot.plugin.pooulcloud.body.PooulcloudPayInfoResponseBody;
import com.minlia.iot.plugin.pooulcloud.body.SwiftpassApiHttpResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

@Slf4j
public class PooulcloudDeserializer<T extends SwiftpassApiHttpResponseBody> extends JsonApiDeserializer<T> {

  public PooulcloudDeserializer() {
  }


  @Override
  public StatefulApiResponseBody<T> execute(ApiMarshalWrappedBody body,ApiRuntimeContext context) {
    StatefulApiResponseBody statefulApiResponseBody = (StatefulApiResponseBody) JsonHelper
        .deserialize(body.getRaw(), body.getStatefulResponseBodyClass());

    String raw=body.getRaw();

    JSONObject jsonObject= JSONObject.parseObject(raw);
    String data=jsonObject.get("data").toString();

    String payinfo=JSONObject.parseObject(data).get("pay_info").toString();
    PooulcloudPayInfoResponseBody pooulcloudPayInfoResponseBody=JsonHelper
        .deserialize(payinfo, PooulcloudPayInfoResponseBody.class);

//    ApiHttpDataResponseBody data=JsonHelper
//        .deserialize(raw, ApiHttpDataResponseBody.class);



    ApiHttpResponseBody apiHttpResponseBody = (ApiHttpResponseBody) JsonHelper
        .deserialize(payinfo, body.getBusinessResponseBodyClass());

    statefulApiResponseBody.setPayload(apiHttpResponseBody);

    return statefulApiResponseBody;
  }

}
