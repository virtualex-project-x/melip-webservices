package com.melip.webservices.service.facility;

import java.util.List;

import com.melip.webservices.dto.facility.FacilityDto;

/**
 * 施設のサービスインタフェースです。
 */
public interface IFacilityService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "facilityService";

  /**
   * 全施設情報を取得します。
   * 
   * @param langDiv 言語区分
   * @return 施設DTOリスト
   */
  public List<FacilityDto> getFacilityList(String langDiv);

  /**
   * 全施設情報を取得します。<br>
   * 属性情報は受け取った施設属性グループの情報のみです。
   * 
   * @param langDiv 言語区分
   * @param facilityAttrGrpId 施設属性グループID
   * @return
   */
  public List<FacilityDto> getFacilityList(String langDiv, Integer facilityAttrGrpId);

  /**
   * 受け取った地域に所属する施設情報を取得します。<br>
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @return 施設DTOリスト
   */
  public List<FacilityDto> getFacilityListByRegion(String langDiv, Integer regionId);

  /**
   * 受け取った地域に所属する施設情報を取得します。<br>
   * 属性情報は受け取った施設属性グループの情報のみです。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param facilityAttrGrpId 施設属性グループID
   * @return 施設DTOリスト
   */
  public List<FacilityDto> getFacilityListByRegion(String langDiv, Integer regionId,
      Integer facilityAttrGrpId);

  /**
   * 施設情報を取得します。
   * 
   * @param langDiv 言語区分
   * @param facilityId 施設ID
   * @return 施設DTO
   */
  public FacilityDto getFacility(String langDiv, Integer facilityId);

  /**
   * 施設情報を取得します。<br>
   * 属性情報は受け取った施設属性グループの情報のみです。
   * 
   * @param langDiv 言語区分
   * @param facilityId 施設ID
   * @param facilityAttrGrpId 施設属性グループID
   * @return 施設DTO
   */
  public FacilityDto getFacility(String langDiv, Integer facilityId, Integer facilityAttrGrpId);

}
