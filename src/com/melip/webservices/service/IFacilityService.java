package com.melip.webservices.service;

import java.util.List;

import com.melip.webservices.dto.FacilityDto;


/**
 * 施設のサービスインタフェースです。
 */
public interface IFacilityService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "facilityService";

  /**
   * 施設の一覧を取得します。
   * 
   * @return 施設DTOリスト
   */
  public List<FacilityDto> getFacilityList();

  /**
   * 施設を1件取得します。
   * 
   * @param facilityId 施設ID
   * @return 施設DTO
   */
  public FacilityDto getFacility(Integer facilityId);

}
