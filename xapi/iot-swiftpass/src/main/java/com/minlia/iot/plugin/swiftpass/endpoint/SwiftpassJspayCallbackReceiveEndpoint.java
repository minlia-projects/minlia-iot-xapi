//package com.minlia.iot.plugin.swiftpass.endpoint;
//
//
//import com.minlia.iot.plugin.swiftpass.body.jspay.SwiftpassCallbackRequestBody;
//import com.minlia.iot.plugin.swiftpass.event.SwiftpassJspayCallbackEvent;
//import com.minlia.iot.plugin.swiftpass.util.SignUtils;
//import com.minlia.iot.plugin.swiftpass.util.XmlUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by will on 9/15/17.
// * api/open/callback/unified/payment/alipay
// */
//@Slf4j
//@RestController
//@RequestMapping(value = "api/open/callback/swiftpass")
//@Api(tags = "支付-回调", description = "支付-回调")
//public class SwiftpassJspayCallbackReceiveEndpoint {
//
//    @Autowired
//    private ApplicationEventPublisher publisher;
//
//    @PostMapping(value = "jspay")
//    @ApiOperation(value = "支付宝回调", notes = "支付宝回调", response = String.class, httpMethod = "POST")
//    public String process(HttpServletRequest request,@RequestBody SwiftpassCallbackRequestBody requestBody) {
//
////        request.getInputStream().
//        List<String> list = null;
//        try {
//            list = IOUtils.readLines(request.getInputStream());
//            System.out.println(list.get(0));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        Map<String,String> properties = null;
//        try {
//            properties = BeanUtils.describe(requestBody);
//            System.out.println(properties);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        if (isOfficialNotificationRequest(request)) {
//            publisher.publishEvent(new SwiftpassJspayCallbackEvent(requestBody));
//            return "success";
//        } else {
////            return "fail";
//            return "success";
//        }
//    }
//
//    private String getRequestedXmlString(HttpServletRequest request) {
//        String requestedXmlString = null;
//        try {
//            BufferedReader reader = null;
//            reader = request.getReader();
//            String line = "";
//            StringBuffer inputString = new StringBuffer();
//            while ((line = reader.readLine()) != null) {
//                inputString.append(line);
//            }
//            requestedXmlString = inputString.toString();
//            request.getReader().close();
//            System.out.println("----接收到的数据如下：---" + requestedXmlString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return requestedXmlString;
//    }
//
//    private Boolean isOfficialNotificationRequest(Map<String,String> properties) {
//        System.out.println("Swiftpass通知内容：" + properties.toString());
//        if(properties.containsKey("sign")){
//            //"威富通交易密钥"
//            String secretKey = "7b4688f21bc8e4c29d432eb35fcbc790";
//            if(!SignUtils.checkParam(properties, secretKey)){
//                return false;
//            }else{
//                return true;
//            }
//        }
//        return false;
//    }
//    private Boolean isOfficialNotificationRequest(HttpServletRequest request) {
//        try {
//            request.setCharacterEncoding("utf-8");
//            String resString = XmlUtils.parseRequst(request);
//            System.out.println("通知内容：" + resString);
//
//            if(resString != null && !"".equals(resString)){
//                Map<String,String> map = XmlUtils.toMap(resString.getBytes(), "utf-8");
//                String res = XmlUtils.toXml(map);
//                System.out.println("通知内容：" + res);
//                if(map.containsKey("sign")){
//                    if(!SignUtils.checkParam(map, "3686385300072b8a7704105f802a41a0")){
//                        return false;
//                    }else{
//                        String status = map.get("status");
//                        if(status != null && "0".equals(status)){
//                            String result_code = map.get("result_code");
//                            if(result_code != null && "0".equals(result_code)){
//                                String out_trade_no = map.get("out_trade_no");
//                                //此处可以在添加相关处理业务，校验通知参数中的商户订单号out_trade_no和金额total_fee是否和商户业务系统的单号和金额是否一致，一致后方可更新数据库表中的记录。
//                            }
//                        }
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
////        try {
////            request.setCharacterEncoding("utf-8");
////            String resString = XmlUtils.parseRequst(request);
////            System.out.println("通知内容：" + resString);
////
////            if(resString != null && !"".equals(resString)){
////                Map<String,String> map = null;
////                map = XmlUtils.toMap(resString.getBytes(), "utf-8");
////
////                String res = XmlUtils.toXml(map);
////                System.out.println("通知内容：" + res);
////                if(map.containsKey("sign")){
////                    //"威富通交易密钥"  TODO
////                    String secretKey = "3686385300072b8a7704105f802a41a0";
////                    if(!SignUtils.checkParam(map, secretKey)){
////                        return false;
////                    }else{
////                        return true;
////                    }
////                }
////            }
////        } catch (UnsupportedEncodingException e) {
////            e.printStackTrace();
////        }  catch (Exception e) {
////            e.printStackTrace();
////        }
//        return false;
//    }
//
//}