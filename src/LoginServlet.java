import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取login.jsp中用户输入的email,password
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        //调用dao 调用daozhongde 函数
        UserDao dao=new UserDao();
        User user=dao.CheckPassword(email, password);


        if(user==null){
            response.sendRedirect("login.jsp");
        }else{
            request.getSession().setAttribute("user", user);
            response.sendRedirect("list");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
