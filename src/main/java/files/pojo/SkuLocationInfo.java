package files.pojo;

import java.util.List;

public class SkuLocationInfo {
    public int getAvailable_qty() {
        return available_qty;
    }

    public void setAvailable_qty(int available_qty) {
        this.available_qty = available_qty;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getBin_id() {
        return bin_id;
    }

    public void setBin_id(int bin_id) {
        this.bin_id = bin_id;
    }

    public String getBin_location() {
        return bin_location;
    }

    public void setBin_location(String bin_location) {
        this.bin_location = bin_location;
    }

    public boolean isIs_processed() {
        return is_processed;
    }

    public void setIs_processed(boolean is_processed) {
        this.is_processed = is_processed;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQuantity_picked() {
        return quantity_picked;
    }

    public void setQuantity_picked(int quantity_picked) {
        this.quantity_picked = quantity_picked;
    }

    public int getQuantity_recommended() {
        return quantity_recommended;
    }

    public void setQuantity_recommended(int quantity_recommended) {
        this.quantity_recommended = quantity_recommended;
    }

    public int getQuantity_weight() {
        return quantity_weight;
    }

    public void setQuantity_weight(int quantity_weight) {
        this.quantity_weight = quantity_weight;
    }

    public int getSequence_id() {
        return sequence_id;
    }

    public void setSequence_id(int sequence_id) {
        this.sequence_id = sequence_id;
    }

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUnderpick_reason_id() {
        return underpick_reason_id;
    }

    public void setUnderpick_reason_id(int underpick_reason_id) {
        this.underpick_reason_id = underpick_reason_id;
    }

    public List<Crates> getCrates() {
        return crates;
    }

    public void setCrates(List<Crates> crates) { this.crates = crates; }


    private int available_qty;
    private int batch_id;
    private int bin_id;
    private String bin_location;
    private boolean is_processed;
    private int location_id;
    private int order_id;
    private int quantity_picked;
    private int quantity_recommended;
    private int quantity_weight;
    private int sequence_id;
    private int sku_id;
    private int task_id;
    private int underpick_reason_id;
    private List<Crates> crates;

}
