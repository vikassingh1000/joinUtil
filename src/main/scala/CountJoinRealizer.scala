import org.apache.spark.sql.DataFrame

class CountJoinRealizer extends JoinRealizer[Long] {

  override def realizer(dataFrame: DataFrame): Long = {

    val startTime = System.currentTimeMillis()
    val rtnVal = dataFrame.count()
    val endTime = System.currentTimeMillis()
    val totalTime = startTime - endTime
    println(s"Total time taken is $totalTime")
    return rtnVal;
  }
}
