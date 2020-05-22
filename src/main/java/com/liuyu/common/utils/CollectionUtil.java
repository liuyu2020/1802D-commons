package com.liuyu.common.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @ClassName: CollectionUtil 
 * @Description: 集合的处理类
 * @author: 刘宇
 * @date: 2020年3月26日 上午10:47:08
 */
public class CollectionUtil {

	
	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: TODO//判断集合中是否有内容
	 * @param collection
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmpty(Collection<?> collection) {
		
		
		
		return collection==null || collection.isEmpty();
		
	}
}
