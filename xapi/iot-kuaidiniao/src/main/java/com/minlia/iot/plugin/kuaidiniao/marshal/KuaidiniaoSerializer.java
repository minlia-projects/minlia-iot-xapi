package com.minlia.iot.plugin.kuaidiniao.marshal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.minlia.iot.marshal.serialize.AbstractAnnotationApiSerializer;
import com.minlia.iot.scope.HttpMediaType;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by will on 9/10/17.
 */
@Slf4j
public class KuaidiniaoSerializer<T> extends AbstractAnnotationApiSerializer<T> {

  @Override
  public String serialize(T body, HttpMediaType type) {
    return serializeAsJson(body);
  }

  public String serializeAsJson(T body) {
    String result = "";
    try {
      result = jsonMapper.writeValueAsString(body);
      log.debug("With post {}", result);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    StringBuilder requestParams = new StringBuilder();
    try {

      HashMap<String, String> result1 = jsonMapper.readValue(result, HashMap.class);
      for (Map.Entry<String, String> entry : result1.entrySet()) {
        if (requestParams.length() > 0) {
          requestParams.append("&");
        }
        requestParams.append(entry.getKey());
        requestParams.append("=");
        requestParams.append(entry.getValue());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return requestParams.toString();
  }

}
