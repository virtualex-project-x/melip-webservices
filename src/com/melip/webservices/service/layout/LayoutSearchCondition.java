package com.melip.webservices.service.layout;

import com.melip.webservices.service.common.SearchCondition;

/**
 * レイアウト関連の検索条件クラスです。
 */
public class LayoutSearchCondition extends SearchCondition {

  /** スクリーンオブジェクトID */
  private Integer screenObjId;

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
   * @param screenObjId the screenObjId to set
   */
  public void setScreenObjId(Integer screenObjId) {
    this.screenObjId = screenObjId;
  }


}
