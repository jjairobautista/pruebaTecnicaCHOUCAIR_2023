package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ValidarCarroDeCompras;
import tasks.Abrir;
import tasks.AbrirCategorias;
import tasks.ElegirProductos;

public class ValidacionCarrito {

    @Before
    public  void Onstage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado(":Que el usuario ingrese a la platafroma y elija categoria y subcategoria")
    public void queElUsuarioIngreseALaPlatafromaYElijaCategoriaYSubcategoria() {
        OnStage.theActorCalled("Jhon").wasAbleTo(Abrir.sitioWeb(),AbrirCategorias.elegirCategorias());
    }

    @Cuando(": Agregar productos aleatorios y cantidades aleatorias")
    public void agregarProductosAleatoriosYCantidadesAleatorias() {
        OnStage.theActorInTheSpotlight().attemptsTo(ElegirProductos.eleccionProductosAleatorias());

    }

    @Entonces(": Validar carrito de compras")
    public void validarCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCarroDeCompras.ValidacionDeArticulos()));

    }
}
