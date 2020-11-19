package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.MarketDataEntity;
import nyansapo.tradesolution.Entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private static List<OrderEntity> orderEntityList;
    OrderEntity orderEntity = new OrderEntity();
    MarketDataDao marketDataDao = new MarketDataDao();

    static {
        orderEntityList = new ArrayList<OrderEntity>() {

        };
    }

    public static List<OrderEntity> getOrderEntityList() {
        return orderEntityList;
    }

    public void setOrderEntityList(OrderEntity orderEntity) {
        if (!orderEntityList.isEmpty() && orderEntityList.size() >= 5) {
            orderEntityList.clear();
        }
        this.orderEntityList.add(orderEntity);
    }

    public List<OrderEntity> order() {
        double bidPrice = orderEntity.getQuantity()/orderEntity.getAmount();
        if (orderEntity.getTicker().equals("BUY")) {
            marketDataDao.getBestBuyingValue(orderEntity.getTicker());
        }
        return null;
    }

}
