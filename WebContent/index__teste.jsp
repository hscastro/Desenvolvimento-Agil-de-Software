<%@page import="br.ce.facade.LivroFacade"%>
<%@page import="br.ce.model.Livro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benvindo a listagem de livros</title>
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
    </style>
    

</head>

<body>
<%
	//String login = (String) session.getAttribute("login");    
    //Integer pontos = (Integer) session.getAttribute("pontos");
    int id = 0;
    String status = "";                
    String titulo = "";
    String genero = "";
    String autor = "";
    int qtd_paginas = 0;
    int nivel = 0;
%>
<br/>
<!-- <div align="left"><a href="telaLogin.jsp">Voltrar</a></div>-->

<div align="center" style="background-color:#9AC0CD; color: blue;">
   <b> "ESSE EU J� LI!"</b>
</div> 

<div align="left"><b> <a href="telaRancking.jsp">Pontua��o </a> </b></div>

<div align="left"><b> <a href="telaLogin.jsp">Sair </a> </b></div>
<!-- <input type="submit" name="novo_livro" value="NOVO LIVRO" onclick="enviar();">-->

<div id="divCenters">       
        <table width="80%" border="0" cellspacing="1px" cellpadding="0" bgcolor="">
            <caption><b>LISTAGEM DE LIVROS </b></caption>
            <tr bgcolor="#9AC0CD" align="center"><td> <b> ID</b></td> <td> <b> COD.LIVRO</b></td><td><b>T�TULO DO LIVRO</b></td>  <td><b> AUTOR </b></td> <td><b> QUANT. DE P�GINAS </b></td>    <td><b> VISUALIZAR </b></td> </tr>
            <%
            	LivroFacade facadeLivros = new LivroFacade();
                List<Livro> lista = facadeLivros.listarTodos();                  
                
                for(int i = 0; i < lista.size(); i++){
                	
                	id = lista.get(i).getId();
                	titulo = lista.get(i).getTitulo();
                	autor = lista.get(i).getAutor();
                	genero = lista.get(i).getGenero();
                	qtd_paginas = lista.get(i).getQtdDePaginas();
                	nivel = lista.get(i).getStatus();
             	   
            %>
                   <tr bgcolor="#B2DFEE" ><td> <%= id %> </td><td> </td>  <td><%= titulo %></td> <td height="5px"> <%= autor  %> </td>  
                   <td height="5px"><center> <%= qtd_paginas %> </center></td> 
                    <td height="5px">
                      <a href="telaLogin.jsp?"><center> Clique </center>    </a>                  		                 
                    </td> 

                     </tr>
                 <%
               }             
            %>
            
       </table> 
       
   </div>
    
    <script type="text/javascript">
       
        function enviar(){
        	window.location.href = "inserirLivro.jsp";
        }
        
    </script>
</body>
</html>