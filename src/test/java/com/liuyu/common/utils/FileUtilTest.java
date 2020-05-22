package com.liuyu.common.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileUtilTest {

	@Test
	public void testGetExtendName() {
		String string = FileUtil.getExtendName("sd.aa.jsp");
		System.out.println(string);
	}

	@Test
	public void testGetTempDirectory() {
		File file = FileUtil.getTempDirectory();
		System.out.println(file);
	}

	@Test
	public void testGetUserDirectory() {
		File userDirectory = FileUtil.getUserDirectory();
		System.out.println(userDirectory);
	}

}
