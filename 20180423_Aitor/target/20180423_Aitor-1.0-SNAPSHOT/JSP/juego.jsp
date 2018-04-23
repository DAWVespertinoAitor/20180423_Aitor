<%-- 
    Document   : juego
    Created on : 22-abr-2018, 18:19:25
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <%--<br><br><c:forEach var="numero" items="${requestScope.numeroAleatorio}">
                <c:out value="${numero}"/>
            </c:forEach><br><br>--%>
            <h2 style="color: blue; font-family: arial;">Mastermind. Juego de los muertos y los heridos</h2>
            <h2 style="color: orange; font-family: arial;">Registro de jugadas</h2>
            <c:forEach var="numJugada" items="${requestScope.numeroJugadas}">
                <input type="hidden" name="numJugada" value="${numJugada.numero}"/>
                <p>Jugada numero <c:out value="${numJugada.numero}"/> tienes <c:out value="${numJugada.heridos}"/> heridos y <c:out value="${numJugada.muertos}"/> muertos.</p>
            </c:forEach>
            <form action="<%=request.getContextPath()%>/Controlador" method="post">
                <input type="hidden" name="cantidadDigitos" value="${requestScope.cantidadDigitos}"/>
                <label for="numero">Introduce un número:</label>
                <c:forEach var="digito" begin = "1" end = "${requestScope.cantidadDigitos}">
                    <input type="number" id="numero" name="numero${digito}" style="width: 25px;" min="0" max="9" required/>
                </c:forEach><br><br>

                <input type="submit" name="enviar" value="Enviar"/><br><br>
            </form>
        </div>
    </body>
</html>
