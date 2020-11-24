package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderDataDao {

    private static List<OrderData> orderDataList;
    private ValidatedOrder validatedOrder = new ValidatedOrder();
    OrderData orderData = new OrderData();

    static {
        orderDataList = new ArrayList<OrderData>() {

        };
    }

    public List<OrderData> getAllOrderData() {
        return this.orderDataList;
    }

    public void save (OrderData orderData) {
        if (!this.orderDataList.isEmpty() && this.orderDataList.size() >= 8) {
            this.orderDataList.clear();
        }
//        this.orderDataList.sort(Comparator.comparing(OrderData::getPrice));
        this.orderDataList.add(orderData);


    }


    public List<OrderData> filterByProductName (String product) {
        return orderDataList.stream().filter(InsProduct -> InsProduct.getProductName().equals(product)) .collect(Collectors.toList());
    }


    public Optional<OrderData> getBestSellingValue(String product) {
        return filterByProductName(product).stream().min(Comparator.comparing(OrderData::getPrice));
    }

//    public List<OrderData> sortOrderDataForBuy() {
//
//        return orderDataList.stream().sorted().filter(p -> p.getPrice() >= validatedOrder.getValidatedAmount()).collect(Collectors.toList());
//    }

    public Optional <OrderData> getBestBuyingValue(String product) {
        return filterByProductName(product).stream().max(Comparator.comparing(OrderData::getPrice));
    }

//    public String createOrder() {
//        if(validatedOrder.getValidatedSide().toUpperCase() == "BUY" ) {
//           orderDataList.stream().sorted().filter(p -> p.getPrice() <= validatedOrder.getValidatedAmount()).collect(Collectors.toList());
//        }
//        else {
//            orderDataList.stream().sorted().filter(p -> p.getPrice() >= validatedOrder.getValidatedAmount()).collect(Collectors.toList());
//        }
//        int Qty = validatedOrder.getValidatedQuantity();
//
//        for (OrderData data:orderDataList) {
//            int availableQty = Qty - orderData.getCumulatitiveQty();
//            if (availableQty > Qty) {
//
//
//            }
//        }
//
//    }



//    public String Base_URL () {
//
//        if (validatedOrder.getValidatedSide().toUpperCase() == "BUY") {
//
//        }
//    }


}
