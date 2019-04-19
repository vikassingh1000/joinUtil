import com.google.common.base.Strings

class QueryBuilder {

  def buildQuery(tableInfo: TableInfo): String = {

    def buildFilterCondition: String = {
      if (!Strings.isNullOrEmpty(tableInfo.filterCondition)) {
        return s" where ${tableInfo.filterCondition}"
      }
      return ""
    }

    val query = s" select ${tableInfo.columnSelections} from ${tableInfo.tableMeta.dbName}.${tableInfo.tableMeta.tableName} $buildFilterCondition"
    query
  }
}