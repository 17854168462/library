package com.myservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DB;
import com.model.User;

public class QueryUserServlet extends HttpServlet {
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		String type = request.getParameter("type");
		//������װ��ѯ���
		List<User> rs = new ArrayList();
		//�жϲ�ѯ���ͣ�������
		if("1".equals(type)){
			//����userlist
			for(User u : DB.userlist){
				//����username�Ƿ����query
				if(u.getUsername().indexOf(query)!=-1){
					//��user���������rs
					rs.add(u);
				}
			}
		}else{
			//���������ѯ
			//����userlist
			for(User u : DB.userlist){
				//����age�Ƿ����query
				if(u.getAge()==Integer.parseInt(query)){
					//��user���������rs
					rs.add(u);
				}
			}
		}
		
		request.getSession().setAttribute("rs", rs);
		response.sendRedirect("rs.jsp");
		
		
		
		
		
		
		
		
	}

}
