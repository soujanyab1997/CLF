package com.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.dao.LibraryDao;
import com.capg.model.Book;
import com.capg.model.Library;


/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/searchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    LibraryDao dao = new LibraryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Library l = dao.findBook(request.getParameter("sid"));
		
		if(l!=null)
		{
			out.println("Library Id:"+l.getLibraryId());out.print("<br>");
			out.println("Library Name:"+l.getLibraryName());
			
		}

		Book b = dao.findBookID(request.getParameter("sbid"));
		
		  out.print("<br>");
		  if(b!=null) { out.println("Book Id : "+b.getBookId());out.print("<br>");
		  out.println("Book Name : "+b.getBookName());out.print("<br>");
		  out.println("Author of Book : "+b.getAuthor());out.print("<br>");
		  out.println("Publisher of Book : "+b.getPublisher()); }else {
		  out.println("Enter the correct BookId"); }
		  
		 
		
	
}
}