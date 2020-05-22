package com.liuyu.common.utils;

import java.io.File;

public class FileUtil {

	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: 方法1 ：给一个文件名 ，获取文件名后缀，“aa.jsp”返回“.jsp”
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static String getExtendName(String fileName) {
		
		if(!StringUtil.hasText(fileName) || !fileName.contains(".")) {
			throw new RuntimeException("不是文件");
		}
		
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: 方法2:返回操作系统的临时目录
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
	 * @Description: 方法3:返回操作系统的用户目录
	 * 例如Linux系统是在 /home/{用户账号名} ，Windows系统是在C:\User\{用户账号名}
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static File getUserDirectory() {
		String path = System.getProperty("user.home");
		return new File(path);
	}
	
	
}
