package br.ce.dao;

import java.util.List;

import br.ce.model.Usuario;

public interface UsuarioDAO {
	
	public abstract Usuario autenticar(String login, String senha);
	 

 }