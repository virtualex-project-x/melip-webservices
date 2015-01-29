package com.melip.webservices.dto.layout;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;

/**
 * レイアウト・スクリーンオブジェクトDTO
 */
public class LayoutScreenObjDto extends AbstractDto {

  /** レイアウトオブジェクトIDのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_ID = "layoutObjId";
  /** レイアウトオブジェクトエイリアスのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_ALIAS = "layoutObjAlias";
  /** レイアウトオブジェクト名称のフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_NM = "layoutObjNm";
  /** レイアウトオブジェクト種別のフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_TYPE = "layoutObjType";
  /** スクリーンオブジェクトIDのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_ID = "screenObjId";
  /** スクリーンオブジェクト属性DTOリストのフィールド名 */
  public static final String FIELD_SCREEN_OBJ_ATTR_DTO_LIST = "screenObjAttrDtoList";

  /** レイアウトオブジェクトID */
  private Integer layoutObjId;
  /** レイアウトオブジェクトエイリアス */
  private String layoutObjAlias;
  /** レイアウトオブジェクト名称 */
  private String layoutObjNm;
  /** レイアウトオブジェクト種別 */
  private String layoutObjType;
  /** スクリーンオブジェクトID */
  private Integer screenObjId;
  /** スクリーンオブジェクト属性DTOリスト */
  private List<ScreenObjAttrDto> screenObjAttrDtoList;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * レイアウトオブジェクトIDを取得します。
   * 
   * @return レイアウトオブジェクトID
   */
  public Integer getLayoutObjId() {
    return layoutObjId;
  }

  /**
   * レイアウトオブジェクトIDを設定します。
   * 
   * @param layoutObjId レイアウトオブジェクトID
   */
  public void setLayoutObjId(Integer layoutObjId) {
    this.layoutObjId = layoutObjId;
  }

  /**
   * レイアウトオブジェクトエイリアスを取得します。
   * 
   * @return レイアウトオブジェクトエイリアス
   */
  public String getLayoutObjAlias() {
    return layoutObjAlias;
  }

  /**
   * レイアウトオブジェクトエイリアスを設定します。
   * 
   * @param layoutObjAlias レイアウトオブジェクトエイリアス
   */
  public void setLayoutObjAlias(String layoutObjAlias) {
    this.layoutObjAlias = layoutObjAlias;
  }

  /**
   * レイアウトオブジェクト名称を取得します。
   * 
   * @return レイアウトオブジェクト名称
   */
  public String getLayoutObjNm() {
    return layoutObjNm;
  }

  /**
   * レイアウトオブジェクト名称を設定します。
   * 
   * @param layoutObjNm レイアウトオブジェクト名称
   */
  public void setLayoutObjNm(String layoutObjNm) {
    this.layoutObjNm = layoutObjNm;
  }

  /**
   * レイアウトオブジェクト種別を取得します。
   * 
   * @return レイアウトオブジェクト種別
   */
  public String getLayoutObjType() {
    return layoutObjType;
  }

  /**
   * レイアウトオブジェクト種別を設定します。
   * 
   * @param layoutObjType レイアウトオブジェクト種別
   */
  public void setLayoutObjType(String layoutObjType) {
    this.layoutObjType = layoutObjType;
  }

  /**
   * スクリーンオブジェクトIDを取得します。
   * 
   * @return スクリーンオブジェクトID
   */
  public Integer getScreenObjId() {
    return screenObjId;
  }

  /**
   * スクリーンオブジェクトIDを設定します。
   * 
   * @param screenObjId スクリーンオブジェクトID
   */
  public void setScreenObjId(Integer screenObjId) {
    this.screenObjId = screenObjId;
  }

  /**
   * スクリーンオブジェクト属性DTOリストを取得します。
   * 
   * @return スクリーンオブジェクト属性DTOリスト
   */
  public List<ScreenObjAttrDto> getScreenObjAttrDtoList() {
    return screenObjAttrDtoList;
  }

  /**
   * スクリーンオブジェクト属性DTOリストを設定します。
   * 
   * @param screenObjAttrDtoList スクリーンオブジェクト属性DTOリスト
   */
  public void setScreenObjAttrDtoList(List<ScreenObjAttrDto> screenObjAttrDtoList) {
    this.screenObjAttrDtoList = screenObjAttrDtoList;
  }

}
