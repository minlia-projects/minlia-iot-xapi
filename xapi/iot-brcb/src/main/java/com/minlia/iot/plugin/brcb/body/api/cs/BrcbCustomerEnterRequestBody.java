package com.minlia.iot.plugin.brcb.body.api.cs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbSettleProcessMode;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbCustomerEnterRequestBody extends BrcbCustomerServiceApiHttpRequestBody {

  /**
   * 下游商户号(唯一)	outMchId	是	varchar(32)	可用于查询商户信息
   */
  @XmlElement(name = "outMchId", required = true)
  @JsonProperty(value = "outMchId")
  private String outMchId;

  /**
   * 商户类型	customerType	是	varchar(32)	个体：PERSONAL 企业：ENTERPRISE
   */
  @XmlElement(name = "customerType", required = true)
  @JsonProperty(value = "customerType")
  private String customerType;

  /**
   * 经营行业	businessType	是	Int(5)	详见:经营行业列表
   * http://note.youdao.com/groupshare/?token=6084D34731534395A58D86AFBF0F2F18&gid=47293425
   */
  @XmlElement(name = "businessType", required = true)
  @JsonProperty(value = "businessType")
  private Integer businessType;

  /**
   * 经营名称	businessName	是	varchar(50)	支付成功显示
   */
  @XmlElement(name = "businessName", required = true)
  @JsonProperty(value = "businessName")
  private String businessName;


  /**
   * 商户名称	customerName		varchar(32)	必填
   */
  @XmlElement(name = "customerName", required = true)
  @JsonProperty(value = "customerName")
  private String customerName;

  /**
   * 法人身份证	legalId	是	varchar(32)
   */
  @XmlElement(name = "legalId", required = true)
  @JsonProperty(value = "legalId")
  private String legalId;

  /**
   * 法人名称	legalName	是	varchar(32)
   */
  @XmlElement(name = "legalName", required = true)
  @JsonProperty(value = "legalName")
  private String legalName;

  /**
   * 联系人	legalName	是	varchar(32)
   */
  @XmlElement(name = "contact", required = true)
  @JsonProperty(value = "contact")
  private String contact;

  /**
   * 联系人电话	contactPhone	是	varchar(16)	手机号
   */
  @XmlElement(name = "contactPhone", required = true)
  @JsonProperty(value = "contactPhone")
  private String contactPhone;

  /**
   * 联系人邮箱	contactEmail	是	varchar(32)
   */
  @XmlElement(name = "contactEmail", required = true)
  @JsonProperty(value = "contactEmail")
  private String contactEmail;

  /**
   * 联系人账号	contactId	否	varchar(32)	微信号：打开微信，在"个人信息"中查看到的"微信号";
   */
  @XmlElement(name = "contactId")
  @JsonProperty(value = "contactId")
  private String contactId;

  /**
   * 联系人账号类型	contactType	否	varchar(32)	值为type_wechatid
   */
  @XmlElement(name = "contactType")
  @JsonProperty(value = "contactType")
  private String contactType;


  /**
   * 客服电话	servicePhone	是	varchar(32)	座机号
   */
  @XmlElement(name = "servicePhone", required = true)
  @JsonProperty(value = "servicePhone")
  private String servicePhone;


  /**
   * 经营地址	businessAddress	否	varchar(32)	支付宝必传，商户经营地址
   */
  @XmlElement(name = "businessAddress")
  @JsonProperty(value = "businessAddress")
  private String businessAddress;

  /**
   * 经营省	provinceName		varchar(32)	企业商户必填
   */
  @XmlElement(name = "provinceName")
  @JsonProperty(value = "provinceName")
  private String provinceName;

  /**
   * 经营市	cityName		varchar(32)	企业商户必填
   */
  @XmlElement(name = "cityName")
  @JsonProperty(value = "cityName")
  private String cityName;
  /**
   * 经营区	districtName		varchar(32)	企业商户必填
   */
  @XmlElement(name = "districtName")
  @JsonProperty(value = "districtName")
  private String districtName;


  /**
   * 注册地址	address		varchar(32)	企业商户必填
   */
  @XmlElement(name = "address")
  @JsonProperty(value = "address")
  private String address;


  /**
   * 营业执照	licenseNo		varchar(32)	企业商户必填
   */
  @XmlElement(name = "licenseNo")
  @JsonProperty(value = "licenseNo")
  private String licenseNo;
  /**
   * 支付通道类型	payChannel	是	varchar(32)	查看支付通道类型
   * //http://note.youdao.com/share/?token=21ABDED8F2644CD083D64A7D90A03E74&gid=47293425#/
   */
  @XmlElement(name = "payChannel", required = true)
  @JsonProperty(value = "payChannel")
  private BrcbPayChannel payChannel;

  /**
   * 交易费率	rate	是	Decimal(20,8)	百分比，0.5为千五
   */
  @XmlElement(name = "rate", required = true)
  @JsonProperty(value = "rate")
  private BigDecimal rate;

  /**
   * 是否开通T+0	t0Status	是	varchar(16)	开通：Y／关闭：N
   */
  @XmlElement(name = "t0Status", required = true)
  @JsonProperty(value = "t0Status")
  private String t0Status;

  /**
   * T+0费率	settleRate	是	Decimal(20,8)	百分比，0.5为千五
   */
  @XmlElement(name = "settleRate", required = true)
  @JsonProperty(value = "settleRate")
  private BigDecimal settleRate;

  /**
   * T+0单笔加收费用	fixedFee	是	Decimal(20,8)	单位：元（未开通T+0 填写0）
   */
  @XmlElement(name = "fixedFee", required = true)
  @JsonProperty(value = "fixedFee")
  private BigDecimal fixedFee;

  /**
   * 是否封顶	isCapped	是	varchar(16)	封顶：Y／不封顶：N
   */
  @XmlElement(name = "isCapped", required = true)
  @JsonProperty(value = "isCapped")
  private String isCapped;

  /**
   * 结算模式	settleMode	是	varchar(32)	查看结算模式
   * http://note.youdao.com/share/?token=B675723C6D8E412C9A9A324053CD4896&gid=47293425#/
   */
  @XmlElement(name = "settleMode", required = true)
  @JsonProperty(value = "settleMode")
  private BrcbSettleProcessMode settleMode;


  /**
   * 封顶值	upperFee	是	Decimal(20,8)	单位：元，当IS_CAPPED为Y时，否则请填写0
   */
  @XmlElement(name = "upperFee", required = true)
  @JsonProperty(value = "upperFee")
  private BigDecimal upperFee;

  /**
   * 银行卡账户类型	accountType	是	varchar(32)	个体户：PERSONAL 公户：COMPANY
   */
  @XmlElement(name = "accountType", required = true)
  @JsonProperty(value = "accountType")
  private String accountType;

  /**
   * 开户名	accountName	是	varchar(32)	银行开户名称
   */
  @XmlElement(name = "accountName", required = true)
  @JsonProperty(value = "accountName")
  private String accountName;


  /**
   * 银行卡号	bankCard	是	varchar(32)
   */
  @XmlElement(name = "bankCard", required = true)
  @JsonProperty(value = "bankCard")
  private String bankCard;

  /**
   * 开户行名称	bankName	是	varchar(32)
   */
  @XmlElement(name = "bankName", required = true)
  @JsonProperty(value = "bankName")
  private String bankName;

  /**
   * 开户行省份	province	是	varchar(32)
   */
  @XmlElement(name = "province", required = true)
  @JsonProperty(value = "province")
  private String province;

  /**
   * 开户行城市	city	是	varchar(32)
   */
  @XmlElement(name = "city", required = true)
  @JsonProperty(value = "city")
  private String city;

  /**
   * 开户行支行	bankAddress	是	varchar(32)
   */
  @XmlElement(name = "bankAddress", required = true)
  @JsonProperty(value = "bankAddress")
  private String bankAddress;

  /**
   * 联行号	alliedBankNo	是	Int(12)	务必准确，否则会影响结算
   */
  @XmlElement(name = "alliedBankNo", required = true)
  @JsonProperty(value = "alliedBankNo")
  private Integer alliedBankNo;

  /**
   * 身份证正面	rightID	否	varchar(32)	查看上传方式
   */
  @XmlElement(name = "rightID")
  @JsonProperty(value = "rightID")
  private String rightID;

  /**
   * 身份证反面	reservedID	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "reservedID")
  @JsonProperty(value = "reservedID")
  private String reservedID;

  /**
   * 手持身份证	IDWithHand	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "IDWithHand")
  @JsonProperty(value = "IDWithHand")
  private String IDWithHand;

  /**
   * 银行卡正面	rightBankCard	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "rightBankCard")
  @JsonProperty(value = "rightBankCard")
  private String rightBankCard;

  /**
   * 营业执照	licenseImage	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "licenseImage")
  @JsonProperty(value = "licenseImage")
  private String licenseImage;

  /**
   * 门面照	doorHeadImage	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "doorHeadImage")
  @JsonProperty(value = "doorHeadImage")
  private String doorHeadImage;

  /**
   * 开户许可证	accountLicence	否	varchar(64)	查看上传方式
   */
  @XmlElement(name = "accountLicence")
  @JsonProperty(value = "accountLicence")
  private String accountLicence;

  /**
   * 签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
