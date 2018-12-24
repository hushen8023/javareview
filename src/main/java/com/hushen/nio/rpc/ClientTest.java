package com.hushen.nio.rpc;

/**
 * 客户端测试
 * @author Sonny
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		//服务端连接信息
		RpcInitFactory initFactory=  new RpcInitFactory("127.0.0.1",8090);
		//客户端连接服务端，获取服务对象实例
        Idemo demo = new DemoRemoteImpl(new CommonClient(initFactory));
        System.out.println(demo.add(3, 1));
	}

}
