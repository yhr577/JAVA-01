作业4:
PS C:\Users\ayg\Desktop> jps
10432
12276 gateway-server-0.0.1-SNAPSHOT.jar
18168 Launcher
7576 Jps
PS C:\Users\ayg\Desktop> jinfo 12276
Attaching to process ID 12276, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 25.131-b11
Java System Properties:

java.runtime.name = Java(TM) SE Runtime Environment
java.vm.version = 25.131-b11
sun.boot.library.path = C:\Program Files\Java\jre1.8.0_131\bin
java.protocol.handler.pkgs = org.springframework.boot.loader
java.vendor.url = http://java.oracle.com/
java.vm.vendor = Oracle Corporation
path.separator = ;
file.encoding.pkg = sun.io
java.vm.name = Java HotSpot(TM) 64-Bit Server VM
sun.os.patch.level =
sun.java.launcher = SUN_STANDARD
user.script =
user.country = CN
user.dir = C:\Users\ayg
java.vm.specification.name = Java Virtual Machine Specification
PID = 12276
java.runtime.version = 1.8.0_131-b11
java.awt.graphicsenv = sun.awt.Win32GraphicsEnvironment
os.arch = amd64
java.endorsed.dirs = C:\Program Files\Java\jre1.8.0_131\lib\endorsed
line.separator =

java.io.tmpdir = C:\Users\ayg\AppData\Local\Temp\
java.vm.specification.vendor = Oracle Corporation
user.variant =
os.name = Windows 10
sun.jnu.encoding = GBK
java.library.path = C:\ProgramData\Oracle\Java\javapath;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\ProgramData\Oracle\Java\javapath;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\GitExtensions\;C:\Program Files\Git\cmd;C:\WINDOWS\System32\OpenSSH\;C:\Program Files\Docker\Docker\resources\bin;C:\ProgramData\DockerDesktop\version-bin;C:\Users\ayg\AppData\Local\Microsoft\WindowsApps;D:\SoftInstall\curl-7.66.0-win64\bin;D:\software\apache-maven-3.3.3\bin;C:\Program Files\Java\jdk1.8.0_131\\bin;D:\software\gradle-6.1.1\bin;;.
spring.beaninfo.ignore = true
java.specification.name = Java Platform API Specification
java.class.version = 52.0
sun.management.compiler = HotSpot 64-Bit Tiered Compilers
os.version = 10.0
user.home = C:\Users\ayg
user.timezone = Asia/Shanghai
catalina.useNaming = false
java.awt.printerjob = sun.awt.windows.WPrinterJob
file.encoding = GBK
java.specification.version = 1.8
catalina.home = C:\Users\ayg\AppData\Local\Temp\tomcat.4853695854242345966.8088
user.name = ayg
java.class.path = C:\Users\ayg\Documents\JavaTraining\gateway-server-0.0.1-SNAPSHOT.jar
java.vm.specification.version = 1.8
sun.arch.data.model = 64
sun.java.command = C:\Users\ayg\Documents\JavaTraining\gateway-server-0.0.1-SNAPSHOT.jar
java.home = C:\Program Files\Java\jre1.8.0_131
user.language = zh
java.specification.vendor = Oracle Corporation
awt.toolkit = sun.awt.windows.WToolkit
java.vm.info = mixed mode
java.version = 1.8.0_131
java.ext.dirs = C:\Program Files\Java\jre1.8.0_131\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
sun.boot.class.path = C:\Program Files\Java\jre1.8.0_131\lib\resources.jar;C:\Program Files\Java\jre1.8.0_131\lib\rt.jar;C:\Program Files\Java\jre1.8.0_131\lib\sunrsasign.jar;C:\Program Files\Java\jre1.8.0_131\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_131\lib\jce.jar;C:\Program Files\Java\jre1.8.0_131\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_131\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_131\classes
java.awt.headless = true
java.vendor = Oracle Corporation
sun.stderr.encoding = ms936
catalina.base = C:\Users\ayg\AppData\Local\Temp\tomcat.4853695854242345966.8088
file.separator = \
java.vendor.url.bug = http://bugreport.sun.com/bugreport/
sun.io.unicode.encoding = UnicodeLittle
sun.cpu.endian = little
sun.stdout.encoding = ms936
sun.desktop = windows
sun.cpu.isalist = amd64

