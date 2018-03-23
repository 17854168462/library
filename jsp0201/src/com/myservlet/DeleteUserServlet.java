package com.myservlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DB;
import com.model.User;

public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�����Ӵ��ݵ�userid��ת��Ϊint
		int userid = Integer.parseInt(req.getParameter("userid"));
		
		//��userlist��ɾ����Ӧuserid�Ķ���
		/*for(User u : DB.userlist){
			if(u.getUserid()==userid){
				
				 * remove����������
				 * ����Ϊintֵremove(1)����list����ɾ������
				 * ����ΪObject��remove(u)��������뼯���еĶ�����ͬһ����ɾ��
				 * ����ж��Ƿ�ͬһ������
				 * 1������hashcode�ж�
				 * 2����дequals����
				 
				DB.userlist.remove(u);
			}
		}*/
		//��ȡ������
		Iterator<User> it = DB.userlist.iterator();
		//it.hasNext�ж��Ƿ�����һ��Ԫ��
		while(it.hasNext()){
			//it.nextȡ��Ԫ��
			User u = it.next();
			if(u.getUserid()==userid){
				//it.remove����ǰ���ڵ����Ķ���ɾ��
				it.remove();
				break;//����while
			}
		}
		
		resp.sendRedirect("index.jsp");
		
		
		
		
	}

}
