package com.liuyu.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: StreamUtil
 * @Description: 流處理
 * @author: 刘宇
 * @date: 2020年3月1日 下午4:11:05
 */
public class StreamUtil {

	/*
	 * 方法1：批量关闭流，参数能传无限个。(3分) 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	 */
	public static void closeAll(AutoCloseable... autoCloseable) {
		if (autoCloseable == null || autoCloseable.length == 0)
			throw new RuntimeException("参数异常");
		for (AutoCloseable autoCloseable2 : autoCloseable) {
			try {
				autoCloseable2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	 */
	public static String readTextFile(InputStream src) {

		byte[] b = new byte[1024];
		int len;
		try {
			while ((len = src.read(b)) != -1) {
				return new String(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	/*
	 * 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */

	public static String readTextFile(File txtFile) {

		try {
			FileInputStream stream = new FileInputStream(txtFile);
			return readTextFile(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 读取InputStream 放入集合
	public static List<String> read(InputStream inputStream) throws IOException {
		// 声明集合
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	// 根据文件的地址读取文件放入集合中
	public static List<String> read(String filePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);
		return read(inputStream);
	}

	// 讀取文件内容放入集合
	public static List<String> read(File file) throws Exception {
		FileInputStream inputStream = new FileInputStream(file);
		return read(inputStream);
	}
}
