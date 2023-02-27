package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.devtools.v85.page.Page;

public class CarritoDeCompras extends Page {

    public static final Target NOMBRE_PRODUCTO = Target.the("nombre de los productos en el carrito ").
            locatedBy("/html/body/div[5]/div[3]/div[1]/div[1]/div[2]/table/tbody/tr[{0}]/td[2]/a[1]");
    public static final Target UNIDADES_DE_PRODUCTOS = Target.the("cantidad de unidades en el carrito ").
            locatedBy("/html/body/div[5]/div[3]/div[1]/div[1]/div[2]/table/tbody/tr[{0}]/td[5]");

}
