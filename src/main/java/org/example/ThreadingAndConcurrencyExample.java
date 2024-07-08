package org.example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadingAndConcurrencyExample {
    public void run() {
        System.out.println("Threading and Concurrency Examples in Java:");

        basicThreadCreation();
        runnableInterfaceExample();
        synchronizedMethodExample();
        lockExample();
        executorServiceExample();
        callableAndFutureExample();
        atomicVariableExample();
        countDownLatchExample();
        cyclicBarrierExample();
    }

    private void basicThreadCreation() {
        System.out.println("\n*********************** Basic Thread Creation ***********************");
        System.out.println("Explanation: This example demonstrates creating a new thread directly using the Thread class.");
        System.out.println("Pros: Simple and straightforward for basic threading needs.");
        System.out.println("Cons: Limited control over thread lifecycle and resource management.");

        Thread thread = new Thread(() -> {
            System.out.println("Hello from a new thread!");
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runnableInterfaceExample() {
        System.out.println("\n*********************** Runnable Interface Example ***********************");
        System.out.println("Explanation: This example shows how to use the Runnable interface to define a task for a thread.");
        System.out.println("Pros: Separates task definition from thread management, more flexible than extending Thread.");
        System.out.println("Cons: Doesn't return a result, limited exception handling.");

        Runnable task = () -> System.out.println("Task executed using Runnable");
        new Thread(task).start();
    }

    private void synchronizedMethodExample() {
        System.out.println("\n*********************** Synchronized Method Example ***********************");
        System.out.println("Explanation: This example demonstrates using synchronized methods to ensure thread-safe access to shared resources.");
        System.out.println("Pros: Simple way to achieve thread safety, prevents race conditions.");
        System.out.println("Cons: Can lead to performance issues due to thread contention, potential for deadlocks if not careful.");

        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value: " + counter.getCount());
    }

    private void lockExample() {
        System.out.println("\n*********************** Lock Example ***********************");
        System.out.println("Explanation: This example shows how to use explicit locks for more fine-grained control over synchronization.");
        System.out.println("Pros: More flexible than synchronized methods, supports advanced features like timed waits.");
        System.out.println("Cons: More complex to use correctly, risk of forgetting to release locks.");

        LockCounter lockCounter = new LockCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                lockCounter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lock Counter value: " + lockCounter.getCount());
    }

    private void executorServiceExample() {
        System.out.println("\n*********************** Executor Service Example ***********************");
        System.out.println("Explanation: This example demonstrates using ExecutorService for managing thread pools and task execution.");
        System.out.println("Pros: Efficient thread reuse, better resource management, separates task submission from execution.");
        System.out.println("Cons: More complex setup, potential for thread leaks if not properly shut down.");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void callableAndFutureExample() {
        System.out.println("\n*********************** Callable and Future Example ***********************");
        System.out.println("Explanation: This example shows how to use Callable for tasks that return results and Future to handle those results.");
        System.out.println("Pros: Allows tasks to return results, provides mechanisms for handling exceptions and cancellation.");
        System.out.println("Cons: Can be complex to use correctly, potential for deadlocks if not managed properly.");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });
        try {
            System.out.println("Future result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private void atomicVariableExample() {
        System.out.println("\n*********************** Atomic Variable Example ***********************");
        System.out.println("Explanation: This example demonstrates using atomic variables for thread-safe operations without explicit synchronization.");
        System.out.println("Pros: Provides thread-safe operations without locks, generally more efficient than synchronization for single variables.");
        System.out.println("Cons: Limited to single variable operations, not suitable for more complex synchronization scenarios.");

        AtomicInteger atomicInt = new AtomicInteger(0);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicInt.incrementAndGet();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Atomic Integer value: " + atomicInt.get());
    }

    private void countDownLatchExample() {
        System.out.println("\n*********************** CountDownLatch Example ***********************");
        System.out.println("Explanation: This example shows how to use CountDownLatch for coordinating multiple threads.");
        System.out.println("Pros: Useful for scenarios where one thread needs to wait for multiple threads to complete.");
        System.out.println("Cons: Cannot be reset once count reaches zero, not reusable.");

        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
            System.out.println("All threads completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cyclicBarrierExample() {
        System.out.println("\n*********************** CyclicBarrier Example ***********************");
        System.out.println("Explanation: This example demonstrates using CyclicBarrier for synchronizing multiple threads at a common point.");
        System.out.println("Pros: Allows multiple threads to wait for each other, can be reset and reused, can execute a task when barrier is reached.");
        System.out.println("Cons: More complex to use than CountDownLatch, potential for deadlocks if not all threads reach the barrier.");

        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Barrier action executed"));
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " crossed barrier");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    private static class LockCounter {
        private int count = 0;
        private Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            return count;
        }
    }
}