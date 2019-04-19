import org.apache.spark.sql.Column

class JoiningConditionParser {

  def parse(tableJoinInfo1: TableJoinInfo, tableJoinInfo2: TableJoinInfo, joiningTables: JoiningTables): Column = {

    val joinConditions = joiningTables.joiningCondition.split("&&")

    val tableIdentifierToDF = Map(
      tableJoinInfo1.tableInfo.tableMeta.tableName -> tableJoinInfo1.df,
      tableJoinInfo2.tableInfo.tableMeta.tableName -> tableJoinInfo2.df
    )
    var column: Column = null
    //TODO: Try using foldLeft or map function, below approach is not a scala way of doing
    joinConditions.foreach(atomiCondition => {

      val dfIndex = 0
      val clmnNameIndex = 1

      val columns = atomiCondition.split("==").toSeq

      def buildJoinExpresion(conditionIndex: Int) = {
        val firstColmn = columns(conditionIndex).split("\\.").toSeq
        if (firstColmn.size < 2) {
          throw new RuntimeException(s"Table name should be used in joining condition, fail to get table name for $columns(0)")
        }
        val firstClumnObj = tableIdentifierToDF(firstColmn(dfIndex).trim)(firstColmn(clmnNameIndex) trim)
        firstClumnObj
      }

      val firstClumnObj: Column = buildJoinExpresion(0)
      val secondClumnObj: Column = buildJoinExpresion(1)

      column = if (column == null) firstClumnObj === secondClumnObj else column && firstClumnObj === secondClumnObj
    })
    column
  }
}