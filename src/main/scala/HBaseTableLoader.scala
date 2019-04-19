import org.apache.spark.sql.{DataFrame, SparkSession}

case class HBaseTableLoaderInput(val dbName: String, val table: String) extends TableLoaderInput

class HBaseTableLoader extends TableLoader[HBaseTableLoaderInput] {

  override def load(input: HBaseTableLoaderInput, session: SparkSession): DataFrame = {
    throw new UnsupportedOperationException
  }
}