package Lets_Analyse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class Text_Analyser extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String nm1 = req.getParameter("nm1");
		int num1 = Integer.parseInt(nm1);
		
		
		String nm2 = req.getParameter("nm2");
		int num2 = Integer.parseInt(nm2);
		
		PrintWriter out = res.getWriter();

		if(req.getParameter("mul") != null) {
			int mul = num1 * num2;
			out.print("<html><body><h1>" +mul+"</h1></body></html>");
		}
		else if(req.getParameter("add") != null)
		{
			
			int add = num1 + num2;
			out.print("<html><body><h1>" +req.getParameter("add")+add+"</h1></body></html>");
		}
		else if(req.getParameter("sub") != null)
		{
			int sub = num1 - num2;
			out.print("<html><body><h1>" +sub+"</h1></body></html>");
		}
		else if(req.getParameter("mod") != null)
		{
			int mod = num1 % num2;
			out.print("<html><body><h1>" +mod+"</h1></body></html>");
		}
		else if(req.getParameter("div") != null)
		{
			int div = num1 / num2;
			out.print("<html><body><h1>" +div+"</h1></body></html>");
		}	
	}
}
