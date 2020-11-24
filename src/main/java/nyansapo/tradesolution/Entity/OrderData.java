package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;

public class OrderData {

    @JsonProperty("product")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("price")
    private  Double price;

    @JsonProperty("side")
    private  String side;

    @JsonProperty("cumulatitiveQuantity")
    private int cumulatitiveQty;

    private String exchange_Path;

    public OrderData(){}

    public OrderData(String productName, int quantity, Double price, String side, int cumulatitiveQty, String exchange_Path) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.cumulatitiveQty = cumulatitiveQty;
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

    public void setCumulatitiveQty(int cumulatitiveQty) {
        this.cumulatitiveQty = cumulatitiveQty;
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

    public int getCumulatitiveQty() {
        return cumulatitiveQty;
    }

    public String getExchange_Path() {
        return exchange_Path;
    }



    public  static Comparator<OrderData> sortByLowPrice = (data1, data2) -> Double.compare(data1.price, data2.price);
    public  static Comparator<OrderData> sortByHighPrice = (data1, data2) -> Double.compare(data1.price, data2.price);
}
