package files.pojo;

public class Crates {
    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPick_timestamp() {
        return pick_timestamp;
    }

    public void setPick_timestamp(String pick_timestamp) {
        this.pick_timestamp = pick_timestamp;
    }

    private int type_id;
    private String label;
    private int quantity;
    private int weight;
    private String status;
    private String pick_timestamp;
}
