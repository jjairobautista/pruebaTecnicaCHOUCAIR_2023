package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import userinterfaces.CarritoDeCompras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static net.serenitybdd.screenplay.questions.Text.*;

public class ValidarCarroDeCompras implements Question<Boolean> {

    private CarritoDeCompras carritoDeCompras;
    WebDriver driver ;
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

            String nombre = of(carritoDeCompras.NOMBRE_PRODUCTO.of(String.valueOf(i + 1))).answeredBy(actor).toString();
            String unidades = of(carritoDeCompras.UNIDADES_DE_PRODUCTOS.of(String.valueOf(i + 1))).answeredBy(actor).toString();

            System.out.println(unidades + " Cantidad de Productos");

            comparar.add(nombre);
        }

         Collections.sort(valores);
        Collections.sort(comparar);


        System.out.println(valores.toString());
        System.out.println(comparar.toString());
        if (comparar.toString().equals(valores.toString())) {
            return true;
        }

        /**
       for (int i = 0; i < valores.size(); i++) {
            for (int j = 0; j < comparar.size(); j++) {



                if (valores.get(i).equals(comparar.get(j))){
                    System.out.println("ProductoEncontrado" + valores.get(i));
                    break;
                }
            }
        }

 */




         return false;
    }
}
