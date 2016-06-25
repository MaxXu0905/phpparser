package com.ailk.php.down;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownUtils {
   public static void downFile(File file, String ulr) throws Exception {
	     URL url = new URL(ulr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// connection.setRequestProperty("Accept-Charset", "utf-8");
		connection.setRequestProperty("contentType", "GBK");

		connection.connect();
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
		System.out.println("=============================");
		String lines;
//		File file = new File("assets/source/left.html");
	    RandomAccessFile  a = new RandomAccessFile(file, "rw");
	    BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		while ((lines = reader.readLine()) != null) {
		    write.write(lines+"\r\n");
			System.out.println(lines);
		}
		write.close();
		reader.close();
		// 断开连接
		connection.disconnect();
		System.out.println("=============================");
   }
}
