package com.kh.team.cjh.util;


public class MyUrlUtil {
	public static String makeUrl(String url, String u_id) {
		url += "?";
		url += "u_id=" + u_id;
		return url;
	}   
}
