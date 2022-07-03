package com.ioof;

public class Common {
	
	public final static int WRONG_PARSE = -99;
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";
	public static final String WEST = "WEST";
	public static final String NORTH = "NORTH";

	/**
	* <b>Description:</b><br> 
	* Parse String number to int
	* @param strNum String number
	* @return Integer or Wrong number
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public static int parseInt(String strNum) {
		
	    if (strNum == null) {
	        return WRONG_PARSE;
	    }
	    
	    try {
	        Integer num = Integer.parseInt(strNum);
	        return num;
	    } catch (NumberFormatException nfe) {
	        return WRONG_PARSE;
	    }
	}
}
