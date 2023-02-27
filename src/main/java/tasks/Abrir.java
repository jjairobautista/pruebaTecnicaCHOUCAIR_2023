package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import userinterfaces.AbiriSitioWebExito;
import net.serenitybdd.screenplay.actions.Open;
public class Abrir implements Task {

    private AbiriSitioWebExito abiriSitioWebExito;

    public static Abrir sitioWeb() {
        return Tasks.instrumented(Abrir.class);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(abiriSitioWebExito));

    }
}
