package com.minlia.iot.plugin.swiftpass.body.jspay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpResponseBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by will on 9/10/17.
 */
public class SwiftpassWechatJspayPayInfoBody {

  private String appId;

  private String timeStamp;

  private String status;

  private String signType;

  @JsonProperty(value = "package")
  private String packages;

  @JsonProperty(value = "callbackUrl")
  private String callback_url;

  private String nonceStr;

  private String paySign;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSignType() {
    return signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getPackage() {
    return packages;
  }

  public void setPackage(String packages) {
    this.packages = packages;
  }

  public String getCallback_url() {
    return callback_url;
  }

  public void setCallback_url(String callback_url) {
    this.callback_url = callback_url;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getPaySign() {
    return paySign;
  }

  public void setPaySign(String paySign) {
    this.paySign = paySign;
  }
}
