<%-- 
    Document   : relatorioContato
    Created on : 08/10/2016, 20:00:40
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoContato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="contato" scope="page" class="com.professordelphi.imovel.dao.DAOContato"/>
<jsp:setProperty name="contato" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contatos</title>
    </head>
    <body>
        <% List listando = contato.listarContato();
            String listagem = null;
            contato.setMensagem("Lista de Contatos");
            listagem = "<h1>" + contato.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código</h4>"
                    + "</td><td align='center'<h4>Nome</h4>"
                    + "</td><td align='center'<h4>Email</h4>"
                    + "</td><td align='center'<h4>Observação</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoContato dto = (DtoContato) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigocon() + "</td><td><a href = '../pages/contato.jsp?codigocon=" + dto.getCodigocon()
                            + "'>" + dto.getNomecon() + "</a>"
                            + "</td><td>" + dto.getEmailcon()
                            + "</td><td>" + dto.getObservacaocon()
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                contato.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
