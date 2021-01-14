1.内存的分配情况如图.前三个收集器新生代和老年代内存分配区别并不是很明显.G1的from和to很小,Old区也比其它3个收集器小,eden区几乎是其它三个的两倍
2.其它收集器都是4个收集线程,G1多了5个线程G1 Concurrent Refinement Thread
3.因为内存小,四种收集器mirror GC的频率差不多,Full GC不存在.

