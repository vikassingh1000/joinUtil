import org.apache.spark.sql.{DataFrame, SparkSession}


trait TableLoaderInput {}

/**
  * Trait to load Table and return Dataframe
  *
  * @tparam A - Trait to provide input to load Tables
  */
trait TableLoader[A <: TableLoaderInput] {

  def load(input: A, session: SparkSession): DataFrame
}