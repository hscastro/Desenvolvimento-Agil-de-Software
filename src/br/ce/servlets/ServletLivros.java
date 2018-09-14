package br.ce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ce.facade.LivroFacade;
import br.ce.facade.UsuarioFacade;
import br.ce.model.Livro;
import br.ce.model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/livro")
public class ServletLivros extends HttpServlet {	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		/*String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String autor = request.getParameter("autor");
		String qtdPaginas = request.getParameter("quant_paginas");			
		String status = request.getParameter("estado");		
		String login = request.getParameter("login");
		String pontos = request.getParameter("pontos");	 
		int total = 0;	
		
		LivroFacade facade = new LivroFacade();		
		Usuario user = new Usuario();		
				
		try{
			
			Livro livro = new Livro();			
			livro.setTitulo(titulo);
			livro.setGenero(genero);
			livro.setAutor(autor);			
			livro.setQtdDePaginas(Integer.parseInt(qtdPaginas));
			livro.setStatus(0);
			user.setLogin(login);	
			user.setPontos(Integer.parseInt(pontos));				
			total = facade.inserir(livro, user);
			//request.getSession().setAttribute("pontos", total);
			
		    //UsuarioFacade fadUsuario = new UsuarioFacade();
		    //fadUsuario.adicionarPontos(login, total);	
		    request.getRequestDispatcher("listaDeLivros.jsp").forward(request, response);
									
		}catch(Exception e) {
			request.setAttribute("erro", e.getMessage());	
			request.getRequestDispatcher("telaLogin.jsp").forward(request, response);
		}	*/		
		
			
     }	
}
