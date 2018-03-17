<%-- 
    Document   : corretor
    Created on : 03/09/2016, 15:18:17
    Author     : notle
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="corretor" scope="page" class="com.professordelphi.imovel.dao.DAOCorretor"/>
<jsp:setProperty name="corretor" property="*"/>

<%
    if (request.getParameter("btmovimento") != null) {
        try {
            corretor.persistencia(request.getParameter("btmovimento"));
        } catch (NullPointerException erro) {
            corretor.limpar();
            corretor.setMensagem("" + erro);
        }
    } else {
        try {
            corretor.localizarCorretor(request.getParameter("codigocor"));
        } catch (NullPointerException erro) {
            corretor.setMensagem("Operação cancelada! " + erro);
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html;charset=ISO-8859-1">
        <title>JSP Cadastro de Corretores</title>
        <link href ="../estilo/estilo.css" rel ="Stylesheet" 
              type="text/css">
    </head>
    <body>
        <div class="mae">
            <div class="topo">
                <div class="corpo">
                    <form name="form1" action="corretor.jsp"
                          method="POST">
                        <h1>Cadastro de Corretores <%=corretor.getMensagem()%>
                        </h1>
                        <br>
                        <label>Código</label>
                        <input type="text" name="codigocor"
                               value="<jsp:getProperty name="corretor"
                                                property="codigocor"/>"/>
                        <br>
                        <label>Nome</label>
                        <input type="text" name="nomecor"
                               value="<jsp:getProperty name="corretor"
                                                property="nomecor"/>"/>
                        <br>
                        <label>Celular</label>
                        <input type="number"
                               name="celularcor" value="<jsp:getProperty
                                   name="corretor" property="celularcor"/>"/>
                        <br>
                        <label>WhatsApp</label>
                        <input type="number"
                               name="whatsappcor" value="<jsp:getProperty
                                   name="corretor" property="whatsappcor"/>"/>
                        <br>
                        <label>E-mail</label>
                        <input type="text"
                               name="emailcor" value="<jsp:getProperty
                                   name="corretor" property="emailcor"/>"/>
                        <br>
                        <label>Senha</label>
                        <input type="password"
                               name="senhacor" value="<jsp:getProperty name="corretor"
                                                property="senhacor"/>"/>
                        <br>
                        <label>Creci</label>
                        <input type="text" 
                               name="crecicor" value="<jsp:getProperty name="corretor"
                                                property="crecicor"/>"/>
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
