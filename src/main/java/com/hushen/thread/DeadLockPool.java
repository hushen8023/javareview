package com.hushen.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池的任务1依赖任务2的执行结果，但是线程池是单线程的，也就是说任务1不执行完，任务2永远得不到执行，那么因此造成了死锁
 * 
 * 解决办法：扩大线程池线程数 or 任务结果之间不再互相依赖。
 * 
 * @author Sonny
 *
 */
public class DeadLockPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ExecutorService executorService = Executors.newSingleThreadExecutor();
		@SuppressWarnings("unchecked")
		Future f1 = executorService.submit(new Callable() {
			public Long call() throws Exception{
				System.out.println("start f1");
				Thread.sleep(1000);//延时
				@SuppressWarnings("unchecked")
				Future f2 = executorService.submit(new Callable() {
					public Long call() throws Exception{
						System.out.println("start f2");
						return-1L;
						}
					});
				System.out.println("result"+ f2.get());
				System.out.println("end f1");
				return-1L;
			}
		});
		
	}

}
