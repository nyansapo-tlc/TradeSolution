package nyansapo.tradesolution.Controller;

import nyansapo.tradesolution.Dao.OrderDataDao;
import nyansapo.tradesolution.Dao.ValidatedOrderDao;
import nyansapo.tradesolution.Entity.OderData;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import nyansapo.tradesolution.Service.OrderDataService;
import nyansapo.tradesolution.Service.ValidatedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<OderData> getAllMarketData1() {
        Flux<OderData> marketDataResponse = this.orderDataService.getAllOrderData1();
        marketDataResponse.toStream().forEach((OderData data)->{
            data.setExchange_Path(exchange_Path[0]);
            orderDataDao.save(data);
        });

        Flux<OderData> marketDataResponse2 = this.orderDataService.getAllOrderData2();
        marketDataResponse2.toStream().forEach((OderData data)->{
            data.setExchange_Path(exchange_Path[1]);
            orderDataDao.save(data);
        });
        return orderDataService.fetchAllOrderData1();
    }


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<OderData> collectAllMarketData() {
        getAllMarketData1();
        return orderDataService.fetchAllOrderData1();
    }

    @RequestMapping(value = "/filter/{ticker}", method = RequestMethod.GET)
    public List<OderData> controllerFilterByProductName (@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return orderDataService.serviceFilterByProductName(ticker);
    }

    @RequestMapping(value = "buying/{ticker}", method = RequestMethod.GET)
    public Optional<OderData> controllerGetBestBuyingValue(@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return orderDataService.serviceGetBestBuyingValue(ticker);
    }

    @RequestMapping(value = "selling/{ticker}", method = RequestMethod.GET)
    public Optional<OderData> controllerGetBestSellingValue(@PathVariable("ticker") String ticker) {
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
