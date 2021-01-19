
CMS与ParallelGC相比:
2g3g4g堆下,CMS不如ParallelGC,8G以上CMS相比有微弱优势

ParallelGC与SerialGC相比:
在内存大的情况下比较有优势,1g平均13000.2g平均16000.而Serial在1g和2g都是在12000左右.

G1与CMS:
G1在2g或者4G下都比CMS好


总体情况:
大内存下,G1>CMS>Parallel>Serial



CMS的过程:
2021-01-18T22:53:31.724+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 283188K(349568K)] 300804K(506816K), 0.0002269 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-18T22:53:31.724+0800: [CMS-concurrent-mark-start]
2021-01-18T22:53:31.726+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-18T22:53:31.726+0800: [CMS-concurrent-preclean-start]
2021-01-18T22:53:31.727+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-18T22:53:31.727+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-18T22:53:31.744+0800: [GC (Allocation Failure) 2021-01-18T22:53:31.744+0800: [ParNew: 157248K->17472K(157248K), 0.0171944 secs] 440436K->345476K(506816K), 0.0175933 secs] [Times: user=0.03 sys=0.03, real=0.02 secs]
2021-01-18T22:53:31.762+0800: [CMS-concurrent-abortable-preclean: 0.001/0.035 secs] [Times: user=0.05 sys=0.03, real=0.04 secs]
2021-01-18T22:53:31.763+0800: [GC (CMS Final Remark) [YG occupancy: 23390 K (157248 K)]2021-01-18T22:53:31.763+0800: [Rescan (parallel) , 0.0003331 secs]2021-01-18T22:53:31.763+0800: [weak refs processing, 0.0000816 secs]2021-01-18T22:53:31.763+0800: [class unloading, 0.0002755 secs]2021-01-18T22:53:31.764+0800: [scrub symbol table, 0.0003323 secs]2021-01-18T22:53:31.764+0800: [scrub string table, 0.0001549 secs][1 CMS-remark: 328004K(349568K)] 351395K(506816K), 0.0015026 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-18T22:53:31.764+0800: [CMS-concurrent-sweep-start]
2021-01-18T22:53:31.765+0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-18T22:53:31.765+0800: [CMS-concurrent-reset-start]
2021-01-18T22:53:31.765+0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
G1的GC过程:
2021-01-17T00:31:58.843+0800: 0.292: [GC pause (G1 Evacuation Pause) (young), 0.0065314 secs]
2021-01-17T00:31:58.843+0800: 0.292: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0042691 secs]
2021-01-17T00:31:58.843+0800: 0.292: [GC concurrent-root-region-scan-start]
2021-01-17T00:31:58.843+0800: 0.293: [GC concurrent-root-region-scan-end, 0.0001204 secs]
2021-01-17T00:31:58.843+0800: 0.293: [GC concurrent-mark-start]
2021-01-17T00:31:58.845+0800: 0.295: [GC concurrent-mark-end, 0.0020604 secs]
2021-01-17T00:31:58.845+0800: 0.295: [GC remark 2021-01-17T00:31:58.845+0800: 0.295: [Finalize Marking, 0.0002439 secs] 2021-01-17T00:31:58.845+0800: 0.295: [GC ref-proc, 0.0001073 secs] 2021-01-17T00:31:58.845+0800: 0.295: [Unloading, 0.0004300 secs], 0.0011603 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-17T00:31:58.846+0800: 0.296: [GC cleanup 233M->233M(512M), 0.0007831 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 