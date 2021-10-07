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
            <script src='js/main.js' type="text/javascript"></script>
            <script src='js/locales.js' type="text/javascript"></script>
            <script src="js/calendar.js" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
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
                    <form>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="recipient-dni" class="col-form-label">DNI de Paciente:</label>
                                <input type="text" class="form-control" id="recipient-dni" required />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-especialidad" class="col-form-label">Especialidad:</label>
                                <input type="text" class="form-control" id="recipient-especialidad" disabled value="${titulo}" />
                            </div>
                            <div class="mb-3">
                                <label for="fecha-atencion" class="col-form-label">Fecha de atención:</label>
                                <input type="date" id="fecha-atencion" class="form-control" disabled />
                            </div>
                            <div class="mb-3">
                                <label for="hora-atencion" class="col-form-label">Hora de atención:</label>
                                <input type="time" id="hora-atencion" class="form-control" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success">Solicitar Turno</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>