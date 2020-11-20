package nyansapo.tradesolution.Service;

import nyansapo.tradesolution.Dao.OrderDataDao;
import nyansapo.tradesolution.Entity.OderData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;


@Service
public class OrderDataService {


    private OrderDataDao orderDataDao = new OrderDataDao();
    private OderData oderData = new OderData();
    private ValidatedOrderService validatedOrderService = new ValidatedOrderService();

//    String ticker = validatedOrderService.tickerName();

    // return all MDE
    public Flux<OderData> getAllOrderData1() {
        String ticker = validatedOrderService.tickerName();
       return  WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build().get()
                .uri("/orderbook/" +ticker+ "/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(OderData.class);
    }

    public Flux<OderData> getAllOrderData2() {
        String ticker = validatedOrderService.tickerName();
        return  WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build().get()
                .uri("/orderbook/" +ticker+ "/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(OderData.class);
    }


    public List<OderData> fetchAllOrderData1() {
        return orderDataDao.getAllOrderData();
    }

    public List<OderData> serviceFilterByProductName (String product) {
        return orderDataDao.filterByProductName(product);
    }

    public Optional<OderData> serviceGetBestSellingValue(String product) {
        return orderDataDao.getBestBuyingValue(product);
    }

    public Optional<OderData> serviceGetBestBuyingValue(String product) {
        return orderDataDao.getBestSellingValue(product);
    }

//    public double BuyingValue(String ticker) {
//        return marketDataDao.getElement(ticker);
//    }

    // return MDE by ticker
//    public MarketDataEntity getMarketDataByTicker(String ticker) {
//        return this.marketDataDao.getMarketDataByTicker(ticker);
//    }
}
