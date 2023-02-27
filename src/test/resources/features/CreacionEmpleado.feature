#language: es


@CreacionEmpleado
Característica: Realizar la la creacion de un empleado
  Cmo usuario requiero hacer la creacion de empleado

  Esquema del escenario:  Creacion de empelado
    Dado jhon realiza la preparacion del servicio Dummy
    Cuando ingrese la informacion  <name> <salary> <age> de la creacion del empleado
    Entonces Validacion del codigo de respuesta 200

    Ejemplos:
      | name           | salary  | age  |
      | "JhonBautista" | "90888" | "25" |