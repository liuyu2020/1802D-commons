package com.liuyu.common.utils;


import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void testGetPlaceholderValue() {
		String value = StringUtil.getPlaceholderValue("http://news.cnstock.com/news,yw-201908-4413224.htm", "[0-9]+(?=[^0-9]*$)");
		System.out.println(value);
	}
	@Test
	public void testgetValue() {
		String value = StringUtil.getValue("123456", 5);
		System.out.println(value);
	}
	@Test
	public void testNumber() {
		boolean b = StringUtil.isNumber("0");
		System.out.println(b);
	}
	@Test
	public void testEmail() {
		boolean b = StringUtil.isEMail("2802581460@qq.com");
		System.out.println(b);
	}
	@Test
	public void testPhone() {
		boolean b = StringUtil.isPhone("13345677835");
		System.out.println(b);
	}

	@Test
	public void testHasLength() {
		String src=" ";
		boolean b = StringUtil.hasLength(src);
		System.out.println(b);
	}

	@Test
	public void testHasText() {
		String src=" ";
		boolean b = StringUtil.hasText(src);
		System.out.println(b);
	}

	@Test
	public void testRandomChineseString() {
		String string = StringUtil.randomChineseString(3);
		System.out.println(string);
	}

	@Test
	public void testGenerateChineseName() {
		String name = StringUtil.generateChineseName();
		System.out.println(name);
	}

}
