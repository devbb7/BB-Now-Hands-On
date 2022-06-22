package bbNowOrderPlacement;

import files.Constants;
import files.Payload;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentSuccess {
    @Then("I do payment success")
    public void paymentSuccess() throws InterruptedException {
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_entry_context);
        list.add(RequestHeaders.x_entry_context_id);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_service);
        list.add(RequestHeaders.x_caller);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI1();
        Thread.sleep(5000);
        given().log().all().headers(header).header("Content-Type","application/json").body(Payload.paymentSuccessBody()).
                when().post("order/internal/v1/order/payment_status").then().
                log().all().assertThat().statusCode(200);

    }
}
