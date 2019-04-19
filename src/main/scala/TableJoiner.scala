import org.apache.spark.sql.{Column, DataFrame}

case class TableJoinInfo(df: DataFrame, tableInfo: TableInfo)

trait TableJoiner {
  def join(tableJoinInfo1: TableJoinInfo, tableJoinInfo2: TableJoinInfo, joiningTables: JoiningTables): DataFrame
}

class TableJoinerImpl(joiningConditionParser: JoiningConditionParser) extends TableJoiner {

  override def join(tableJoinInfo1: TableJoinInfo, tableJoinInfo2: TableJoinInfo, joiningTables: JoiningTables): DataFrame = {

    val df1 = tableJoinInfo1.df
    val df2 = tableJoinInfo2.df
    val joinExp: Column = joiningConditionParser.parse(tableJoinInfo1, tableJoinInfo2, joiningTables)
    df1.join(df2, joinExp, joiningTables.joinType.toString.toLowerCase)
  }
}
