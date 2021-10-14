<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="styles">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/calendar.css">
    </jsp:attribute>
    <jsp:attribute name="scripts">
            <script>
                const listaDeTurnos=[];
                <c:forEach items="${turnos}" var="turno">
                    listaDeTurnos.push({
                        title: "Ocupado",
                        start: "${turno.fecha}T${turno.hora}:00"
                    })
                </c:forEach>
                var traerEventos=function() {
                    return listaDeTurnos;
                }
            </script>
            <script src='js/main.js' type="text/javascript"></script>
            <script src='js/locales.js' type="text/javascript"></script>
            <script src="js/calendar.js" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
        <section>
            <h1>${titulo}</h1>
            <form method="POST" action="calendarios">
                <select name="especialidad" class="form-select">
                    <option selected disabled value="0">Elija una opción</option>
                    <c:forEach items="${calendarios}" var="calendar">
                        <option value="${calendar.profesion}">${calendar.profesion}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-primary mt-3">Aplicar filtro</button>
            </form>
        </section>
        <section>
            <div id='calendar'></div>
        </section>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nuevo turno</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form:form action="solicitar-turno" method="post" modelAttribute="turno">
                        <div class="modal-body">
                            <div class="mb-3">
                                <form:label path="documento" class="col-form-label">DNI de Paciente:</form:label>
                                <form:input path="documento" type="text" class="form-control" value="32141254" readonly="true" />
                            </div>
                            <div class="mb-3">
                                <form:label path="especialidad" class="col-form-label">Especialidad:</form:label>
                                <form:input path="especialidad" type="text" class="form-control" readonly="true" value="${titulo}" />
                            </div>
                            <div class="mb-3">
                                <form:label path="fecha" class="col-form-label">Fecha de atención:</form:label>
                                <form:input path="fecha" type="text" id="fecha-atencion" class="form-control" readonly="false" />
                            </div>
                            <div class="mb-3">
                                <form:label path="hora" class="col-form-label">Hora de atención:</form:label>
                                <form:select path="hora" class="form-control">
                                    <form:option value="0" selected="true" disabled="true">Elija un horario</form:option>
                                    <form:option value="14:00">14:00</form:option>
                                    <form:option value="15:00">15:00</form:option>
                                    <form:option value="16:00">16:00</form:option>
                                    <form:option value="17:00">17:00</form:option>
                                    <form:option value="18:00">18:00</form:option>
                                </form:select>
                            </div>
                            <div class="mb-3">
                                <form:label path="especialista" class="col-form-label">Especialidad:</form:label>
                                <form:input path="especialista" type="text" class="form-control" readonly="true" value="Dr. Jorge Sanchez" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success">Solicitar Turno</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>