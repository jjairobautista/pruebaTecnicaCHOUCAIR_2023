package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeExito  extends PageObject {

    public static final Target MENU_CATEGORIAS = Target.the("Boton de Menu Horizontal de categorias")
            .located(By.id("category-menu"));
    public static final Target CATGORIA_CELULARES = Target.the("Categoria d celulares y accesorios")
            .located(By.id("undefined-nivel2-Celulares y accesorios"));
    public static final Target CATEGORIA_IPHONE = Target.the("SubCategoria Iphone Celulares")
            .located(By.xpath("//*[contains(text(),'Iphone')]"));

}
