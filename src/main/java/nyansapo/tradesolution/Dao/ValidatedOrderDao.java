package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.ValidatedOrder;

import java.util.ArrayList;
import java.util.List;

public class ValidatedOrderDao {

    private static List<ValidatedOrder> validatedOrderList;
    ValidatedOrder validatedOrder = new ValidatedOrder(1, "IBM", "BUY", 110, 1000);

    OrderDataDao orderDataDao = new OrderDataDao();

    static {
        validatedOrderList = new ArrayList<ValidatedOrder>() {
//            {
//                add( new ValidatedOrder(1, "IBM", "BUY", 110, 1000));
//            }
        };
    }

    public List<ValidatedOrder> getValidatedOrderList() {
        return this.validatedOrderList;
    }

    public void setOrderEntityList(ValidatedOrder validatedOrder) {
        if (!validatedOrderList.isEmpty() && validatedOrderList.size() >= 5) {
            validatedOrderList.clear();
        }
        this.validatedOrderList.add(validatedOrder);
    }

    public List<ValidatedOrder> order() {
        double bidPrice = validatedOrder.getValidatedQuantity()/validatedOrder.getValidatedAmount();
        if (validatedOrder.getValidatedSide().equals("BUY")) {
            orderDataDao.getBestBuyingValue(validatedOrder.getValidatedSide());
        }
        return null;
    }

    public String getTickerName (){
        return validatedOrder.getValidatedProductName();
    }

}
