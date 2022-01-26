package PickingBinningOperations;

import files.Constants;
import files.Payload;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class OrderBinning {
    @Then("I do order binning")
    public void orderBinning() throws InterruptedException {
        Thread.sleep(2000);
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller_picking);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.cookie);
        Headers header = new Headers(list);
        baseURI = Constants.baseURI2;
        given().log().all().headers(header).header("Content-Type","application/json").body(Payload.orderBinningBody()).
                when().post("warehousecomposition/admin/planogram/v1/fcs/"+Constants.getFc_id()+"/delivery/orderbinmapping").then().
                log().all().assertThat().statusCode(200);
    }
}
