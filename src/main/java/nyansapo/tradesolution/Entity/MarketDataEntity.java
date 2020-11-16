package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketDataEntity {
    @JsonProperty("LAST_TRADED_PRICE")
    private double last_traded_price;

    @JsonProperty("BID_PRICE")
    private double bid_price;

    @JsonProperty("SELL_LIMIT")
    private int sell_limit;

    @JsonProperty("TICKER")
    private String ticker;

    @JsonProperty("MAX_PRICE_SHIFT")
    private int max_price_shift;

    @JsonProperty("ASK_PRICE")
    private double ask_price;

    @JsonProperty("BUY_LIMIT")
    private int buy_limit;

    public MarketDataEntity() {
    }

    public MarketDataEntity(double last_traded_price, double bid_price, int sell_limit, String ticker, int max_price_shift, double ask_price, int buy_limit) {
        this.last_traded_price = last_traded_price;
        this.bid_price = bid_price;
        this.sell_limit = sell_limit;
        this.ticker = ticker;
        this.max_price_shift = max_price_shift;
        this.ask_price = ask_price;
        this.buy_limit = buy_limit;
    }

    //setters
    public void setLast_traded_price(double last_traded_price) {
        this.last_traded_price = last_traded_price;
    }

    public void setBid_price(double bid_price) {
        this.bid_price = bid_price;
    }

    public void setSell_limit(int sell_limit) {
        this.sell_limit = sell_limit;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setMax_price_shift(int max_price_shift) {
        this.max_price_shift = max_price_shift;
    }

    public void setAsk_price(double ask_price) {
        this.ask_price = ask_price;
    }

    public void setBuy_limit(int buy_limit) {
        this.buy_limit = buy_limit;
    }


    //getters
    public double getLast_traded_price() {
        return last_traded_price;
    }

    public double getBid_price() {
        return bid_price;
    }

    public int getSell_limit() {
        return sell_limit;
    }

    public String getTicker() {
        return ticker;
    }

    public int getMax_price_shift() {
        return max_price_shift;
    }

    public double getAsk_price() {
        return ask_price;
    }

    public int getBuy_limit() {
        return buy_limit;
    }

    @Override
    public String toString() {
        return "MarketDataEntity{" +
                "last_traded_price=" + last_traded_price +
                ", bid_price=" + bid_price +
                ", sell_limit=" + sell_limit +
                ", ticker='" + ticker + '\'' +
                ", max_price_shift=" + max_price_shift +
                ", ask_price=" + ask_price +
                ", buy_limit=" + buy_limit +
                '}';
    }
}
