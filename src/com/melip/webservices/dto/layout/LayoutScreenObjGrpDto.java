package com.melip.webservices.dto.layout;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;

/**
 * レイアウト・スクリーンオブジェクトグループDTO
 */
public class LayoutScreenObjGrpDto extends AbstractDto {

  /** レイアウトオブジェクトグループIDのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_GRP_ID = "layoutObjGrpId";
  /** レイアウトオブジェクトグループエイリアスのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_GRP_ALIAS = "layoutObjGrpAlias";
  /** 多重度のフィールド名 */
  public static final String FIELD_MULTIPLICITY = "multiplicity";
  /** スクリーンオブジェクトグループIDのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_GRP_ID = "screenObjGrpId";
  /** スクリーンオブジェクトグループエンティティのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_GRP_ENTITY = "screenObjGrpEntity";
  /** 遷移先スクリーンIDのフィールド名 */
  public static final String FIELD_TARGET_SCREEN_ID = "targetScreenId";
  /** レイアウト・スクリーンオブジェクトDTOリストのフィールド名 */
  public static final String FIELD_LAYOUT_SCREEN_OBJ_DTO_LIST = "layoutScreenObjDtoList";

  /** レイアウトオブジェクトグループID */
  private Integer layoutObjGrpId;
  /** レイアウトオブジェクトグループエイリアス */
  private String layoutObjGrpAlias;
  /** 多重度 */
  private String multiplicity;
  /** スクリーンオブジェクトグループID */
  private Integer screenObjGrpId;
  /** スクリーンオブジェクトグループエンティティ */
  private String screenObjGrpEntity;
  /** 遷移先スクリーンID */
  private Integer targetScreenId;
  /** レイアウト・スクリーンオブジェクトDTOリスト */
  private List<LayoutScreenObjDto> layoutScreenObjDtoList;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * レイアウトオブジェクトグループIDを取得します。
   * 
   * @return レイアウトオブジェクトグループID
   */
  public Integer getLayoutObjGrpId() {
    return layoutObjGrpId;
  }

  /**
   * レイアウトオブジェクトグループIDを設定します。
   * 
   * @param layoutObjGrpId レイアウトオブジェクトグループID
   */
  public void setLayoutObjGrpId(Integer layoutObjGrpId) {
    this.layoutObjGrpId = layoutObjGrpId;
  }

  /**
   * レイアウトオブジェクトグループエイリアスを取得します。
   * 
   * @return レイアウトオブジェクトグループエイリアス
   */
  public String getLayoutObjGrpAlias() {
    return layoutObjGrpAlias;
  }

  /**
   * レイアウトオブジェクトグループエイリアスを設定します。
   * 
   * @param layoutObjGrpAlias レイアウトオブジェクトグループエイリアス
   */
  public void setLayoutObjGrpAlias(String layoutObjGrpAlias) {
    this.layoutObjGrpAlias = layoutObjGrpAlias;
  }

  /**
   * 多重度を取得します。
   * 
   * @return 多重度
   */
  public String getMultiplicity() {
    return multiplicity;
  }

  /**
   * 多重度を設定します。
   * 
   * @param multiplicity 多重度
   */
  public void setMultiplicity(String multiplicity) {
    this.multiplicity = multiplicity;
  }

  /**
   * スクリーンオブジェクトグループIDを取得します。
   * 
   * @return スクリーンオブジェクトグループID
   */
  public Integer getScreenObjGrpId() {
    return screenObjGrpId;
  }

  /**
   * スクリーンオブジェクトグループIDを設定します。
   * 
   * @param screenObjGrpId スクリーンオブジェクトグループID
   */
  public void setScreenObjGrpId(Integer screenObjGrpId) {
    this.screenObjGrpId = screenObjGrpId;
  }

  /**
   * スクリーンオブジェクトグループエンティティを取得します。
   * 
   * @return スクリーンオブジェクトグループエンティティ
   */
  public String getScreenObjGrpEntity() {
    return screenObjGrpEntity;
  }

  /**
   * スクリーンオブジェクトグループエンティティを設定します。
   * 
   * @param screenObjGrpEntity スクリーンオブジェクトグループエンティティ
   */
  public void setScreenObjGrpEntity(String screenObjGrpEntity) {
    this.screenObjGrpEntity = screenObjGrpEntity;
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

  /**
   * レイアウト・スクリーンオブジェクトDTOリストを取得します。
   * 
   * @return レイアウト・スクリーンオブジェクトDTOリスト
   */
  public List<LayoutScreenObjDto> getLayoutScreenObjDtoList() {
    return layoutScreenObjDtoList;
  }

  /**
   * レイアウト・スクリーンオブジェクトDTOリストを設定します。
   * 
   * @param layoutScreenObjDtoList レイアウト・スクリーンオブジェクトDTOリスト
   */
  public void setLayoutScreenObjDtoList(List<LayoutScreenObjDto> layoutScreenObjDtoList) {
    this.layoutScreenObjDtoList = layoutScreenObjDtoList;
  }

}
