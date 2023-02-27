package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpHeaders;

public class Actualizacion implements Task {
    private String name;
    private String salary;

    private String age;
    private String idEmpleado;


    public Actualizacion(String name, String salary, String age, String idEmpleado) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.idEmpleado = idEmpleado;
    }

    public static Actualizacion conMetdoPut(String name, String salary, String age, String idEmpleado) {
        return Tasks.instrumented(Actualizacion.class, name, salary, age, idEmpleado);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("api/v1/update/"+idEmpleado).
                        with(requestSpecification -> requestSpecification.headers(HttpHeaders.CONTENT_TYPE, ContentType.JSON).
                                body("\t{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")));

    }
}
