import org.apache.spark.sql.DataFrame

trait JoinRealizer[A] {

  def realizer(dataFrame: DataFrame): A
}
