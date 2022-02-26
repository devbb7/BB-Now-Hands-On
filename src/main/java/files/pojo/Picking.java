package files.pojo;

import java.util.List;

public class Picking {
    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public List<SkuLocationInfo> getSku_location_info() {
        return sku_location_info;
    }

    public void setSku_location_info(List<SkuLocationInfo> sku_location_info) {
        this.sku_location_info = sku_location_info;
    }

    private int job_id;
    private String job_status;
    private List<SkuLocationInfo> sku_location_info;
}
