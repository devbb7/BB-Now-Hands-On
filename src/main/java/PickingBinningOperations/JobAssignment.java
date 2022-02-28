package PickingBinningOperations;
import com.google.gson.Gson;
import files.Constants;

import files.RequestHeaders;
import java.util.*;
import files.pojo.JobAssignmentResponse;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static files.Constants.*;

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
        jobAssignmentResponse =  given().log().all().headers(header).when().post("warehousecomposition/admin/v1/fcs/"+Constants.getFc_id()+"/jobs").as(JobAssignmentResponse.class);
        Gson g = new Gson();
        System.out.println(g.toJsonTree(jobAssignmentResponse));
        pickingList = jobAssignmentResponse.getPicking();
        picking_size = jobAssignmentResponse.getPicking().size();
        for(int i=0;i<picking_size;i++) {
            bag_id.add("BB" + (int) (Math.random() * (9999999 - 1000000 + 1) + 1000000));
            job_id_picking.add(pickingList.get(i).getJob_id());
            skuLocationInfoList = pickingList.get(i).getSku_location_info();
            order_id_picking.add(skuLocationInfoList.get(i).getOrder_id());
        }

        }
}
