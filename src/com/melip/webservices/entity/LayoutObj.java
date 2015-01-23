package com.melip.webservices.entity;

import com.melip.webservices.entity.common.AbstractEntity;


public class LayoutObj extends AbstractEntity {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_layout_obj.LAYOUT_OBJ_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  private Integer layoutObjId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_layout_obj.LAYOUT_OBJ_GRP_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  private Integer layoutObjGrpId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_layout_obj.ALIAS
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  private String alias;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_layout_obj.NM
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  private String nm;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_layout_obj.TYPE
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  private String type;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_layout_obj.LAYOUT_OBJ_ID
   *
   * @return the value of m_layout_obj.LAYOUT_OBJ_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public Integer getLayoutObjId() {
    return layoutObjId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_layout_obj.LAYOUT_OBJ_ID
   *
   * @param layoutObjId the value for m_layout_obj.LAYOUT_OBJ_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public void setLayoutObjId(Integer layoutObjId) {
    this.layoutObjId = layoutObjId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_layout_obj.LAYOUT_OBJ_GRP_ID
   *
   * @return the value of m_layout_obj.LAYOUT_OBJ_GRP_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public Integer getLayoutObjGrpId() {
    return layoutObjGrpId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_layout_obj.LAYOUT_OBJ_GRP_ID
   *
   * @param layoutObjGrpId the value for m_layout_obj.LAYOUT_OBJ_GRP_ID
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public void setLayoutObjGrpId(Integer layoutObjGrpId) {
    this.layoutObjGrpId = layoutObjGrpId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_layout_obj.ALIAS
   *
   * @return the value of m_layout_obj.ALIAS
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public String getAlias() {
    return alias;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_layout_obj.ALIAS
   *
   * @param alias the value for m_layout_obj.ALIAS
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_layout_obj.NM
   *
   * @return the value of m_layout_obj.NM
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public String getNm() {
    return nm;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_layout_obj.NM
   *
   * @param nm the value for m_layout_obj.NM
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public void setNm(String nm) {
    this.nm = nm;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_layout_obj.TYPE
   *
   * @return the value of m_layout_obj.TYPE
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public String getType() {
    return type;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_layout_obj.TYPE
   *
   * @param type the value for m_layout_obj.TYPE
   *
   * @mbggenerated Fri Jan 23 15:41:53 JST 2015
   */
  public void setType(String type) {
    this.type = type;
  }
}