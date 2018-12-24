package com.hushen.nio.rpc;

import java.util.HashMap;

/**
 * 注册中心
 * @author Sonny
 *
 */
public class RpcRegister {
	/**存储注册的服务提供实现类*/
    private HashMap<String, Object> registMap = new HashMap<String, Object>();
    private  static  RpcRegister register=new RpcRegister();
    public static  RpcRegister buildRegist(){
        return register;
    }
    public RpcRegister regist(String interfaceName,Object obj){
        registMap.put(interfaceName,obj);
        return this;
    }
    public Object findServier(String interfaceName){
        return  registMap.get(interfaceName);
    }
}
