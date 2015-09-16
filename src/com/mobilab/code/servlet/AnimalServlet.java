package com.mobilab.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilab.code.Dog;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/AnimalServlet")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Dog> animals;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalServlet() {
        super();
        animals = new ArrayList<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("here goes an animal");
		System.out.println( "DO GET" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int age = Integer.parseInt( request.getParameter("age") );
		String breed = request.getParameter("breed");
		if( age>=0 ){
			animals.add( new Dog(breed, age) );
			Collections.sort(animals, new Dog());
		} else if( age<0 ){
			request.setAttribute("error", "negative numbers are not allowed");
		}
		request.setAttribute( "animalsList" , animals);
		
		System.out.println( animals );
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showanimals.jsp");
		dispatcher.forward(request,response);
	}

}
