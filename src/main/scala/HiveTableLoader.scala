import org.apache.spark.sql.{DataFrame, SparkSession}

case class HiveTableLoaderInput(val dbName: String, val table: String) extends TableLoaderInput

class HiveTableLoader extends TableLoader[HiveTableLoaderInput] {

  override def load(input: HiveTableLoaderInput, session: SparkSession): DataFrame = {
    var tableFDQN = input.dbName + "." + input.table
    session.sql(s"select * from $tableFDQN")
  }
}
