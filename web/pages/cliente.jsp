<%-- 
    Document   : cliente
    Created on : 03/09/2016, 14:34:21
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="cliente" scope="page" class="com.professordelphi.imovel.dao.DAOCliente"/>
<jsp:setProperty name="cliente" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            cliente.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            cliente.limpar();
            cliente.setMensagem("" + erro);
        }
    } else {
        try {
            cliente.localizarCliente(request.getParameter("codigocli"));
        } catch (NullPointerException erro) {
            cliente.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Clientes</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="cliente.jsp"
                          method="POST">
                        <h1>Cadastro de Cliente <%=cliente.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código</label>
                        <input type="text" name="codigocli"
                               value="<jsp:getProperty name="cliente"
                                                property="codigocli"/>"/>
                        <br>
                        <label>Nome</label>
                        <input type="text" name="nomecli"
                               value="<jsp:getProperty name="cliente"
                                                property="nomecli"/>"/>
                        <br>
                        <label>Celular</label>
                        <input type="number"
                               name="celularcli" value="<jsp:getProperty
                                   name="cliente" property="celularcli"/>"/>
                        <br>
                        <label>WhatsApp</label>
                        <input type="number"
                               name="whatsappcli" value="<jsp:getProperty
                                   name="cliente" property="whatsappcli"/>"/>
                        <br>
                        <label>E-mail</label>
                        <input type="text"
                               name="emailcli" value="<jsp:getProperty
                                   name="cliente" property="emailcli"/>"/>
                        <br>
                        <label>Senha</label>
                        <input type="password"
                               name="senhacli" value="<jsp:getProperty name="cliente"
                                                property="senhacli"/>"/>
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
