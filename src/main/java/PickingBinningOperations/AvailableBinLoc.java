package PickingBinningOperations;

import files.Constants;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AvailableBinLoc {
    @Then("I check for available bin location")
    public void availableBinLoc() throws InterruptedException {
        Thread.sleep(2000);
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller_picking);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.cookie);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI2();
        String location = given().headers(header).when().get("warehousecomposition/admin/planogram/v1/fcs/"+Constants.getFc_id()+"/delivery/binrecommendation").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(location);
        Constants.available_bin_loc = js.getString("bin_loc");
    }
}
