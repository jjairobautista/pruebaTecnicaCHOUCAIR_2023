package tasks;

import javafx.util.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import userinterfaces.CategoriaCeularesIphone;
import userinterfaces.HomeExito;

public class AbrirCategorias implements Task {

    private HomeExito homeExito;
    private CategoriaCeularesIphone categoriaCeularesIphone;

    public static AbrirCategorias elegirCategorias() {
        return Tasks.instrumented(AbrirCategorias.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(homeExito.MENU_CATEGORIAS),
                Click.on(homeExito.CATGORIA_CELULARES),
                Click.on(homeExito.CATEGORIA_IPHONE)
                //WaitUntil.the(homeExito.CATEGORIA_IPHONE, WebElementStateMatchers.isVisible()).forNoMoreThan(3).seconds()

        );

    }
}
