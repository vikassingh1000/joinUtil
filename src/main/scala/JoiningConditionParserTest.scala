import org.apache.spark.sql.SparkSession

object JoiningConditionParserTest {

  def main(args: Array[String]): Unit = {
    val joiningCond: JoiningConditionParser = new JoiningConditionParser
    val yl = new YamlLoader
    val joiningTables = yl.load(classOf[JoiningTables])

    val spark = SparkSession
      .builder
      .appName("SparkSQL")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", "file:///C:/temp") // Necessary to work around a Windows bug in Spark 2.0.0; omit if you're not on Windows.
      .getOrCreate()
    import spark.implicits._

    val someDF = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse")
    ).toDF("joinClm1", "joinClm2")

    val someDF2 = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse")
    ).toDF("joinClm1", "joinClm3")


    val tableJoinInfo1:TableJoinInfo = new TableJoinInfo(someDF, joiningTables.tableInfoList.get(0) )
    val tableJoinInfo2:TableJoinInfo = new TableJoinInfo(someDF2, joiningTables.tableInfoList.get(1) )

    val createdJoinCond = joiningCond.parse(tableJoinInfo1,tableJoinInfo2,joiningTables)

    val joinCond = someDF("joinClm1") === someDF2("joinClm1") && someDF("joinClm2")===someDF2("joinClm3")
    println(createdJoinCond.equals(joinCond))
  }

}
