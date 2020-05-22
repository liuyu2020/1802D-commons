package com.liuyu.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: StringUtil
 * @Description: �ַ���������
 * @author: ����
 * @date: 2020��2��27�� ����8:33:49
 */
public class StringUtil {

	/**
	 * У�鴫��Ĳ����Ƿ�Ϊurl
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isHttpUrl(String src) {
		try {
			URL url = new URL(src);
			url.openStream();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("���ǺϷ���url");
		return false;

	}

	/*
	 * �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ��
	 * �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	 * 
	 * regex = [0-9]+(?=[^0-9]*$)
	 */
	public static String getPlaceholderValue(String src, String regex) {

		Pattern p = Pattern.compile(regex);// �������
		Matcher matcher = p.matcher(src);// Pattern ƥ��src
		if (matcher.find()) {// ����ҵ�
			return matcher.group();// ����ƥ�䵽���ַ���
		}
		return null;
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:������������,Ҫ�󷵻ظ��ַ�����start���ȿ�ʼ,�Ժ���ַ���*����. ��:���� ��ά����ѧԺ ���������,���� ��ά****
	 * @param str
	 * @param start
	 * @return
	 * @return: String
	 */
	public static String getValue(String str, int start) {
		// ��ά����ѧԺ ���������,���� ��ά****

		String s1 = str.substring(2);
		String s2 = "";
		for (int i = 0; i < s1.length(); i++) {
			// str = str.replace(String.valueOf(str.charAt(i)),"*");
			s2 += "*";
		}
		return str.substring(0, 2) + s2;
	}

	// �ж�һ���ַ����Ƿ������� �������� ���� С��
	public static boolean isNumber(String src) {

		String reg = "^(-)?[0-9]+(\\.[0-9]+)?$";
		return src.matches(reg);
	}

	// �ж��Ƿ�����
	public static boolean isEMail(String src) {
		// ������� num2222@126.com
		String reg = "\\w+\\@\\w+\\.\\w+";
		return src.matches(reg);
	}

	// �ж��Ƿ������й����ֻ���
	public static boolean isPhone(String src) {
		// �������
		String reg = "^1[3|4|5|6|7|8]\\d{9}$";
		return src.matches(reg);
	}

	// ����1���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)Ҳ��ûֵ (5��)
	public static boolean hasLength(String src) {

		return null != src && src.length() > 0;
	}

	// ����2���ж�Դ�ַ���
	public static boolean hasText(String src) {

		return null != src && src.trim().length() > 0;
	}

	// �������һ�����ļ��庺��
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	// ����3�����ز���length�����ĺ����ַ�����
	// �ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomChineseString();
		}
		return str;
	}

	// ����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա��
	// ��ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
	public static String generateChineseName() {
		String[] str = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��", "ۺ",
				"��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��", "տ",
				"��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��", "��",
				"��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��", "÷",
				"ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��", "��",
				"¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "�", "��", "��", "�L", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��", "��",
				"��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "б", "��", "��", "��", "��",
				"��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ", "��",
				"��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��", "��",
				"̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "�S", "�", "ɣ", "��", "�", "ţ", "��", "ͨ", "��",
				"��", "��", "��", "ۣ", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "˧",
				"��", "��", "��", "��", "��", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��", "��", "��", "��", "١",
				"��ٹ", "˾��", "�Ϲ�", "ŷ��", "�ĺ�", "���", "����", "����", "����", "�ʸ�", "ξ��", "����", "�̨", "��ұ", "����", "���", "����",
				"����", "̫��", "����", "����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "آ��", "˾��",
				"��", "��", "�ӳ�", "���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����",
				"����", "����", "����", "��", "��", "����", "΢��", "����", "����", "����", "����", "�Ϲ�" };
		// ���� �����������ȡһ��
		String string = str[RandomUtil.random(0, str.length - 1)];
		// ���� 1-2���������
		String string2 = randomChineseString(RandomUtil.random(1, 2));
		// ƴ�� �������
		return string + string2;
	}
}
