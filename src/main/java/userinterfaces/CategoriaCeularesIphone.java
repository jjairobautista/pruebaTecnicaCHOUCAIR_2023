package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;

public class CategoriaCeularesIphone extends Page {


    public static final Target CELULAR = Target.the("div con el celular ").
            locatedBy("//*[@id=\"gallery-layout-container\"]/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/button/div/div");

    public static final Target NOMBRE_CELULAR = Target.the("para obtener el nombre del producto seleccionado").
            locatedBy("//*[@id=\"gallery-layout-container\"]/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[1]/div/div/div[3]/div/div/div/h3");

    public static final Target UNIDADES_CELULAR = Target.the("Para obtener el numero de unidades seleccionadas ").
            locatedBy("//*[@id=\"gallery-layout-container\"]/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div");


    public static final Target AGREGAR = Target.the("boton para agregar una segunda unidad de un producto").
            locatedBy("//*[@id=\"gallery-layout-container\"]/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/button");
    public static final Target SUMAR = Target.the("Boton para realizar la suma de unidades cuando es mas de 2 unidades").
            locatedBy("//*[@id=\"gallery-layout-container\"]/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/button[2]");

    public static final Target IR_AL_CARRITO = Target.the("Boton para ir al carrito a realizar la validacion").
            locatedBy("/html/body/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[4]/div/a");


}
