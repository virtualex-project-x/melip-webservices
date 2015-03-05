package com.melip.webservices.service.facility;

import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.entity.Facility;
import com.melip.webservices.entity.FacilityAttrVal;
import com.melip.webservices.entity.FacilityAttrValLang;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のサービスインタフェースです。
 */
public interface IFacilityService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "facilityService";

  /**
   * 施設DTOリストを取得します。
   * 
   * @param langDiv 言語区分
   * @return 施設DTOリスト
   */
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv);

  /**
   * 施設DTOリストを取得します。<br>
   * 指定された位置から指定された件数分施設情報を返します。
   * 
   * @param langDiv 言語区分
   * @param index 開始位置
   * @param count 件数
   * @return 施設情報DTOリスト
   */
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv, Integer index, Integer count);

  /**
   * 施設DTOリストを取得します。
   * 
   * @param condition 検索条件
   * @return 施設情報DTOリスト
   */
  public DtoList<FacilityDto> getFacilityDtoList(QueryCondition condition);

  /**
   * 施設DTOを取得します。
   * 
   * @param langDiv 言語区分
   * @param facilityId 施設ID
   * @return 施設DTO
   */
  public FacilityDto getFacilityDto(String langDiv, Integer facilityId);

  /**
   * 施設DTOを取得します。
   * 
   * @param condition 検索条件
   * @return 施設DTO
   */
  public FacilityDto getFacilityDto(QueryCondition condition);

  /**
   * 施設を更新します。
   * 
   * @param facility 施設
   * @return 更新件数
   */
  public int updateFacility(Facility facility);

  /**
   * 子施設を一括更新します。
   * 
   * @param parentFacilityId 親施設ID
   * @param facility 施設
   * @return 更新件数
   */
  public int updateChildFacilityByParentFacilityId(Integer parentFacilityId, Facility facility);

  /**
   * 施設属性値を一括更新します。
   * 
   * @param facilityId 施設ID
   * @param facilityAttrVal 施設属性値
   * @return 更新件数
   */
  public int updateFacilityAttrValByFacilityId(Integer facilityId, FacilityAttrVal facilityAttrVal);

  /**
   * 施設属性値_多言語を一括更新します。
   * 
   * @param facilityId 施設ID
   * @param langDiv 言語区分。nullの場合はすべての言語区分が更新対象になります。
   * @param facilityAttrValLang 施設属性値_多言語
   * @return 更新件数
   */
  public int updateFacilityAttrValLangByFacilityId(Integer facilityId, String langDiv,
      FacilityAttrValLang facilityAttrValLang);

  /**
   * 施設情報を論理削除します。
   * 
   * @param facilityId 施設ID
   */
  public void logicalDeleteFacility(Integer facilityId);

}
