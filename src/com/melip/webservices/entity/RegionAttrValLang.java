package com.melip.webservices.entity;

import com.melip.webservices.entity.common.AbstractEntity;


public class RegionAttrValLang extends AbstractEntity {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_region_attr_val_lang.REGION_ATTR_VAL_LANG_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  private Integer regionAttrValLangId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_region_attr_val_lang.REGION_ATTR_VAL_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  private Integer regionAttrValId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_region_attr_val_lang.LANG_DIV
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  private String langDiv;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_region_attr_val_lang.VAL
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  private String val;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_region_attr_val_lang.REGION_ATTR_VAL_LANG_ID
   *
   * @return the value of m_region_attr_val_lang.REGION_ATTR_VAL_LANG_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public Integer getRegionAttrValLangId() {
    return regionAttrValLangId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_region_attr_val_lang.REGION_ATTR_VAL_LANG_ID
   *
   * @param regionAttrValLangId the value for m_region_attr_val_lang.REGION_ATTR_VAL_LANG_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public void setRegionAttrValLangId(Integer regionAttrValLangId) {
    this.regionAttrValLangId = regionAttrValLangId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_region_attr_val_lang.REGION_ATTR_VAL_ID
   *
   * @return the value of m_region_attr_val_lang.REGION_ATTR_VAL_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public Integer getRegionAttrValId() {
    return regionAttrValId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_region_attr_val_lang.REGION_ATTR_VAL_ID
   *
   * @param regionAttrValId the value for m_region_attr_val_lang.REGION_ATTR_VAL_ID
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public void setRegionAttrValId(Integer regionAttrValId) {
    this.regionAttrValId = regionAttrValId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_region_attr_val_lang.LANG_DIV
   *
   * @return the value of m_region_attr_val_lang.LANG_DIV
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public String getLangDiv() {
    return langDiv;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_region_attr_val_lang.LANG_DIV
   *
   * @param langDiv the value for m_region_attr_val_lang.LANG_DIV
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public void setLangDiv(String langDiv) {
    this.langDiv = langDiv;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_region_attr_val_lang.VAL
   *
   * @return the value of m_region_attr_val_lang.VAL
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public String getVal() {
    return val;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_region_attr_val_lang.VAL
   *
   * @param val the value for m_region_attr_val_lang.VAL
   *
   * @mbggenerated Thu Feb 12 11:26:13 JST 2015
   */
  public void setVal(String val) {
    this.val = val;
  }
}
