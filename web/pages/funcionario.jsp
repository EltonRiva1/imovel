<%-- 
    Document   : funcionario
    Created on : 03/09/2016, 14:06:40
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="funcionario" scope="page" class="com.professordelphi.imovel.dao.DAOFuncionario"/>
<jsp:setProperty name="funcionario" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            funcionario.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            funcionario.limpar();
            funcionario.setMensagem("" + erro);
        }
    } else {
        try {
            funcionario.localizarFuncionario(request.getParameter("codigofunc"));
        } catch (NullPointerException erro) {
            funcionario.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Funcionários</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="funcionario.jsp"
                          method="POST">
                        <h1> Cadastro de Funcionário <%=funcionario.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código</label>
                        <input type="text" name="codigofunc"
                               value="<jsp:getProperty name="funcionario"
                                                property="codigofunc"/>"/>
                        <br>
                        <label>Nome</label>
                        <input type="text" name="nomefunc"
                               value="<jsp:getProperty name="funcionario"
                                                property="nomefunc"/>"/>
                        <br>
                        <label>Celular</label>
                        <input type="number"
                               name="celularfunc" value="<jsp:getProperty
                                   name="funcionario" property="celularfunc"/>"/>
                        <br>
                        <label>WhatsApp</label>
                        <input type="number"
                               name="whatsappfunc" value="<jsp:getProperty
                                   name="funcionario" property="whatsappfunc"/>"/>
                        <br>
                        <label>E-mail</label>
                        <input type="email"
                               name="emailfunc" value="<jsp:getProperty
                                   name="funcionario" property="emailfunc"/>"/>
                        <br>
                        <label>Senha</label>
                        <input type="password"
                               name="senhafunc" value="<jsp:getProperty name="funcionario"
                                                property="senhafunc"/>"/>
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
