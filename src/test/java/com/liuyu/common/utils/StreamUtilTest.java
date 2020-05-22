package com.liuyu.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testRead() throws Exception {
		List<String> list = StreamUtil.read(new File("d:\\data.txt"));
		for (String string : list) {
			System.out.println(string);
		}
	}

}
