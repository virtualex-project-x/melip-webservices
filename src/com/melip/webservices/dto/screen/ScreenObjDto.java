package com.melip.webservices.dto.screen;

import com.melip.webservices.dto.common.AbstractDto;

/**
 * スクリーンの個々のオブジェクトを表すクラスです。
 */
public class ScreenObjDto extends AbstractDto {

  /** レイアウト_オブジェクトのID */
  private Integer layoutObjId;
  /** スクリーン_オブジェクトのID */
  private Integer screenObjId;
  /** 属性グループのID */
  private Integer attrGrpId;
  /** 属性グループの種別 */
  private String attrGrpType;
  /** 属性グループの名称 */
  private String attrGrpNm;
  /** 属性値 */
  private String attrVal;
  /** 属性値（コード） */
  private String attrCdVal;

  /**
   * レイアウト_オブジェクトのIDを取得します。
   * 
   * @return レイアウト_オブジェクトのID
   */
  public Integer getLayoutObjId() {
    return layoutObjId;
  }

  /**
   * レイアウト_オブジェクトのIDを設定します。
   * 
   * @param layoutObjId レイアウト_オブジェクトのID
   */
  public void setLayoutObjId(Integer layoutObjId) {
    this.layoutObjId = layoutObjId;
  }

  /**
   * スクリーン_オブジェクトのIDを取得します。
   * 
   * @return スクリーン_オブジェクトのID
   */
  public Integer getScreenObjId() {
    return screenObjId;
  }

  /**
   * スクリーン_オブジェクトのIDを設定します。
   * 
   * @param screenObjId スクリーン_オブジェクトのID
   */
  public void setScreenObjId(Integer screenObjId) {
    this.screenObjId = screenObjId;
  }

  /**
   * 属性グループのIDを取得します。
   * 
   * @return 属性グループのID
   */
  public Integer getAttrGrpId() {
    return attrGrpId;
  }

  /**
   * 属性グループのIDを設定します。
   * 
   * @param attrGrpId 属性グループのID
   */
  public void setAttrGrpId(Integer attrGrpId) {
    this.attrGrpId = attrGrpId;
  }

  /**
   * 属性グループの種別を取得します。
   * 
   * @return 属性グループの種別
   */
  public String getAttrGrpType() {
    return attrGrpType;
  }

  /**
   * 属性グループの種別を設定します。
   * 
   * @param attrGrpType 属性グループの種別
   */
  public void setAttrGrpType(String attrGrpType) {
    this.attrGrpType = attrGrpType;
  }

  /**
   * 属性グループの名称を取得します。
   * 
   * @return 属性グループの名称
   */
  public String getAttrGrpNm() {
    return attrGrpNm;
  }

  /**
   * 属性グループの名称を設定します。
   * 
   * @param attrGrpNm 属性グループの名称
   */
  public void setAttrGrpNm(String attrGrpNm) {
    this.attrGrpNm = attrGrpNm;
  }

  /**
   * 属性値を取得します。
   * 
   * @return 属性値
   */
  public String getAttrVal() {
    return attrVal;
  }

  /**
   * 属性値を設定します。
   * 
   * @param attrVal 属性値
   */
  public void setAttrVal(String attrVal) {
    this.attrVal = attrVal;
  }

  /**
   * 属性値（コード）を取得します。
   * 
   * @return 属性値（コード）
   */
  public String getAttrCdVal() {
    return attrCdVal;
  }

  /**
   * 属性値（コード）を設定します。
   * 
   * @param attrCdVal 属性値（コード）
   */
  public void setAttrCdVal(String attrCdVal) {
    this.attrCdVal = attrCdVal;
  }



}
