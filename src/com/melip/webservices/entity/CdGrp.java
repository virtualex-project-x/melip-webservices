package com.melip.webservices.entity;

import com.melip.webservices.entity.common.AbstractEntity;


public class CdGrp extends AbstractEntity {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.CD_GRP_ID
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  private Integer cdGrpId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.ALIAS
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  private String alias;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.NM
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  private String nm;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.SUMMARY
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  private String summary;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.CD_GRP_ID
   *
   * @return the value of m_cd_grp.CD_GRP_ID
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public Integer getCdGrpId() {
    return cdGrpId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.CD_GRP_ID
   *
   * @param cdGrpId the value for m_cd_grp.CD_GRP_ID
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public void setCdGrpId(Integer cdGrpId) {
    this.cdGrpId = cdGrpId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.ALIAS
   *
   * @return the value of m_cd_grp.ALIAS
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public String getAlias() {
    return alias;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.ALIAS
   *
   * @param alias the value for m_cd_grp.ALIAS
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.NM
   *
   * @return the value of m_cd_grp.NM
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public String getNm() {
    return nm;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.NM
   *
   * @param nm the value for m_cd_grp.NM
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public void setNm(String nm) {
    this.nm = nm;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.SUMMARY
   *
   * @return the value of m_cd_grp.SUMMARY
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public String getSummary() {
    return summary;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.SUMMARY
   *
   * @param summary the value for m_cd_grp.SUMMARY
   *
   * @mbggenerated Wed Jan 28 11:26:06 JST 2015
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }
}
