package patterns._1_creational._1_singleton.test;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

/**
 * @author LinnykOleh
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Fork(2)
public class ThreadSafeSingletonBenchmark {

	/**
	 * Results:
	 *
	 * +---------------------------+-------+------+---------+-----------+-------+
	 * |Benchmark                  |  Mode | Cnt  |  Score  |   Error   | Units |
	 * |---------------------------+-------+------+---------+-----------+-------+
	 * |getInstance()              |  avgt |  10  | 117.026 | ± 132.415 | ns/op |
	 * |getInstanceDoubleLocking() |  avgt |  10  | 21.665  | ±  18.267 | ns/op |
	 * +---------------------------+-------+------+---------+-----------+-------+
	 *
	 * */
	private ThreadSafeSingletonBenchmark instance;

	@Setup
	public void setup() {
		this.instance = null;
	}

	@Benchmark
	@Threads(5)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public synchronized ThreadSafeSingletonBenchmark getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingletonBenchmark();
		}
		return instance;
	}

	@Benchmark
	@Threads(5)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public ThreadSafeSingletonBenchmark getInstanceDoubleLocking(){
		if(instance == null){
			synchronized(ThreadSafeSingletonBenchmark.class){
				if(instance == null){
					instance = new ThreadSafeSingletonBenchmark();
				}
			}
		}
		return instance;
	}

}
