package files;

import java.time.Instant;

import static files.Constants.po_order_id;

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

    public static String bagLinking(){
        return "{\n" +
                "  \"order_id\":"+ Constants.order_id_job+",\n" +
                "  \"container_label\":\""+Constants.bag_id+"\"\n" +
                "}";
    }

    public static String taskCompletion(){
        int len=Constants.bin_location.length();
        if(len==8){
            Constants.bin_loc_trimmed=Constants.bin_location;
        }
        else if(len==11) {
            Constants.bin_loc_trimmed = Constants.bin_location.substring(0, Constants.bin_location.length() - 3);
        }
        else if(len==10) {
            Constants.bin_loc_trimmed = Constants.bin_location.substring(0, Constants.bin_location.length() - 2);
        }
        return "{\n" +
                "        \"sku_info\" :\n" +
                "    [\n" +
                "        {\n" +
                "                   \n" +
                "                    \"available_qty\":" +Constants.available_qty+",\n"+
                "                    \"batch_id\":"+Constants.batch_id+",\n" +
                "                    \"bin_id\":"+Constants.bin_id+",\n" +
                "                    \"bin_location\":\""+Constants.bin_loc_trimmed+"\",\n" +
                "                \n" +
                "                    \"is_processed\":"+Constants.is_processed +",\n" +
                "                    \"location_id\":"+Constants.location_id+",\n" +
                "                    \"order_id\":"+ Constants.order_id_job+",\n" +
                "                    \"quantity_picked\":"+ Constants.quantity_recommended+",\n" +
                "                    \"quantity_recommended\":"+ Constants.quantity_recommended+",\n" +
                "                    \"quantity_weight\":"+Constants.quantity_weight+",\n" +
                "                    \"sequence_id\":"+Constants.sequence_id+",\n" +
                "                    \"sku_id\":"+ Constants.sku_id_assigned+",\n" +
                "                    \"task_id\":"+Constants.task_id+",\n" +
                "                    \"picking_timestamp\":\""+ Instant.now().toString()+"\",\n" +
                "                \n" +
                "            \"underpick_reason_id\": 0,\n" +
                "            \"crates\" :\n" +
                "                [\n" +
                "                                {\n" +
                "                                    \"type_id\": 0,\n" +
                "                                    \"label\":\""+ Constants.bag_id+"\",\n" +
                "                                    \"quantity\":"+Constants.quantity_recommended+",\n" +
                "                    \"weight\":"+Constants.quantity_weight+",\n" +
                "                    \"status\":\"open\",\n" +
                "                    \"pick_timestamp\":\""+Instant.now().toString()+"\"\n" +
                "                                }\n" +
                "                        ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public static String pickCompletionBody(){
        return "{\n" +
                "    \"job_id\":"+Constants.job_id+",\n" +
                "    \"order_id\":"+Constants.order_id_job +"\n" +
                "}\n";
    }

    public static String orderBinningBody(){
        return "{\n" +
                "  \"container_info\": [\n" +
                "    {\n" +
                "      \"id\":\""+Constants.bag_id +"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bin_loc\":\""+Constants.available_bin_loc+"\",\n" +
                "  \"event_type\": \"binning\",\n" +
                "  \"order_id\":"+Constants.order_id_job+"\n" +
                "}";
    }

}
