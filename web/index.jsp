<%-- 
    Document   : index
    Created on : 22/10/2016, 14:05:43
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="login" scope="page" class="com.professordelphi.imovel.dao.DAOLogin" />
<jsp:setProperty name="login" property="*" />
<jsp:useBean id="funcionario" scope="page" class="com.professordelphi.imovel.dao.DAOFuncionario" />
<jsp:setProperty name="funcionario" property="*" />
<jsp:useBean id="corretor" scope="page" class="com.professordelphi.imovel.dao.DAOCorretor" />
<jsp:setProperty name="corretor" property="*" />
<%
    login.setMensagem("");
    try {
        if (request.getParameter("clickBt").equalsIgnoreCase("login")) {
            if (login.acessar(request.getParameter("email"), request.getParameter("senha")) == 0) {
                response.sendRedirect("pages/corretor.jsp");
            } else if (login.acessar(request.getParameter("email"), request.getParameter("senha")) == 1) {
                response.sendRedirect("sistemaAdmin.jsp");
            } else if (login.acessar(request.getParameter("email"), request.getParameter("senha")) == 2) {
                session.setAttribute("codigocor", String.valueOf(login.getCodigocor()));
                response.sendRedirect("pages/imovel.jsp");
            }
        }
    } catch (NullPointerException erro) {
        login.setMensagem("");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="estilo/estilo.css" />
        <title>Sistema de cadastro de Imóveis</title>
    </head>
    <body>
        <div class="mae">
            <div class="topo">
            </div>
            <div class="corpo">
                <form name="form1" action="index.jsp">
                    <h1></h1>
                    <label>E-mail</label>
                    <input type="text" name="email" value=""/><br>
                    <label>Senha</label>
                    <input type="password" name="senha" value=""/><br>
                    <input type="submit" value="Login" name="clickBt"/>
                    <input type="submit" value="Limpar" name="clickBt"/><br>
                    <br>
                    <br>
                </form>
            </div>
            <%=login.getMensagem()%>
            <div class="rodape"></div>
        </div>
    </body>
</html>
