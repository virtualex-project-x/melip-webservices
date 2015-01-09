package com.melip.mybatis.generator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * MyBatis Generatorで出力されるエンティティ名称を変更するクラスです。
 */
public class EntityClassNameChange extends PluginAdapter {

  private static final String PREFIX_MASTER = "M";
  private static final String PREFIX_TRANSACTION = "T";

  /**
   * @see org.mybatis.generator.api.Plugin#validate(java.util.List)
   */
  @Override
  public boolean validate(List<String> arg0) {
    return true;
  }

  /**
   * マスタ/トランザクションのプレフィックスを除去します。
   * 
   * @see org.mybatis.generator.api.PluginAdapter#initialized(org.mybatis.generator.api.IntrospectedTable)
   */
  @Override
  public void initialized(IntrospectedTable table) {

    super.initialized(table);

    // エンティティクラス名（パッケージ名＋クラス名）
    String entityFullName = table.getBaseRecordType();

    String regex = ".*\\.";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(entityFullName);
    if (m.find()) {
      // エンティティクラス名のパッケージ名部分
      String entityPackageName = m.group(0);
      // エンティティクラス名のクラス名部分
      String entityName = table.getBaseRecordType().replaceFirst(entityPackageName, "");

      String newEntityFullName = null;
      if (entityName.startsWith(PREFIX_MASTER)) {
        newEntityFullName = entityPackageName + entityName.replaceFirst(PREFIX_MASTER, "");
      } else if (entityName.startsWith(PREFIX_TRANSACTION)) {
        newEntityFullName = entityPackageName + entityName.replaceFirst(PREFIX_TRANSACTION, "");
      }
      table.setBaseRecordType(newEntityFullName);
    }
  }

}
