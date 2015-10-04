Learning Apache Spark
=====================

Setup
-----

Download Spark prebuild for Haddop: http://spark.apache.org/downloads.html

In extracted directory. Start master:

```sh
./sbin/start-master.sh
```
Check logs for WEB url (e.g `hostname:8080`) and Akka URL (e.g. `spark://hostName:7077`)

Start worker (replace `HOSTNAME` with one your machine hostname or one in spark logs)

```sh
./sbin/start-slave.sh spark://HOSTNAME:7077
```

Import this project with Intelij IDEA or SBT.

During development
------------------

If you do not want to setup Spark master/slave, you can change `setMaster` to `.setMaster("local[2]")`