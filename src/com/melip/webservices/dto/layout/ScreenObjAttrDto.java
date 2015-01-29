package com.melip.webservices.dto.layout;

import com.melip.common.dto.common.AbstractDto;

/**
 * スクリーンオブジェクト属性DTO
 */
public class ScreenObjAttrDto extends AbstractDto {

  /** スクリーンオブジェクト属性IDのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_ATTR_ID = "screenObjAttrId";
  /** スクリーンオブジェクト属性エンティティのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_ATTR_ENTITY = "screenObjAttrEntity";
  /** 属性グループIDのフィールド名 */
  public static final String FIELD_ATTR_GRP_ID = "attrGrpId";
  /** 表示順のフィールド名 */
  public static final String FIELD_DISPLAY_NUM = "displayNum";
  /** 遷移先スクリーンIDのフィールド名 */
  public static final String FIELD_TARGET_SCREEN_ID = "targetScreenId";

  /** スクリーンオブジェクト属性ID */
  private Integer screenObjAttrId;
  /** スクリーンオブジェクト属性エンティティ */
  private String screenObjAttrEntity;
  /** 属性グループID */
  private Integer attrGrpId;
  /** 表示順 */
  private Integer displayNum;
  /** 遷移先スクリーンID */
  private Integer targetScreenId;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * スクリーンオブジェクト属性IDを取得します。
   * 
   * @return スクリーンオブジェクト属性ID
   */
  public Integer getScreenObjAttrId() {
    return screenObjAttrId;
  }

  /**
   * スクリーンオブジェクト属性IDを設定します。
   * 
   * @param screenObjAttrId スクリーンオブジェクト属性ID
   */
  public void setScreenObjAttrId(Integer screenObjAttrId) {
    this.screenObjAttrId = screenObjAttrId;
  }

  /**
   * スクリーンオブジェクト属性エンティティを取得します。
   * 
   * @return スクリーンオブジェクト属性エンティティ
   */
  public String getScreenObjAttrEntity() {
    return screenObjAttrEntity;
  }

  /**
   * スクリーンオブジェクト属性エンティティを設定します。
   * 
   * @param screenObjAttrEntity スクリーンオブジェクト属性エンティティ
   */
  public void setScreenObjAttrEntity(String screenObjAttrEntity) {
    this.screenObjAttrEntity = screenObjAttrEntity;
  }

  /**
   * 属性グループIDを取得します。
   * 
   * @return 属性グループID
   */
  public Integer getAttrGrpId() {
    return attrGrpId;
  }

  /**
   * 属性グループIDを設定します。
   * 
   * @param attrGrpId 属性グループID
   */
  public void setAttrGrpId(Integer attrGrpId) {
    this.attrGrpId = attrGrpId;
  }

  /**
   * 表示順を取得します。
   * 
   * @return 表示順
   */
  public Integer getDisplayNum() {
    return displayNum;
  }

  /**
   * 表示順を設定します。
   * 
   * @param displayNum 表示順
   */
  public void setDisplayNum(Integer displayNum) {
    this.displayNum = displayNum;
  }

  /**
   * 遷移先スクリーンIDを取得します。
   * 
   * @return 遷移先スクリーンID
   */
  public Integer getTargetScreenId() {
    return targetScreenId;
  }

  /**
   * 遷移先スクリーンIDを設定します。
   * 
   * @param targetScreenId 遷移先スクリーンID
   */
  public void setTargetScreenId(Integer targetScreenId) {
    this.targetScreenId = targetScreenId;
  }

}
