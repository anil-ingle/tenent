package com.tentent.module.util;

public class SqlUtil {

public static final String Reset_Password="update tab_login set password =? where email=?";
public static final String Login="select roll from  tab_login where email=? and password=? and active=1";
public static final String Is_Email_Valid="select count(*) from tab_login where email=?";
}
