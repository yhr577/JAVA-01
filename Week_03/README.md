作业笔记:

分别用端口8088,8089 启动jar包

java -jar -Xmx4g -Xms4g -XX:-UseAdaptiveSizePolicy  -Dserver.port=8088 springdemo-0.0.1-SNAPSHOT.jar
java -jar -Xmx4g -Xms4g -XX:-UseAdaptiveSizePolicy  -Dserver.port=8089 springdemo-0.0.1-SNAPSHOT.jar

浏览器访问:

http://127.0.0.1:8888/controller/admin/xxxxx

http://127.0.0.1:8888/controller/test


可以看到打印了不同结果
This is springdemo project !!! 

This is springdemo project test !!! 