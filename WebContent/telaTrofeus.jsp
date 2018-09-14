<%@page import="br.ce.facade.RanckingFacade"%>
<%@page import="br.ce.model.Usuario"%>
<%@page import="br.ce.model.Pontos"%>
<%@page import="br.ce.facade.LivroFacade"%>
<%@page import="br.ce.model.Livro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benvindo ao Rancking</title>
    <style type="text/css">
        * { margin: 0; padding: 5px; font-family:Tahoma; font-size:10pt;}
        #divCenter { 
                background-color: #e1e1e1; 
                width: 820px; 
                height: 380px; 
                left: 30%; 
                margin: -130px 0 0 -210px; 
                padding:14px;
                position: absolute; 
                top: 20%; }
                a:link { text-decoration: none; }
    </style>    

</head>

<body>
<%
    String nome = (String) session.getAttribute("nome"); 
	String login = (String) session.getAttribute("login");    
    Integer pontos = (Integer) session.getAttribute("pontos");
    int id = 0;
    String nomeDeUsuario = "";                
    String genero = "";
    String autor = "";
    int qtd_paginas = 0;
    int valor = 0;
    int contador = 0;
    
%>
<br/>


<div align="center" style="background-color:#9AC0CD; color: blue;">
   <b> "ESSE EU JÁ LI!"</b> Usuário: <%=nome %>
</div> 

<div align="left"> <b><a href="listaDeLivros.jsp">Voltrar</a></b> </div>

<div id="divCenters">       
        <table width="80%" border="0" cellspacing="1px" cellpadding="0" bgcolor="">
            <caption><b>MEUS TROFÉUS DE UM BOM LEITOR </b></caption>
            <tr bgcolor="#9AC0CD" align="center"><td> <b> ID</b></td> <td><b>USUÁRIO</b></td>  <td><b> PONTOS </b></td> <td><b> GENERO </b></td> <td><b> TROFÉUS </b></td>  </tr>
            <%
            
                Usuario user = new Usuario();
                user.setLogin(login);
            	RanckingFacade ranck = new RanckingFacade();
				List<Pontos> lista = ranck.listaTodos(user);   
				
                for(int i = 0; i < lista.size(); i++){
                	id += 1;
                	nomeDeUsuario = lista.get(i).getLogin();
                	contador = lista.get(i).getContador();
                	valor = lista.get(i).getValor();
                	genero = lista.get(i).getGenero();

            %>
                    <tr bgcolor="#B2DFEE" ><td><center><%= id %></center>  </td>  <td><center><%= nomeDeUsuario %> </center>  </td> 
                    <td height="5px"> <center><%= valor %> </center> </td>
                    <td height="5px"> <center><%= genero %> </center> </td>
                    <%
                    if(contador >= 5){
                    	contador++;
                    %>                    			
                    	<td height="5px"><DIV style="color: blue; margin-left: 33%; "> TROFÉU "LEITOR DE <%= genero %>" </DIV></td>	
                    <%
                      }else{                    
                    %>	
                    <td height="5px"><DIV style="color: red; margin-left: 33%; "> SEM TROFÉU </DIV></td>
                     <%
                      }	  
                    %>  
                                           		   
                   </tr>
                 <%
               }             
            %>
            
       </table> 
              
   </div>
   
</body>
</html>