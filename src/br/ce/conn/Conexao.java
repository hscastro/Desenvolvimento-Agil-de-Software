package br.ce.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String url;
	private String user;
	private String password;
	private Connection connection;	
		
	static {		
		try{			
			 Class.forName("org.postgresql.Driver");			
			
		}catch (ClassNotFoundException e) {
		   e.printStackTrace();			
		}
	}

	public Conexao() {
		url = "jdbc:postgresql://localhost:5432/coursera";
		user = "postgres";		
		password = "postgresql";		
	}
	
	public Connection openConexao() {
		
		try{			
			connection = DriverManager.getConnection(url, user, password);
			
		}catch (Exception e) {
			throw new RuntimeException("Não foi possível se conectar ao banco de dados", e);
		}
		
		return connection;
	}
	
	
	public void closeConexao() {
		
		if(this.connection != null){
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			
			}finally{
				this.connection = null;
			}
		}
				
	}	

}
