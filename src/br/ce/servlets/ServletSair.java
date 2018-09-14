package br.ce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


import br.ce.facade.UsuarioFacade;
import br.ce.model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/sair")
public class ServletSair extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		
		try{
						
			request.getSession().setAttribute("login", null);			
			request.getSession().setAttribute("nome", null);	
			
			request.getRequestDispatcher("telaLogin.jsp").forward(request, response);
			
		}catch(Exception e) {
			request.setAttribute("erro", e.getMessage());			
		}				
		
     }
	
}
