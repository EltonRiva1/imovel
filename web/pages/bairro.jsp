<%-- 
    Document   : bairro
    Created on : 03/09/2016, 14:48:45
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="bairro" scope="page" class="com.professordelphi.imovel.dao.DAOBairro"/>
<jsp:setProperty name="bairro" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            bairro.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            bairro.limpar();
            bairro.setMensagem("" + erro);
        }
    } else {
        try {
            bairro.localizarBairro(request.getParameter("codigobai"));
        } catch (NullPointerException erro) {
            bairro.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Bairros</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="bairro.jsp"
                          method="POST">
                        <h1>Cadastro de Bairros <%=bairro.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código</label>
                        <input type="text" name="codigobai"
                               value="<jsp:getProperty name="bairro"
                                                property="codigobai"/>"/>
                        <br>
                        <label>Nome</label>
                        <input type="text" name="nomebai"
                               value="<jsp:getProperty name="bairro"
                                                property="nomebai"/>"/>
                        <br>
                        <input type="submit" value="Incluir" name="btmovimento"/>
                        <input type="submit" value="Excluir" name="btmovimento"/>
                        <input type="submit" value="Atualizar" name="btmovimento"/>
                        <input type="submit" value="Localizar" name="btmovimento"/>
                        <input type="submit" value="Limpar" name="btmovimento"/>
                        <a href="index.jsp">
                            <input type="button" value="Voltar">
                        </a>
                    </form>
                </div>
                <div class="rodape"></div>
            </div>
        </div>
    </body>
</html>
