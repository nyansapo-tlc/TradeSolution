package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidatedOrder {

    @JsonProperty("product")
    private  String validatedProductName;

    @JsonProperty("side")
    private String validatedSide;

    @JsonProperty("price")
    private double validatedAmount;

    @JsonProperty("quantity")
    private int validatedQuantity;

    public ValidatedOrder() {}

    public ValidatedOrder( String validatedProductName, String validatedSide, double validatedAmount, int validatedQuantity) {
        this.validatedProductName = validatedProductName;
        this.validatedSide = validatedSide;
        this.validatedAmount = validatedAmount;
        this.validatedQuantity = validatedQuantity;
    }

//setters

    public void setValidatedProductName(String validatedProductName) {
        this.validatedProductName = validatedProductName;
    }

    public void setValidatedSide(String validatedSide) {
        this.validatedSide = validatedSide;
    }

    public void setValidatedAmount(double validatedAmount) {
        this.validatedAmount = validatedAmount;
    }

    public void setValidatedQuantity(int validatedQuantity) {
        this.validatedQuantity = validatedQuantity;
    }


//getters

    public String getValidatedProductName() {
        return validatedProductName;
    }

    public String getValidatedSide() {
        return validatedSide;
    }

    public double getValidatedAmount() {
        return validatedAmount;
    }

    public int getValidatedQuantity() {
        return validatedQuantity;
    }

    @Override
    public String toString() {
        return "ValidatedOrder{" +
                "validatedProductName='" + validatedProductName + '\'' +
                ", validatedSide='" + validatedSide + '\'' +
                ", validatedAmount=" + validatedAmount +
                ", validatedQuantity=" + validatedQuantity +
                '}';
    }
}
