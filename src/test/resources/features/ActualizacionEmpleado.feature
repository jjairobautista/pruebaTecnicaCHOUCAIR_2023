#language: es


@CreacionEmpleado
Característica: Realizar la la creacion de un empleado
  Cmo usuario requiero hacer la creacion de empleado

  Escenario:  Actualizacion de empelado
    Dado jhon realiza la preparacion del servicio Dummy
    Cuando ingrese la informacion   "JhonBautista" "90888" "25" "99" de la actualiza del empleado
    Entonces Validacion del codigo de respuesta 200

