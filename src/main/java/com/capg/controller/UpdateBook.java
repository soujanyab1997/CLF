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


/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    LibraryDao dao = new LibraryDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		String nbId = request.getParameter("buid");
		String nBName = request.getParameter("buname");
		String nBauthr = request.getParameter("uauthor");
		String nBpubshr = request.getParameter("upub");
		
		Book book = dao.findBookID(nbId);

		Book upbook = dao.updateBookDetails(nbId,nBName,nBauthr,nBpubshr);
		 	
	  	out.println("After Updating");out.print("<br>");
		out.println("Book Name : " +upbook.getBookName());out.print("<br>");
		out.println("Book Author : "+upbook.getAuthor());out.print("<br>");
		out.println("Book Publisher Name : "+upbook.getPublisher());out.print("<br>");

		
	}

}
