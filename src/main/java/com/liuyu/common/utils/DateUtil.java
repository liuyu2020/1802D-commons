package com.liuyu.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @author: 刘宇
 * @date: 2020年2月29日 下午11:08:19
 */
public class DateUtil {

	/**
	 * 功能：获取人性化时间，例如5分钟之内则显示“刚刚”，其它显示16分钟前、2小时前、3天前、4月前、5年前等
	 *
	 * @param Date date 源时间。
	 * @return 人性化时间
	 */
	public static String getDisplayTime(Date date) {
		Date now = new Date();
		long t1 = now.getTime();
		long t2 = date.getTime();
		long t = (t1 - t2) / 1000 / 60;
		if ((t / 60 / 24 / 30 / 12) >= 1) {
			return (t / 60 / 24 / 30 / 12) + "年前";
		} else {
			if ((t / 60 / 24 / 30) >= 1) {
				return (t / 60 / 24 / 30) + "月前";
			} else {
				if ((t / 60 / 24) >=1) {
					return (t / 60 / 24) + "天前";
				} else {
					if ((t / 60) >=1) {
						return (t / 60) + "小时前";
					} else {
						if (t >= 1) {
							return t + "分钟前";
						} else {
							return "刚刚";
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @Title: SubDate
	 * @Description: 返回指定小时之前的时间
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
	 * @Description: 根据出生日期算年龄
	 * @param date
	 * @return
	 * @return: int
	 */
	public static int getAgeByBirthday(Date birthday) {// 出生日期date

		Calendar c = Calendar.getInstance();
		c.setTime(birthday);
		int bn = c.get(Calendar.YEAR); // 出生年份
		int by = c.get(Calendar.MONTH); // 出生月份
		int br = c.get(Calendar.DAY_OF_MONTH); // 出生日期

		Date date = new Date();
		c.setTime(date);
		int nn = c.get(Calendar.YEAR); // 当前年份
		int ny = c.get(Calendar.MONTH); // 当前月份
		int nr = c.get(Calendar.DAY_OF_MONTH); // 当前日期
		int age = nn - bn; // 计算整岁数
		if (ny <= by) {
			if (ny == by) {
				if (nr < br) {
					age--;// 当前日期在生日之前，年龄减一
				} else {
					age--;// 当前月份在生日之前，年龄减一
				}
			}
		}
		return age;
	}

	/**
	 * 
	 * @Title: getEndMonth
	 * @Description: 返回指定日期的月末，比如 2011-02-14 返回到 2011-02-29
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		// 获取日历类
		Calendar c = Calendar.getInstance();
		// 用传入的日期初始化日历类
		c.setTime(date);
		// 整体让月份+1，再变成月初-1
		c.add(Calendar.MONTH, 1);// 让月份+1
		Date initMonth = getInitMonth(c.getTime());
		c.setTime(initMonth);// 再变回月初
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getInitMonth
	 * @Description: 返回指定日期的月初；比如 2020-02-28 返回 2020-02-01
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date) {
		// 获取一个日历类
		Calendar c = Calendar.getInstance();// 获取当前系统时间的日历类
		// 用传入的日期再初始化日历类
		c.setTime(date);
		// 调用日历类的相关方法
		c.set(Calendar.DAY_OF_MONTH, 1);// 让日期为当月的第一天
		c.set(Calendar.HOUR_OF_DAY, 0); // 让日期为当天的0时
		c.set(Calendar.MINUTE, 0); // 让日期为0时的0分
		c.set(Calendar.SECOND, 0); // 让日期为0时的0分的0秒
		return c.getTime();
	}

	/**
	 * 
	 * @Title: randomData
	 * @Description: TODO
	 * @param min 最小日期
	 * @param max 最大日期
	 * @return 返回在min 和 max之间的随机日期
	 * @return: Date
	 */
	public static Date randomData(Date min, Date max) {
		long t1 = max.getTime();
		long t2 = min.getTime();
		if (t2 > t1) {
			return null;
		}
		double d = Math.random(); // 获取0-1之间的随机数
		long x = (long) (d * (t1 - t2 + 1) + t2);
		return new Date(x);
	}
}
