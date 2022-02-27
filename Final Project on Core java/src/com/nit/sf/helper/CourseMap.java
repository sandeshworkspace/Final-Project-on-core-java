package com.nit.sf.helper;

import java.util.HashMap;

public class CourseMap {
	
	//one static properties
	private static HashMap<String,Integer> map;
	
	//static block
	static {
		map = new HashMap();
		map.put("CJ",1);
		map.put("Oracle",1);
		map.put("Html",1);
		map.put("AJ",1);
		
	}
	
	//one static factory method
	public static int getCoruseID(String course) {
		return map.get(course.toUpperCase());
		
	}//factory method
	
}
