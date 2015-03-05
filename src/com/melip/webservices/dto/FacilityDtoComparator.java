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

    String val1 = null;
    String val2 = null;
    String attrGrpAlias = getAttrGrpAlias();

    if (FacilityDto.FIELD_DISTANCE.equals(attrGrpAlias)) {
      val1 = null == facilityDto1.getDistance() ? null : String.valueOf(facilityDto1.getDistance());
      val2 = null == facilityDto2.getDistance() ? null : String.valueOf(facilityDto2.getDistance());
    } else {
      val1 = facilityDto1.getAttrVal(getAttrGrpAlias());
      val2 = facilityDto2.getAttrVal(getAttrGrpAlias());
    }

    int returnVal = 0;

    // 両方null
    if (StringUtils.isEmpty(val1) && StringUtils.isEmpty(val2)) {
      returnVal = 0;
    }
    // 左がnull
    else if (StringUtils.isEmpty(val1) && StringUtils.isNotEmpty(val2)) {
      returnVal = nullFirst ? -1 : 1;
    }
    // 右がnull
    else if (StringUtils.isNotEmpty(val1) && StringUtils.isEmpty(val2)) {
      returnVal = nullFirst ? 1 : -1;
    }
    // 両方nullでない
    else {
      if (FacilityDto.FIELD_DISTANCE.equals(attrGrpAlias)) {
        returnVal = facilityDto1.getDistance().compareTo(facilityDto2.getDistance());
      } else {
        returnVal = val1.compareTo(val2);
      }
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
