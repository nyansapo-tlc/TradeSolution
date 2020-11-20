package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OderData {

    @JsonProperty("product")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("price")
    private  Double price;

    @JsonProperty("side")
    private  String side;

    private String exchange_Path;

    public OderData (){}

    public OderData (String productName, int quantity, Double price, String side, String exchange_Path) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.exchange_Path = exchange_Path;
    }

    //Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setExchange_Path(String exchange_Path) {
        this.exchange_Path = exchange_Path;
    }

    //Getter

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getSide() {
        return side;
    }

    public String getExchange_Path() {
        return exchange_Path;
    }
}
