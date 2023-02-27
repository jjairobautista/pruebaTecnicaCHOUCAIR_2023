package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LastResponseStatusCode implements Question<Boolean> {


    public static LastResponseStatusCode is() {
        return new LastResponseStatusCode();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        int codeResponse = lastResponse().statusCode();

        System.out.println(codeResponse);
        if (codeResponse == 200) {
            return true;
        }
        return false;
    }
}
