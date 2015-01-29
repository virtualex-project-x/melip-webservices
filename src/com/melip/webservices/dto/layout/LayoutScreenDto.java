package com.melip.webservices.dto.layout;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;

/**
 * レイアウト・スクリーンDTO
 */
public class LayoutScreenDto extends AbstractDto {

  /** レイアウトIDのフィールド名 */
  public static final String FIELD_LAYOUT_ID = "layoutId";
  /** レイアウトエイリアスのフィールド名 */
  public static final String FIELD_LAYOUT_ALIAS = "layoutAlias";
  /** レイアウト名称のフィールド名 */
  public static final String FIELD_LAYOUT_NM = "layoutNm";
  /** レイアウト種別のフィールド名 */
  public static final String FIELD_LAYOUT_TYPE = "layoutType";
  /** レイアウト種別コードエイリアスのフィールド名 */
  public static final String FIELD_LAYOUT_TYPE_CD_ALIAS = "layoutTypeCdAlias";
  /** スクリーンIDのフィールド名 */
  public static final String FIELD_SCREEN_ID = "screenId";
  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** スクリーンエンティティのフィールド名 */
  public static final String FIELD_SCREEN_ENTITY = "screenEntity";
  /** スクリーン名称のフィールド名 */
  public static final String FIELD_SCREEN_NM = "screenNm";
  /** レイアウト・スクリーンオブジェクトグループDTOリストのフィールド名 */
  public static final String FIELD_LAYOUT_SCREEN_OBJ_GRP_DTO_LIST = "layoutScreenObjGrpDtoList";

  /** レイアウトID */
  private Integer layoutId;
  /** レイアウトエイリアス */
  private String layoutAlias;
  /** レイアウト名称 */
  private String layoutNm;
  /** レイアウト種別 */
  private String layoutType;
  /** レイアウト種別コードエイリアス */
  private String layoutTypeCdAlias;
  /** スクリーンID */
  private Integer screenId;
  /** 地域ID */
  private Integer regionId;
  /** スクリーンエンティティ */
  private String screenEntity;
  /** スクリーン名称 */
  private String screenNm;
  /** レイアウト・スクリーンオブジェクトグループDTOリスト */
  private List<LayoutScreenObjGrpDto> layoutScreenObjGrpDtoList;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * レイアウトIDを取得します。
   * 
   * @return レイアウトID
   */
  public Integer getLayoutId() {
    return layoutId;
  }

  /**
   * レイアウトIDを設定します。
   * 
   * @param layoutId レイアウトID
   */
  public void setLayoutId(Integer layoutId) {
    this.layoutId = layoutId;
  }

  /**
   * レイアウトエイリアスを取得します。
   * 
   * @return レイアウトエイリアス
   */
  public String getLayoutAlias() {
    return layoutAlias;
  }

  /**
   * レイアウトエイリアスを設定します。
   * 
   * @param layoutAlias レイアウトエイリアス
   */
  public void setLayoutAlias(String layoutAlias) {
    this.layoutAlias = layoutAlias;
  }

  /**
   * レイアウト名称を取得します。
   * 
   * @return レイアウト名称
   */
  public String getLayoutNm() {
    return layoutNm;
  }

  /**
   * レイアウト名称を設定します。
   * 
   * @param layoutNm レイアウト名称
   */
  public void setLayoutNm(String layoutNm) {
    this.layoutNm = layoutNm;
  }

  /**
   * レイアウト種別を取得します。
   * 
   * @return レイアウト種別
   */
  public String getLayoutType() {
    return layoutType;
  }

  /**
   * レイアウト種別を設定します。
   * 
   * @param layoutType レイアウト種別
   */
  public void setLayoutType(String layoutType) {
    this.layoutType = layoutType;
  }

  /**
   * レイアウト種別コードエイリアスを取得します。
   * 
   * @return レイアウト種別コードエイリアス
   */
  public String getLayoutTypeCdAlias() {
    return layoutTypeCdAlias;
  }

  /**
   * レイアウト種別コードエイリアスを設定します。
   * 
   * @param layoutTypeCdAlias レイアウト種別コードエイリアス
   */
  public void setLayoutTypeCdAlias(String layoutTypeCdAlias) {
    this.layoutTypeCdAlias = layoutTypeCdAlias;
  }

  /**
   * スクリーンIDを取得します。
   * 
   * @return スクリーンID
   */
  public Integer getScreenId() {
    return screenId;
  }

  /**
   * スクリーンIDを設定します。
   * 
   * @param screenId スクリーンID
   */
  public void setScreenId(Integer screenId) {
    this.screenId = screenId;
  }

  /**
   * 地域IDを取得します。
   * 
   * @return 地域ID
   */
  public Integer getRegionId() {
    return regionId;
  }

  /**
   * 地域IDを設定します。
   * 
   * @param regionId 地域ID
   */
  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  /**
   * スクリーンエンティティを取得します。
   * 
   * @return スクリーンエンティティ
   */
  public String getScreenEntity() {
    return screenEntity;
  }

  /**
   * スクリーンエンティティを設定します。
   * 
   * @param screenEntity スクリーンエンティティ
   */
  public void setScreenEntity(String screenEntity) {
    this.screenEntity = screenEntity;
  }

  /**
   * スクリーン名称を取得します。
   * 
   * @return スクリーン名称
   */
  public String getScreenNm() {
    return screenNm;
  }

  /**
   * スクリーン名称を設定します。
   * 
   * @param screenNm スクリーン名称
   */
  public void setScreenNm(String screenNm) {
    this.screenNm = screenNm;
  }

  /**
   * レイアウト・スクリーンオブジェクトグループDTOリストを取得します。
   * 
   * @return レイアウト・スクリーンオブジェクトグループDTOリスト
   */
  public List<LayoutScreenObjGrpDto> getLayoutScreenObjGrpDtoList() {
    return layoutScreenObjGrpDtoList;
  }

  /**
   * レイアウト・スクリーンオブジェクトグループDTOリストを設定します。
   * 
   * @param layoutScreenObjGrpDtoList レイアウト・スクリーンオブジェクトグループDTOリスト
   */
  public void setLayoutScreenObjGrpDtoList(List<LayoutScreenObjGrpDto> layoutScreenObjGrpDtoList) {
    this.layoutScreenObjGrpDtoList = layoutScreenObjGrpDtoList;
  }

}
