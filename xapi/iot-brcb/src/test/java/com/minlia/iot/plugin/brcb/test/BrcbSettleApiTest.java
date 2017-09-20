package com.minlia.iot.plugin.brcb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbSettleMode;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleQueryResponseBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleRequestBody;
import com.minlia.iot.plugin.brcb.BrcbAbstractTest;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleQueryRequestBody;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbT0SettleResponseBody;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
public class BrcbSettleApiTest extends BrcbAbstractTest {

  @Test
  public void test_t0settle_with_failure_result() {

    //创建请求体
    BrcbT0SettleRequestBody body = new BrcbT0SettleRequestBody();

    //设置请求参数
    body.setOrderNum("ORDERNUM-000000001");


    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbT0SettleResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbSettleApi
        .sandbox(true)
        .t0Settle(body);


    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);

    //由于提交的参数不全, 所以预期出现以下错误
    assertEquals("CS001000", statefulApiResponseBody.getReturnCode());
    assertEquals("代理商信息不存在", statefulApiResponseBody.getReturnMsg());


  }

  @Test
  public void test_t0settle_query_with_failure_result() {

    //创建请求体
    BrcbT0SettleQueryRequestBody body = new BrcbT0SettleQueryRequestBody();

    //设置请求参数
    body.setSettleNum("SETTLENUM-00000001");
    body.setOutTradeNo("OUTTRADENO-000001");
    body.setSettleMode(BrcbSettleMode.SINGLE);



    //设置为沙箱模式
    brcbCustomerServiceApi.sandbox(true);

    //返回被封装成2层
    //1. 状态化的返回体, 负责整体api调用是否成功型封装
    //2. 具体业务需要的返回体, 在状态化的返回体中 payload中承载, 负责业务返回
    BrcbStatefulApiResponseBody<BrcbT0SettleQueryResponseBody> statefulApiResponseBody = (BrcbStatefulApiResponseBody) brcbSettleApi
        .t0SettleQuery(body);


    //断言状态化返回体不可以为空
    assertNotNull(statefulApiResponseBody);

    //由于提交的参数不全, 所以预期出现以下错误
    assertEquals("FAIL", statefulApiResponseBody.getReturnCode());
    assertEquals("结算信息不存在", statefulApiResponseBody.getReturnMsg());


  }


}