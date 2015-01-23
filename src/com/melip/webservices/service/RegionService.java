package com.melip.webservices.service;

import java.util.List;

import com.melip.webservices.dto.RegionDto;
import com.melip.webservices.service.common.AbstractService;

/**
 * 地域のサービスクラスです。
 */
public class RegionService extends AbstractService implements IRegionService {

  /** 地域情報取得SQL_ID */
  private String selectRegionSqlId;

  /**
   * @see com.melip.webservices.service.IRegionService#getRegionList()
   */
  @Override
  public List<RegionDto> getRegionList() {

    List<RegionDto> regionDtoList = getSession().selectList(getSelectRegionSqlId());
    return regionDtoList;
  }

  /**
   * @see com.melip.webservices.service.IRegionService#getRegion(java.lang.Integer)
   */
  @Override
  public RegionDto getRegion(Integer regionId) {

    RegionDto regionDto = getSession().selectOne(getSelectRegionSqlId(), regionId);
    return regionDto;
  }

  /**
   * 地域情報取得SQL_IDを取得します。
   * 
   * @return 地域情報取得SQL_ID
   */
  public String getSelectRegionSqlId() {
    return selectRegionSqlId;
  }

  /**
   * 地域情報取得SQL_IDを設定します。
   * 
   * @param selectRegionSqlId 地域情報取得SQL_ID
   */
  public void setSelectRegionSqlId(String selectRegionSqlId) {
    this.selectRegionSqlId = selectRegionSqlId;
  }


}
