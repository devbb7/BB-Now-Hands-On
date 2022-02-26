package files.pojo;

import java.util.List;

public class SkuInfoResponse {
    public List<SkuInfo> getSku_info() {
        return sku_info;
    }

    public void setSku_info(List<SkuInfo> sku_info) {
        this.sku_info = sku_info;
    }

    List<SkuInfo> sku_info;
}
