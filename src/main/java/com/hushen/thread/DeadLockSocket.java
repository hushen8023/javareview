package com.hushen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 在网络连接池也会发生死锁，假设此时有两个线程A和B，两个数据库连接池N1和N2，连接池大小都只有1，如果线程A按照先N1后N2的顺序获得网络连接，
 * 而线程B按照先N2后N1的顺序获得网络连接，并且两个线程在完成执行之前都不释放自己已经持有的链接，因此也造成了死锁。
 * @author Sonny
 *
 */
public class DeadLockSocket {

	public static void main(String[] args) {
		// 连接1
		final MultiThreadedHttpConnectionManager connectionManager1 =new MultiThreadedHttpConnectionManager();
		final HttpClient httpClient1 = new HttpClient(connectionManager1);
		httpClient1.getHttpConnectionManager().getParams().setMaxTotalConnections(1);//设置整个连接池最大连接数
		// 连接2
		final MultiThreadedHttpConnectionManager connectionManager2 =new MultiThreadedHttpConnectionManager();
		final HttpClient httpClient2 =new HttpClient(connectionManager2);
		httpClient2.getHttpConnectionManager().getParams().setMaxTotalConnections(1);//设置整个连接池最大连接数
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new Runnable() {
			public void run(){
				try{
					PostMethod httpost =new PostMethod("http://www.baidu.com");
					System.out.println(">>>> Thread A execute 1 >>>>");
					httpClient1.executeMethod(httpost);
					Thread.sleep(5000l);
					System.out.println(">>>> Thread A execute 2 >>>>");
					httpClient2.executeMethod(httpost);
					System.out.println(">>>> End Thread A>>>>");
				}catch(Exception e) {
					// ignore
				}
			}
		});
		executorService.submit(new Runnable() {
			public void run(){
				try{
					PostMethod httpost =new PostMethod("http://www.baidu.com");
					System.out.println(">>>> Thread B execute 2 >>>>");
					httpClient2.executeMethod(httpost);
					Thread.sleep(5000l);
					System.out.println(">>>> Thread B execute 1 >>>>");
					httpClient1.executeMethod(httpost);
					System.out.println(">>>> End Thread B>>>>");
				}catch(Exception e) {
					// ignore
				}
			}
		});
	}

}
