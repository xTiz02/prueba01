

<%@page import="java.util.List"%>
<%@ page import="org.prd.demo2.vista.Presentador" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>8
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>@import"Estilos.css"</style>
    </head>
    <body>
        <div>
            <h1>Carrito</h1>
            <% Presentador pres=(Presentador)session.getAttribute("pres"); %>
            <% List lis=pres.getLis();
                System.out.println("lis="+lis);
            %>
            <table>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Creditos</td>
                </tr>
                <% for(int i=0;i<lis.size();i++){ %>
                <% Object[]f=(Object[])lis.get(i); %>
                <tr>
                    <form action="Control" method="Post">
                    <td><input type="text" name="cod" size="5" value="<%= f[0] %>"/></td>
                    <td><input type="text" name="nom" size="15" value="<%= f[1] %>"/></td>
                    <td><input type="text" name="cre" size="5" value="<%= f[2] %>"/></td>
                    <td><input type="submit" name="acc" size="5" value="Quitar Curso"/></td>
                    </form>
                </tr>
                <% } %>
            </table>
            <table>
                <form action="Control" method="Post">
                <tr><td><input type="submit" name="acc" value="Lista de Cursos"/></td></tr>
                </form>
            </table>
            <table>
                <form action="Control" method="Post">
                <tr><td><input type="submit" name="acc" value="Crear Matricula"/></td></tr>
                </form>
            </table>  
        </div>
    </body>
</html>