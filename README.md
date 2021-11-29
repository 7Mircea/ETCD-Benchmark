
# Cum se ruleaza

Pentru a pute rula acest exemplu mai intai trebuie sa rulam comenzile
cd
etcd
Prima ne duce in folderul home si a doua porneste baza de date in mod nesecurizat.
In memoria RAM se citesc toate valorile din fiiser care ocupa aprox : 121_555_200B = 121.5MB(aprox).
Pentru a compila programul se ruleaza in folderul in care a fost descarcat codul.
gradle clean 
gradle build
gradle run

# Mediu testare

Linux 20.04, Intel i7, 16GB RAM, java 17.

# Testare

Pentru a vedea daca dupa rularea comenzii:
etcd
Baza de date chiar s-a pornit se deschide un nou terminal si se scrie 
etcdctl put cheie valoare
etcdctl get cheie
Daca vrei sa stergi scrii
etcdctl del cheie

# Rezultat original

Scalation factor : 10000
Inseration time:8039.0s
Inseration time:6608.0s
Inseration time:6445.0s
Inseration time:6407.0s
Inseration time:6320.0s
Mean : 6763.8. Std dev: 644.4077591090909

Scalation factor : 100000
Inseration time:64022.0s
Inseration time:68764.0s
Inseration time:63971.0s
java.util.concurrent.ExecutionException: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:396)
        at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:2073)
        at benchmark.Benchmark.put(Benchmark.java:134)
        at benchmark.Benchmark.main(Benchmark.java:61)
Inseration time:2501.0s
Caused by: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at com.google.common.util.concurrent.AbstractFuture.getDoneValue(AbstractFuture.java:588)
        at com.google.common.util.concurrent.AbstractFuture.get(AbstractFuture.java:547)
        at io.etcd.jetcd.ClientConnectionManager.lambda$null$3(ClientConnectionManager.java:287)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at io.grpc.Status.asRuntimeException(Status.java:535)
        at io.grpc.stub.ClientCalls$UnaryStreamToFuture.onClose(ClientCalls.java:533)
        at io.grpc.PartialForwardingClientCallListener.onClose(PartialForwardingClientCallListener.java:39)
        at io.grpc.ForwardingClientCallListener.onClose(ForwardingClientCallListener.java:23)
        at io.grpc.ForwardingClientCallListener$SimpleForwardingClientCallListener.onClose(ForwardingClientCallListener.java:40)
        at io.etcd.jetcd.auth.AuthInterceptor$1$1.onClose(AuthInterceptor.java:101)
        at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:557)
        at io.grpc.internal.ClientCallImpl.access$300(ClientCallImpl.java:69)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:738)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:717)
        at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)
        at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)
        ... 3 more
Inseration time:64519.0s
Mean : 52755.4. Std dev: 25190.824667723762

Scalation factor : 200000
Inseration time:133955.0s
Inseration time:129730.0s
Inseration time:131649.0s
Inseration time:4463.0s
java.util.concurrent.ExecutionException: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:396)
        at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:2073)
        at benchmark.Benchmark.put(Benchmark.java:134)
        at benchmark.Benchmark.main(Benchmark.java:61)
Caused by: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at com.google.common.util.concurrent.AbstractFuture.getDoneValue(AbstractFuture.java:588)
        at com.google.common.util.concurrent.AbstractFuture.get(AbstractFuture.java:547)
        at io.etcd.jetcd.ClientConnectionManager.lambda$null$3(ClientConnectionManager.java:287)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at io.grpc.Status.asRuntimeException(Status.java:535)
        at io.grpc.stub.ClientCalls$UnaryStreamToFuture.onClose(ClientCalls.java:533)
        at io.grpc.PartialForwardingClientCallListener.onClose(PartialForwardingClientCallListener.java:39)
        at io.grpc.ForwardingClientCallListener.onClose(ForwardingClientCallListener.java:23)
        at io.grpc.ForwardingClientCallListener$SimpleForwardingClientCallListener.onClose(ForwardingClientCallListener.java:40)
        at io.etcd.jetcd.auth.AuthInterceptor$1$1.onClose(AuthInterceptor.java:101)
        at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:557)
        at io.grpc.internal.ClientCallImpl.access$300(ClientCallImpl.java:69)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:738)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:717)
        at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)
        at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)
        ... 3 more
Inseration time:130715.0s
Mean : 106102.4. Std dev: 50838.97577882544

Scalation factor : 400000
Inseration time:262260.0s
Inseration time:268585.0s
Inseration time:10028.0s
java.util.concurrent.ExecutionException: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:396)
        at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:2073)
        at benchmark.Benchmark.put(Benchmark.java:134)
        at benchmark.Benchmark.main(Benchmark.java:61)
Caused by: java.util.concurrent.ExecutionException: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at com.google.common.util.concurrent.AbstractFuture.getDoneValue(AbstractFuture.java:588)
        at com.google.common.util.concurrent.AbstractFuture.get(AbstractFuture.java:547)
        at io.etcd.jetcd.ClientConnectionManager.lambda$null$3(ClientConnectionManager.java:287)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: io.grpc.StatusRuntimeException: UNKNOWN: etcdserver: too many requests
        at io.grpc.Status.asRuntimeException(Status.java:535)
        at io.grpc.stub.ClientCalls$UnaryStreamToFuture.onClose(ClientCalls.java:533)
        at io.grpc.PartialForwardingClientCallListener.onClose(PartialForwardingClientCallListener.java:39)
        at io.grpc.ForwardingClientCallListener.onClose(ForwardingClientCallListener.java:23)
        at io.grpc.ForwardingClientCallListener$SimpleForwardingClientCallListener.onClose(ForwardingClientCallListener.java:40)
        at io.etcd.jetcd.auth.AuthInterceptor$1$1.onClose(AuthInterceptor.java:101)
        at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:557)
        at io.grpc.internal.ClientCallImpl.access$300(ClientCallImpl.java:69)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:738)
        at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:717)
        at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)
        at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)
        ... 3 more
Inseration time:265803.0s
Inseration time:266425.0s
Mean : 214620.2. Std dev: 102316.30838023819

Scalation factor : 405184
Inseration time:267925.0s
Inseration time:267258.0s
Inseration time:268205.0s
Inseration time:270758.0s
Inseration time:271942.0s
Mean : 269217.6. Std dev: 1807.284880698115

# Rezultat original

Scalation factor : 10000
Inseration time:8039.0s
Inseration time:6608.0s
Inseration time:6445.0s
Inseration time:6407.0s
Inseration time:6320.0s
Mean : 6763.8. Std dev: 644.4077591090909

Scalation factor : 100000
Inseration time:63622.0s
Inseration time:66698.0s
Inseration time:68952.0s
Inseration time:68697.0s
Inseration time:67464.0s
Mean : 67086.6. Std dev: 1916.7680715203912

Scalation factor : 200000
Inseration time:133955.0s
Inseration time:129730.0s
Inseration time:131649.0s
Inseration time:131543.0s
Inseration time:130715.0s
Mean : 131518.4. Std dev: 1399.8933673676722

Scalation factor : 400000
Inseration time:262260.0s
Inseration time:268585.0s
Inseration time:267583.0s
Inseration time:265803.0s
Inseration time:266425.0s
Mean : 266131.2. Std dev: 2159.1239334507873

Scalation factor : 405184
Inseration time:267925.0s
Inseration time:267258.0s
Inseration time:268205.0s
Inseration time:270758.0s
Inseration time:271942.0s
Mean : 269217.6. Std dev: 1807.284880698115
