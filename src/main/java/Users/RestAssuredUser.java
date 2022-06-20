import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssuredUser {

    protected final String URL ="https://stellarburgers.nomoreparties.site/api";
    protected final String  CREATE_USER = "/auth/register"; // создание клиента
    protected final String  LOGIN = "/auth/login"; // логин в системе
    protected final String  UPDATE_DATA = "/auth/user"; //изменение данных
    protected final String  ORDERS = "/orders"; // создание заказа


    protected final RequestSpecification reqSpec = given()
            .header("Content-type","application/json")
            .baseUri(URL);
}
