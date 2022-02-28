package bbNowOrderPlacement;
import files.Constants;
import files.Payload;
import files.RequestHeaders;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class AddToCart {
    @Then("I add sku items {string} with quantity {string} to cart")
    public void addToCart(String sku_list,String qty_list){
        String[] sku_array = sku_list.split(",");
        String[] qty_array = qty_list.split(",");
        List<Header> list = new ArrayList<>();
        list.add(RequestHeaders.x_entry_context);
        list.add(RequestHeaders.x_entry_context_id);
        list.add(RequestHeaders.origin);
        list.add(RequestHeaders.bb_decoded_mid);
        list.add(RequestHeaders.bb_decoded_vid);
        Headers header = new Headers(list);
        baseURI = Constants.getBaseURI1();
        for(int i=0;i<sku_array.length;i++) {
            given().headers(header).header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                    body(Payload.addToCartBody(sku_array[i],qty_array[i])).when()
                    .post("basketService/msl/add-list-item-to-basket/")
                    .then().log().all().assertThat().statusCode(200);
        }
    }
}
