package com.melip.webservices.dto;

import com.melip.common.dto.common.AbstractDto;
import com.melip.webservices.entity.Layout;
import com.melip.webservices.entity.LayoutObj;
import com.melip.webservices.entity.LayoutObjGrp;
import com.melip.webservices.entity.Screen;
import com.melip.webservices.entity.ScreenObj;

/**
 * レイアウト・スクリーンDTO
 */
public class LayoutScreenDto extends AbstractDto {

  /** レイアウトのフィールド名 */
  public static final String FIELD_LAYOUT = "layout";
  /** レイアウトオブジェクトグループのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ_GRP = "layoutObjGrp";
  /** レイアウトオブジェクトのフィールド名 */
  public static final String FIELD_LAYOUT_OBJ = "layoutObj";
  /** スクリーンのフィールド名 */
  public static final String FIELD_SCREEN = "screen";
  /** スクリーンオブジェクトのフィールド名 */
  public static final String FIELD_SCREEN_OBJ = "screenObj";

  /** レイアウト・スクリーンID（ユニークとなるスクリーンオブジェクトIDが設定される */
  private Integer layoutScreenId;
  /** レイアウト */
  private Layout layout;
  /** レイアウトオブジェクトグループ */
  private LayoutObjGrp layoutObjGrp;
  /** レイアウトオブジェクト */
  private LayoutObj layoutObj;
  /** スクリーン */
  private Screen screen;
  /** スクリーンオブジェクト */
  private ScreenObj screenObj;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * レイアウト・スクリーンIDを取得します。
   * 
   * @return レイアウト・スクリーンID
   */
  public Integer getLayoutScreenId() {
    return layoutScreenId;
  }

  /**
   * レイアウト・スクリーンIDを設定します。
   * 
   * @param layoutScreenId レイアウト・スクリーンID
   */
  public void setLayoutScreenId(Integer layoutScreenId) {
    this.layoutScreenId = layoutScreenId;
  }

  /**
   * レイアウトを取得します。
   * 
   * @return レイアウト
   */
  public Layout getLayout() {
    return layout;
  }

  /**
   * レイアウトを設定します。
   * 
   * @param layout レイアウト
   */
  public void setLayout(Layout layout) {
    this.layout = layout;
  }

  /**
   * レイアウトオブジェクトグループを取得します。
   * 
   * @return レイアウトオブジェクトグループ
   */
  public LayoutObjGrp getLayoutObjGrp() {
    return layoutObjGrp;
  }

  /**
   * レイアウトオブジェクトグループを設定します。
   * 
   * @param layoutObjGrp レイアウトオブジェクトグループ
   */
  public void setLayoutObjGrp(LayoutObjGrp layoutObjGrp) {
    this.layoutObjGrp = layoutObjGrp;
  }

  /**
   * レイアウトオブジェクトを取得します。
   * 
   * @return レイアウトオブジェクト
   */
  public LayoutObj getLayoutObj() {
    return layoutObj;
  }

  /**
   * レイアウトオブジェクトを設定します。
   * 
   * @param layoutObj レイアウトオブジェクト
   */
  public void setLayoutObj(LayoutObj layoutObj) {
    this.layoutObj = layoutObj;
  }

  /**
   * スクリーンを取得します。
   * 
   * @return スクリーン
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * スクリーンを設定します。
   * 
   * @param screen スクリーン
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * スクリーンオブジェクトを取得します。
   * 
   * @return スクリーンオブジェクト
   */
  public ScreenObj getScreenObj() {
    return screenObj;
  }

  /**
   * スクリーンオブジェクトを設定します。
   * 
   * @param screenObj スクリーンオブジェクト
   */
  public void setScreenObj(ScreenObj screenObj) {
    this.screenObj = screenObj;
  }

}
