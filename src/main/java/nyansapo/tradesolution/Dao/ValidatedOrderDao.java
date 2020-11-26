package nyansapo.tradesolution.Dao;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ValidatedOrderDao {

    private static final List<ValidatedOrder> validatedOrderList;
    ValidatedOrder validatedOrder = new ValidatedOrder();

    OrderDataDao orderDataDao = new OrderDataDao();

    static {
        validatedOrderList = new ArrayList<>() {

        };
    }

    public List<ValidatedOrder> getValidatedOrderList() {
        return this.validatedOrderList;
    }

    public void save(ValidatedOrder validatedOrder) {
        if (!validatedOrderList.isEmpty()) {
            validatedOrderList.clear();
        }
        this.validatedOrderList.add(validatedOrder);
    }

//    public List<ValidatedOrder> order() {
//        double price = validatedOrder.getValidatedQuantity()/validatedOrder.getValidatedAmount();
//        if (validatedOrder.getValidatedSide().equals("BUY")) {
//            orderDataDao.getBestBuyingValue(validatedOrder.getValidatedSide());
//        }
//        return null;
//    }

    public String getTickerName (){
        return getValidatedOrderList().get(0).getValidatedProductName();
    }

    public String getSide () {
        return  getValidatedOrderList().get(0).getValidatedSide();
    }



}