VM Flags:
Non-default VM flags: -XX:CICompilerCount=3 -XX:InitialHeapSize=268435456 -XX:MaxHeapSize=4265607168 -XX:MaxNewSize=1421869056 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=89128960 -XX:OldSize=179306496 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
Command line:

其中: 这个是默认参数 
-XX:CICompilerCount=3 
-XX:InitialHeapSize=268435456  //初始化 268435456/1024/1024=256MB
-XX:MaxHeapSize=4265607168  //最大堆 4068 MB
-XX:MaxNewSize=1421869056  //新生代 1356 MB
-XX:MinHeapDeltaBytes=524288  // 512 KB
-XX:NewSize=89128960  // 85 MB
-XX:OldSize=179306496  //171 MB
-XX:+UseCompressedClassPointers 
-XX:+UseCompressedOops 
-XX:+UseFastUnorderedTimeStamps 
-XX:-UseLargePagesIndividualAllocation 
-XX:+UseParallelGC

带参数启动:
-XX:+UseAdaptiveSizePolicy 开启
-XX:-UseAdaptiveSizePolicy 关闭
java -XX:-UseAdaptiveSizePolicy -Xmx1024m -Xms1024m  -XX:+PrintFlagsFinal -jar  C:\Users\ayg\Documents\JavaTraining\gateway-server-0.0.1-SNAPSHOT.jar

-XX:CICompilerCount=3 
-XX:InitialHeapSize=1073741824  // 1024MB
-XX:MaxHeapSize=1073741824  //1024 MB
-XX:MaxNewSize=357564416  //341 MB
-XX:MinHeapDeltaBytes=524288 //512 KB
-XX:NewSize=357564416  // 341 MB
-XX:OldSize=716177408  // 683 MB
-XX:+PrintFlagsFinal 
-XX:-UseAdaptiveSizePolicy 
-XX:+UseCompressedClassPointers 
-XX:+UseCompressedOops 
-XX:+UseFastUnorderedTimeStamps 
-XX:-UseLargePagesIndividualAllocation 
-XX:+UseParallelGC

经过压测:
sb -u http://127.0.0.1:8088/api/hello  -c 10 -N 300
发现mirror GC 相对频繁,但是full GC 却是一次也没有,如果是按照现有系统,
现有说明现有设置-Xmx1024m -Xms1024m完全够用.自适应的4G已经很高了.

如下是总体数据:
PS C:\WINDOWS\system32> sb -u http://127.0.0.1:8088/api/hello  -c 10 -N 300
Starting at 2021/1/14 22:23:25
[Press C to stop the test]
1241140 (RPS: 4081.5)
---------------Finished!----------------
Finished at 2021/1/14 22:28:30 (took 00:05:04.2980002)
Status 200:    1241145

RPS: 4120.1 (requests/second)
Max: 45ms
Min: 0ms
Avg: 0.1ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 0ms
  90%   below 0ms
  95%   below 0ms
  98%   below 1ms
  99%   below 2ms
99.9%   below 3m

