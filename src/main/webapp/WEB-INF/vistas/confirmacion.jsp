<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
  <jsp:body>
    <div>
      <h1>Turno Confirmado</h1>
      <p>Paciente: ${turno.documento.toString()}</p>
      <p>Especialidad: ${turno.especialidad}</p>
      <p>Fecha: ${turno.fecha.toString()}</p>
      <p>Hora: ${turno.hora}</p>
      <p>Especialista: ${turno.especialista}</p>
    </div>
    <div>
      <a href="calendarios">Volver a Calendarios</a>
    </div>
    <script>
      console.log("${turno.documento.toString()}")
      console.log("${turno.especialidad}")
      console.log("${turno.fecha.toString()}")
      console.log("${turno.especialista}")
    </script>
  </jsp:body>
</t:layout>
