package com.liuyu.common.utils;

import java.io.File;

public class FileUtil {

	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: ����1 ����һ���ļ��� ����ȡ�ļ�����׺����aa.jsp�����ء�.jsp��
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static String getExtendName(String fileName) {
		
		if(!StringUtil.hasText(fileName) || !fileName.contains(".")) {
			throw new RuntimeException("�����ļ�");
		}
		
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: ����2:���ز���ϵͳ����ʱĿ¼
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static File getTempDirectory() {
		String path = System.getProperty("java.io.tmpdir");
		return new File(path);
	}
	
	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: ����3:���ز���ϵͳ���û�Ŀ¼
	 * ����Linuxϵͳ���� /home/{�û��˺���} ��Windowsϵͳ����C:\User\{�û��˺���}
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static File getUserDirectory() {
		String path = System.getProperty("user.home");
		return new File(path);
	}
	
	
}
