package files;

import com.google.gson.Gson;
import files.pojo.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static files.Constants.*;

public class Payload {
    public static String addToCartBody(String sku,String qty){
        return "items[]="+sku+"_"+qty+"&slug=";
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
                "  \"order_id\":"+order_id_picking.get(index)+",\n" +
                "  \"container_label\":\""+bag_id.get(index)+"\"\n" +
                "}";
    }


    public static String taskCompletion(int index){
        List<SkuLocationInfo> skuInfopicking = pickingList.get(index).getSku_location_info();
        List<SkuInfo> skuInfosarray = new ArrayList<>();
        SkuInfoResponse sku_payload = new SkuInfoResponse() ;
        for(int i=0;i<skuInfopicking.size();i++) {
            SkuInfo skuInfo = new SkuInfo();
            skuInfo.setAvailable_qty(skuInfopicking.get(i).getAvailable_qty());
            skuInfo.setBatch_id(skuInfopicking.get(i).getBatch_id());
            skuInfo.setBin_id(skuInfopicking.get(i).getBin_id());

            String bin_loc_trimmed = null;
            int len=skuInfopicking.get(i).getBin_location().length();
            if(len==8)
                bin_loc_trimmed = skuInfopicking.get(i).getBin_location();
            else if(len==11)
                bin_loc_trimmed = skuInfopicking.get(i).getBin_location().substring(0, len - 3);
            else if(len==10)
                bin_loc_trimmed = skuInfopicking.get(i).getBin_location().substring(0, len - 2);
            skuInfo.setBin_location(bin_loc_trimmed);

            skuInfo.setIs_processed(skuInfopicking.get(i).isIs_processed());
            skuInfo.setLocation_id(skuInfopicking.get(i).getLocation_id());
            skuInfo.setOrder_id(order_id_picking.get(index));
            skuInfo.setQuantity_picked(skuInfopicking.get(i).getQuantity_recommended());
            skuInfo.setQuantity_recommended(skuInfopicking.get(i).getQuantity_recommended());
            skuInfo.setQuantity_weight(skuInfopicking.get(i).getQuantity_weight());
            skuInfo.setSequence_id(skuInfopicking.get(i).getSequence_id());
            skuInfo.setSku_id(skuInfopicking.get(i).getSku_id());
            skuInfo.setTask_id(skuInfopicking.get(i).getTask_id());
            skuInfo.setPicking_timestamp(Instant.now().toString());
            skuInfo.setUnderpick_reason_id(skuInfopicking.get(i).getUnderpick_reason_id());
            Crates crates = new Crates();
            crates.setLabel(bag_id.get(index));
            crates.setPick_timestamp(Instant.now().toString());
            crates.setQuantity(skuInfopicking.get(i).getQuantity_recommended());
            crates.setStatus("open");
            crates.setWeight(skuInfopicking.get(i).getQuantity_weight());
            crates.setType_id(0);
            List<Crates> cratesList = new ArrayList<>();
            cratesList.add(crates);
            skuInfo.setCrates(cratesList);
            skuInfosarray.add(skuInfo);
        }
        sku_payload.setSku_info(skuInfosarray);
        Gson gson = new Gson();
        return gson.toJson(sku_payload);
    }

    public static String pickCompletionBody(int index){
        return "{\n" +
                "    \"job_id\":"+job_id_picking.get(index)+",\n" +
                "    \"order_id\":"+order_id_picking.get(index)+"\n" +
                "}\n";
    }

    public static String orderBinningBody(int index){
        return "{\n" +
                "  \"container_info\": [\n" +
                "    {\n" +
                "      \"id\":\""+bag_id.get(index)+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bin_loc\":\""+Constants.available_bin_loc+"\",\n" +
                "  \"event_type\": \"binning\",\n" +
                "  \"order_id\":"+order_id_picking.get(index)+"\n" +
                "}";
    }

}
