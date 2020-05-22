package com.liuyu.common.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class AssertUtil {

	// ����1������Ϊ�棬���Ϊ�٣����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void isTrue(boolean condition, String message) {
		if (!condition)
			throw new AssertException(message);
	}

	// ����2������Ϊ�٣����Ϊ�棬���׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void isFalse(boolean condition, String message) {
		if (condition)
			throw new AssertException(message);

	}

	// ����3�����Զ���Ϊ�գ����Ϊ�գ����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void notNull(Object obj, String message) {
		if (null == obj)
			throw new AssertException(message);

	}

	// ����4�����Զ������գ������Ϊ�գ����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void isNull(Object obj, String message) {
		if (null != obj)
			throw new AssertException(message);
	}

	// ����5�����Լ��ϲ�Ϊ�գ������ܿգ��Լ��������1��Ԫ�ء����Ϊ�գ����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void notEmpty(Collection<?> coll, String message) {
		if (null == coll || coll.isEmpty())
			throw new AssertException(message);

	}

	// ����6������Map���ϲ�Ϊ�գ������ܿգ��Լ��������1��Ԫ�ء����Ϊ�գ����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void notEmpty(Map<?, ?> map, String message) {
		if (null == map || map.isEmpty())
			throw new AssertException(message);
	}

	// ����7�������ַ���������ֵ��ȥ���ո�Ȼ���ж��ַ��������Ƿ����0�����ûֵ�����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void hasText(String condition, String message) {
		if (!StringUtil.hasText(condition))
			throw new AssertException(message);

	}

	// ����8������ֵ�������0�����С�ڻ����0�����׳��Զ����쳣���쳣��ϢΪ��2������Ĭ����Ϣ�� (5��)
	public static void greaterThanZero(BigDecimal value, String message) {
		if (value.compareTo(BigDecimal.ZERO) <= 0)
			throw new AssertException(message);

	}

}
