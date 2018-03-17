<%-- 
    Document   : relatorioImovel
    Created on : 08/10/2016, 20:22:04
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoImovel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="imovel" scope="page" class="com.professordelphi.imovel.dao.DAOImovel"/>
<jsp:setProperty name="imovel" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Imóveis</title>
    </head>
    <body>
        <% List listando = imovel.listarImovel();
            String listagem = null;
            imovel.setMensagem("Lista de Imóveis");
            listagem = "<h1>" + imovel.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código dos Imóveis</h4>"
                    + "</td><td align='center'<h4>Código dos Bairros</h4>"
                    + "</td><td align='center'<h4>Endereço</h4>"
                    + "</td><td align='center'<h4>CEP</h4>"
                    + "</td><td align='center'<h4>Foto</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoImovel dto = (DtoImovel) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigoimo() + "</td><td><a href = '../pages/imovel.jsp?codigoimo=" + dto.getCodigoimo()
                            + "'>" + dto.getCodigobai() + "</a>"
                            + "</td><td>" + dto.getEnderecoimo()
                            + "</td><td>" + dto.getCepimo()
                            + "</td><td>" + dto.getFotoimo()
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                imovel.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
