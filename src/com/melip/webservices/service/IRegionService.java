package com.melip.webservices.service;

import java.util.List;

import com.melip.webservices.dto.RegionDto;


/**
 * 地域のサービスインタフェースです。
 */
public interface IRegionService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "regionService";

  /**
   * 地域の一覧を取得します。
   * 
   * @return 地域DTOリスト
   */
  public List<RegionDto> getRegionList();

  /**
   * 地域を1件取得します。
   * 
   * @param regionId 地域ID
   * @return 地域DTO
   */
  public RegionDto getRegion(Integer regionId);

}
