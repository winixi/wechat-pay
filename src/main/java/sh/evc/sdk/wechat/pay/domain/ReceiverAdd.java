package sh.evc.sdk.wechat.pay.domain;

import sh.evc.sdk.wechat.pay.dict.ReceiverType;
import sh.evc.sdk.wechat.pay.dict.RelationType;

/**
 * 添加接收方
 *
 * @author winixi
 * @date 2021/1/28 5:10 PM
 */
public class ReceiverAdd {

  /**
   * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
   * PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
   * PERSONAL_SUB_OPENID: 个人sub_openid（由子商户APPID转换得到）
   */
  private ReceiverType type;

  /**
   * 类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
   * 类型是PERSONAL_OPENID时，是个人openid
   * 类型是PERSONAL_SUB_OPENID时，是个人sub_openid
   */
  private String account;

  /**
   * 分账接收方类型是MERCHANT_ID时，是商户全称（必传）
   * 分账接收方类型是PERSONAL_OPENID时，是个人姓名（选传，传则校验）
   * 分账接收方类型是PERSONAL_SUB_OPENID时，是个人姓名（选传，传则校验）
   */
  private String name;

  /**
   * 与分账方的关系类型
   */
  private RelationType relationType;

  /**
   * 子商户与接收方具体的关系，本字段最多10个字。
   * 当字段relation_type的值为CUSTOM时，本字段必填
   * 当字段relation_type的值不为CUSTOM时，本字段无需填写
   */
  private String customRelation;

  public ReceiverAdd(ReceiverType type, String account, String name, RelationType relationType) {
    this.type = type;
    this.account = account;
    this.name = name;
    this.relationType = relationType;
  }

  public ReceiverType getType() {
    return type;
  }

  public void setType(ReceiverType type) {
    this.type = type;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RelationType getRelationType() {
    return relationType;
  }

  public void setRelationType(RelationType relationType) {
    this.relationType = relationType;
  }

  public String getCustomRelation() {
    return customRelation;
  }

  public void setCustomRelation(String customRelation) {
    this.customRelation = customRelation;
  }
}
