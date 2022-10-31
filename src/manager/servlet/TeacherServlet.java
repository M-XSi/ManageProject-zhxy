package manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.bean.Teachers;
import manager.dao.TeachersDao;
import manager.dao.impl.TeachersDaoImpl;

public class TeacherServlet extends HttpServlet {
	
	HttpSession session=null;
	/**
	 * Constructor of the object.
	 */
	public TeacherServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

      // System.out.println("get提交");
        doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String req=request.getParameter("req");
		if(req.equals("addTeacher")){
			addTeacher(request,response);
			
		}else if(req.equals("t_login")){
			t_login(request,response);
		}else if(req.equals("updateTeacher")){
			updateTeacher(request,response);
		}else if(req.equals("t_list")){
			t_list(request,response);
		}else if(req.equals("delTeacher")){
			delTeacher(request,response);
		}
				

	}
	public void addTeacher(HttpServletRequest request, HttpServletResponse response){
		TeachersDao td=new TeachersDaoImpl();
		String t_name=request.getParameter("t_name");
		String t_login=request.getParameter("t_login");
		String t_pwd=request.getParameter("t_pwd");
		String t_address=request.getParameter("t_address");
		String t_tel=request.getParameter("t_tel");
		String t_sex=request.getParameter("t_sex");
		String t_email=request.getParameter("t_email");
		System.out.println(t_name);
		Teachers t = new Teachers();
		t.setT_address(t_address);
		t.setT_email(t_email);
		t.setT_login(t_login);
		t.setT_name(t_name);
		t.setT_sex(t_sex);
		t.setT_pwd(t_pwd);
		t.setT_tel(t_tel);
		td.addTeacher(t);
	}
	//老师登录
	public void t_login(HttpServletRequest request, HttpServletResponse response){	
		String t_login=request.getParameter("t_login");
		String t_pwd=request.getParameter("t_pwd");
		TeachersDao td=new TeachersDaoImpl();
		Teachers t=new Teachers();
		t.setT_login(t_login);
		t.setT_pwd(t_pwd);
		Teachers t1=td.findTeacher(t);
		session=request.getSession();
		if(t1 == null){
			System.out.println("登录失败");
		}else{
			session.setAttribute("t_info", t1);
			try {
				request.getRequestDispatcher("t_info.jsp").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("登录成功");
		}
	}
	
    
	
	//修改老师个人信息
	public void updateTeacher(HttpServletRequest request, HttpServletResponse response){
		TeachersDao td=new TeachersDaoImpl();
		int t_id=Integer.parseInt(request.getParameter("t_id"));
		String t_name=request.getParameter("t_name");
		String t_login=request.getParameter("t_login");
		String t_pwd=request.getParameter("t_pwd");
		String t_address=request.getParameter("t_address");
		String t_tel=request.getParameter("t_tel");
		String t_sex=request.getParameter("t_sex");
		String t_email=request.getParameter("t_email");
		System.out.println(t_name);
		System.out.println(t_login);
		Teachers t = new Teachers();
		t.setT_id(t_id);
		t.setT_address(t_address);
		t.setT_email(t_email);
		t.setT_login(t_login);
		t.setT_name(t_name);
		t.setT_sex(t_sex);
		t.setT_pwd(t_pwd);
		t.setT_tel(t_tel);
		int i = td.updateTeachers(t);
		if(i==1){
			session=request.getSession();
			session.setAttribute("t_info",t);
		}
		
	}
	
	public void t_list(HttpServletRequest request, HttpServletResponse response){
		TeachersDao td=new TeachersDaoImpl();
		List<Teachers> tl=td.findTeachers();
		if(tl!=null){
			request.setAttribute("t_list",tl);
			try{
				request.getRequestDispatcher("t_list.jsp").forward(request,response);
			}catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void delTeacher(HttpServletRequest request, HttpServletResponse response){
		int t_id=Integer.parseInt(request.getParameter("t_id"));
		TeachersDao td=new TeachersDaoImpl();
		Teachers t=new Teachers();
		t.setT_id(t_id);
		int rst=td.delTeacher(t);
		t_list(request,response);
		
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
