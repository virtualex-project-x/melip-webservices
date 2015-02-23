package com.melip.webservices.dto;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;

/**
 * 施設の検索条件用DTOです。
 */
public class FacilitySearchConditionDto extends AbstractDto {

  private static final long serialVersionUID = 1L;

  /** 取得対象属性グループエイリアスリストのフィールド名 */
  public static final String FIELD_TARGET_ATTR_GRP_ALIAS_LIST = "targetAttrGrpAliasList";
  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** 属性グループ検索条件DTOリストのフィールド名 */
  public static final String FIELD_ATTR_GRP_SEARCH_CONDITION_DTO_LIST =
      "attrGrpSearchConditionDtoList";
  /** 属性グループ検索条件の個数のフィールド名 */
  public static final String FIELD_NUM_OF_SEARCH_CONDITION = "numOfSearchCondition";

  /** 取得対象属性グループエイリアスリスト */
  private List<String> targetAttrGrpAliasList;
  /** 地域ID */
  private Integer regionId;
  /** 属性グループ検索条件DTOリスト */
  private List<AttrGrpSearchConditionDto> attrGrpSearchConditionDtoList;
  /** 属性グループ検索条件の個数 */
  private Integer numOfSearchCondition;

  /**
   * 取得対象属性グループエイリアスリストを取得します。
   * 
   * @return 取得対象属性グループエイリアスリスト
   */
  public List<String> getTargetAttrGrpAliasList() {
    return targetAttrGrpAliasList;
  }

  /**
   * 取得対象属性グループエイリアスリストを設定します。
   * 
   * @param targetAttrGrpAliasList 取得対象属性グループエイリアスリスト
   */
  public void setTargetAttrGrpAliasList(List<String> targetAttrGrpAliasList) {
    this.targetAttrGrpAliasList = targetAttrGrpAliasList;
  }

  /**
   * 地域IDを取得します。
   * 
   * @return 地域ID
   */
  public Integer getRegionId() {
    return regionId;
  }

  /**
   * 地域IDを設定します。
   * 
   * @param regionId 地域ID
   */
  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  /**
   * 属性グループ検索条件DTOリストを取得します。
   * 
   * @return 属性グループ検索条件DTOリスト
   */
  public List<AttrGrpSearchConditionDto> getAttrGrpSearchConditionDtoList() {
    return attrGrpSearchConditionDtoList;
  }

  /**
   * 属性グループ検索条件DTOリストを設定します。
   * 
   * @param attrGrpSearchConditionDtoList 属性グループ検索条件DTOリスト
   */
  public void setAttrGrpSearchConditionDtoList(
      List<AttrGrpSearchConditionDto> attrGrpSearchConditionDtoList) {
    this.attrGrpSearchConditionDtoList = attrGrpSearchConditionDtoList;
  }

  /**
   * 属性グループ検索条件の個数を取得します。
   * 
   * @return 属性グループ検索条件の個数
   */
  public Integer getNumOfSearchCondition() {
    return numOfSearchCondition;
  }

  /**
   * 属性グループ検索条件の個数を設定します。
   * 
   * @param numOfSearchCondition 属性グループ検索条件の個数
   */
  public void setNumOfSearchCondition(Integer numOfSearchCondition) {
    this.numOfSearchCondition = numOfSearchCondition;
  }

}
