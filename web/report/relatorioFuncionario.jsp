<%-- 
    Document   : relatorioFuncionario
    Created on : 08/10/2016, 14:36:21
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoFuncionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="funcionario" scope="page" class="com.professordelphi.imovel.dao.DAOFuncionario"/>
<jsp:setProperty name="funcionario" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
    </head>
    <body>
        <% List listando = funcionario.listarFuncionario();
            String listagem = null;
            funcionario.setMensagem("Lista de Funcionários");
            listagem = "<h1>" + funcionario.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código</h4>"
                    + "</td><td align='center'<h4>Nome</h4>"
                    + "</td><td align='center'<h4>Celular</h4>"
                    + "</td><td align='center'<h4>WhatsApp</h4>"
                    + "</td><td align='center'<h4>Email</h4>"
                    + "</td><td align='center'<h4>Senha</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoFuncionario dto = (DtoFuncionario) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigofunc() + "</td><td><a href = '../pages/funcionario.jsp?codigofunc=" + dto.getCodigofunc()
                            + "'>" + dto.getNomefunc() + "</a>"
                            + "</td><td>" + dto.getCelularfunc()
                            + "</td><td>" + dto.getWhatsappfunc()
                            + "</td><td>" + dto.getEmailfunc()
                            + "</td><td>" + dto.getSenhafunc()
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                funcionario.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
