package com.melip.webservices.service.layout;

import com.melip.webservices.service.common.SearchCondition;

/**
 * レイアウト関連の検索条件クラスです。
 */
public class LayoutSearchCondition extends SearchCondition {

  /** 対象スクリーンID */
  private Integer targetScreenId;

  /**
   * 対象スクリーンIDを取得します。
   * 
   * @return 対象スクリーンID
   */
  public Integer getTargetScreenId() {
    return targetScreenId;
  }

  /**
   * 対象スクリーンIDを設定します。
   * 
   * @param targetScreenId 対象スクリーンID
   */
  public void setTargetScreenId(Integer targetScreenId) {
    this.targetScreenId = targetScreenId;
  }

}
