package com.minlia.iot.plugin.kuaidiniao.marshal;

import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoApiHttpResponseBody;
import com.minlia.iot.marshal.deserialize.JsonApiDeserializer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by will on 9/10/17.
 */
@Slf4j
public class KuaidiniaoDeserializer<T extends KuaidiniaoApiHttpResponseBody> extends
    JsonApiDeserializer<T> {


}
