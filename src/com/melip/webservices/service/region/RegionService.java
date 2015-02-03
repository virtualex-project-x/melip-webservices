package com.melip.webservices.service.region;

import java.util.List;

import com.melip.webservices.dto.region.RegionDto;
import com.melip.webservices.service.common.AbstractDataService;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 地域のサービスクラスです。
 */
public class RegionService extends AbstractDataService implements IRegionService {

  /** 地域情報取得SQL_ID */
  private String selectRegionSqlId;

  /**
   * @see com.melip.webservices.service.region.IRegionService#getRegionList(java.lang.String)
   */
  @Override
  public List<RegionDto> getRegionList(String langDiv) {
    return getRegionList(langDiv, null);
  }

  /**
   * @see com.melip.webservices.service.region.IRegionService#getRegionList(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public List<RegionDto> getRegionList(String langDiv, Integer regionAttrGrpId) {

    QueryCondition condition = new QueryCondition(langDiv);
    // TODO:ベタ書き
    condition.setValue("regionAttrGrpId", regionAttrGrpId);
    List<RegionDto> regionDtoList = selectList(getSelectRegionSqlId(), condition);

    return regionDtoList;
  }

  /**
   * @see com.melip.webservices.service.region.IRegionService#getRegion(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public RegionDto getRegion(String langDiv, Integer regionId) {
    return getRegion(langDiv, regionId, null);
  }

  /**
   * @see com.melip.webservices.service.region.IRegionService#getRegion(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  public RegionDto getRegion(String langDiv, Integer regionId, Integer regionAttrGrpId) {

    QueryCondition condition = new QueryCondition(langDiv);
    // TODO:ベタ書き
    condition.setValue("regionId", regionId);
    condition.setValue("regionAttrGrpId", regionAttrGrpId);
    RegionDto regionDto = selectOne(getSelectRegionSqlId(), condition);

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
