package br.ce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ce.facade.UsuarioFacade;
import br.ce.model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
			
		try{
		    UsuarioFacade facade = new UsuarioFacade();
			
			Usuario usuario = facade.autenticar(login, senha);
			request.getSession().setAttribute("login", usuario.getLogin());			
			request.getSession().setAttribute("nome", usuario.getNome());
			
					
			if(usuario != null){			   
				request.getRequestDispatcher("listaDeLivros.jsp").forward(request, response);				
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);				
			}			
			
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
     }
	
}
