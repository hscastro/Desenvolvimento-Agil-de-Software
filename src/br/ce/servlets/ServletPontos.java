package br.ce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ce.facade.LivroFacade;
import br.ce.facade.RanckingFacade;
import br.ce.model.Livro;
import br.ce.model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/pontos")
public class ServletPontos extends HttpServlet {	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id_livro_ = request.getParameter("id_livro");		
		String paginas = request.getParameter("qtd_paginas");		
		String checkbox = request.getParameter("checkbox");			
		String login = request.getParameter("login");
		boolean testador = false;	
		
		
		if(checkbox == null || checkbox == ""){				
		   request.getRequestDispatcher("falha.jsp").forward(request, response);
		   
		}else{			
			  
			  int id_livro = Integer.parseInt(id_livro_);
			  int status = Integer.parseInt(checkbox);	
			  int qtd_paginas = Integer.parseInt(paginas);
			  	  
			  Usuario user = new Usuario();
			  user.setLogin(login);
				
			  Livro livro = new Livro();
			  livro.setId(id_livro);
			  livro.setQtdDePaginas(qtd_paginas);
			   
			  RanckingFacade ranckingFacade = new RanckingFacade();
			  testador = ranckingFacade.adicionarPontos(user, livro);
			  LivroFacade facade = new LivroFacade();	
			   	
		   
			  if(testador){				  
				 request.getRequestDispatcher("sucesso.jsp").forward(request, response);
			  }else{
				 request.getRequestDispatcher("falha.jsp").forward(request, response); 
			  }
										
		}
		

     }
}
