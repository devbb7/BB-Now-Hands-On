package bbNowOrderPlacement;

import files.Constants;
import files.Payload;
import files.RawToJSON;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class CreateOrder {
    @Then("I create order")
    public void createOrder() throws InterruptedException {
        Thread.sleep(3000);
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_entry_context);
        list.add(RequestHeaders.x_entry_context_id);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller);
        list.add(RequestHeaders.x_service);
        list.add(RequestHeaders.bb_decoded_mid);
        list.add(RequestHeaders.bb_decoded_vid);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI1();
        String order_response = given().log().all().headers(header).header("Content-Type","application/json").body(Payload.createOrderBody()).
                when().post("order/v1/order").then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = RawToJSON.rawToJson(order_response);
        Constants.order_id = js.getInt("orders[0].id");



    }
}
