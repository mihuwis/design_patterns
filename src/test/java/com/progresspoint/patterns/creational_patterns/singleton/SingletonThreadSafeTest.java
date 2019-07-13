package com.progresspoint.patterns.creational_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SingletonThreadSafeTest {

    SingletonThreadSafe firstInstanceForTestBreakWithThreads;
    SingletonThreadSafe secondInstanceForTestBreakWithThreads;

    @Test
    void SingletonThreadSafe_TestWhenTwoThreadsRun() throws InterruptedException {
        Runnable task1 = () -> {
            firstInstanceForTestBreakWithThreads = SingletonThreadSafe.getInstance();
        };
        Runnable task2 = () -> {
            secondInstanceForTestBreakWithThreads = SingletonThreadSafe.getInstance();
        };

        int testSuccess = 0;
        int testFail = 0;
        for (int i = 0; i < 100; i++) {
            SingletonThreadSafe.instance = null;
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(task1);
            service.submit(task2);
            service.shutdown();
            service.awaitTermination(1, TimeUnit.SECONDS);

            if (firstInstanceForTestBreakWithThreads != null && secondInstanceForTestBreakWithThreads != null && firstInstanceForTestBreakWithThreads.equals(secondInstanceForTestBreakWithThreads)) {
                testSuccess++;
            } else {
                testFail++;
            }
        }

        System.out.println(String.format("testSuccess: %d, testFail: %d", testSuccess, testFail));
    }
}