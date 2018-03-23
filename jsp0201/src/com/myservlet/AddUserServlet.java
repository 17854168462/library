package com.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DB;
import com.model.User;

public class AddUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ���ύ������
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));
		String sex = req.getParameter("sex");
		//��װUser����
		User user = new User();
		user.setUsername(username);
		user.setAge(age);
		if("1".equals(sex)){
			user.setSex("��");
		}else{
			user.setSex("Ů");
		}
		//��userlist�л�ȡ���һ��user��id
		//  list��get������ȡָ�������Ķ���DB.userlist.size()��ȡlist�й��м�������
		//��ȡ���һ��user����DB.userlist.get(DB.userlist.size()-1)
		User lastUser = (User)DB.userlist.get(DB.userlist.size()-1);
		int lastId = lastUser.getUserid();
		//��������user�����id
		int userid = lastId+1;
		user.setUserid(userid);
		//��user��ӵ�userlist
		DB.userlist.add(user);
		
		resp.sendRedirect("index.jsp");
		
		
		
		
		
		
		
		
		
	}

}
