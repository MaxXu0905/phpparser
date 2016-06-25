package com.ailk.php.down;

import java.io.File;

public class PhpLeftDown {
	static String urlLeft = "http://php.jz123.cn/left.htm";

	public static void main(String[] args) throws Exception {
		HttpDownUtils.downFile(new File("assets/source/left.html"), urlLeft);
	}
}
