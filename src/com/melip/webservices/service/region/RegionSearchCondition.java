package com.melip.webservices.service.region;

import com.melip.webservices.service.common.SearchCondition;

/**
 * 地域関連の検索条件クラスです。
 */
public class RegionSearchCondition extends SearchCondition {

  /** 地域ID */
  private Integer regionId;
  /** 地域属性グループID */
  private Integer regionAttrGrpId;

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
   * 地域属性グループIDを取得します。
   * 
   * @return 地域属性グループID
   */
  public Integer getRegionAttrGrpId() {
    return regionAttrGrpId;
  }

  /**
   * 地域属性グループIDを設定します。
   * 
   * @param regionAttrGrpId 地域属性グループID
   */
  public void setRegionAttrGrpId(Integer regionAttrGrpId) {
    this.regionAttrGrpId = regionAttrGrpId;
  }

}
