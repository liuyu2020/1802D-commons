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
 * @Description: ��̎��
 * @author: ����
 * @date: 2020��3��1�� ����4:11:05
 */
public class StreamUtil {

	/*
	 * ����1�������ر����������ܴ����޸���(3��) ���紫��FileInputStream����JDBC��Connection���󶼿��Թرա�
	 */
	public static void closeAll(AutoCloseable... autoCloseable) {
		if (autoCloseable == null || autoCloseable.length == 0)
			throw new RuntimeException("�����쳣");
		for (AutoCloseable autoCloseable2 : autoCloseable) {
			try {
				autoCloseable2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ����2������һ���ı��ļ�����Ĭ��ΪUTF-8���룬���ظ��ļ�����(3��)��Ҫ�󷽷��ڲ����������1�������ر���(3��)
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
	 * ����3�������ı��ļ����󣬷��ظ��ļ�����(3��)������Ҫ���ڲ����������2������(5��)��* ���ǵ��͵ķ������أ���ס�������ꡭ
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

	// ��ȡInputStream ���뼯��
	public static List<String> read(InputStream inputStream) throws IOException {
		// ��������
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

	// �����ļ��ĵ�ַ��ȡ�ļ����뼯����
	public static List<String> read(String filePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);
		return read(inputStream);
	}

	// �xȡ�ļ����ݷ��뼯��
	public static List<String> read(File file) throws Exception {
		FileInputStream inputStream = new FileInputStream(file);
		return read(inputStream);
	}
}
