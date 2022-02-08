package files;

import org.json.JSONObject;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static files.Constants.*;

public class Payload {
    public static String addToCartBody(){
        return "items[]="+Constants.getSku()+"_"+Constants.sku_quantity+"&slug=";
    }

    public static String createPOBody(){
        return "{\n" +
                "    \"member_address_id\":"+Constants.getMemberAddr()+",\n" +
                "    \"is_qc\": false\n" +
                "}";
    }

    public static String createOrderBody(){
        return "{\n" +
                "  \"po\": {\n" +
                "    \"id\":"+po_order_id  +
                "  },\n" +
                "  \"payment\":{\n" +
                "\t\"payment_method\":\"NB_HDFC\",\n" +
                "\t\"bb_txn_id\":\"a0f70076751ebedcb50c\",\n" +
                "\t\"payment_method_type\":\"NB_HDFC\",\n" +
                "\t\"wallet\":false\n" +
                "  }\n" +
                "}";
    }

    public static String paymentSuccessBody(){
        return  "{\n" +
                "  \"app_version\": \"4.11.0\",\n" +
                "  \"txn_type\": \"checkout\",\n" +
                "  \"payment_status\": \"success\",\n" +
                "  \"purchased_txn_list\": [\n" +
                Constants.order_id     +
                "  ],\n" +
                "  \"bb_txn_id\": \"4a5223beccd0f2e8a276\",\n" +
                "  \"discount\": \"0.0\",\n" +
                "  \"device\": \"android\",\n" +
                "  \"payment_method\": \"NB_HDFC\",\n" +
                "  \"tcp_loyalty_points\": 0,\n" +
                "  \"payment_amount\": 11110.00\n" +
                "}";
    }

    public static String orderTopPriorityBody(){
        return "{\n" +
                "\"order_id\": "+Constants.order_id +
                "}";
    }

    public static String bagLinking(int index){
        return "{\n" +
                "  \"order_id\":"+order_id_job_arr[index][0]+",\n" +
                "  \"container_label\":\""+bag_id_arr[index]+"\"\n" +
                "}";
    }



    public static String taskCompletion(int index){
        return sku_info_merged[index].toString();
    }

    public static String pickCompletionBody(int index){
        return "{\n" +
                "    \"job_id\":"+job_id_arr[index]+",\n" +
                "    \"order_id\":"+order_id_job_arr[index][0] +"\n" +
                "}\n";
    }

    public static String orderBinningBody(int index){
        return "{\n" +
                "  \"container_info\": [\n" +
                "    {\n" +
                "      \"id\":\""+bag_id_arr[index] +"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bin_loc\":\""+Constants.available_bin_loc+"\",\n" +
                "  \"event_type\": \"binning\",\n" +
                "  \"order_id\":"+order_id_job_arr[index][0]+"\n" +
                "}";
    }

}
