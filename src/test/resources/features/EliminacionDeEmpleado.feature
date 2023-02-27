#language: es


@CreacionEmpleado
Característica: Realizar la Eliminacion de un empleado
  Cmo usuario requiero hacer la Eliminacion de empleado

  Escenario:  Eliminacion de empelado
    Dado jhon realiza la preparacion del servicio Dummy
    Cuando ingrese la informacion "300" de la e del empleado
    Entonces Validacion del codigo de respuesta 200
