package com.minlia.iot.plugin.swiftpass.endpoint;


import com.minlia.iot.plugin.swiftpass.body.jspay.SwiftpassCallbackRequestBody;
import com.minlia.iot.plugin.swiftpass.event.SwiftpassJspayCallbackEvent;
import com.minlia.iot.plugin.swiftpass.util.SignUtils;
import com.minlia.iot.plugin.swiftpass.util.XmlUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by will on 9/15/17.
 * api/open/callback/unified/payment/alipay
 */
@Slf4j
@RestController
@RequestMapping(value = "api/open/callback/swiftpass")
@Api(tags = "支付-回调", description = "支付-回调")
public class SwiftpassJspayCallbackReceiveEndpoint {

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping(value = "jspay")
    @ApiOperation(value = "支付宝回调", notes = "支付宝回调", response = String.class, httpMethod = "POST")
    public String process(HttpServletRequest request,@RequestBody SwiftpassCallbackRequestBody requestBody) {
        if (isOfficialNotificationRequest(request)) {
            SwiftpassCallbackRequestBody body = new SwiftpassCallbackRequestBody();
            publisher.publishEvent(new SwiftpassJspayCallbackEvent(requestBody));
            return "success";
        } else {
            return "fail";
        }
    }

    private Boolean isOfficialNotificationRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
            String resString = XmlUtils.parseRequst(request);
            System.out.println("通知内容：" + resString);
            if(resString != null && !"".equals(resString)){
                Map<String,String> map = null;
                map = XmlUtils.toMap(resString.getBytes(), "utf-8");

                String res = XmlUtils.toXml(map);
                System.out.println("通知内容：" + res);
                if(map.containsKey("sign")){
                    //"威富通交易密钥"
                    String secretKey = "3686385300072b8a7704105f802a41a0";
                    if(!SignUtils.checkParam(map, secretKey)){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}