package com.liuyu.common.utils;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		 //返回1-120之间的随机数   1<=i<=120
	      int i = RandomUtil.random(1, 120);
	      System.out.println(i);
	}

	@Test
	public void testSubRandom() {
		//1-10之间的三个不同数字
		int[] is = RandomUtil.subRandom(1, 10, 3);
		for (int i : is) {
			System.out.println(i);
		}
	}

	@Test
	public void testRandomCharacter() {
		char c = RandomUtil.randomCharacter();
		System.out.println(c);
	}

	@Test
	public void testRandomString() {
		String string = RandomUtil.randomString(4);
		System.out.println(string);
	}

}
