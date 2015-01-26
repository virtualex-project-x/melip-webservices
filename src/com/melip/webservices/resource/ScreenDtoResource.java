package com.melip.webservices.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.melip.common.dto.screen.ScreenDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.layout.ILayoutService;

/**
 * 画面表示のためのScreenDtoを取得するクラスです。
 */
@Path("/screenDto")
public class ScreenDtoResource extends AbstractResource {

  /** 言語区分 */
  private String langDiv;
  /** スクリーンオブジェクトID */
  private Integer screenObjId;
  /** 地域ID */
  private Integer regionId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設グループID */
  private Integer facilityGrpId;

  @GET
  @Produces(MEDIA_TYPE_JSON)
  public ScreenDto getScreenDto(@QueryParam("langDiv") String langdiv,
      @QueryParam("screenObjId") String screenObjId, @QueryParam("regionId") String regionId,
      @QueryParam("facilityId") String facilityId, @QueryParam("facilityGrpId") String facilityGrpId) {

    // パラメータ設定
    setParameters(langdiv, screenObjId, regionId, facilityId, facilityGrpId);

    ILayoutService service = BeanCreator.getBean(ILayoutService.SERVICE_NAME, ILayoutService.class);
    ScreenDto screenDto =
        service.getScreenDto(getLangDiv(), getScreenObjId(), getRegionId(), getFacilityId(),
            getFacilityGrpId());

    return screenDto;
  }

  /**
   * パラメータを設定します。
   * 
   * @param langdiv 言語区分
   * @param screenObjId スクリーンオブジェクトID
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   */
  private void setParameters(String langdiv, String screenObjId, String regionId,
      String facilityId, String facilityGrpId) {

    // 言語区分
    setLangDiv(langdiv);
    // スクリーンオブジェクトID
    setScreenObjId(Integer.valueOf(screenObjId));
    // 地域ID
    setRegionId(Integer.valueOf(regionId));
    // 施設ID
    setFacilityId(Integer.valueOf(facilityId));
    // 施設グループID
    setFacilityGrpId(Integer.valueOf(facilityGrpId));
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
   * スクリーンオブジェクトIDを取得します。
   * 
   * @return スクリーンオブジェクトID
   */
  public Integer getScreenObjId() {
    return screenObjId;
  }

  /**
   * スクリーンオブジェクトIDを設定します。
   * 
   * @param screenObjId スクリーンオブジェクトID
   */
  public void setScreenObjId(Integer screenObjId) {
    this.screenObjId = screenObjId;
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
