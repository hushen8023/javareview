package com.hushen.nio.rpc;

public class RpcResponse {
	 /**请求流水号*/
    private String requestId;
    /**异常*/
    private Exception exception;
    /**返回结果**/
    private Object result;
	public String getRequestId() {
		return requestId;
	}
	public Exception getException() {
		return exception;
	}
	public Object getResult() {
		return result;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
