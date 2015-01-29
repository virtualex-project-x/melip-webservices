package com.melip.webservices.dto.facility;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;
import com.melip.common.dto.common.AttrDto;

/**
 * 施設DTO
 */
public class FacilityDto extends AbstractDto {

  /** 施設IDのフィールド名 */
  public static final String FIELD_FACILITY_ID = "facilityId";
  /** 属性DTOリストのフィールド名 */
  public static final String FIELD_ATTR_DTO_LIST = "attrDtoList";

  /** 施設ID */
  private Integer facilityId;
  /** 属性DTOリスト */
  private List<AttrDto> attrDtoList;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

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
