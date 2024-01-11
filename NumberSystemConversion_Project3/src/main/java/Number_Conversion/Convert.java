package Number_Conversion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Disadvantage - Both the values should be entered
public class Convert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s1 = req.getParameter("nm");
		int n = Integer.parseInt(s1);
		
		String s = req.getParameter("txt");
		
		PrintWriter out = resp.getWriter();
		//Decimal to Binary
		if(req.getParameter("dtb") != null)
		{
			String dec = "";
			while(n!=0)
			{
				int r = n%2;
				dec =  r + dec;
				n = n/2;
			}
			out.print("<html><body><h1> The Binary Conversion is - "+dec+"</html></body></h1>");
		}
		//Decimal to HexaDecimal
		else if(req.getParameter("dth") != null)
		{
			char a [] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			String dec = "";
			while (n!=0)
			{
				int r = n%16;
				dec = a[r] + dec ;
				n = n/16;
			}
			out.print("<html><body><h1> The Hexadecimal Conversion is - "+dec+"</html></body></h1>");
		}
		//Decimal to Octal
		else if(req.getParameter("dto") != null)
		{
			String dec = "";
			while(n!=0)
			{
				int r = n %8;
				dec = r + dec;
				n = n/8;
			}
			out.print("<html><body><h1> The Octal Conversion is - "+dec+"</html></body></h1>");
		}
		//Binary to Decimal
		else if(req.getParameter("btd") != null)
		{
			int sum = 0;
			int k = 0;

			while(n!=0)
			{
				int d = n%10;
				sum = sum + power(2,k++)*d;
				n = n/10;
			}
			out.print("<html><body><h1> The Decimal Conversion is - "+sum+"</html></body></h1>");

		}
		//Binary to HexaDecimal
		else if(req.getParameter("bth") != null)
		{
			int dec = BTD(n);
			String hex = DTH(dec);
			out.print("<html><body><h1> The HexaDecimal Conversion is - "+hex+"</html></body></h1>");

		}
		//Binary to Octal
		else if(req.getParameter("bto") != null)
		{
			int d = BTD(n);
			String oct = DTO(d);
			out.print("<html><body><h1> The Octal Conversion is - "+oct+"</html></body></h1>");
		}
		//Octal to Binary
		else if(req.getParameter("otb") != null)
		{
			int d = OTD(n);
			String bin = DTB(d);
			out.print("<html><body><h1> The Binary Conversion is - "+bin+"</html></body></h1>");
		}
		//Octal to Decimal
		else if(req.getParameter("otd") != null)
		{
			int sum = 0;
			String dec = "";
			int k = 0;
			while(n!=0)
			{
				int d = n % 10;
				sum = sum + d*power(8,k++);
				n = n /10;
			}
			out.print("<html><body><h1> The Decimal Conversion is - "+sum+"</html></body></h1>");
		}
		//Octal to HexaDecimal
		else if(req.getParameter("oth") != null)
		{
			int d = OTD(n);
			String hex = DTH(d);
			out.print("<html><body><h1> The HexaDecimal Conversion is - "+hex+"</html></body></h1>");
		}
		//HexaDecimal to Binary
		else if(req.getParameter("htb") != null)
		{
			int dec = HTD(s);
			System.out.println(dec);
			String bin = DTB(dec);
			out.print("<html><body><h1> The Binary Conversion is - "+bin+"</html></body></h1>");
		}
		//HexaDecimal to Decimal
		else if(req.getParameter("htd") != null)
		{
			int dec = 0;
			int k = 0;
			for(int i = s.length()-1;i>=0;i--)
			{
				if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
				{
					dec = dec + (s.charAt(i)-48) * power(16,k++);				
				}	
				else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'F')					
				{
					dec = dec + (s.charAt(i)-55) * power(16,k++);
				}
			}
			out.print("<html><body><h1> The Decimal Conversion is - "+dec+"</html></body></h1>");
		}
		//HexaDecimal to Octal
		else if(req.getParameter("hto") != null)
		{
			int dec = HTD(s);
			String oct = DTO(dec);
			out.print("<html><body><h1> The Decimal Conversion is - "+oct+"</html></body></h1>");
		}
		}
	
		public static int HTD(String s)
		{

			int dec = 0;
			int k = 0;
			for(int i = s.length()-1;i>=0;i--) 
			{
				if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
				{
					dec = dec + (s.charAt(i) - 48)*power(16,k++);
				}
				else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'F')
				{
					dec = dec + (s.charAt(i) - 55)*power(16,k++);
				}

			}
			return dec;
		}
		public static int OTD(int n)
		{
		
			int sum = 0;
			String dec = "";
			int k = 0;
			while(n!=0)
			{
				int d = n % 10;
				sum = sum + d*power(8,k++);
				n = n /10;
			}
			return sum;
		}
		public static String DTB(int n)
		{
			String dec = " ";
			while(n!=0)
			{
				int r = n%2;
				dec =  r + dec;
				n = n/2;
			}
			return dec;
		}
		public static String DTO(int n)
		{
			String dec = "";
			int res = 1;
			while(n!=0)
			{
				int d = n%8;
				dec = d + dec;
				n = n/8;	
			}
			return dec;
		}
		public static String DTH(int n)
		{
			String dec = "";
			char a [] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			while(n!=0)
			{
				int d = n%16;
				dec = a[d] + dec;
				n = n/16;
			}
			return dec;
		}
		public static int BTD(int n)
		{
			int k = 0;
			int sum = 0;
			while(n!=0)
			{
				int d = n%10;
				sum = sum + d*power(2,k++);
				n = n/10;
			}
			return sum;
		}
	
		public static int power(int n,int p)
		{
			int pro = 1;
			for(int i = 1;i<=p;i++)
			{
				pro = pro * n;
			}
			return pro;
		}
		
	}
	

