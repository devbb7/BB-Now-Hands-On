package PickingBinningOperations;
import files.Constants;
import files.RawToJSON;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;

import static files.Constants.*;
import static io.restassured.RestAssured.*;

import java.time.Instant;
import java.util.*;


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

        picking_size  = js.getInt("picking.size()");
        sku_loc_size_array =new int[picking_size][];
        job_id_arr = new int[picking_size];
        bag_id_arr = new String[picking_size];
        available_quantity_arr = new int[picking_size][];
        batch_id_arr = new int[picking_size][];
        bin_id_arr = new int[picking_size][];
        bin_loc_arr = new String[picking_size][];
        is_processed_arr = new boolean[picking_size][];
        location_id_arr = new int[picking_size][];
        order_id_job_arr = new int[picking_size][];
        quantity_recommended_arr = new int[picking_size][];
        quantity_weight_arr = new int[picking_size][];
        sequence_id_arr = new int[picking_size][];
        sku_id_assigned_arr = new int[picking_size][];
        task_id_arr = new int[picking_size][];
        crate_info_arr = new Object[picking_size][];
        bin_loc_trimmed1=null;
        sku_info_internal = new Object[picking_size][];
        sku_info_merged = new Object[picking_size];

        for(int i=0;i<picking_size;i++) {
            job_id_arr[i] = js.getInt("picking[" + i + "].job_id");
            bag_id_arr[i] = "BB"+(int)(Math.random()*(9999999-1000000+1)+1000000);
        }

        for (int i = 0; i < picking_size; i++) {
            int sku_loc_size = js.getInt("picking[" + i + "].sku_location_info.size()");
            sku_loc_size_array[i] = new int[sku_loc_size];
            available_quantity_arr[i] = new int[sku_loc_size];
            batch_id_arr[i] = new int[sku_loc_size];
            bin_id_arr[i] = new int[sku_loc_size];
            bin_loc_arr[i] = new String[sku_loc_size];
            is_processed_arr[i] = new boolean[sku_loc_size];
            location_id_arr[i] = new int[sku_loc_size];
            order_id_job_arr[i] = new int[sku_loc_size];
            quantity_recommended_arr[i] = new int[sku_loc_size];
            quantity_weight_arr[i] = new int[sku_loc_size];
            sequence_id_arr[i] = new int[sku_loc_size];
            sku_id_assigned_arr[i] = new int[sku_loc_size];
            task_id_arr[i] = new int[sku_loc_size];
            sku_info_internal[i] = new Object[sku_loc_size];
            crate_info_arr[i]= new Object[sku_loc_size];
        }
        for(int i=0;i<picking_size;i++){
            for(int j=0;j<sku_loc_size_array[i].length;j++){
                available_quantity_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].available_qty");
                batch_id_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].batch_id");
                bin_id_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].bin_id");
                bin_loc_arr[i][j] = js.getString("picking["+i+"].sku_location_info["+j+"].bin_location");
                is_processed_arr[i][j] = js.getBoolean("picking["+i+"].sku_location_info["+j+"].is_processed");
                location_id_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].location_id");
                order_id_job_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].order_id");
                quantity_recommended_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].quantity_recommended");
                quantity_weight_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].quantity_weight");
                sequence_id_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].sequence_id");
                sku_id_assigned_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].sku_id");
                task_id_arr[i][j] = js.getInt("picking["+i+"].sku_location_info["+j+"].task_id");
            }
        }

        for(int i=0;i<picking_size;i++){
            for(int j=0;j<sku_loc_size_array[i].length;j++){
                Map<String,Object> crates_info = new HashMap<>();
                crates_info.put("type_id",0);
                crates_info.put("label",bag_id_arr[i]);
                crates_info.put("quantity",quantity_recommended_arr[i][j]);
                crates_info.put("weight",quantity_weight_arr[i][j]);
                crates_info.put("status","open");
                crates_info.put("pick_timestamp", Instant.now().toString());
                JSONObject crate_json = new JSONObject(crates_info);
                JSONArray ja = new JSONArray();
                ja.put(crate_json);
                    crate_info_arr[i][j] = ja;
                }
            }
            for(int i=0;i<picking_size;i++){
                for(int j=0;j<sku_loc_size_array[i].length;j++){
                    Map<String,Object> sku_info = new HashMap<>();
                    sku_info.put("available_qty",available_quantity_arr[i][j]);
                    sku_info.put("batch_id",batch_id_arr[i][j]);
                    sku_info.put("bin_id",bin_id_arr[i][j]);
                    int len=bin_loc_arr[i][j].length();
                    if(len==8)
                        bin_loc_trimmed1=bin_loc_arr[i][j];
                    else if(len==11)
                        bin_loc_trimmed1 = bin_loc_arr[i][j].substring(0, len - 3);
                    else if(len==10)
                        bin_loc_trimmed1 = bin_loc_arr[i][j].substring(0, len - 2);
                    sku_info.put("bin_location",bin_loc_trimmed1);
                    sku_info.put("is_processed",is_processed_arr[i][j]);
                    sku_info.put("location_id",location_id_arr[i][j]);
                    sku_info.put("order_id",order_id_job_arr[i][j]);
                    sku_info.put("quantity_picked",quantity_recommended_arr[i][j]);
                    sku_info.put("quantity_recommended",quantity_recommended_arr[i][j]);
                    sku_info.put("quantity_weight",quantity_weight_arr[i][j]);
                    sku_info.put("sequence_id",sequence_id_arr[i][j]);
                    sku_info.put("sku_id",sku_id_assigned_arr[i][j]);
                    sku_info.put("task_id",task_id_arr[i][j]);
                    sku_info.put("picking_timestamp",Instant.now().toString());
                    sku_info.put("underpick_reason_id",0);
                    sku_info.put("crates", crate_info_arr[i][j]);
                    JSONObject sku_details_json;
                    sku_details_json = new JSONObject(sku_info);
                    sku_info_internal[i][j] = sku_details_json;
                }
            }

            for(int i=0;i<picking_size;i++){
                Map<String,Object> map = new HashMap<>();
                map.put("sku_info",sku_info_internal[i]);
                JSONObject json = new JSONObject(map);
                sku_info_merged[i]= json;
            }
        }
}
