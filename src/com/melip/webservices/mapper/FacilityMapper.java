package com.melip.webservices.mapper;

import java.util.List;

import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.entity.Facility;
import com.melip.webservices.entity.FacilityAttrVal;
import com.melip.webservices.entity.FacilityAttrValLang;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のマッパーインタフェースです。
 */
public interface FacilityMapper {

  public List<FacilityDto> getFacilityDtoList(QueryCondition condition);

  public Facility getFacility(QueryCondition condition);

  public FacilityAttrValLang getFacilityAttrValLang(QueryCondition condition);

  public int insertFacility(Facility facility);

  public int insertFacilityAttrVal(FacilityAttrVal facilityAttrVal);

  public int insertFacilityAttrValLang(FacilityAttrValLang facilityAttrValLang);

  public int updateFacility(QueryCondition condition);

  public int updateFacilityAttrVal(QueryCondition condition);

  public int updateFacilityAttrValLang(QueryCondition condition);

  public int updateChildFacilityByParentFacilityId(QueryCondition condition);

  public int updateFacilityAttrValByFacilityId(QueryCondition condition);

  public int updateFacilityAttrValLangByFacilityId(QueryCondition condition);

}
