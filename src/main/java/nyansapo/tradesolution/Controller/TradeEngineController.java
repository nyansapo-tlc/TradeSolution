package nyansapo.tradesolution.Controller;

import nyansapo.tradesolution.Dao.OrderDataDao;
import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import nyansapo.tradesolution.Service.OrderDataService;
import nyansapo.tradesolution.Service.ValidatedOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
public class TradeEngineController {


    private OrderDataService orderDataService = new OrderDataService();

    private OrderDataDao orderDataDao = new OrderDataDao();
    private ValidatedOrderService validatedOrderService = new ValidatedOrderService();

    private String exchange_Path[] = {"https://exchange.matraining.com", "https://exchange2.matraining.com"};


    @RequestMapping(value = "/m", method = RequestMethod.GET)
    public List<OrderData> getAllMarketData1() {
        Flux<OrderData> marketDataResponse = this.orderDataService.getAllOrderData1();
        marketDataResponse.toStream().forEach((OrderData data)->{
            data.setExchange_Path(exchange_Path[0]);
            orderDataDao.save(data);
        });

        Flux<OrderData> marketDataResponse2 = this.orderDataService.getAllOrderData2();
        marketDataResponse2.toStream().forEach((OrderData data)->{
            data.setExchange_Path(exchange_Path[1]);
            orderDataDao.save(data);
        });
        return orderDataService.fetchAllOrderData1();
    }


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<OrderData> collectAllMarketData() {
        getAllMarketData1();
        return orderDataService.fetchAllOrderData1();
    }

    @RequestMapping(value = "/filter/{side}/{ticker}", method = RequestMethod.GET)
    public List<OrderData> controllerFilterByProductName (@PathVariable String side, String ticker) {
        getAllMarketData1();
        return orderDataService.serviceFilterByProductName(ticker);
    }

    @RequestMapping(value = "buying/{ticker}", method = RequestMethod.GET)
    public Optional<OrderData> controllerGetBestBuyingValue(@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return orderDataService.serviceGetBestBuyingValue(ticker);
    }

    @RequestMapping(value = "selling/{ticker}", method = RequestMethod.GET)
    public Optional<OrderData> controllerGetBestSellingValue(@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return orderDataService.serviceGetBestSellingValue(ticker);
    }

    @RequestMapping(value = "/val", method = RequestMethod.GET)
    public List<ValidatedOrder> controllerGetOrderEntityList() {
        return validatedOrderService.ServiceGetOrderEntityList();
    }


//    @RequestMapping(value = "g1/{ticker}", method = RequestMethod.GET)
//    public double cBuyingValue(@PathVariable("ticker") String ticker) {
//        getAllMarketData1();
//        return marketDataService.BuyingValue(ticker);
//    }



}
