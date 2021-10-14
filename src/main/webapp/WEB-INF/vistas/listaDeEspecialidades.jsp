<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:body>
        <h1>Elija una especialidad</h1>
        <form method="POST" action="calendarios">
            <select name="especialidad" class="form-select">
                <option selected disabled value="0">Elija una opción</option>
                <c:forEach items="${calendarios}" var="calendar">
                    <option value="${calendar.profesion}">${calendar.profesion}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary mt-3">Aplicar filtro</button>
        </form>
    </jsp:body>
</t:layout>
