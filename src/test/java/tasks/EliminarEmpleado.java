package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class EliminarEmpleado implements Task {

    private String idEmpleado;

    public EliminarEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public static EliminarEmpleado deleted(String idEmpleado) {
        return Tasks.instrumented(EliminarEmpleado.class,idEmpleado);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("api/v1/delete/"+idEmpleado));

    }
}
