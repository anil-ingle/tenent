package com.tenent.module.login;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	private LoginService service;

	@Autowired
	private JavaMailSender sender;

	// reset password
	@RequestMapping(value = "mvc/resetPass", method = RequestMethod.GET)
	public @ResponseBody Status resetPass(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		return service.resetPass(email, password);
	}

	// login method
	@RequestMapping(value = "mvc/login", method = RequestMethod.GET)
	public @ResponseBody Status login(@RequestParam("email") String email, @RequestParam("password") String password) {

		return service.login(email, password);
	}

	// forgot password
	@RequestMapping(value = "mvc/forgotpassword", method = RequestMethod.GET)
	public @ResponseBody Status forgotPassword(@RequestParam("email") String email) {
		Status status=service.forgotPassword(email);
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			if (status.getResCode() == 1002) {
				helper.setTo(status.getEmail());
				helper.setText("We received a request to reset your tenent app password.");
				helper.setText("Your reset code is ." + status.getOtp());
				helper.setSubject(status.getOtp() + "is your tenentapp account recovery code");
			}
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// otp validation
	@RequestMapping(value = "mvc/validotp", method = RequestMethod.GET)
	public @ResponseBody Status validOtp(@RequestParam Integer otp) {
		/*Status status = service.validOtp(otp);
		try {
			if (status.getResCode() == 1010) {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);
				helper.setTo(service.otpMap.get(otp));
				helper.setText("We received a request to reset your tenent app password.");
				helper.setText("Your reset code is ." + status.getOtp());
				helper.setSubject(status.getOtp() + "is your tenentapp account recovery code");
				sender.send(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
*/		return service.validOtp(otp);
	}

}
