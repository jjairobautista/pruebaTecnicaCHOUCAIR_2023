#language: es
@ConsultaEmpleados
Característica:  Realizar validacion E2E del servicio Dummy
  como usuario requiero la validacion del del servicio Dummy para la prueba tecnica

  Escenario: Validacion de consulta de empleados
    Dado jhon realiza la preparacion del servicio Dummy
    Cuando Realizar consulta de empleados
    Entonces  Validacion del codigo de respuesta 200






