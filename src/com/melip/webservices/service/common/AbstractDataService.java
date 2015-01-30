package com.melip.webservices.service.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.melip.common.dto.common.AbstractDto;
import com.melip.webservices.common.IDao;

/**
 * サービスの基底クラスです。<br>
 * すべてのサービスはこのクラスを継承して作成します。
 */
public abstract class AbstractDataService extends AbstractService implements IDataService {

  /** DAO */
  private IDao dao;

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String)
   */
  @Override
  public <T extends AbstractDto> T selectOne(String sqlId) {

    T result = null;
    try {
      result = getSession().selectOne(sqlId);
    } catch (PersistenceException e) {
      // TODO:例外処理
      e.printStackTrace();
    } catch (Exception e) {
      // TODO:例外処理
      e.printStackTrace();
    }

    return result;
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String,
   *      com.melip.webservices.service.common.SearchCondition)
   */
  @Override
  public <To extends AbstractDto, Ti extends SearchCondition> To selectOne(String sqlId,
      Ti condition) {

    To result = null;
    try {
      result = getSession().selectOne(sqlId, condition);
    } catch (PersistenceException e) {
      // TODO:例外処理
      e.printStackTrace();
    } catch (Exception e) {
      // TODO:例外処理
      e.printStackTrace();
    }

    return result;
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectList(java.lang.String)
   */
  @Override
  public <E extends AbstractDto> List<E> selectList(String sqlId) {

    List<E> resultList = new ArrayList<E>();
    try {
      resultList = getSession().selectList(sqlId);
    } catch (PersistenceException e) {
      // TODO:例外処理
      e.printStackTrace();
    } catch (Exception e) {
      // TODO:例外処理
      e.printStackTrace();
    }

    return resultList;
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectList(java.lang.String,
   *      com.melip.webservices.service.common.SearchCondition)
   */
  @Override
  public <E extends AbstractDto, T extends SearchCondition> List<E> selectList(String sqlId,
      T condition) {

    List<E> resultList = new ArrayList<E>();
    try {
      resultList = getSession().selectList(sqlId, condition);
    } catch (PersistenceException e) {
      // TODO:例外処理
      e.printStackTrace();
    } catch (Exception e) {
      // TODO:例外処理
      e.printStackTrace();
    }

    return resultList;
  }

  /**
   * SQLセッションを取得します。
   * 
   * @return SQLセッション
   */
  protected SqlSession getSession() {
    return getDao().getSqlSessionFactory().openSession();
  }

  /**
   * DAOを取得します。
   * 
   * @return DAO
   */
  private IDao getDao() {
    return dao;
  }

  /**
   * DAOを設定します。
   * 
   * @param DAO
   */
  public void setDao(IDao dao) {
    this.dao = dao;
  }

}
