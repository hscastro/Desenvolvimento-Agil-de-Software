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
    
    <script type="text/javascript">
       
        function voltar(){
        	window.location.href = "listaDeLivros.jsp";
        } 
                    
    </script>
   
</head>
<body>
<%  
    String nome = (String) session.getAttribute("nome");
    String login = (String) session.getAttribute("login");	
    Integer pontos = (Integer) session.getAttribute("pontos");
    String id_livro = request.getParameter("id_livro");    
    String status = request.getParameter("status");
    String titulo = request.getParameter("titulo");
    String autor = request.getParameter("autor");
    String genero = request.getParameter("genero");
    String qtd_paginas = request.getParameter("qtd_paginas");
    int nivel = Integer.parseInt(status);
    
%>
<br/>

<div align="center" style="background-color:#9AC0CD; color: blue;">
   <b> "ESSE EU JÁ LI!"</b> Usuário: <%=nome %>
</div>  
  <br/>
<div id="divCenters">

<input type="submit" name="Voltar" value="Voltar" onclick="voltar();">
 
   <form id="form" method="POST" action="pontos">
     <br/>
        <table width="40%" border="0" cellspacing="1px" cellpadding="0" bgcolor="">
            <caption><b> DESCRIÇÃO DO LIVRO </b></caption>
            <tr bgcolor="#9AC0CD" >
                <td> <b> ID</b></td> 
                <td align="center"> <%= id_livro %> </td>
            </tr>                                
            <tr bgcolor="#9AC0CD">
               <td> <b> COD.LIVRO</b></td>          
               <td align="center">  </td>  
            </tr> 
            
            <tr bgcolor="#9AC0CD">
              <td><b>TÍTULO </b></td> 
              <td align="center"> <%= titulo %>  </td> 
            </tr>
           
            <tr bgcolor="#9AC0CD">
              <td><b>GÊNERO </b></td> 
              <td align="center"> <%= genero %>  </td> 
            </tr>
            
            <tr bgcolor="#9AC0CD">  
              <td><b> AUTOR </b></td> 
              <td align="center"> <%= autor %> </td>
             </tr>
             
             <tr bgcolor="#9AC0CD"> 
              <td><b> QUANT. DE PÁGINAS </b></td> 
              <td align="center"> <%= qtd_paginas %> </td>
             </tr>
             <tr bgcolor="#9AC0CD"> 
               <td><b> JÁ LEU O LIVRO ? </b></td> 
               <td align="center"> <%
               				
				if(!(nivel == 1)){
				   status = "SIM";	
				}else{
					status = "NÃO";
				} %>
				
				<%= status %> </td>
             </tr>
             
             <tr bgcolor="#9AC0CD">  
               <td style="color: blue;" ><b> MARCAR LIVRO COMO LIDO </b></td>               
               <td align="center"> <input type="checkbox" name="checkbox" value="<%= nivel %>"/> </td>
             </tr>
                
         </table> 
         <br/>
           <br/> 
          
          <input type="hidden" name="login" value="<%= login %>" />
          <input type="hidden" name="id_livro" value="<%= id_livro %>" />
          <input type="hidden" name="titulo" value="<%= titulo %>" />
          <input type="hidden" name="autor" value="<%= autor %>" />
          <input type="hidden" name="genero" value="<%= genero %>" />
          <input type="hidden" name="qtd_paginas" value="<%= qtd_paginas %>" />
          <input type="hidden" name="nivel" value="<%=nivel %>" />
          <input type="submit" name="Salvar" value="Salvar" />
                                      
       </form>                
       
   </div>   
       
</body>
</html>