package com.melip.webservices.dto;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.melip.common.dto.common.AbstractDto;
import com.melip.common.dto.common.AttrDto;

/**
 * 施設DTO
 */
public class FacilityDto extends AbstractDto {

  /** エンティティ */
  public static final String ENTITY = "Facility";

  /** 施設IDのフィールド名 */
  public static final String FIELD_FACILITY_ID = "facilityId";
  /** 緯度のフィールド名 */
  public static final String FIELD_LATITUDE = "latitude";
  /** 経度のフィールド名 */
  public static final String FIELD_LONGITUDE = "longitude";
  /** 属性DTOリストのフィールド名 */
  public static final String FIELD_ATTR_DTO_LIST = "attrDtoList";

  /** 施設ID */
  private Integer facilityId;
  /** 緯度 */
  private Float latitude;
  /** 経度 */
  private Float longitude;
  /** 属性DTOリスト */
  private List<AttrDto> attrDtoList;

  /**
   * 属性グループエイリアスを元に属性値を取得します。
   * 
   * @param attrGrpAlias 属性グループエイリアス
   * @return 属性値
   */
  public String getAttrVal(String attrGrpAlias) {

    String attrVal = null;

    if (CollectionUtils.isNotEmpty(getAttrDtoList())) {
      for (AttrDto attrDto : getAttrDtoList()) {
        if (attrGrpAlias.equals(attrDto.getAttrGrpAlias())) {
          attrVal = attrDto.getAttrVal();
        }
      }
    }

    return attrVal;
  }

  /**
   * 施設IDを取得します。
   * 
   * @return 施設ID
   */
  public Integer getFacilityId() {
    return facilityId;
  }

  /**
   * 施設IDを設定します。
   * 
   * @param facilityId 施設ID
   */
  public void setFacilityId(Integer facilityId) {
    this.facilityId = facilityId;
  }

  /**
   * 緯度を取得します。
   * 
   * @return 緯度
   */
  public Float getLatitude() {
    return latitude;
  }

  /**
   * 緯度を設定します。
   * 
   * @param latitude 緯度
   */
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  /**
   * 経度を取得します。
   * 
   * @return 経度
   */
  public Float getLongitude() {
    return longitude;
  }

  /**
   * 経度を設定します。
   * 
   * @param longitude 経度
   */
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  /**
   * 属性DTOリストを取得します。
   * 
   * @return 属性DTOリスト
   */
  public List<AttrDto> getAttrDtoList() {
    return attrDtoList;
  }

  /**
   * 属性DTOリストを設定します。
   * 
   * @param attrDtoList 属性DTOリスト
   */
  public void setAttrDtoList(List<AttrDto> attrDtoList) {
    this.attrDtoList = attrDtoList;
  }

}
