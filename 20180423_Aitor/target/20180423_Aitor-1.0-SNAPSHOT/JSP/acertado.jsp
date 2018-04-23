<%-- 
    Document   : acertado
    Created on : 22-abr-2018, 18:19:37
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizado</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h2 style="color: blue; font-family: arial;">Mastermind. Juego de los muertos y los heridos</h2>
            <h2 style="color: orange; font-family: arial;">Juego finalizado</h2>
            <h3 style="color: red; font-family: arial;">
                ENHORABUENA!!! HAS ACERTADO EL NÚMERO 
                <p>
                    <c:forEach var="numero" items="${requestScope.numeroAleatorio}">
                        <c:out value="${numero}"/>
                    </c:forEach>
                </p> EN <c:out value="${requestScope.numeroJugadas}"/>
                <c:if test="${requestScope.numeroJugadas == 1}">
                    JUGADA
                </c:if>
                <c:if test="${requestScope.numeroJugadas != 1}">
                    JUGADAS
                </c:if>
            </h3>
            <form action="<%=request.getContextPath()%>/Controlador" method="post">
                <h3 style="font-family: arial;">¿Quieres jugar otra vez?</h3>
                <input type="submit" name="si" value="Si"/>
                <input type="submit" name="no" value="No"/><br><br>
            </form>
        </div>
    </body>
</html>
