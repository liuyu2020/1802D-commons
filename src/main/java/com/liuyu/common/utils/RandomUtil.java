package com.liuyu.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: 随机数工具类
 * @author: 刘宇
 * @date: 2020年2月27日 下午8:31:14
 */
public class RandomUtil {

	    //方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
		public static int random(int min, int max){
	        Random random = new Random();
	        int i = random.nextInt(max - min + 1)+min; //nextInt(3) 返回的随机数是 0 or 1 or 2 
			return i;
		}
		//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
		public static int[] subRandom (int min, int max, int subs){
			//声明数组，用来存放返回的min-max之间·的·随机数
			int[] x =new int [subs];
			//用来过滤重复的数据
			HashSet<Integer> set = new HashSet<Integer>();
			
			while(set.size()!=subs) {
				int i = random(min, max);
			    set.add(i);
			}
			//遍历set 把值放入数组
		    int k = 0;
		    for (Integer integer : set) {
				x[k] = integer;
				k++;
			}
			return x;
		}
		//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
		public static char randomCharacter (){
            String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
            
			return str.charAt(random(0, str.length()-1));
		}
		//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
		public static String randomString(int length){
			String str ="";
			for (int i = 0; i < length; i++) {
				char c = randomCharacter();
				str += c;
			}
			return str;
		}
		
		
		//返回一个0-9之间的数据
		public static int random() {
			int[] str = {1,2,3,4,5,6,7,8,9,0};
			return str[random(0, 9)];
		}
		
		//方法5：返回指定长度的随机数字
		public static String random(int length) {
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < length; i++) {
				str.append(random());
			}
			return str.toString();
		}
}
