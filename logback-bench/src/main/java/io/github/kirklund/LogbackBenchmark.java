package io.github.kirklund;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.Before;
import org.junit.Test;
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

@Measurement(iterations = 1, time = 1, timeUnit = MINUTES)
@Warmup(iterations = 1, time = 1, timeUnit = MINUTES)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(SECONDS)
@State(Scope.Benchmark)
@SuppressWarnings("unused")
public class LogbackBenchmark {

  private org.apache.logging.log4j.Logger log4jLogger;
  private org.slf4j.Logger slf4jLogger;

  @Setup @Before
  public void setUp() {
    System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    log4jLogger = org.apache.logging.log4j.LogManager.getLogger();
    slf4jLogger = org.slf4j.LoggerFactory.getLogger(getClass());
  }

  @Benchmark @Test
  public void debugProcessorThreadsLog4j() {
    log4jLogger.debug("debugProcessorThreadsLog4j");
  }

  @Benchmark @Test
  public void infoProcessorThreadsLog4j() {
    log4jLogger.info("infoProcessorThreadsLog4j");
  }

  @Benchmark @Test
  public void debugProcessorThreadsSlf4J() {
    slf4jLogger.debug("debugProcessorThreadsSlf4J");
  }

  @Benchmark @Test
  public void infoProcessorThreadsSlf4J() {
    slf4jLogger.info("infoProcessorThreadsSlf4J");
  }

  @Benchmark @Threads(1) @Test
  public void debug1ThreadLog4j() {
    log4jLogger.debug("debug1ThreadLog4j");
  }

  @Benchmark @Threads(1) @Test
  public void info1ThreadLog4j() {
    log4jLogger.info("info1ThreadLog4j");
  }

  @Benchmark @Threads(1) @Test
  public void debug1ThreadSlf4J() {
    slf4jLogger.debug("debug1ThreadSlf4J");
  }

  @Benchmark @Threads(1) @Test
  public void info1ThreadSlf4J() {
    slf4jLogger.info("info1ThreadSlf4J");
  }

  @Benchmark @Threads(10) @Test
  public void debug10ThreadsLog4j() {
    log4jLogger.debug("debug10ThreadsLog4j");
  }

  @Benchmark @Threads(10) @Test
  public void info10ThreadsLog4j() {
    log4jLogger.info("info10ThreadsLog4j");
  }

  @Benchmark @Threads(10) @Test
  public void debug10ThreadsSlf4J() {
    slf4jLogger.debug("debugSlf4J");
  }

  @Benchmark @Threads(10) @Test
  public void info10ThreadsSlf4J() {
    slf4jLogger.info("infoSlf4J");
  }

  @Benchmark @Threads(100) @Test
  public void debug100ThreadsLog4j() {
    log4jLogger.debug("debug100ThreadsLog4j");
  }

  @Benchmark @Threads(100) @Test
  public void info100ThreadsLog4j() {
    log4jLogger.info("info100ThreadsLog4j");
  }

  @Benchmark @Threads(100) @Test
  public void debug100ThreadsSlf4J() {
    slf4jLogger.debug("debug100ThreadsSlf4J");
  }

  @Benchmark @Threads(100) @Test
  public void info100ThreadsSlf4J() {
    slf4jLogger.info("info100ThreadsSlf4J");
  }
}
