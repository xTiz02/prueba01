<%@page import="java.util.List"%>
<%@ page import="org.prd.demo2.vista.Presentador" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>@import"Estilos.css"</style>
    </head>
    <body>
        <div>
            <h1>Lista de Cursos</h1>
            <%
                // Recupera el Presentador desde la sesión
                Presentador pres = (Presentador) session.getAttribute("pres");
                // Recupera la lista de productos desde el Presentador
                List<Object[]> lis = pres.getLis();
            %>
            <% if (lis != null && !lis.isEmpty()) { %>
            <table>
                <tr>
                    <td>Código</td>
                    <td>Nombre</td>
                    <td>Creditos</td>
                </tr>
                <% for (int i = 0; i < lis.size(); i++) { %>
                <% Object[] f = (Object[]) lis.get(i);%>
                <tr>
                <form action="Control" method="Post">
                    <td><input type="text" name="cod" size="5" value="<%= f[0]%>"/></td>
                    <td><input type="text" name="nom" size="15" value="<%= f[1]%>"/></td>
                    <td><input type="text" name="cre" size="5" value="<%= f[2]%>"/></td>
                    <td><input type="submit" name="acc" size="5" value="Agregar Curso"/></td>
                </form>
                </tr>
                <% } %>
            </table>
            <% } else { %>
            <p>No se encontraron productos disponibles.</p>
            <% }%>
        </div>

    </body>
</html>