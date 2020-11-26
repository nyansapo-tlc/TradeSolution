package nyansapo.tradesolution.Service;

import nyansapo.tradesolution.Dao.OrderDataDao;
import nyansapo.tradesolution.Dao.ValidatedOrderDao;
import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderDataService {


    private OrderDataDao orderDataDao = new OrderDataDao();
    private OrderData orderData = new OrderData();
    private ValidatedOrderDao validatedOrder = new ValidatedOrderDao();

//    String ticker = validatedOrderService.tickerName();

    // return all MDE
    public Flux<OrderData> getAllOrderData1() {
        String ticker = validatedOrder.getTickerName().toUpperCase();
        String orderType = validatedOrder.getSide().toLowerCase();
        String URI = "/orderbook/" +ticker+ "/" + orderType;
       return  WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build().get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(OrderData.class);
    }

    public Flux<OrderData> getAllOrderData2() {
        String ticker = validatedOrder.getTickerName().toUpperCase();
        String orderType = validatedOrder.getSide().toLowerCase();
        String URI = "/orderbook/" +ticker+ "/" + orderType;
        return  WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build().get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(OrderData.class);
    }


    public List<OrderData> fetchAllOrderData1() {
        return orderDataDao.getAllOrderData();
    }

//    public List<OrderData> serviceFilterByProductName (String product) {
//        return orderDataDao.filterByProductName(product);
//    }
//
//    public Optional<OrderData> serviceGetBestSellingValue(String product) {
//        return orderDataDao.getBestBuyingValue(product);
//    }
//
//    public Optional<OrderData> serviceGetBestBuyingValue(String product) {
//        return orderDataDao.getBestSellingValue();
//    }


//    public List<OrderData> sortOrderDataForBuy1() {
//
//        return orderDataDao.sortOrderDataForBuy();
//    }

//    public double BuyingValue(String ticker) {
//        return marketDataDao.getElement(ticker);
//    }

    // return MDE by ticker
//    public MarketDataEntity getMarketDataByTicker(String ticker) {
//        return this.marketDataDao.getMarketDataByTicker(ticker);
//    }
}
