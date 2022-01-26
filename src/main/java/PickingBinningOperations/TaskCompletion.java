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

public class TaskCompletion {
    @Then("I do task completion")
    public void taskCompletion() throws InterruptedException {
        Thread.sleep(3000);
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_tracker);
        list.add(RequestHeaders.x_caller_picking);
        list.add(RequestHeaders.x_timestamp);
        list.add(RequestHeaders.x_entry_context_id_picking);
        list.add(RequestHeaders.x_entry_context_picking);
        list.add(RequestHeaders.cookie);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI2();
        given().log().all().headers(header).header("Content-Type","application/json").
                body(Payload.taskCompletion()).when().put("warehousecomposition/admin/planogram/v1/fcs/"+Constants.getFc_id()+"/picking/jobs/"+ Constants.job_id)
                .then().log().all().assertThat().statusCode(200);
    }
}
