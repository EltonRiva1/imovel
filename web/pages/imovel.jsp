<%-- 
    Document   : imovel
    Created on : 03/09/2016, 15:26:49
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="imovel" scope="page" class="com.professordelphi.imovel.dao.DAOImovel"/>
<jsp:setProperty name="imovel" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            imovel.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            imovel.limpar();
            imovel.setMensagem("" + erro);
        }
    } else {
        try {
            imovel.localizarImovel(request.getParameter("codigoimo"));
        } catch (NullPointerException erro) {
            imovel.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Imóveis</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="imovel.jsp"
                          method="POST">
                        <h1>Cadastro de Imóveis <%=imovel.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código dos imóveis</label>
                        <input type="text" name="codigoimo"
                               value="<jsp:getProperty name="imovel"
                                                property="codigoimo"/>"/>
                        <br>
                        <label>Código dos bairros</label>
                        <input type="text" name="codigobai"
                               value="<jsp:getProperty name="imovel"
                                                property="codigobai"/>"/>
                        <br>
                        <label>Endereço dos imóveis</label>
                        <input type="text" name="enderecoimo" value="<jsp:getProperty name="imovel" property="enderecoimo"/>"/>
                        <br>
                        <label>CEP</label>
                        <input type="text" name="cepimo" value="<jsp:getProperty name="imovel" property="cepimo"/>"/>
                        <br>
                        <label>Foto</label>
                        <input type="text" name="fotoimo" value="<jsp:getProperty name="imovel" property="fotoimo"/>"/>
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
