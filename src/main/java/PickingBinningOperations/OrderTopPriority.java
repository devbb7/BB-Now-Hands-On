package PickingBinningOperations;

import files.Constants;
import files.Payload;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;

public class OrderTopPriority {
    @Then("I make order top priority")
    public void orderTopPriority() throws InterruptedException {
        Thread.sleep(10000);
        baseURI = Constants.getBaseURI1();
        given().log().all().header("Content-Type","application/json").body(Payload.orderTopPriorityBody()).when().
                post("pickingplatform/internal/v1/perform_picking_operation").then().
                log().all().assertThat().statusCode(200);
        Thread.sleep(2000);
    }

    @Then("I make order id {string} top priority")
    public void iMakeOrderIdTopPriority(String order_id) throws InterruptedException {
        Constants.order_id=Integer.parseInt(order_id);
        baseURI = Constants.getBaseURI1();
        given().log().all().header("Content-Type","application/json").body(Payload.orderTopPriorityBody()).when().
                post("pickingplatform/internal/v1/perform_picking_operation").then().
                log().all().assertThat().statusCode(200);
        Thread.sleep(2000);
    }
}
