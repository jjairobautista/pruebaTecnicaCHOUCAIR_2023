package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultaEmpleado  implements Task {

    private String idEmpleado;

    public ConsultaEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public static Performable getEmpleado(String id) {
        return Tasks.instrumented(ConsultaEmpleado.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(idEmpleado + ": empleado");
        actor.attemptsTo(Get.resource("api/v1/employee/"+idEmpleado));
    }
}
