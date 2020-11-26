package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderDataDao {

    private static List<OrderData> orderDataList;
    private ValidatedOrder validatedOrder = new ValidatedOrder();
    OrderData orderData = new OrderData();

    static {
        orderDataList = new ArrayList<>() {

        };
    }

    public List<OrderData> getAllOrderData() {
        return this.orderDataList;
    }

    public void save (OrderData orderData) {
        if (!this.orderDataList.isEmpty() && this.orderDataList.size() >= 8) {
            this.orderDataList.clear();
        }
        this.orderDataList.add(orderData);


    }


    public List<OrderData> filterByProductName (String product) {
        return orderDataList.stream().filter(InsProduct -> InsProduct.getProductName().equals(product)) .collect(Collectors.toList());
    }


    public Optional<OrderData> getBestSellingValue() {
        return orderDataList.stream().min(Comparator.comparing(OrderData::getPrice));
    }


    public Optional <OrderData> getBestBuyingValue() {
        return orderDataList.stream().max(Comparator.comparing(OrderData::getPrice));
    }




}
