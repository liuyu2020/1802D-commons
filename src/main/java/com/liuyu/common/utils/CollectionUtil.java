package com.liuyu.common.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @ClassName: CollectionUtil 
 * @Description: ���ϵĴ�����
 * @author: ����
 * @date: 2020��3��26�� ����10:47:08
 */
public class CollectionUtil {

	
	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: TODO//�жϼ������Ƿ�������
	 * @param collection
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmpty(Collection<?> collection) {
		
		
		
		return collection==null || collection.isEmpty();
		
	}
}
