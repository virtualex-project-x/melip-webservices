package com.melip.webservices.resource.facility;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.FacilityStoreDto;
import com.melip.webservices.resource.common.AbstractResource;

/**
 * 施設のリソースクラスです。
 */
@Path("/facilities")
public class ResourceFacilities extends AbstractResource {

  /**
   * 施設情報を取得します。
   * 
   * @param facilityId 施設ID
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @return 施設情報を保持したリソースシングルDTO、もしくはリソースエラーDTO
   */
  @Path("{id}")
  @GET
  public Response getFacility(@PathParam("id") int facilityId,
      @QueryParam(PARAM_LANG_DIV) String langDiv,
      @QueryParam(PARAM_ATTR_GRP_ALIAS) String attrGrpAlias) {

    return new GetFacility().getFacility(facilityId, langDiv, attrGrpAlias);
  }

  /**
   * 施設情報を検索します。
   * 
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @param regionId 地域ID
   * @param condition 検索条件
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   * @param latitude 緯度
   * @param longitude 経度
   * @param radius 半径
   * @return 施設情報を保持したリソースマルチDTO、もしくはリソースエラーDTO
   */
  @GET
  public Response searchFacilities(@QueryParam(PARAM_LANG_DIV) String langDiv,
      @QueryParam(PARAM_ATTR_GRP_ALIAS) String attrGrpAlias,
      @QueryParam(PARAM_REGION_ID) String regionId, @QueryParam(PARAM_CONDITION) String condition,
      @QueryParam(PARAM_INDEX) String index, @QueryParam(PARAM_COUNT) String count,
      @QueryParam(PARAM_ORDER) String order, @QueryParam(PARAM_LATITUDE) String latitude,
      @QueryParam(PARAM_LONGITUDE) String longitude, @QueryParam(PARAM_RADIUS) String radius) {

    return new SearchFacilities().searchFacilities(langDiv, attrGrpAlias, regionId, condition,
        index, count, order, latitude, longitude, radius);
  }

  /**
   * 施設情報を新規作成します。
   * 
   * @param facilityStoreDtoList 施設登録更新DTOリスト
   * @return 登録された施設のIDリスト、もしくはリソースエラーDTO
   */
  @POST
  @Consumes(CommonConstants.MEDIA_TYPE_JSON)
  public Response createFacilities(List<FacilityStoreDto> facilityStoreDtoList) {
    return new CreateFacilities().createFacilities(facilityStoreDtoList);
  }

  /**
   * 施設情報を更新します。
   * 
   * @param facilityId 施設ID
   * @param facilityStoreDto 施設登録更新DTO
   * @return 施設情報を保持したリソースシングルDTO、もしくはリソースエラーDTO
   */
  @Path("{id}")
  @PUT
  @Consumes(CommonConstants.MEDIA_TYPE_JSON)
  public Response updateFacility(@PathParam("id") int facilityId, FacilityStoreDto facilityStoreDto) {
    return new UpdateFacility().updateFacility(facilityId, facilityStoreDto);
  }

  /**
   * 施設情報を削除します。
   * 
   * @param facilityId 施設ID
   * @return 空、もしくはリソースエラーDTO
   */
  @Path("{id}")
  @DELETE
  public Response deleteFacility(@PathParam("id") int facilityId) {
    return new DeleteFacility().deleteFacility(facilityId);
  }

}
