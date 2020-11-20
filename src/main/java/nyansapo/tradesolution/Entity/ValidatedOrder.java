package nyansapo.tradesolution.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidatedOrder {
    @JsonProperty("")
    private int ID;

    @JsonProperty("")
    private  String validatedProductName;

    @JsonProperty("")
    private String validatedSide;

    @JsonProperty("")
    private double validatedAmount;

    @JsonProperty("")
    private int validatedQuantity;

    public ValidatedOrder() {}

    public ValidatedOrder(int ID, String validatedProductName, String validatedSide, double validatedAmount, int validatedQuantity) {
        this.ID = ID;
        this.validatedProductName = validatedProductName;
        this.validatedSide = validatedSide;
        this.validatedAmount = validatedAmount;
        this.validatedQuantity = validatedQuantity;
    }

//setters

    public void setID(int ID) {
        this.ID = ID;
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


    public int getID() {
        return ID;
    }

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
}
