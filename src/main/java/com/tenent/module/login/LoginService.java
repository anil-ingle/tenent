package com.tenent.module.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginDAO dao;
	
	Map<Integer,String> otpMap=new HashMap();
	Random rand = new Random();
    //reset password
	public Status resetPass(String email, String password) {
		int status = dao.resetPass(email, password);
		Status Status = new Status();
		if (status == 1) {
			Status.setResCode(1004);
			Status.setRespMsg("password rerset successfully");
		} else {
			Status.setResCode(1005);
			Status.setRespMsg("password reset  failure");
		}
		return Status;
	}
    //login 
	public Status login(String email, String password) {
		Status status = new Status();
		int loginDaoRet = dao.login(email, password);
		if (loginDaoRet > 0) {
			status.setRoll(loginDaoRet);
			status.setRespMsg("login successfully");
			status.setResCode(1000);
		} else {
			status.setRespMsg("login failure");
			status.setResCode(1001);
		}
		return status;
	}
    //forgot password
	public Status forgotPassword(String email) {
		Status status = new Status();
		int stat = dao.forgotPassword(email);
		if (stat == 1) {
			int otp = 10000 + rand.nextInt(90000);
			status.setOtp(otp);
			status.setRespMsg("otp generated succesfully");
			status.setResCode(1002);
			status.setEmail(email);
			
			otpMap.put(otp,email);
		} else {
			status.setRespMsg("resend otp");
			status.setResCode(1009);
		}
		return status;
	}
	//validate otp
	public Status validOtp(Integer otp) {
		Status status = new Status();
		if(otpMap.containsKey(otp)) {
		status.setRespMsg("otp verify successfully");
		status.setResCode(1010);
		}
		else {
			status.setRespMsg("otp verify failed");
			status.setResCode(1011);
		}
		return status;
	}
	
	
}
