package com.melip.webservices.service;

import java.util.List;

import com.melip.webservices.entity.Facility;

/**
 * テスト用サービスのインタフェースです。
 */
public interface ITestService {

  /**
   * DIコンテナ登録用の名称
   */
  public static final String SERVICE_NAME = "testService";

  public List<Facility> getFacilityList();
}
