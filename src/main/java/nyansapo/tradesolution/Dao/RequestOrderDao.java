package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.RequestOrder;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestOrderDao {

    private static List<RequestOrder> requestOrderList;

    private ValidatedOrder validatedOrder = new ValidatedOrder();
    private OrderDataDao orderDataDao = new OrderDataDao();
//    private RequestOrder requestOrder = new RequestOrder();


    public void createRequestOrder (RequestOrder requestOrder) {

        String exchangePath;
        if(validatedOrder.getValidatedSide().toUpperCase().equals("BUY")) {
            exchangePath = orderDataDao.getBestBuyingValue().get().getExchange_Path();
        } else {
            exchangePath = orderDataDao.getBestSellingValue().get().getExchange_Path();
        }
        requestOrder.setProduct(validatedOrder.getValidatedProductName());
        requestOrder.setQuantity(validatedOrder.getValidatedQuantity());
        requestOrder.setPrice(validatedOrder.getValidatedAmount());
        requestOrder.setSide(validatedOrder.getValidatedSide());
        requestOrder.setBaseURL(exchangePath);
    }

//    public void getAndSet_ProductAndSide (){
//        requestOrder.setProduct(validatedOrder.getValidatedProductName());
//        requestOrder.setSide(validatedOrder.getValidatedSide().toUpperCase());
//        requestOrder.setPrice(validatedOrder.getValidatedAmount());
//        requestOrder.setQuantity(validatedOrder.getValidatedQuantity());
//
//    }


    static {
        requestOrderList = new ArrayList<RequestOrder>(){
        };
    }
//
//    public void saveList () {
//        if (!this.requestOrderList.isEmpty() && this.requestOrderList.size() >= 5) {
//            this.requestOrderList.clear();
//        }
//        this.requestOrderList.add(requestOrder);
//    }
//
//    public List<RequestOrder> getRequestOrderList () {
//        return this.requestOrderList;
//    }









}
