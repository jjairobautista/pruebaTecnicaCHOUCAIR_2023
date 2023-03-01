package tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Narrative;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import userinterfaces.CategoriaCeularesIphone;
import userinterfaces.HomeExito;

import java.util.ArrayList;
import java.util.Random;

public class ElegirProductos implements Task {

    private CategoriaCeularesIphone categoriaCeularesIphone;

    WebDriver driver;

    public static Performable eleccionProductosAleatorias() {
        return Tasks.instrumented(ElegirProductos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int pos;
        int nProductos = 8;
        ArrayList<Integer> prodEleccion = new ArrayList<>();

        ArrayList<String> nombreProductos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pos = (int) (Math.random() * nProductos + 1);
            while (prodEleccion.contains(pos)) {
                pos = (int) (Math.random() * nProductos + 1);
            }
            prodEleccion.add(pos);

        }

        for (int i = 0; i < prodEleccion.size(); i++) {
            int cUnidades = (int) (Math.random() * 5 + 1);

            if (cUnidades == 1) {
                actor.attemptsTo(
                        WaitUntil.the(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i))), WebElementStateMatchers.isVisible()).forNoMoreThan(3).seconds(),
                        Click.on(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i)))));
            } else if (cUnidades == 2) {
                actor.attemptsTo(
                        WaitUntil.the(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i))), WebElementStateMatchers.isVisible()).forNoMoreThan(3).seconds(),

                        Click.on(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i)))),
                        Click.on(categoriaCeularesIphone.AGREGAR.of(String.valueOf(prodEleccion.get(i)))));
            } else {
                        actor.attemptsTo(
                                WaitUntil.the(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i))), WebElementStateMatchers.isVisible()).forNoMoreThan(3).seconds(),

                                Click.on(categoriaCeularesIphone.CELULAR.of(String.valueOf(prodEleccion.get(i)))),
                                Click.on(categoriaCeularesIphone.AGREGAR.of(String.valueOf(prodEleccion.get(i)))));
                for (int j = 0; j < cUnidades - 2; j++) {
                    actor.attemptsTo(Click.on(categoriaCeularesIphone.SUMAR.of(String.valueOf(prodEleccion.get(i)))));
                }
            }
            String nombre = Text.of(categoriaCeularesIphone.NOMBRE_CELULAR.of(String.valueOf(prodEleccion.get(i)))).answeredBy(actor).toString();
            String unidadesP = (Text.of(categoriaCeularesIphone.UNIDADES_CELULAR.of(String.valueOf(prodEleccion.get(i)))).answeredBy(actor).toString());

                    nombreProductos.add(nombre + "["+unidadesP.charAt(0)+"]");

        }

        actor.attemptsTo(RememberThat.theValueOf("nomCantidad").is(nombreProductos));

        actor.attemptsTo(WaitUntil.the(categoriaCeularesIphone.IR_AL_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(3).seconds(),
                Click.on(categoriaCeularesIphone.IR_AL_CARRITO));
    }
}
