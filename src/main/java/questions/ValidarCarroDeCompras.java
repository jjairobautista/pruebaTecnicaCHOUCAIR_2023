package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import userinterfaces.CarritoDeCompras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.questions.Text.*;

public class ValidarCarroDeCompras implements Question<Boolean> {

    private CarritoDeCompras carritoDeCompras;


    ArrayList<String> valores = new ArrayList<String>();

    public static Question<Boolean> ValidacionDeArticulos() {
        return new ValidarCarroDeCompras();
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        valores = actor.recall("nomCantidad");
        ArrayList<String> comparar = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            actor.attemptsTo(WaitUntil.the(carritoDeCompras.NOMBRE_PRODUCTO.of(String.valueOf(i + 1)), WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds());

            String nombre = Text.of(carritoDeCompras.NOMBRE_PRODUCTO.of(String.valueOf(i + 1))).answeredBy(actor).toString();

            String unidades = (carritoDeCompras.UNIDADES_DE_PRODUCTOS.of(String.valueOf(i + 1))).resolveAllFor(actor).stream()
                    .map(element -> element.getAttribute("value")).collect(Collectors.toList()).toString();


            comparar.add(nombre + unidades);
        }

        Collections.sort(valores);
        Collections.sort(comparar);


        System.out.println("Compra : "+valores.toString());
        System.out.println("Carrito: "+comparar.toString());
        if (comparar.toString().equals(valores.toString())) {
            return true;
        }
        return false;
    }
}
