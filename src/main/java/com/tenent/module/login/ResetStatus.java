package com.tenent.module.login;

public class ResetStatus {

	private Integer resCode;
	private String respMsg;
	
	public ResetStatus() {
	}
	
	public ResetStatus(Integer resCode, String respMsg) {
		this.resCode = resCode;
		this.respMsg = respMsg;
	}

	public Integer getResCode() {
		return resCode;
	}
	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	@Override
	public String toString() {
		return "ResetStatus [resCode=" + resCode + ", respMsg=" + respMsg + "]";
	}
	
}
