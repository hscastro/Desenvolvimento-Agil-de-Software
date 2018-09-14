package br.ce.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ce.conn.Conexao;
import br.ce.dao.UsuarioDAO;
import br.ce.model.Usuario;

public class UsuarioFacade implements UsuarioDAO {		
	private Connection conn;
	private Conexao conexao = new Conexao();

	public UsuarioFacade() {		
		this.conn = conexao.openConexao();
	}	
	
	public Usuario autenticar(String login, String senha) {
		
		String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
		PreparedStatement pstm = null;
		try {
			 pstm = this.conn.prepareStatement(sql);
			 pstm.setString(1, login);
			 pstm.setString(2, senha);
			 ResultSet rs = pstm.executeQuery();
			 
			 Usuario user = new Usuario();					 
			 
			 while(rs.next()){
				 user.setLogin(rs.getString("login"));				 
				 user.setNome(rs.getString("nome"));
			 }
			 
			 conexao.closeConexao();
			 
			 if(user.getLogin() != null){				 
				return user;			 
			 }		  
			 	 
			 
		}catch(SQLException e) {
			e.printStackTrace();
		
		}finally{
			 conexao.closeConexao();				
		}
				
		return null;
	}	
	

}
