#language: es

@ConsultaPorId
Característica: Realizar la consulta de empleado en especifico
  Cmo usuario requiero hacer la consulta de una empleado

  Esquema del escenario: Consulta de empleado por id
    Dado jhon realiza la preparacion del servicio Dummy
    Cuando realice la consula con el  del empleado con el <idEmpleado> id
    Entonces Validacion del codigo de respuesta 200

    Ejemplos:
      | idEmpleado |
      | "3"        |
      | "1"        |
      | "2"        |
      | "4"        |
      | "5"        |

