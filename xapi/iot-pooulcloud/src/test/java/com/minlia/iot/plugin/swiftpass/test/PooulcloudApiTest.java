package com.minlia.iot.plugin.swiftpass.test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.minlia.iot.body.SignatureBody;
import com.minlia.iot.plugin.pooulcloud.body.SwiftpassStatefulApiResponseBody;
import com.minlia.iot.plugin.pooulcloud.body.jspay.SwiftpassWechatJspayPaymentRequestBody;
import com.minlia.iot.plugin.pooulcloud.body.jspay.SwiftpassWechatJspayPaymentResponseBody;
import com.minlia.iot.plugin.swiftpass.SwiftpassAbstractTest;
import com.minlia.iot.signature.CaseControl;
import com.minlia.iot.signature.SignatureAlgorithmic;
import com.minlia.iot.signature.binder.SignatureBinder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Created by will on 9/10/17.
 */
@Slf4j
public class PooulcloudApiTest extends SwiftpassAbstractTest {

  @Test
  public void test_jspay_with_success_result() {

    //body=测试支付&charset=UTF-8&mch_id=8444812501217143&nonce_str=qXSWWJdIbuCOPGdyKXvlvNbcVKZLxj&out_trade_no=MINLIA-TEST-ORDER-5359822683&payType=wechat.jsapi&sign_type=MD5&total_fee=1&version=2.0&key=7B8CC56D58F81D7DACCE67C4D6C90E4D
    //把pay_info中的appId 替换为wx469ffdb81de47e4d，然后用这个密钥  6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr 重新计算 paySign
//{"code":0,"msg":"OK","data":{"appid":"wx26a0ffd6bfa99df7","sub_appid":"wx469ffdb81de47e4d","prepay_id":"wx120044241533465455a935262325943199","pay_info":"{\"appId\":\"wx26a0ffd6bfa99df7\",\"timeStamp\":\"1526057064\",\"nonceStr\":\"7KhCt1kO5Zjk8Wsv\",\"package\":\"prepay_id=wx120044241533465455a935262325943199\",\"signType\":\"MD5\",\"paySign\":\"DA4231910BCD7759AB93441CE2762823\"}","trade_id":"5af5c867fd4eb06e46c3261a","mch_trade_id":"MINLIA-TEST-ORDER-7757040984","merchant_id":"2302209837595143","pay_type":"wechat.jsapi","nonce_str":"5af5c868fd4eb06e46c3261d"},"version":"1.0","sign_type":"md5","sign":"FBD2226215C9F6F0A3C1C31D63D3EE38"}

//      {
//        "data": {
//           "appid": "wx26a0ffd6bfa99df7",
//          "sub_appid": "wx469ffdb81de47e4d",
//          "prepay_id": "wx1521101398908548b7cbf75f1090559034",
//          "pay_info": "{\"appId\":\"wx26a0ffd6bfa99df7\",\"timeStamp\":\"1526389814\",\"nonceStr\":\"rjtdjUjLck1lh9tW\",\"package\":\"prepay_id=wx1521101398908548b7cbf75f1090559034\",\"signType\":\"MD5\",\"paySign\":\"440537728C4050F5D123EE99D8F9C792\"}",
//          "trade_id": "5afadc35fd4eb06e4bc17029",
//          "mch_trade_id": "MINLIA-TEST-ORDER-2307894603",
//          "merchant_id": "2302209837595143",
//          "pay_type": "wechat.jsapi",
//          "nonce_str": "5afadc36fd4eb06e4bc1702c"
//        },

//        "code": 0,
//        "msg": "OK",

//        "version": "1.0",
//        "sign_type": "md5",
//        "sign": "61FB43E7B08FAD57A67DD1C8688E2050"
//  }

    SwiftpassWechatJspayPaymentRequestBody requestBody = new SwiftpassWechatJspayPaymentRequestBody();
//    requestBody.setAuthCode("134967598248771757");
//    requestBody.setSpbillCreateIp("127.0.0.1");
    requestBody.setSubAppid("wx469ffdb81de47e4d");
    requestBody.setSubOpenid("oerQA5Q5clTAK8eA3tGNOAiz7s4o");
//    requestBody.setOpenid("oZtcE0aIoRluOZ4XbfdHZFB6zG");
    requestBody.setMchTradeId("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
    requestBody.setTotalFee("1");
    requestBody.setBody("测试支付");
    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));

    //设置为沙箱模式
    swiftpassApi.sandbox(false);
    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi
        .wechatJspay(requestBody);

    assertNotNull(statefulApiResponseBody);
    assertTrue(statefulApiResponseBody.isSuccess());
    assertEquals("0", statefulApiResponseBody.getCode());

    SwiftpassWechatJspayPaymentResponseBody apiHttpResponseBody = (SwiftpassWechatJspayPaymentResponseBody) statefulApiResponseBody
        .getPayload();


    //把pay_info中的appId 替换为wx469ffdb81de47e4d，然后用这个密钥  6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr 重新计算 paySign
    //你相当于多做一步，把pay_info的信息调整一下
    //你调了以后可以用微信的工具校验一下https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=20_1
    apiHttpResponseBody.setAppId("wx469ffdb81de47e4d");
    SignatureBody signatureBody = new SignatureBody();
    signatureBody.setSalt("6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr");
    signatureBody.setAlgorithmic(SignatureAlgorithmic.MD5);
    signatureBody.setCaseControl(CaseControl.TO_UPPER_CASE);
    signatureBody.setExcludeSaltParameter(false);
    signatureBody.setSaltParameterPrefix("key=");
    signatureBody.setRaw(apiHttpResponseBody);
    signatureBody.setDelimiter("&");
    SignatureBinder.bind(signatureBody);

