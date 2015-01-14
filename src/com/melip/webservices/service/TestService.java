package com.melip.webservices.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.melip.webservices.entity.Facility;
import com.melip.webservices.service.common.AbstractService;

/**
 * テスト用のサービスです。
 */
public class TestService extends AbstractService implements ITestService {

  @Override
  public List<Facility> getFacilityList() {

    SqlSession session = getDao().getSqlSessionFactory().openSession();
    List<Facility> facilityList = session.selectList("test.facilityInfo");
    return facilityList;
  }
}
