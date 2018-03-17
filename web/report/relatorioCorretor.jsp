<%-- 
    Document   : relatorioCorretor
    Created on : 08/10/2016, 20:08:59
    Author     : notle
--%>

<%@page import="java.util.List"%>
<%@page import="com.professordelphi.imovel.dto.DtoCorretor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="corretor" scope="page" class="com.professordelphi.imovel.dao.DAOCorretor"/>
<jsp:setProperty name="corretor" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Corretores</title>
    </head>
    <body>
        <% List listando = corretor.listarCorretor();
            String listagem = null;
            corretor.setMensagem("Lista de Corretores");
            listagem = "<h1>" + corretor.getMensagem() + "</h1><table border=2>"
                    + "<tr><td align='center'><h4>Código</h4>"
                    + "</td><td align='center'<h4>Nome</h4>"
                    + "</td><td align='center'<h4>Celular</h4>"
                    + "</td><td align='center'<h4>WhatsApp</h4>"
                    + "</td><td align='center'<h4>Email</h4>"
                    + "</td><td align='center'<h4>Senha</h4>"
                    + "</td><td align='center'<h4>Creci</h4>"
                    + "</td></tr>";
            try {
                for (int i = 0; i < listando.size(); i++) {
                    DtoCorretor dto = (DtoCorretor) listando.get(i);
                    listagem = listagem + "<tr><td>" + dto.getCodigocor() + "</td><td><a href = '../pages/corretor.jsp?codigocor=" + dto.getCodigocor()
                            + "'>" + dto.getNomecor() + "</a>"
                            + "</td><td>" + dto.getCelularcor()
                            + "</td><td>" + dto.getWhatsappcor()
                            + "</td><td>" + dto.getEmailcor()
                            + "</td><td>" + dto.getSenhacor()
                            + "</td><td>" + dto.getCrecicor()
                            + "</td></tr>";
                }
                out.println(listagem);
                out.println("</table>");
            } catch (NullPointerException erro) {
                corretor.setMensagem("Operação cancelada! " + erro);
            }
        %>
    </body>
</html>
