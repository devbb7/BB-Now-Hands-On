package bbNowOrderPlacement;
import files.Constants;
import files.Payload;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class AddToCart {
    @Then("I add items to cart")
    public void addToCart(){
        List<Header> list = new ArrayList<Header>();
        list.add(RequestHeaders.x_entry_context);
        list.add(RequestHeaders.x_entry_context_id);
        list.add(RequestHeaders.origin);
        list.add(RequestHeaders.bb_decoded_mid);
        list.add(RequestHeaders.bb_decoded_vid);;
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI1();
        given().headers(header).header("Content-Type","application/x-www-form-urlencoded; charset=UTF-8").
                body(Payload.addToCartBody()).when()
                .post("basketService/msl/add-list-item-to-basket/")
                .then().log().all().assertThat().statusCode(200);
    }
}
