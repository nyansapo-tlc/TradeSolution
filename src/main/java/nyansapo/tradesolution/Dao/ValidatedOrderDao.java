package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.RequestOrder;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ValidatedOrderDao {

    private static final List<ValidatedOrder> validatedOrderList;
    ValidatedOrder validatedOrder = new ValidatedOrder();

    OrderDataDao orderDataDao = new OrderDataDao();
    RequestOrder requestOrder = new RequestOrder();

    static {
        validatedOrderList = new ArrayList<ValidatedOrder>() {
            {
                new ValidatedOrder("IBM", "BUY", 0.11, 5);
            }
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
        double price = validatedOrder.getValidatedQuantity()/validatedOrder.getValidatedAmount();
        if (validatedOrder.getValidatedSide().equals("BUY")) {
            orderDataDao.getBestBuyingValue(validatedOrder.getValidatedSide());
        }
        return null;
    }

    public String getTickerName (){
        return validatedOrder.getValidatedProductName();
    }

    public String getSide () {
        return  validatedOrder.getValidatedSide();
    }





}
