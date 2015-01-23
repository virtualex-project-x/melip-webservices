package com.melip.webservices.resource.common;

/**
 * リソースの基底クラスです。<br>
 * すべてのリソースはこのクラスを継承して作成します。
 */
public abstract class AbstractResource implements IResource {

  /** JSONのメディアタイプ（UTF-8） */
  protected static final String MEDIA_TYPE_JSON = "application/json;charset=UTF-8";

}
