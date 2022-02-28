package files;

import files.pojo.JobAssignmentResponse;
import files.pojo.Picking;
import files.pojo.SkuLocationInfo;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static String env_type;
    public static String baseURI1;
    public static void setBaseURI1(){
        if(env_type.equals("QAS")){
            baseURI1 = "http://qa-svc.bigbasket.com";
        }
        else baseURI1 = "http://uat-svc.bigbasket.com";
    }
    public static String getBaseURI1(){
        return baseURI1;
    }
    public static String fc_id;
    public static void setFc_id(){
        if(env_type.equals("QAS")){
            fc_id="236";
        }
        else fc_id="234";
    }
    public static String getFc_id(){
        return fc_id;
    }
    public static String baseURI2;
    public static void setBaseURI2(){
        if(env_type.equals("QAS")){
            baseURI2 = "https://qa.bigbasket.com";
        }
        else baseURI2 = "https://uat3.bigbasket.com";
    }
    public static String getBaseURI2(){
        return baseURI2;
    }
    static String memberID;
    public static void setMemberID(){
        if(env_type.equals("QAS")){
            memberID="20049181";
        }
        else memberID="19994818";
    }
    public static String getMemberID(){
        return memberID;
    }
    static String vid;
    public static void setVid(){
        if(env_type.equals("QAS")){
             vid="20049181";
        }
        else vid="19994818";
    }
    public static String getVid(){
        return vid;
    }
    static String memberAddr;
    public static void setMemberAddr(){
        if(env_type.equals("QAS")){
            memberAddr="157260148";
        }
        else memberAddr="157228451";
    }
    public static String getMemberAddr(){
        return memberAddr;
    }
    static String entry_context_value = "bbnow";
    static String origin_value = "https://qas31.bigbasket.com";
    static String bb_channel_type_value = "bb-ios";
    public static String po_order_id;
    public static int order_id;
    public static String BBADMINAUTHTOKEN;
    public static void setBBADMINAUTHTOKEN(){
        if(env_type.equals("QAS")){
            BBADMINAUTHTOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFmZiI6IldCV0RSb3VXMVU4TEJRIiwidWlkIjoyMDg1OTUsInRpbWUiOjE2Mzk3NDY1NjkuMDUxNDYzfQ.AxUTloSxRNm168egg5RQnTDiSbmAH0YZLOGcM9hJiAk";
        }
        else BBADMINAUTHTOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFmZiI6IkF6WGRlLVFUNHdid0FBIiwidWlkIjoyMTAwMzYsInRpbWUiOjE2NDA2NzY4MzcuODAxOTk1fQ.K9JfDVDu-wk5TH08_biYkdE0fsdGCM-uOZwinW0PZkU";
    }
    public static String getBBADMINAUTHTOKEN(){
        return BBADMINAUTHTOKEN;
    }
    static String x_caller_value_picking ="IQ-APP";
    static String x_entry_context_id_picking = "102";
    static String x_entry_context_picking = "bb_internal";
    public static int picking_size;
    public static JobAssignmentResponse jobAssignmentResponse;
    public static List<Picking> pickingList = new ArrayList<>();
    public static List<SkuLocationInfo> skuLocationInfoList= new ArrayList<>();
    public static List<Integer> order_id_picking= new ArrayList<>();
    public static List<Integer> job_id_picking = new ArrayList<>();
    public static List<String> bag_id = new ArrayList<>();
    public static String  available_bin_loc;

}
