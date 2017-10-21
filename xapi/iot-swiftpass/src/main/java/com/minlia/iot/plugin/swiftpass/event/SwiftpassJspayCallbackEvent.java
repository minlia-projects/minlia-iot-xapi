package com.minlia.iot.plugin.swiftpass.event;


import com.minlia.iot.plugin.swiftpass.body.jspay.SwiftpassCallbackRequestBody;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class SwiftpassJspayCallbackEvent extends ApplicationEvent {

    public SwiftpassJspayCallbackEvent(SwiftpassCallbackRequestBody source) {
        super(source);
    }

}
