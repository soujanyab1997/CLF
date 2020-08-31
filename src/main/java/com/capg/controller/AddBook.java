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


@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    LibraryDao dao=new LibraryDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String libraryId=request.getParameter("libid");
    	String libraryName=request.getParameter("libname");
    	String bookId=request.getParameter("bookid");
		String bookName=request.getParameter("bookname");
		String author=request.getParameter("bookauthor");
		String publisher=request.getParameter("bookpub");
		
		String bookId2=request.getParameter("bookid2");
		String bookName2=request.getParameter("bookname2");
		String author2=request.getParameter("bookauthor2");
		String publisher2=request.getParameter("bookpub2");
				
		
		
		
		PrintWriter out=response.getWriter();
		out.println(libraryId);
		out.println(libraryName);
		out.println(bookId);
		out.println(bookName);
		out.println(author);
		out.println(publisher);
		
		out.println(bookId2);
		out.println(bookName2);
		out.println(author2);
		out.println(publisher2);
		
		
		Library library=new Library();
	
		library.setLibraryId(libraryId);
		library.setLibraryName(libraryName);
		
		
		Book books=new Book();
		books.setBookId(bookId);
		books.setBookName(bookName);
		books.setAuthor(author);
		books.setPublisher(publisher);
		books.setLibrary(library);
		library.getBook().add(books);
		
		
		Book books2=new Book();
		books2.setBookId(bookId2);
		books2.setBookName(bookName2);
		books2.setAuthor(author2);
		books2.setPublisher(publisher2);
		books2.setLibrary(library);
		library.getBook().add(books2);
		
		
		dao.add(library);

	}

}
