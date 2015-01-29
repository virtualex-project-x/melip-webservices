package com.melip.webservices.dto.region;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;
import com.melip.common.dto.common.AttrDto;

/**
 * 地域DTO
 */
public class RegionDto extends AbstractDto {

  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** 属性DTOリストのフィールド名 */
  public static final String FIELD_ATTR_DTO_LIST = "attrDtoList";

  /** 地域ID */
  private Integer regionId;
  /** 属性DTOリスト */
  private List<AttrDto> attrDtoList;

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

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
