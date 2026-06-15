package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterTwentySix implements Chapter{
	
	private Note notes;
	
	public ChapterTwentySix()
	{	
		Note notes = new ChapterNote(Arrays.asList("Thread and Runnable"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {	
		return "Multithreading";
	}

	@Override
	public List<String> getNotes() {
		return notes.getNotes();
	}

	@Override
	public void execute() {
		// section/Chapter 26;
		// executing threat and runnable section: 
//		ChapterTwentySix.topicThreadAndRunnable();
//		ChapterTwentySix.topicThreadScheduler();
//		ChapterTwentySix.topicSynchronizationBasic();
		Demo.exec();
	}
	
	// 136. MultiThreading Program: Thread & Runnable
	public static void topicThreadAndRunnable()
	{
		System.out.println("--- Executing:  topicThreadAndRunnable ---");
		Runnable task = new DefaultRunnable();
		Thread t1 = new Thread(task);
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run () {
				System.out.println("anonymous class, " + Thread.currentThread().getName());
			}
		});
		
		Thread t4 = new Thread(() -> System.out.println("Functional Programing, " + Thread.currentThread().getName()));
		
		
		/// run thread.
		t1.start();
		try {
			// give 10 mls window before interupting t1.
			Thread.sleep(10); // 10 millisecond.
			t1.interrupt();
			
		}catch(InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println("print after a few second sleep");
//		t2.start();
//		t4.start();
	}
	
	// 137. Thread Scheduler, Race Condition, Daemon Threads & Thread Group.
	public static void topicThreadScheduler() {
		System.out.println("--- Executing:  threadScheduler ---");
		var t0 = new Thread(PriorityDemo::execute);
		var t1 = new Thread(PriorityDemo::execute);
		var t2 = new Thread(PriorityDemo::execute);
		var t3 = new Thread(PriorityDemo::execute);
		var t4 = new Thread(PriorityDemo::execute);
		var t5 = new Thread(PriorityDemo::execute);
		
		
		t0.setPriority(1);
		t1.setPriority(10);
		t2.setPriority(10);
		t3.setPriority(3);
		t4.setPriority(6);
		t5.setPriority(4);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
			
	}
	
	// 138. Synchronization basic
	public static void topicSynchronizationBasic()
	{
		
		try {
	
		  Counter counter = new Counter();

	        Thread ct1 = new Thread(() -> {
	            for (int i = 0; i < 100_000; i++) {
	                counter.increment();
	            }
	        });

	        Thread ct2 = new Thread(() -> {
	            for (int i = 0; i < 100_000; i++) {
	                counter.increment();
	            }
	        });

	        ct1.start();
	        ct2.start();

	        // Wait for both threads to finish
	        ct1.join();
	        ct2.join();

	        System.out.println("Final count = " + counter.getCount());
		}catch(InterruptedException e)
		{
			
		}
		
	}
}

// External Classes: (for the sake of demo)

// Custom thread Class;
class DefaultRunnable implements Runnable {

	private String externalString;
	
	public DefaultRunnable() {}

	public DefaultRunnable(String externalString)
	{
		this.externalString = externalString;
	}
	@Override
	public void run() {
		
		// t1.interrupt will stop this infinite execution.
	    while (!Thread.currentThread().isInterrupted()) {
	    	System.out.println("I'm  a new thread, My name is " + Thread.currentThread().getName());
	    }
	    System.out.println("Stopping");
	}
	
}

class PriorityDemo
{
	public static void execute() {
		//sample, to get the process executing process last a bit longer.
	    for (int i = 0; i < 1_000_000; i++) {
	        Math.sqrt(i);
	    }

	    System.out.println(
	        Thread.currentThread().getName()
	        + " priority="
	        + Thread.currentThread().getPriority()
	    );
	}
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
class Demo {
    static final Object lock = new Object();

    public static void exec(){
    	
    	try {

        // 2 waiting threads
        Thread t1 = new Thread(() -> waitTask("T1"));
        Thread t2 = new Thread(() -> waitTask("T2"));

        t1.start();
        t2.start();

        Thread.sleep(2000); // give time to start and wait

        // Wake threads (try ONE of these at a time)

        synchronized (lock) {
            System.out.println("Main calling notify()");
            lock.notify(); // wakes ONE thread
        }

        Thread.sleep(2000);

        synchronized (lock) {
            System.out.println("Main calling notifyAll()");
            lock.notifyAll(); // wakes ALL remaining threads
        }
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    }

    static void waitTask(String name) {
        synchronized (lock) {
            try {
                System.out.println(name + " waiting...");
                lock.wait();
                System.out.println(name + " woke up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
