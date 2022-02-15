package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookVo;
import service.EventService;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public control() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("text/html; charset=EUC-KR");
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String type = request.getParameter("type");
		String resultView = "book/";
		EventService service = new EventService();
		if (type.equals("insert")) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String price = request.getParameter("content");
			BookVo vo = new BookVo(0, title, author, publisher, price);
			service.insert(vo);
			resultView = resultView + "index.jsp";
		} else if (type.equals("list")) {
			ArrayList<BookVo> data = service.list();
			request.setAttribute("data", data);
			resultView = resultView + "list.jsp";
		} else {
			int num;
			if (type.equals("update")) {
				num = Integer.parseInt(request.getParameter("pno"));
				BookVo m = service.getMember(num);
				request.setAttribute("m", m);
				resultView = resultView + "update.jsp";
			} else if (type.equals("delete")) {
				num = Integer.parseInt(request.getParameter("pno"));
				service.delete(num);
				resultView = "control?type=list";
			}
		}

		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
	}
}
