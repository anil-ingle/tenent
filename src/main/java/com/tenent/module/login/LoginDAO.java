package com.tenent.module.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tentent.module.util.SqlUtil;

@Repository
public class LoginDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JdbcTemplate jdbctemplate;

	public int resetPass(String email, String password) {
		int ret= jdbctemplate.update(SqlUtil.Reset_Password, password, email);
		System.out.println(email + "---" + password+"  ret--"+ret);
		System.out.println(jdbctemplate.queryForObject("select count(*) from tab_login", Integer.class));
		return ret;
	}

	public Integer login(String email,String password) {
		Object[] inputs = new Object[] { email,password};
		Integer loginRet=jdbctemplate.queryForObject(SqlUtil.Login,inputs,Integer.class);
		System.out.println("------login------");
		return loginRet;
	}
	
	public int forgotPassword(String email) {
		Object[] forgotpass=new Object[] {email};
		return jdbctemplate.queryForObject(SqlUtil.Is_Email_Valid,forgotpass,Integer.class);
	}
}
