package nyansapo.tradesolution.Entity;

public class RequestOrder {
    private String product;
    private int quantity;
    private Double price;
    private String side;
    private String baseURL;

    public RequestOrder() {
    }

    public RequestOrder(String product, int quantity, Double price, String side, String baseURL) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.baseURL = baseURL;
    }

    //setters

    public void setProduct(String product) {
        this.product = product;
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

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    //getters

    public String getProduct() {
        return product;
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

    public String getBaseURL() {
        return baseURL;
    }


}
