package chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ChapterTwentySix implements Chapter {

	private Note notes;

	public ChapterTwentySix() {
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
//		Demo.exec();
//		ChapterTwentySix.topicExecutorService();
//		topicCompletableFuture();
//		try { System.out.println(FutureMethod.calculateAsync().get()); }catch(ExecutionException |InterruptedException e) { e.printStackTrace();}
//		try { FutureMethod.supplyAsync(); }catch(ExecutionException | InterruptedException e) {}
//		topicLockAPI();
		VirtualThread();
	}

	// 136. MultiThreading Program: Thread & Runnable
	public static void topicThreadAndRunnable() {
		System.out.println("--- Executing:  topicThreadAndRunnable ---");
		Runnable task = new DefaultRunnable();
		Thread t1 = new Thread(task);

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
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

		} catch (InterruptedException e) {

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
	public static void topicSynchronizationBasic() {

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
		} catch (InterruptedException e) {

		}

	}

	// 141. Executor Service, Callable & Future.
	public static void topicExecutorService() {
		ExecutorService es = Executors.newCachedThreadPool();

		es.execute(() -> System.out.println("Hello from  thread" + Thread.currentThread().getName()));
		es.execute(() -> System.out.println("Hello from  thread" + Thread.currentThread().getName()));
		
		
//		ExecutorService es = Executors.newCachedThreadPool();
		
		List<Callable<String>> tasks  = new ArrayList<>(Arrays.asList(
				()-> "Task 1",
				()-> "Task 2",
				()-> "Task 3"
				));
		try {
		
			List<Future<String>> futures = es.invokeAll(tasks);
			
			futures.stream().map(future -> {
				try {
					return future.get();
					
				}catch(InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return "";
				}
			}).forEach(s -> System.out.println(s));
		
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	// 144. Completable Future
	public static void topicCompletableFuture() {
		try {
			CompletableFuture.runAsync(
					()-> {
						System.out.println("Thread name: " + Thread.currentThread().getName());
						System.out.println("Http calls goes here.");
					});
			
			TimeUnit.SECONDS.sleep(2);
			
			ExecutorService es = Executors.newCachedThreadPool();
			
			CompletableFuture.runAsync(
					()-> {
						System.out.println("Thread name: " + Thread.currentThread().getName());
						System.out.println("Http calls goes here.");
					}, es);
			es.shutdown();
			
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 145. LockAPI
	public static void topicLockAPI() {
		try {
		var thisInstance = new LockAPI();
		var es = Executors.newFixedThreadPool(4);
		
		IntStream.range(0, 10000).forEach(i -> { es.execute(thisInstance::increamentWithLock); });
		
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();
		
		System.out.println(thisInstance.counter);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 148 Virtual Thread.
	public static void VirtualThread() {
		try { VirtualThreadDemo.main(); } catch( InterruptedException e) {} 
	}
}

// External Classes: (for the sake of demo)

// Custom thread Class;
class DefaultRunnable implements Runnable {

	private String externalString;

	public DefaultRunnable() {
	}

	public DefaultRunnable(String externalString) {
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

class PriorityDemo {
	public static void execute() {
		// sample, to get the process executing process last a bit longer.
		for (int i = 0; i < 1_000_000; i++) {
			Math.sqrt(i);
		}

		System.out.println(Thread.currentThread().getName() + " priority=" + Thread.currentThread().getPriority());
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

	public static void exec() {

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
		} catch (InterruptedException e) {
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

class FutureMethod
{
	
	private static final double DEFAULT_PRICE = 9.99;
	
	public static Future<Double> calculateAsync() throws InterruptedException {
		CompletableFuture<Double> cf = new CompletableFuture<>();
		var es = Executors.newCachedThreadPool();
		Future<Double> future = es.submit(()-> {
			System.out.println("Request to server has been sent");
			Double result = null;
			TimeUnit.SECONDS.sleep(5);
			return result;
		});
		
		es.shutdown(); // stop thread from getting task
		es.awaitTermination(2, TimeUnit.SECONDS); // check executor service, if its still active or not (regardless of thread or task)
		
		if(future.isDone()) {
			return future;
		}else {
			cf.complete(DEFAULT_PRICE);
			return cf;
		}
	}
	
	public static void supplyAsync() throws ExecutionException, InterruptedException{
		var future = CompletableFuture.supplyAsync(()-> {
			System.out.println("Request User ID from exeternal API");
			return 1234;
		}).thenApply(result ->{
			System.out.println("Request total number of purchase in the order Service by ID..." + result);
			return 150;
		});
		
		System.out.println(future.get());
	}
	
}

class LockAPI{
	
	protected static int counter;
	private Lock lock = new ReentrantLock();
	
	public void increamentWithLock() {
		try{
			lock.lock();
			counter++;
		}finally {
			lock.unlock();
		}
	}
}

class VirtualThreadDemo {
	
	public static void main()  throws InterruptedException
	{
		System.out.println("Demo Virutal Thread in Java 21");
		
		Thread vThread = Thread.startVirtualThread(()-> {
			System.out.println("Hello from virual Thread");
		});
		
		vThread.join();
		
		try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
			
			Future<String> result = executor.submit(()-> {
					return "Task Completed";
			});
			
			System.out.println("Result: " + result.get());
		}catch(ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
