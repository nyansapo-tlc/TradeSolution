package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderEntity {
    @JsonProperty("")
    private int orderID;

    @JsonProperty("")
    private int userID;

    @JsonProperty("")
    private int PortfolioID;

    @JsonProperty("")
    private  String ticker;

    @JsonProperty("")
    private String side;

    @JsonProperty("")
    private boolean status;

    @JsonProperty("")
    private double amount;

    @JsonProperty("")
    private int quantity;

    public OrderEntity () {}

    public OrderEntity(int orderID, int userID, int portfolioID, String ticker, String side, boolean status, double amount, int quantity) {
        this.orderID = orderID;
        this.userID = userID;
        PortfolioID = portfolioID;
        this.ticker = ticker;
        this.side = side;
        this.status = status;
        this.amount = amount;
        this.quantity = quantity;
    }

    //setters
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPortfolioID(int portfolioID) {
        PortfolioID = portfolioID;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    //getters
    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getPortfolioID() {
        return PortfolioID;
    }

    public String getTicker() {
        return ticker;
    }

    public String getSide() {
        return side;
    }

    public boolean isStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }
    public int getQuantity() {
        return quantity;
    }
}
