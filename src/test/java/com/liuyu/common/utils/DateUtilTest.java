package com.liuyu.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testRandomDate() {
		//��ȡ������
		Calendar c = Calendar.getInstance();
		c.set(2010, 0, 1);//Ϊ��������ֵ
		Date data = DateUtil.randomData(c.getTime(), new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(data));
	}
	
	//�³�
	@Test
	public void testGetInitMonth() {
		Date date = DateUtil.getInitMonth(new Date(22222222222222l));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	//��ĩ
	@Test
	public void testGetEndMonth() {
		Date date = DateUtil.getEndMonth(new Date(22222));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}
	//���ݳ�������������
	@Test
	public void testGetAgeByBirthday() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birthday = df.parse("2010-09-28");
			int age = DateUtil.getAgeByBirthday(birthday);
			System.out.println("�ҵ�����Ϊ��"+age);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
