package files;

import io.restassured.http.Header;

import java.time.Instant;

public class RequestHeaders {
        public static Header x_entry_context = new Header("X-Entry-Context", Constants.entry_context_value);
        public static Header x_entry_context_id = new Header("X-Entry-Context-Id", "10");
        public static Header origin = new Header("origin", Constants.origin_value);
        public static Header bb_decoded_mid = new Header("bb-decoded-mid", Constants.getMemberID());
        public static Header bb_decoded_vid = new Header("bb-decoded-vid", Constants.getVid());
        public static Header bb_channel_type = new Header("bb-channel-type",Constants.bb_channel_type_value);
//        public static Header content_type = new Header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        public static Header x_timestamp = new Header("X-Timestamp", Instant.now().toString());
        public static Header x_tracker = new Header("X-Tracker","a22b81a3-ad24-456b-ab9d-aa0710307755");
        public static Header x_caller = new Header("X-Caller","123");
        public static Header x_service = new Header("X-Service","123");
        public static Header cookie = new Header("Cookie","BBADMINAUTHTOKEN="+Constants.getBBADMINAUTHTOKEN());
        public static Header x_caller_picking = new Header("X-Caller",Constants.x_caller_value_picking);
        public static Header x_entry_context_id_picking = new Header("X-Entry-Context-Id",Constants.x_entry_context_id_picking);
        public static Header x_entry_context_picking = new Header( "X-Entry-Context",Constants.x_entry_context_picking);
}
