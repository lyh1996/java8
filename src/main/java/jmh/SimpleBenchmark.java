/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-14 11:03
 */
package jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2020/01/14 11:03
 */
@BenchmarkMode({Mode.Throughput, Mode.AverageTime}) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.SECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class SimpleBenchmark {

    @Benchmark
    public void bench() {
        add(1, 1);
    }

    private static int add(int a, int b) {
        return a + b;
    }


    @Benchmark
    public String stringConcat() {
        String a = "a";
        String b = "b";
        String c = "c";
        return a + b + c;
    }

/*    include(SimpleBenchmark.class.getSimpleName())代表我要测试的是哪个类的方法
    exclude("stringConcat")代表测试的时候需要排除stringConcat方法
    forks(2)指的是做2轮测试，在一轮测试无法得出最满意的结果时,可以多测几轮以便得出更全面的测试结果，而每一轮都是先预热，再正式计量。
    warmupIterations(5)代表先预热5次
    measurementIterations(5) 正式运行测试5次*/

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(SimpleBenchmark.class.getSimpleName())
                .exclude("stringConcat")
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();
        new Runner(options).run();
    }
}