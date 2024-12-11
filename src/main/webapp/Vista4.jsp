

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@ page import="org.prd.demo2.vista.Presentador" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>@import"Estilos.css"</style>
        <script>
            function mostrarAlerta(){
                alert("Grabacion Exitosa");
            }
        </script>
    </head>
    <body>
<div>
    <h1>Comprobante</h1>
         <% Presentador pres = (Presentador) session.getAttribute("pres"); %>
    <% String mensaje = pres.getMsg(); %>
    <% Object[] c = pres.getComp(); %>
    <% List<Object[]> lis = pres.getLis();%>
    <h2 class="mensaje">
        <%= (pres.getMsg() != null && !pres.getMsg().isEmpty()) ? pres.getMsg() : "" %>
    </h2>
    <form action="Control" method="Post" onsubmit="mostrarAlerta()">
        <table>
            <tr>
                <td>Numero de Recibo</td>
                <td><input type="text" name="num" size="35" value="<%= c[0]%>"/></td>
            </tr>
            <tr>
                <td>Fecha</td>
                <td><input type="text" name="fec" size="35" value="<%= c[1]%>"/></td>
            </tr>
            <tr>
                <td>Alumno</td>
                <td><input type="text" name="nom" size="35" value="" required/></td>
            </tr>
        </table>

        <table>
            <tr>
                <td>Codigo</td>
                <td>Nombre</td>
                <td>Cantidad</td>
            </tr>
            <%
                int totalcre = 0;  // Variable para acumular el total
                for (int i = 0; i < lis.size(); i++) {
                    Object[] f = lis.get(i);
                    int cantidad = Integer.parseInt((String) f[2]);
                    totalcre += cantidad;  // Acumulamos el importe en totalImporte
            %>
            <tr>
                <td><input type="text" name="codigo_<%= i%>" size="5" value="<%= f[0]%>"/></td>
                <td><input type="text" name="nombre_<%= i%>" size="15" value="<%= f[1]%>"/></td>
                <td><input type="text" name="cantidad_<%= i%>" size="5" value="<%= f[2]%>"/></td>
            </tr>
            <% } %>

            <!-- Fila con el total -->
            <tr>
                <td colspan="4" style="text-align">Total</td>
                <td><input type="text" name="total" size="5" value="<%= totalcre%>" readonly /></td>
            </tr>
        </table>

        <!-- Formulario de Envío -->
        <table>
            <tr><td><input type="submit" name="acc" value="Grabar Matricula"/></td></tr>
        </table>
    </form>
</div>


    </body>
</html>