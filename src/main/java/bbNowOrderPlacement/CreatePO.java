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

public class CreatePO {
    @Then("I create PO order")
    public void createPO() throws InterruptedException {
        Thread.sleep(3000);
        List<Header> list = new ArrayList<Header>();
        list.add(RequestHeaders.x_entry_context);
        list.add(RequestHeaders.x_entry_context_id);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller);
        list.add(RequestHeaders.bb_decoded_mid);
        list.add(RequestHeaders.bb_decoded_vid);
        list.add(RequestHeaders.bb_channel_type);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI1();

        String po_order_response = given().log().all().headers(header).body(Payload.createPOBody()).when().
                    post("/order/internal/v1/potentialorder").then().log().all().assertThat().statusCode(200).
                    extract().response().asString();
        JsonPath js = RawToJSON.rawToJson(po_order_response);
        Constants.po_order_id = js.getString("p_order_id");
    }
    }
