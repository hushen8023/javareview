package com.hushen.nio.rpc;

/**
 * 服务端测试类
 * @author Sonny
 *
 */
public class ServerTest {

	public static void main(String[] args) {
		//服务端
		ProviderServer server = new ProviderServer(8090);
		//提供者注册到注册中心(hashmap中)
	    RpcRegister.buildRegist().regist(Idemo.class.getName(), new DemoImp());
	    //启动一个线程，启动NIO服务端，8090端口对外提供服务
	    new Thread(server).start();
	}

}
