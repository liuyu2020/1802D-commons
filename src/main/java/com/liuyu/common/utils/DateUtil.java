package com.liuyu.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description: ���ڹ�����
 * @author: ����
 * @date: 2020��2��29�� ����11:08:19
 */
public class DateUtil {

	/**
	 * ���ܣ���ȡ���Ի�ʱ�䣬����5����֮������ʾ���ոա���������ʾ16����ǰ��2Сʱǰ��3��ǰ��4��ǰ��5��ǰ��
	 *
	 * @param Date date Դʱ�䡣
	 * @return ���Ի�ʱ��
	 */
	public static String getDisplayTime(Date date) {
		Date now = new Date();
		long t1 = now.getTime();
		long t2 = date.getTime();
		long t = (t1 - t2) / 1000 / 60;
		if ((t / 60 / 24 / 30 / 12) >= 1) {
			return (t / 60 / 24 / 30 / 12) + "��ǰ";
		} else {
			if ((t / 60 / 24 / 30) >= 1) {
				return (t / 60 / 24 / 30) + "��ǰ";
			} else {
				if ((t / 60 / 24) >=1) {
					return (t / 60 / 24) + "��ǰ";
				} else {
					if ((t / 60) >=1) {
						return (t / 60) + "Сʱǰ";
					} else {
						if (t >= 1) {
							return t + "����ǰ";
						} else {
							return "�ո�";
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @Title: SubDate
	 * @Description: ����ָ��Сʱ֮ǰ��ʱ��
	 * @param date
	 * @param hours
	 * @return
	 * @return: Date
	 */
	public static Date SubDate(Date date, int hours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, -hours);
		return cal.getTime();
	}

	/**
	 * 
	 * @Title: getAgeByBirthday
	 * @Description: ���ݳ�������������
	 * @param date
	 * @return
	 * @return: int
	 */
	public static int getAgeByBirthday(Date birthday) {// ��������date

		Calendar c = Calendar.getInstance();
		c.setTime(birthday);
		int bn = c.get(Calendar.YEAR); // �������
		int by = c.get(Calendar.MONTH); // �����·�
		int br = c.get(Calendar.DAY_OF_MONTH); // ��������

		Date date = new Date();
		c.setTime(date);
		int nn = c.get(Calendar.YEAR); // ��ǰ���
		int ny = c.get(Calendar.MONTH); // ��ǰ�·�
		int nr = c.get(Calendar.DAY_OF_MONTH); // ��ǰ����
		int age = nn - bn; // ����������
		if (ny <= by) {
			if (ny == by) {
				if (nr < br) {
					age--;// ��ǰ����������֮ǰ�������һ
				} else {
					age--;// ��ǰ�·�������֮ǰ�������һ
				}
			}
		}
		return age;
	}

	/**
	 * 
	 * @Title: getEndMonth
	 * @Description: ����ָ�����ڵ���ĩ������ 2011-02-14 ���ص� 2011-02-29
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		// ��ȡ������
		Calendar c = Calendar.getInstance();
		// �ô�������ڳ�ʼ��������
		c.setTime(date);
		// �������·�+1���ٱ���³�-1
		c.add(Calendar.MONTH, 1);// ���·�+1
		Date initMonth = getInitMonth(c.getTime());
		c.setTime(initMonth);// �ٱ���³�
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getInitMonth
	 * @Description: ����ָ�����ڵ��³������� 2020-02-28 ���� 2020-02-01
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date) {
		// ��ȡһ��������
		Calendar c = Calendar.getInstance();// ��ȡ��ǰϵͳʱ���������
		// �ô���������ٳ�ʼ��������
		c.setTime(date);
		// �������������ط���
		c.set(Calendar.DAY_OF_MONTH, 1);// ������Ϊ���µĵ�һ��
		c.set(Calendar.HOUR_OF_DAY, 0); // ������Ϊ�����0ʱ
		c.set(Calendar.MINUTE, 0); // ������Ϊ0ʱ��0��
		c.set(Calendar.SECOND, 0); // ������Ϊ0ʱ��0�ֵ�0��
		return c.getTime();
	}

	/**
	 * 
	 * @Title: randomData
	 * @Description: TODO
	 * @param min ��С����
	 * @param max �������
	 * @return ������min �� max֮����������
	 * @return: Date
	 */
	public static Date randomData(Date min, Date max) {
		long t1 = max.getTime();
		long t2 = min.getTime();
		if (t2 > t1) {
			return null;
		}
		double d = Math.random(); // ��ȡ0-1֮��������
		long x = (long) (d * (t1 - t2 + 1) + t2);
		return new Date(x);
	}
}
