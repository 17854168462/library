package com.db;

import java.util.ArrayList;
import java.util.List;

import com.model.User;

/*
 * ģ�����ݿ�洢����
 */
public class DB {
	//ͨ����̬userlsitģ��user��
	public static List<User> userlist = new ArrayList();
	//ͨ����̬��ʼ���飬��userlist���г�ʼ��
	static{
		userlist.add(new User(1001,"scott1",35,"��"));
		userlist.add(new User(1002,"scott2",36,"��"));
		userlist.add(new User(1003,"scott3",37,"��"));
		userlist.add(new User(1004,"scott4",38,"��"));
		userlist.add(new User(1005,"scott5",39,"��"));
		userlist.add(new User(1006,"scott6",33,"��"));
	}
	
	
	
	
	
	
}
