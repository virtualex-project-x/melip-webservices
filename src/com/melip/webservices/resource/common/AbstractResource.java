package com.melip.webservices.resource.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.melip.common.dto.common.IDto;
import com.melip.common.dto.common.ResourceErrorDto;
import com.melip.common.dto.common.ResourceMultiDto;
import com.melip.common.dto.common.ResourceSingleDto;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.system.MessageProvider;

/**
 * リソースの基底クラスです。<br>
 * すべてのリソースはこのクラスを継承して作成します。
 */
public abstract class AbstractResource implements IResource {

  /** パラメータ 言語区分 */
  protected static final String PARAM_LANG_DIV = "langDiv";
  /** パラメータ 属性グループエイリアス */
  protected static final String PARAM_ATTR_GRP_ALIAS = "attrGrpAlias";

  /** 項目のセパレータ */
  protected static final String SEPARATOR_ITEM = ",";
  /** KEY、VALUEのセパレータ */
  protected static final String SEPARATOR_KEY_VALUE = ":";
  /** 昇順を表す文字列 */
  protected static final String STR_ASC = "asc";

  /** 属性グループエイリアスの正規表現 */
  private static final String REGEX_ATTR_GRP_ALIAS = "^([^,]+,)*[^,]+$";
  /** 検索条件の正規表現 */
  private static final String REGEX_CONDITION = "^([^,:]+:[^,:]+,)*[^,:]+:[^,:]+$";
  /** ソートキーの正規表現 */
  private static final String REGEX_ORDER = "^([^,:]+:(asc|desc),)*[^,:]+:(asc|desc)$";

  /** 属性グループエイリアスが不正だった場合に表示する形式 */
  private static final String MSG_ATTR_GRP_ALIAS_PATTERN = "attrGrpAlias,attrGrpAlias,...";
  /** 検索条件が不正だった場合に表示する形式 */
  private static final String MSG_CONDITION_PATTERN = "attrGrpAlias:value,attrGrpAlias:value,...";
  /** ソートキーが不正だった場合に表示する形式 */
  private static final String MSG_ORDER_PATTERN = "attrGrpAlias:asc/desc,attrGrpAlias:asc/desc,...";

  /**
   * 必須チェックを実施します。
   * 
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkRequired(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0001,
          new Object[] {paramName}));
    }
  }

  /**
   * 整数チェックを実施します。
   *
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkInteger(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    try {
      Integer.valueOf(paramValue);
    } catch (NumberFormatException e) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0005, new Object[] {
          paramName, paramValue}));
    }
  }

  /**
   * 数値チェックを実施します。
   *
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkDecimal(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    try {
      Float.valueOf(paramValue);
    } catch (NumberFormatException e) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0008, new Object[] {
          paramName, paramValue}));
    }
  }

  /**
   * 範囲チェックを実施します。
   * 
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値（数値でない場合は何もしません）
   * @param min 最小値（nullの場合は最小値はチェックしません）
   * @param max 最大値（nullの場合は最大値はチェックしません）
   * @return エラーメッセージ
   */
  protected void checkRange(List<String> errMsgList, String paramName, String paramValue,
      Integer min, Integer max) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    Float minF = null;
    Float maxF = null;
    try {
      Float value = Float.valueOf(paramValue);
      if (null != min && null != max) {
        minF = Float.valueOf(min);
        maxF = Float.valueOf(max);
        if (minF.compareTo(value) > 0 || maxF.compareTo(value) < 0) {
          errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0002, new Object[] {
              paramName, min, max, paramValue}));
        }
      } else if (null != min) {
        minF = Float.valueOf(min);
        if (minF.compareTo(value) > 0) {
          errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0003, new Object[] {
              paramName, min, paramValue}));
        }
      } else if (null != max) {
        maxF = Float.valueOf(max);
        if (maxF.compareTo(value) < 0) {
          errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0004, new Object[] {
              paramName, max, paramValue}));
        }
      }
    } catch (NumberFormatException e) {
      // paramValueが数値でない場合は何もしない
    }
  }

  /**
   * 属性グループエイリアスのチェックを実施します。
   * 
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkAttrGrpAlias(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    if (!checkRegex(paramValue, REGEX_ATTR_GRP_ALIAS)) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0007, new Object[] {
          paramName, MSG_ATTR_GRP_ALIAS_PATTERN, paramValue}));
    }
  }

  /**
   * 検索条件のチェックを実施します。
   * 
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkCondition(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    if (!checkRegex(paramValue, REGEX_CONDITION)) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0007, new Object[] {
          paramName, MSG_CONDITION_PATTERN, paramValue}));
    }
  }

  /**
   * ソートキーのチェックを実施します。
   * 
   * @param errMsgList エラーメッセージリスト
   * @param paramName パラメータの名前
   * @param paramValue パラメータの値
   */
  protected void checkOrder(List<String> errMsgList, String paramName, String paramValue) {

    if (StringUtils.isEmpty(paramValue)) {
      return;
    }

    if (!checkRegex(paramValue, REGEX_ORDER)) {
      errMsgList.add(MessageProvider.formatMessage(MessageConstants.CMN_0007, new Object[] {
          paramName, MSG_ORDER_PATTERN, paramValue}));
    }
  }

  /**
   * 対象の文字列が正規表現にマッチするか判定します。
   * 
   * @param targetStr 対象の文字列
   * @param regex 正規表現
   * @return マッチする場合true、しない場合false
   */
  private boolean checkRegex(String targetStr, String regex) {

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetStr);

    return matcher.find();
  }

  /**
   * リソースエラーDTOを生成します。
   * 
   * @param entity エンティティ
   * @param errMsgList エラーメッセージリスト
   * @return リソースエラーDTO
   */
  protected ResourceErrorDto createResourceErrorDto(String entity, List<String> errMsgList) {
    return new ResourceErrorDto(entity, errMsgList);
  }

  /**
   * リソースエラーDTOを生成します。
   * 
   * @param entity エンティティ
   * @param e 例外
   * @return リソースエラーDTO
   */
  protected ResourceErrorDto createResourceErrorDto(String entity, Exception e) {

    List<String> errMsgList = new ArrayList<String>();
    errMsgList.add(e.getMessage());

    return createResourceErrorDto(entity, errMsgList);
  }

  /**
   * リソースシングルDTOを生成します。
   * 
   * @param entity エンティティ
   * @param dto DTO
   * @return リソースシングルDTO
   */
  protected <T extends IDto> ResourceSingleDto<T> createResourceSingleDto(String entity, T dto) {

    ResourceSingleDto<T> resourceSingleDto = new ResourceSingleDto<T>(entity, dto);

    return resourceSingleDto;
  }

  /**
   * リソースマルチDTOを生成します。
   * 
   * @param entity エンティティ
   * @param list DTOリスト
   * @return リソースマルチDTO
   */
  protected <E extends IDto> ResourceMultiDto createResourceMultiDto(String entity, DtoList<E> list) {

    ResourceMultiDto resourceMultiDto = new ResourceMultiDto(entity);
    resourceMultiDto.setAllCount(list.getAllCount());
    resourceMultiDto.setIndex(list.getIndex());
    resourceMultiDto.setCount(list.getCount());
    resourceMultiDto.setDtoList(list.getDtoList());

    return resourceMultiDto;
  }

}
