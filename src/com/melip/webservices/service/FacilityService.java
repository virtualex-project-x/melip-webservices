package com.melip.webservices.service;

import java.util.List;

import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.service.common.AbstractService;

/**
 * 施設のサービスクラスです。
 */
public class FacilityService extends AbstractService implements IFacilityService {

  /** 施設情報取得SQL_ID */
  private String selectFacilitySqlId;

  /**
   * @see com.melip.webservices.service.IFacilityService#getFacilityList()
   */
  @Override
  public List<FacilityDto> getFacilityList() {

    List<FacilityDto> facilityDtoList = getSession().selectList(getSelectFacilitySqlId());
    return facilityDtoList;
  }

  /**
   * @see com.melip.webservices.service.IFacilityService#getFacility(java.lang.Integer)
   */
  @Override
  public FacilityDto getFacility(Integer facilityId) {

    FacilityDto facilityDto = getSession().selectOne(getSelectFacilitySqlId(), facilityId);
    return facilityDto;
  }

  /**
   * 施設情報取得SQL_IDを取得します。
   * 
   * @return 施設情報取得SQL_ID
   */
  public String getSelectFacilitySqlId() {
    return selectFacilitySqlId;
  }

  /**
   * 施設情報取得SQL_IDを設定します。
   * 
   * @param selectFacilitySqlId 施設情報取得SQL_ID
   */
  public void setSelectFacilitySqlId(String selectFacilitySqlId) {
    this.selectFacilitySqlId = selectFacilitySqlId;
  }


}
