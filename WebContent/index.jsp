<b><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de login ao sistema.</title>
    <style type="text/css">
        * { margin: 0; padding: 5px; font-family:Tahoma; font-size:10pt;}
        #divCenter { 
                background-color: #e1e1e1; 
                width: 450px; 
                height: 250px; 
                left: 50%; 
                margin: -130px 0 0 -210px; 
                padding:14px;
                position: absolute; 
                top: 50%; }
    </style>
</head>
<body>
<div id="divCenter">
        <form method="POST" action="login">
             Login: <br/><input type="text" id="login" name="login" size="40" /><br/>
             <br/>
             Senha: <br/><input type="password" id="senha" name="senha" size="40" /><br />
             <br/>
             <input type="submit" name="Acessar" value="Acessar" />
         </form>
           <br/>
              <br/>
               <div style="font-family:Tahoma; font-size:10pt; color: red; "> ${ erro } </div>
          <br/>        
             <a href="telaCadastro.html">Cadastre-se</a>
          <br/>
    </div>
        
</body>
</html>