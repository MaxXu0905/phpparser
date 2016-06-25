package com.ailk.utils;

import java.io.File;

public class MoveToCand {
	public static void main(String[] args) throws Exception {
		String[] files = { "array.xml", "bc.xml", "calendar.xml", "classobj.xml", "ctype.xml", "datetime.xml",
				"errorfunc.xml", "funchand.xml", "info.xml", "math.xml", "overload.xml", "posix.xml", "readline.xml",
				"regex.xml", "spl.xml", "stream.xml", "strings.xml", "tokenizer.xml", "variables.xml" };
       String src = "E:\\MyEclipse10Work\\phpparser\\assets\\target\\";
       String target = "E:\\MyEclipse10Work\\CandPortal\\src\\main\\resources\\docs\\php\\";
       for(String srcName : files){
    	   File file = new File(src + srcName);
    	   boolean result = file.renameTo(new File(target + srcName));
           System.out.println(result);
       }
	}
}
