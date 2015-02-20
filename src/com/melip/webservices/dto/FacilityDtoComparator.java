/**
 * 
 */
package com.melip.webservices.dto;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

import com.melip.common.dto.common.FacilityDto;

/**
 * 施設DTO用のコンパレータです。
 */
public class FacilityDtoComparator implements Comparator<FacilityDto> {

  /** 属性グループエイリアス */
  private String attrGrpAlias;
  /** 昇順か否か */
  private Boolean isAsc = Boolean.TRUE;
  /** nullが先か */
  private Boolean nullFirst = Boolean.TRUE;

  /**
   * コンストラクタ
   * 
   * @param attrGrpAlias 属性グループエイリアス
   * @param isAsc 昇順の場合 true、降順の場合 true
   * @param nullFirst nullが先の場合 true、後の場合 false
   */
  public FacilityDtoComparator(String attrGrpAlias, Boolean isAsc, Boolean nullFirst) {

    super();
    this.attrGrpAlias = attrGrpAlias;
    this.isAsc = isAsc;
    this.nullFirst = nullFirst;
  }

  /**
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(FacilityDto facilityDto1, FacilityDto facilityDto2) {

    int returnVal = 0;
    String val1 = facilityDto1.getAttrVal(getAttrGrpAlias());
    String val2 = facilityDto2.getAttrVal(getAttrGrpAlias());

    // 両方null
    if (StringUtils.isEmpty(val1) && StringUtils.isEmpty(val2)) {
      returnVal = 0;
    }
    // 左がnull
    else if (StringUtils.isEmpty(val1) && StringUtils.isNotEmpty(val2)) {
      if (nullFirst) {
        returnVal = -1;
      } else {
        returnVal = 1;
      }
    }
    // 右がnull
    else if (StringUtils.isNotEmpty(val1) && StringUtils.isEmpty(val2)) {
      if (nullFirst) {
        returnVal = 1;
      } else {
        returnVal = -1;
      }
    }
    // 両方nullでない
    else {
      returnVal = val1.compareTo(val2);
    }

    return isAsc ? returnVal : returnVal * -1;
  }

  /**
   * 属性グループエイリアスを取得します。
   * 
   * @return 属性グループエイリアス
   */
  public String getAttrGrpAlias() {
    return attrGrpAlias;
  }

  /**
   * 昇順か否かを取得します。
   * 
   * @return 昇順の場合 true、降順の場合 false
   */
  public Boolean isAsc() {
    return isAsc;
  }

  /**
   * nullが先かを取得します。
   * 
   * @return 先の場合 true、後の場合 false
   */
  public Boolean getNullFirst() {
    return nullFirst;
  }

}
