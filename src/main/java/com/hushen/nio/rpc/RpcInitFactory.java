package com.hushen.nio.rpc;

/**
 * 服务端连接信息
 * @author Sonny
 *
 */
public class RpcInitFactory {
	 /**
     * 客户端连接远程ip地址
     **/
    private String ip;
    /***远程端口*/
    private int port;


    public RpcInitFactory(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }


	public String getIp() {
		return ip;
	}


	public int getPort() {
		return port;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public void setPort(int port) {
		this.port = port;
	}
}
