
object Test {

  def main(args: Array[String]): Unit = {
    val yl = new YamlLoader
    val joiningTables = yl.load(classOf[JoiningTables])
    val queryBuilder: QueryBuilder = new QueryBuilder
    import scala.collection.JavaConverters._
    val tableInfoList = joiningTables.tableInfoList.asScala
    for (k <- tableInfoList) {
      println(queryBuilder.buildQuery(k))
    }

  }
}
