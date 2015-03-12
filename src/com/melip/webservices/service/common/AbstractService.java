package com.melip.webservices.service.common;

import com.melip.common.constants.CodeConstants;
import com.melip.webservices.entity.common.AbstractEntity;

/**
 * サービスの基底クラスです。<br>
 * すべてのサービスはこのクラスを継承して作成します。
 */
public abstract class AbstractService implements IService {

  /**
   * ユーザーIDを取得します。
   * 
   * @return ユーザーID
   */
  protected Integer getUserId() {
    // TODO:ユーザーの仕組みができたら実装すること
    return 1;
  }

  /**
   * 登録用に共通項目を設定します。<br>
   * 
   * <pre>
   * 登録日時   -> null（SQLで設定）
   * 登録者     -> ユーザーID
   * 更新日時   -> null（SQLで設定）
   * 更新者     -> ユーザーID
   * ステータス -> 'val'（有効）
   * </pre>
   * 
   * @param entity エンティティ
   */
  protected void setCommonPropertyForInsert(AbstractEntity entity) {

    entity.setCreateDatetime(null);
    entity.setCreateUser(getUserId());
    entity.setUpdateDatetime(null);
    entity.setUpdateUser(getUserId());
    entity.setSts(CodeConstants.CODE_STS_VALID);
  }
}
