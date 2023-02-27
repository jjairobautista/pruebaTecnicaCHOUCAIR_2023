package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import java.util.List;

public class CreacionEmpleado implements Task {
    private String name;
    private String salary;
    private String age;


    public CreacionEmpleado(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public static CreacionEmpleado conMetdoPost(String name, String salary, String age){
        return Tasks.instrumented(CreacionEmpleado.class, name, salary, age);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to("api/v1/create").
                        with(requestSpecification -> requestSpecification.
                                body("{\"name\":\""+name+"\",\"salary\":\""+salary+ "\",\"age\":\""+age+"\"}")));


    }
}
