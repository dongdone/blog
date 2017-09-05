问题：线上机器配置过-XX:+HeapDumpBeforeFullGC -XX:+HeapDumpAfterFullGC -XX:HeapDumpPath=/data/applogs/HeapDumpOnOutOfMemoryError 参数么，配了以后并没有把内存dump下来

如果老年代使用的是CMS的话，只有两种情况会dump：1.System.gc(), 2.concurrent mode failure；除此之外，CMS都不是真的full gc，只是因为stop the world被当成了gc
promotion failed不会直接fullgc，而可能间接引发

concurrent mode failed是由于在执行cms的background动作时，发生了类似System.gc导致的



