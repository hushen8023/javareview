package com.hushen.nio.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

/**
 * NIO RPC客户端
 * @author Sonny
 *
 */
public class CommonClient {
	private  RpcInitFactory factory;

    public CommonClient(RpcInitFactory factory) {
        this.factory = factory;
    }

    public <T> T invoke(RpcRquest req) {
        RpcResponse response = null;
        req.setRequestId(UUID.randomUUID().toString());
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(factory.getIp(), factory.getPort()));
            ByteBuffer buf1 = ByteBuffer.allocate(2048);
            buf1.put(JSONObject.toJSON(req).toString().getBytes());
            buf1.put(";".getBytes());
            buf1.flip();
            if (buf1.hasRemaining())
                socketChannel.write(buf1);
            buf1.clear();

            ByteBuffer body = ByteBuffer.allocate(2048);
            socketChannel.read(body);
            body.flip();
            if (body.hasRemaining()) {
                response = JSONObject.parseObject(new String(body.array()), RpcResponse.class);
            }
            body.clear();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) response;
    }
}
