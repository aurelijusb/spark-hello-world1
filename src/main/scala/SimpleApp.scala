/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "README.md"
//    val hostName = java.net.InetAddress.getLocalHost.getHostName
    val conf = new SparkConf().setAppName("Test1").setMaster("local[2]") ///.setMaster(s"spark://$hostName:7077")
    val sc = new SparkContext(conf)
    sc.addJar("target/scala-2.10/hello-spark-1_2.10-1.0.jar")
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    val wordCounts = logData.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
    val top10 = wordCounts.sortBy[Int](_._2, ascending = false).take(10)
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println("WordCount:\n" + top10.map(pair => s"'${pair._1}': ${pair._2}").mkString("\n"))
  }
}
