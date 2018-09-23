package com.tenent.module.login;

public class Status {

	private Integer resCode;
	private String respMsg;
	private Integer roll;
	private Integer Otp;
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOtp() {
		return Otp;
	}

	public void setOtp(Integer otp) {
		Otp = otp;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public Status(Integer resCode, String respMsg, Integer roll,Integer otp,String email) {
		this.resCode = resCode;
		this.respMsg = respMsg;
		this.roll = roll;
		this.Otp=otp;
		this.email=email;
	}

	public Status() {
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
		return "Status [resCode=" + resCode + ", respMsg=" + respMsg + ", roll=" + roll + ", Otp=" + Otp + ", email="
				+ email + "]";
	}

	


	
	
}
