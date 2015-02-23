package com.melip.webservices.dto;

import com.melip.common.dto.common.AbstractDto;

/**
 * 属性グループの検索条件DTOです。
 */
public class AttrGrpSearchConditionDto extends AbstractDto {

  private static final long serialVersionUID = 1L;

  /** 検索対象属性グループエイリアスのフィールド名 */
  public static final String FIELD_ATTR_GRP_ALIAS = "attrGrpAlias";
  /** 検索値のフィールド名 */
  public static final String FIELD_VAL = "val";

  /** 検索対象属性グループエイリアス */
  private String attrGrpAlias;
  /** 検索値 */
  private Object val;

  /**
   * 検索対象属性グループエイリアスを取得します。
   * 
   * @return 検索対象属性グループエイリアス
   */
  public String getAttrGrpAlias() {
    return attrGrpAlias;
  }

  /**
   * 検索対象属性グループエイリアスを設定します。
   * 
   * @param attrGrpAlias 検索対象属性グループエイリアス
   */
  public void setAttrGrpAlias(String attrGrpAlias) {
    this.attrGrpAlias = attrGrpAlias;
  }

  /**
   * 検索値を取得します。
   * 
   * @return 検索値
   */
  public Object getVal() {
    return val;
  }

  /**
   * 検索値を設定します。
   * 
   * @param val 検索値
   */
  public void setVal(Object val) {
    this.val = val;
  }

}
