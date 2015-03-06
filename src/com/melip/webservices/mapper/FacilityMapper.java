package com.melip.webservices.mapper;

import java.util.List;

import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のマッパーインタフェースです。
 */
public interface FacilityMapper {

  public List<FacilityDto> getFacilityDto(QueryCondition condition);

  public int updateFacility(QueryCondition condition);

  public int updateChildFacilityByParentFacilityId(QueryCondition condition);

  public int updateFacilityAttrValByFacilityId(QueryCondition condition);

  public int updateFacilityAttrValLangByFacilityId(QueryCondition condition);

}
