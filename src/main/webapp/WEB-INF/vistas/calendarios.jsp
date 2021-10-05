<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <section>
        <h1>${titulo}</h1>
        <form method="POST" action="calendarios">
            <select name="profesion" class="form-select">
                <option selected disabled value="0">Elija una opción</option>
                <c:forEach items="${calendarios}" var="calendar">
                    <option value="${calendar.profesion}">${calendar.profesion}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary mt-3">Aplicar filtro</button>
        </form>
<%--        <form method="POST" action="calendarios">--%>
<%--        <form:select path="profesion" cssClass="form-select">--%>
<%--            <form:option selected="true" value="0" label="Elija una opción"  disabled="true" />--%>
<%--            <form:options items="${profesiones}" />--%>
<%--        </form:select>--%>
<%--            <button type="submit" class="btn btn-primary mt-3">Aplicar filtro</button>--%>
<%--        </form>--%>
        <div class="text-center">
            <img class="img-fluid" src="https://www.formget.com/wp-content/uploads/2015/07/imageedit_30_8479321211.gif" alt="Calendario"/>
        </div>
    </section>
</t:layout>
