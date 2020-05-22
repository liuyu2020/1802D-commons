package com.liuyu.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: �����������
 * @author: ����
 * @date: 2020��2��27�� ����8:31:14
 */
public class RandomUtil {

	    //����1������min-max֮����������������min��maxֵ�������緵��1-3֮������������ô����1��2��3������ȷ�ģ�����4�Ͳ��ԡ� (5��)
		public static int random(int min, int max){
	        Random random = new Random();
	        int i = random.nextInt(max - min + 1)+min; //nextInt(3) ���ص�������� 0 or 1 or 2 
			return i;
		}
		//����2������Сֵmin�����ֵmax֮���ȡsubs�����ظ����������������1-10֮��ȡ3�����ظ������������ô[2,6,9]�ǶԵģ�[3,5,5]�򲻶ԣ���Ϊ5�ظ��ˡ�Ӧ�ó�������100ƪ���������ȡ10ƪ���£��¿����ܻ�ʹ�õ��� (8��)
		public static int[] subRandom (int min, int max, int subs){
			//�������飬������ŷ��ص�min-max֮�䡤�ġ������
			int[] x =new int [subs];
			//���������ظ�������
			HashSet<Integer> set = new HashSet<Integer>();
			
			while(set.size()!=subs) {
				int i = random(min, max);
			    set.add(i);
			}
			//����set ��ֵ��������
		    int k = 0;
		    for (Integer integer : set) {
				x[k] = integer;
				k++;
			}
			return x;
		}
		//����3������1��1-9,a-Z֮�������ַ��� (8��)
		public static char randomCharacter (){
            String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
            
			return str.charAt(random(0, str.length()-1));
		}
		//����4�����ز���length���ַ���(5��)�������ڲ�Ҫ����randomCharacter()���� (4��)
		public static String randomString(int length){
			String str ="";
			for (int i = 0; i < length; i++) {
				char c = randomCharacter();
				str += c;
			}
			return str;
		}
		
		
		//����һ��0-9֮�������
		public static int random() {
			int[] str = {1,2,3,4,5,6,7,8,9,0};
			return str[random(0, 9)];
		}
		
		//����5������ָ�����ȵ��������
		public static String random(int length) {
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < length; i++) {
				str.append(random());
			}
			return str.toString();
		}
}
