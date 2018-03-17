<%-- 
    Document   : relatorioBairro
    Created on : 08/10/2016, 19:45:11
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoBairro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="bairro" scope="page" class="com.professordelphi.imovel.dao.DAOBairro"/>
<jsp:setProperty name="bairro" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Bairros</title>
    </head>
    <body>
        <% List listando = bairro.listarBairro();
            String listagem = null;
            bairro.setMensagem("Lista de Bairros");
            listagem = "<h1>" + bairro.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código</h4>"
                    + "</td><td align='center'<h4>Nome</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoBairro dto = (DtoBairro) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigobai() + "</td><td><a href = '../pages/bairro.jsp?codigobai=" + dto.getCodigobai()
                            + "'>" + dto.getNomebai() + "</a>"
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                bairro.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
