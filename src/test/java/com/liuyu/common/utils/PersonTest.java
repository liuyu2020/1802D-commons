package com.liuyu.common.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test1() {
		for (int i = 0; i < 10000; i++) {
			Person p = new Person();
		
		//1.姓名属性值调用StringUtil.generateChineseName()创建
		p.setName(StringUtil.generateChineseName());
		//2.年龄属性值调用RandomUtil.random()创建，必须在1-120岁之间
		p.setAge(RandomUtil.random(1, 120));
		//3.介绍属性值调用StringUtil.randomChineseString()创建，
		//字数为140个随机汉
		p.setAbout(StringUtil.randomChineseString(140));
		//4.注册日期属性值模拟2010年1月1日至今任意随机时间
		Calendar c = Calendar.getInstance();//日历类
		c.set(2010, 0, 1);
		p.setCreated(DateUtil.randomData(c.getTime(), new Date()));
        
		System.out.println(p);
		}
	}
}
