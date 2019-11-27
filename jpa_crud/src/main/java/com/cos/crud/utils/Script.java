package com.cos.crud.utils;

public class Script {
	public static String back(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + msg + "');");
		sb.append("history.back();");
		sb.append("console.log('backkkkkkkkkkkkkkkkkkk');");
		sb.append("</script>");
		return sb.toString();
	}

	public static String href(String location) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("location.href='" + location + "';");
		sb.append("console.log('homeeeeeeeeeeeeeeeeee');");
		sb.append("</script>");
		return sb.toString();
	}
}
