package com.liuyu.common.utils;

import org.junit.Test;

public class StringUtilTest2 {

	@Test
	public void testIsHttpUrl() {
		
		boolean b = StringUtil.isHttpUrl("dsada");
		System.out.println(b);
	}

}