    String pkg = apiHttpResponseBody.getPkg();
    String newSign = apiHttpResponseBody.getPaySign();

    log.debug("最终需要的值");
    System.out.println("appId:" +apiHttpResponseBody.getAppId());
    System.out.println("package:" +pkg);
    System.out.println("timeStamp:" +apiHttpResponseBody.getTimeStamp());
    System.out.println("nonceStr:" +apiHttpResponseBody.getNonceStr());
    System.out.println("signType:" +apiHttpResponseBody.getSignType());
    System.out.println("paySign:" +newSign);


    //appid=wx469ffdb81de47e4d&nonceStr=wEblzLm9QBa33INB&package=prepay_id=wx16113952973414641c16d10e2510352351&signType=MD5&timeStamp=1526441993&key=6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr
    //appid=wx469ffdb81de47e4d&nonceStr=wEblzLm9QBa33INB&package=prepay_id=wx16113952973414641c16d10e2510352351&timeStamp=1526441993&key=6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr



    //appid=wx469ffdb81de47e4d&nonceStr=QTbsEmzyF7Jovf6K&package=prepay_id=wx161148028723301bdce6a9222808321886&signType=MD5&timeStamp=1526442482&key=6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr



//    swiftpassSignatureProcessor.sign(swiftpassApiHttpRequestBody);
    //拿这个去重新计算paySign

//    String appid = apiHttpResponseBody.getAppid();
//    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());

//    举例如下:
//    paySign = MD5(appId=wxd678efh567hg6787&nonceStr=5K8264ILTKCH16CQ2502SI8ZNMTM67VS&package=prepay_id=wx2017033010242291fcfe0db70013231072&signType=MD5&timeStamp=1490840662&key=qazwsxedcrfvtgbyhnujmikolp111111) = 22D9B4E54AB1950F51E0649E8810ACD6
//    详细签名算法请参考“签名算法”说明
//    调用wx.requestPayment(OBJECT)发起微信支付

    //appId=wx469ffdb81de47e4d&nonceStr=2inpmFosQuK3wz2B&package=prepay_id=wx16084952697184a4f3301c643387929693&timeStamp=1526431792&key=6Uc2ACa4EpRuZe86fetUsPEcuspUWUcr
    //paySign=DC0B4DC1268A65C5566E49017CBB95AA


  }

//
//  @Test
//  public void test_micripay_with_success_result() {
//
//    SwiftpassWechatMicropayRequestBody requestBody = new SwiftpassWechatMicropayRequestBody();
//
//    requestBody.setAuthCode("134967598248771757");
//    requestBody.setSpbillCreateIp("127.0.0.1");
//    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
//    requestBody.setTotalFee("1");
//    requestBody.setBody("测试支付");
//    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));
//
//    //设置为沙箱模式
//    swiftpassApi.sandbox(true);
//    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatMicropay(requestBody);
//
//    assertNotNull(statefulApiResponseBody);
//    assertTrue(statefulApiResponseBody.isSuccess());
//
//    assertEquals("0", statefulApiResponseBody.getCode());
//
//    SwiftpassWechatMicropayResponseBody apiHttpResponseBody = (SwiftpassWechatMicropayResponseBody) statefulApiResponseBody
//        .getPayload();
//
////    String appid = apiHttpResponseBody.getAppid();
////    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());
//
//  }
//
//
//  @Test
//  public void test_with_success_result() {
//
//    SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
//    requestBody.setMchCreateIp("127.0.0.1");
//    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
//    requestBody.setOutTradeNo("MINLIA-TEST-ORDER-" + RandomStringUtils.randomNumeric(10));//
//    requestBody.setTotalFee("1");
//    requestBody.setBody("测试支付");
//    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));
//
//    //设置为沙箱模式
//    swiftpassApi.sandbox(true);
//    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatNativePayment(requestBody);
//
//    assertNotNull(statefulApiResponseBody);
//    assertTrue(statefulApiResponseBody.isSuccess());
//
//    assertEquals("0", statefulApiResponseBody.getCode());
//
//    SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody
//        .getPayload();
//
//    String appid = apiHttpResponseBody.getAppid();
//    assertEquals("wx8632a91376b81e24", apiHttpResponseBody.getAppid());
//
//  }
//
//  @Test
//  public void test_with_order_already_paid_error_result() {
//
//    SwiftpassWechatNativePaymentRequestBody requestBody = new SwiftpassWechatNativePaymentRequestBody();
//    requestBody.setMchCreateIp("127.0.0.1");
//    requestBody.setNotifyUrl("http://227.0.0.1:9001/javak/");
//    requestBody.setOutTradeNo("141903606228");//
//    requestBody.setTotalFee("1");
//    requestBody.setBody("测试支付");
//    requestBody.setNonceStr(RandomStringUtils.randomAlphabetic(30));
//
//    //设置为沙箱模式
//    swiftpassApi.sandbox(true);
//    SwiftpassStatefulApiResponseBody statefulApiResponseBody = swiftpassApi.wechatNativePayment(requestBody);
//
//    assertNotNull(statefulApiResponseBody);
//    assertTrue(statefulApiResponseBody.isSuccess());
//    assertEquals("0", statefulApiResponseBody.getCode());
//    SwiftpassWechatNativePaymentResponseBody apiHttpResponseBody = (SwiftpassWechatNativePaymentResponseBody) statefulApiResponseBody
//        .getPayload();
//    assertEquals("Order paid", apiHttpResponseBody.getErrCode());
//    assertEquals("订单已支付", apiHttpResponseBody.getErrMsg());
//
//  }


}