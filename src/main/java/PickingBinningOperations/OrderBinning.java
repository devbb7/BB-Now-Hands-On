package PickingBinningOperations;

import files.Constants;
import files.Payload;
import files.RawToJSON;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;

import static files.Constants.picking_size;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class OrderBinning {

    @Then("I check for available bin location and bin the order")
    public void iCheckForAvailableBinLocationAndBinTheOrder() throws InterruptedException {
        Thread.sleep(2000);
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller_picking);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.cookie);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI2();
        for(int i=0;i<picking_size;i++) {
            String location = given().headers(header).when().get("warehousecomposition/admin/planogram/v1/fcs/" + Constants.getFc_id() + "/delivery/binrecommendation").
                    then().log().all().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = RawToJSON.rawToJson(location);
            Constants.available_bin_loc = js.getString("bin_loc");
            given().log().all().headers(header).header("Content-Type", "application/json").body(Payload.orderBinningBody(i)).
                    when().post("warehousecomposition/admin/planogram/v1/fcs/" + Constants.getFc_id() + "/delivery/orderbinmapping").then().
                    log().all().assertThat().statusCode(200);
        }

    }
}
