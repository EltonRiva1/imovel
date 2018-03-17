<%-- 
    Document   : relatorioCliente
    Created on : 08/10/2016, 19:49:50
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="cliente" scope="page" class="com.professordelphi.imovel.dao.DAOCliente"/>
<jsp:setProperty name="cliente" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <% List listando = cliente.listarCliente();
            String listagem = null;
            cliente.setMensagem("Lista de Clientes");
            listagem = "<h1>" + cliente.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código</h4>"
                    + "</td><td align='center'<h4>Nome</h4>"
                    + "</td><td align='center'<h4>Celular</h4>"
                    + "</td><td align='center'<h4>WhatsApp</h4>"
                    + "</td><td align='center'<h4>Email</h4>"
                    + "</td><td align='center'<h4>Senha</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoCliente dto = (DtoCliente) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigocli() + "</td><td><a href = '../pages/cliente.jsp?codigocli=" + dto.getCodigocli()
                            + "'>" + dto.getNomecli() + "</a>"
                            + "</td><td>" + dto.getCelularcli()
                            + "</td><td>" + dto.getWhatsappcli()
                            + "</td><td>" + dto.getEmailcli()
                            + "</td><td>" + dto.getSenhacli()
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                cliente.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