详细数据如下:
 0.00   0.29  68.37   2.79  95.44  92.52     99    0.186     2    0.079    0.265
  0.22   0.00  11.59   2.79  95.44  92.52    100    0.188     2    0.079    0.267
  0.22   0.00  44.18   2.79  95.44  92.52    100    0.188     2    0.079    0.267
  0.22   0.00  85.18   2.79  95.44  92.52    100    0.188     2    0.079    0.267
  0.00   0.29  27.94   2.79  95.45  92.52    101    0.189     2    0.079    0.268
  0.00   0.29  61.47   2.79  95.45  92.52    101    0.189     2    0.079    0.268
  0.29   0.00   3.98   2.79  95.45  92.52    102    0.191     2    0.079    0.270
  0.29   0.00  45.02   2.79  95.45  92.52    102    0.191     2    0.079    0.270
  0.29   0.00  79.24   2.79  95.45  92.52    102    0.191     2    0.079    0.270
  0.00   0.29   8.18   2.80  95.45  92.52    103    0.192     2    0.079    0.271
  0.00   0.29  50.40   2.80  95.45  92.52    103    0.192     2    0.079    0.271
  0.00   0.29  84.62   2.80  95.45  92.52    103    0.192     2    0.079    0.271
  0.29   0.00  24.45   2.80  95.45  92.52    104    0.194     2    0.079    0.272
  0.29   0.00  66.34   2.80  95.45  92.52    104    0.194     2    0.079    0.272
  0.00   0.15   3.97   2.80  95.45  92.52    105    0.195     2    0.079    0.274
  0.00   0.15  38.59   2.80  95.45  92.52    105    0.195     2    0.079    0.274
  0.00   0.15  81.00   2.80  95.45  92.52    105    0.195     2    0.079    0.274
  0.22   0.00  19.77   2.80  95.48  92.52    106    0.196     2    0.079    0.275
  0.22   0.00  55.35   2.80  95.48  92.52    106    0.196     2    0.079    0.275
  0.22   0.00  96.54   2.80  95.48  92.52    106    0.196     2    0.079    0.275
  0.00   0.29  34.60   2.80  95.48  92.52    107    0.197     2    0.079    0.276
  0.00   0.29  73.25   2.80  95.48  92.52    107    0.197     2    0.079    0.276
  0.22   0.00  14.00   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.22   0.00  52.23   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.22   0.00  88.65   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.22   0.00  88.65   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.22   0.00  88.65   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.22   0.00  88.65   2.80  95.48  92.52    108    0.199     2    0.079    0.278
  0.00   0.22   0.00   2.80  95.48  92.52    109    0.200     2    0.079    0.279
  0.00   0.22  36.18   2.80  95.48  92.52    109    0.200     2    0.079    0.279
  0.00   0.22  65.18   2.80  95.48  92.52    109    0.200     2    0.079    0.279
  0.00   0.22  96.38   2.80  95.48  92.52    109    0.200     2    0.079    0.279
  0.29   0.00  26.00   2.80  95.48  92.52    110    0.201     2    0.079    0.280
  0.29   0.00  55.00   2.80  95.48  92.52    110    0.201     2    0.079    0.280
  0.29   0.00  94.85   2.80  95.48  92.52    110    0.201     2    0.079    0.280
  0.00   0.29  29.52   2.80  95.48  92.52    111    0.203     2    0.079    0.281
  0.00   0.29  67.87   2.80  95.48  92.52    111    0.203     2    0.079    0.281
  0.29   0.00   9.98   2.80  95.48  92.52    112    0.204     2    0.079    0.283
  0.29   0.00  52.81   2.80  95.48  92.52    112    0.204     2    0.079    0.283
  0.29   0.00  80.01   2.80  95.48  92.52    112    0.204     2    0.079    0.283
  0.00   0.22  21.95   2.80  95.48  92.52    113    0.206     2    0.079    0.284
  0.00   0.22  68.13   2.80  95.48  92.52    113    0.206     2    0.079    0.284
  0.29   0.00   3.98   2.80  95.48  92.52    114    0.207     2    0.079    0.286
  0.29   0.00  32.12   2.80  95.48  92.52    114    0.207     2    0.079    0.286
  0.29   0.00  76.84   2.80  95.48  92.52    114    0.207     2    0.079    0.286
  0.00   0.29   4.18   2.80  95.48  92.52    115    0.208     2    0.079    0.287
  0.00   0.29  49.50   2.80  95.48  92.52    115    0.208     2    0.079    0.287
  0.00   0.29  81.26   2.80  95.48  92.52    115    0.208     2    0.079    0.287
  0.29   0.00   3.98   2.80  95.48  92.52    116    0.209     2    0.079    0.288
  0.29   0.00  44.52   2.80  95.48  92.52    116    0.209     2    0.079    0.288
  0.29   0.00  86.46   2.80  95.48  92.52    116    0.209     2    0.079    0.288
  0.00   0.29  19.73   2.80  95.48  92.52    117    0.210     2    0.079    0.289
  0.00   0.29  56.84   2.80  95.48  92.52    117    0.210     2    0.079    0.289
  0.22   0.00   3.98   2.80  95.48  92.52    118    0.211     2    0.079    0.290
  
  