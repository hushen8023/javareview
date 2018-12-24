package com.hushen.nio.rpc;

public class RpcRquest {
	 /**请求id*/
    private String requestId;
    /**请求接口名*/
    private String interfaceName;
    /**服务版本**/
    private String serviceVersion;
    /**方法名*/
    private String methodName;
   /**参数类型*/
    private Class<?>[] parameterTypes;
    /**参数*/
    private Object[] parameters;
	public String getRequestId() {
		return requestId;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public String getServiceVersion() {
		return serviceVersion;
	}
	public String getMethodName() {
		return methodName;
	}
	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
