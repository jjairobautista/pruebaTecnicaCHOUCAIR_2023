package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import model.EmpleadosServicio;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.LastResponseStatusCode;
import tasks.*;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidacionServicioDummy {


    @Dado("jhon realiza la preparacion del servicio Dummy")
    public void jhonRealizaLaPreparacionDelServicioDummy() {
        theActorCalled("jhonB")
                .whoCan(CallAnApi.at("https://dummy.restapiexample.com/"));
    }

    @Cuando("Realizar consulta de empleados")
    public void realizarConsumoDelServicio() {
        theActorInTheSpotlight().attemptsTo(ConsultaServicio.getEmpleados());


    }

    @Entonces("Validacion del codigo de respuesta 200")
    public void validacionDelCodigoDeRespuesta() {
        theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is()));
    }


    @Cuando("realice la consula con el  del empleado con el {string} id")
    public void realiceLaConsulaConElDelEmpleadoConElId(String idEmpleado) {
        theActorInTheSpotlight().attemptsTo(ConsultaEmpleado.getEmpleado(idEmpleado));

    }

    @Cuando("ingrese la informacion  {string} {string} {string} de la creacion del empleado")
    public void ingreseLaInformacionDeLaCreacionDelEmpleado(String name, String salary, String age) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(CreacionEmpleado.conMetdoPost(name, salary,age));
    }

    @Cuando("ingrese la informacion   {string} {string} {string} {string} de la actualiza del empleado")
    public void ingreseLaInformacionDeLaActualizaDelEmpleado(String name, String salary, String age, String idEmpleado) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(Actualizacion.conMetdoPut(name, salary,age,idEmpleado));
    }

    @Cuando("ingrese la informacion {string} de la e del empleado")
    public void ingreseLaInformacionDeLaEDelEmpleado(String idEmpleado) {
        theActorInTheSpotlight().attemptsTo(EliminarEmpleado.deleted(idEmpleado));

    }

}

