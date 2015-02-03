package com.melip.webservices.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.dto.screen.ScreenDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.layout.ILayoutService;

/**
 * 画面表示のためのScreenDtoを取得するクラスです。
 */
@Path("/screenDto")
public class ScreenDtoResource extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(ScreenDtoResource.class);

  /** 言語区分 */
  private String langDiv;
  /** 対象スクリーンID */
  private Integer targetScreenId;
  /** 地域ID */
  private Integer regionId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設グループID */
  private Integer facilityGrpId;

  /**
   * スクリーンDTOをJSON形式で取得します。
   * 
   * @param langDiv 言語区分
   * @param targetScreenId 対象スクリーンID
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId
   * @return スクリーンDTO（JSON形式）
   */
  @GET
  @Produces(MEDIA_TYPE_JSON)
  public ScreenDto getScreenDto(@QueryParam("langDiv") String langDiv,
      @QueryParam("targetScreenId") String targetScreenId, @QueryParam("regionId") String regionId,
      @QueryParam("facilityId") String facilityId, @QueryParam("facilityGrpId") String facilityGrpId) {

    // パラメータ設定
    setParameters(langDiv, targetScreenId, regionId, facilityId, facilityGrpId);

    ILayoutService service = BeanCreator.getBean(ILayoutService.SERVICE_NAME, ILayoutService.class);
    ScreenDto screenDto =
        service.getScreenDto(getLangDiv(), getTargetScreenId(), getRegionId(), getFacilityId(),
            getFacilityGrpId());

    return screenDto;
  }

  /**
   * パラメータを設定します。
   * 
   * @param langDiv 言語区分
   * @param targetScreenId 対象スクリーンID
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   */
  private void setParameters(String langDiv, String targetScreenId, String regionId,
      String facilityId, String facilityGrpId) {

    // TODO:必須チェックなど

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  言語区分         -> " + langDiv);
      log.debug("  対象スクリーンID -> " + targetScreenId);
      log.debug("  地域ID           -> " + regionId);
      log.debug("  施設ID           -> " + facilityId);
      log.debug("  施設グループID   -> " + facilityGrpId);
    }

    // 言語区分
    setLangDiv(langDiv);
    // 対象スクリーンID
    setTargetScreenId(Integer.valueOf(targetScreenId));
    // 地域ID
    setRegionId(Integer.valueOf(regionId));
    // 施設ID
    if (StringUtils.isNotEmpty(facilityId)) {
      setFacilityId(Integer.valueOf(facilityId));
    }
    // 施設グループID
    if (StringUtils.isNotEmpty(facilityGrpId)) {
      setFacilityGrpId(Integer.valueOf(facilityGrpId));
    }
  }

  /**
   * 言語区分を取得します。
   * 
   * @return 言語区分
   */
  public String getLangDiv() {
    return langDiv;
  }

  /**
   * 言語区分を設定します。
   * 
   * @param langDiv 言語区分
   */
  public void setLangDiv(String langDiv) {
    this.langDiv = langDiv;
  }

  /**
   * 対象スクリーンIDを取得します。
   * 
   * @return 対象スクリーンID
   */
  public Integer getTargetScreenId() {
    return targetScreenId;
  }

  /**
   * 対象スクリーンIDを設定します。
   * 
   * @param targetScreenId 対象スクリーンID
   */
  public void setTargetScreenId(Integer targetScreenId) {
    this.targetScreenId = targetScreenId;
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
   * 施設IDを取得します。
   * 
   * @return 施設ID
   */
  public Integer getFacilityId() {
    return facilityId;
  }

  /**
   * 施設IDを設定します。
   * 
   * @param facilityId 施設ID
   */
  public void setFacilityId(Integer facilityId) {
    this.facilityId = facilityId;
  }

  /**
   * 施設グループIDを取得します。
   * 
   * @return 施設グループID
   */
  public Integer getFacilityGrpId() {
    return facilityGrpId;
  }

  /**
   * 施設グループIDを設定します。
   * 
   * @param facilityGrpId 施設グループID
   */
  public void setFacilityGrpId(Integer facilityGrpId) {
    this.facilityGrpId = facilityGrpId;
  }

}
