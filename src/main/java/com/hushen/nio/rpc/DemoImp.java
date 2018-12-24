package com.hushen.nio.rpc;

/**
 * 提供者实现类
 * @author Sonny
 *
 */
public class DemoImp implements Idemo {
	
	@Override
	public Integer add(Integer i, Integer j) {
        return i+j;
    }
}
