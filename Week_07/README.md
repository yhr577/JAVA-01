学习笔记:
先设置:

set global max_allowed_packet = 900 * 1024 * 1024;


http://127.0.0.1:8099/demo/getbean

            for (int i = 0; i < 1000000; i++) {
                cardBin10000.setCardBinId(String.valueOf(cardBinId+i));
                cardBinList.add((CardBin)cardBin10000.clone());
            }
            stopWatch.start();
            int ret = cardBinMapper.insertBatchSomeColumn(cardBinList);
            stopWatch.stop();
            
插入数据结束:1000000
StopWatch 'StopWatch': running time = 125144107600 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
125144107600  100%  

插入数据结束:1000000
StopWatch 'StopWatch': running time = 124522544000 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
124522544000  100%  

连接本地数据库: 83秒

StopWatch 'StopWatch': running time = 83564749000 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
83564749000  100%  

