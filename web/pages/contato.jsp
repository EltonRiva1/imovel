<%-- 
    Document   : contato
    Created on : 03/09/2016, 14:56:55
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="contato" scope="page" class="com.professordelphi.imovel.dao.DAOContato"/>
<jsp:setProperty name="contato" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            contato.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            contato.limpar();
            contato.setMensagem("" + erro);
        }
    } else {
        try {
            contato.localizarContato(request.getParameter("codigocon"));
        } catch (NullPointerException erro) {
            contato.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Contatos</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="contato.jsp"
                          method="POST">
                        <h1>Cadastro de Contatos <%=contato.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código</label>
                        <input type="text" name="codigocon"
                               value="<jsp:getProperty name="contato"
                                                property="codigocon"/>"/>
                        <br>
                        <label>Nome</label>
                        <input type="text" name="nomecon"
                               value="<jsp:getProperty name="contato"
                                                property="nomecon"/>"/>
                        <br>
                        <label>E-mail</label>
                        <input type="text"
                               name="emailcon" value="<jsp:getProperty
                                   name="contato" property="emailcon"/>"/>
                        <br>
                        <label>Observação</label>
                        <input type="text"
                               name="observacaocon" value="<jsp:getProperty
                                   name="contato" property="observacaocon"/>"/>
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
