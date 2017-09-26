package com.minlia.iot.plugin.brcb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.BrcbWechatAbstractTest;
import com.minlia.iot.plugin.brcb.body.api.cs.enter.BrcbCustomerEnterRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.enter.BrcbCustomerEnterResponseBody;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class BrcbWechatCustomerServiceApiTest extends BrcbWechatAbstractTest {

  @Test
  public void test_with_failure_result() {

    //创建请求体
    BrcbCustomerEnterRequestBody body = new BrcbCustomerEnterRequestBody();

    //设置请求参数
    body.setServiceType("CUSTOMER_ENTER");
    body.setOutMchId("OUTMCHID000000001");

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbCustomerEnterResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbCustomerServiceApi
       .sandbox(true)
        .customerEnter(body);

    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);

    //由于提交的参数不全, 所以预期出现以下错误
    assertEquals("CS001005", statefulApiResponseBody.getReturnCode());
    assertEquals("无效的商户类型", statefulApiResponseBody.getReturnMsg());


  }


}