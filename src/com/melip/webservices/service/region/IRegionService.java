package com.melip.webservices.service.region;

import java.util.List;

import com.melip.webservices.dto.region.RegionDto;

/**
 * 地域のサービスインタフェースです。
 */
public interface IRegionService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "regionService";

  /**
   * 全地域情報を取得します。
   * 
   * @param langDiv 言語区分
   * @return 地域DTOリスト
   */
  public List<RegionDto> getRegionList(String langDiv);

  /**
   * 全地域情報を取得します。<br>
   * 属性情報は受け取った地域属性グループの情報のみです。
   * 
   * @param langDiv 言語区分
   * @param regionAttrGrpId 地域属性グループID
   * @return 地域DTOリスト
   */
  public List<RegionDto> getRegionList(String langDiv, Integer regionAttrGrpId);

  /**
   * 地域情報を取得します。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @return 地域DTO
   */
  public RegionDto getRegion(String langDiv, Integer regionId);

  /**
   * 地域情報を取得します。<br>
   * 属性情報は受け取った地域属性グループの情報のみです。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param regionAttrGrpId 地域属性グループID
   * @return 地域DTOリスト
   */
  public RegionDto getRegion(String langDiv, Integer regionId, Integer regionAttrGrpId);
}
