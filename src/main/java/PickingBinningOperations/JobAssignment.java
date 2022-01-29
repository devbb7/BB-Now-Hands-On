package PickingBinningOperations;
import files.Constants;
import files.RawToJSON;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


public class JobAssignment {
    @Then("I do job assignment")
    public void jobAssignment() {
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller_picking);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.x_entry_context_id_picking);
        list.add(RequestHeaders.x_entry_context_picking);
        list.add(RequestHeaders.cookie);
        Headers header = new Headers(list);

        baseURI = Constants.getBaseURI2();
        String job_assignment_response = given().log().all().headers(header).when().post("warehousecomposition/admin/v1/fcs/"+Constants.getFc_id()+"/jobs").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = RawToJSON.rawToJson(job_assignment_response);
        Constants.job_id = js.getInt("picking[0].job_id");
        Constants.available_qty = js.getInt("picking[0].sku_location_info[0].available_qty");
        Constants.batch_id = js.getInt("picking[0].sku_location_info[0].batch_id");
        Constants.bin_id = js.getInt("picking[0].sku_location_info[0].bin_id");
        Constants.bin_location = js.getString("picking[0].sku_location_info[0].bin_location");
        Constants.is_processed = js.getBoolean("picking[0].sku_location_info[0].is_processed");
        Constants.location_id = js.getInt("picking[0].sku_location_info[0].location_id");
        Constants.quantity_recommended = js.getInt("picking[0].sku_location_info[0].quantity_recommended");
        Constants.quantity_weight = js.getInt("picking[0].sku_location_info[0].quantity_weight");
        Constants.sequence_id = js.getInt("picking[0].sku_location_info[0].sequence_id");
        Constants.sku_id_assigned = js.getInt("picking[0].sku_location_info[0].sku_id");
        Constants.task_id = js.getInt("picking[0].sku_location_info[0].task_id");
        Constants.order_id_job=js.getInt("picking[0].sku_location_info[0].order_id");


    }
}
