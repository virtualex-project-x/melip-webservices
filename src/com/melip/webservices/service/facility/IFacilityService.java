package com.melip.webservices.service.facility;

import com.melip.webservices.common.DtoList;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.service.common.QueryCondition;

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
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv);

  /**
   * 施設情報を複数件取得します。<br>
   * 指定された位置から指定された件数分施設情報を返します。
   * 
   * @param langDiv 言語区分
   * @param index 開始位置
   * @param count 件数
   * @return 施設情報DTOリスト
   */
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv, Integer index, Integer count);

  /**
   * 施設情報を複数件取得します。
   * 
   * @param condition 検索条件
   * @return 施設情報DTOリスト
   */
  public DtoList<FacilityDto> getFacilityDtoList(QueryCondition condition);

  /**
   * 施設情報を1件取得します。
   * 
   * @param langDiv 言語区分
   * @param facilityId 施設ID
   * @return 施設DTO
   */
  public FacilityDto getFacilityDto(String langDiv, Integer facilityId);

  /**
   * 施設情報を1件取得します。
   * 
   * @param condition 検索条件
   * @return 施設DTO
   */
  public FacilityDto getFacilityDto(QueryCondition condition);

}
