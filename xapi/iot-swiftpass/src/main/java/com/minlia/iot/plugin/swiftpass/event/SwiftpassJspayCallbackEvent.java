package com.minlia.iot.plugin.swiftpass.event;


import org.springframework.context.ApplicationEvent;

public class SwiftpassJspayCallbackEvent extends ApplicationEvent {

    public SwiftpassJspayCallbackEvent(Object source) {
        super(source);
    }

}
