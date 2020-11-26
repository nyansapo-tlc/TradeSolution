package nyansapo.tradesolution.Controller;

import nyansapo.tradesolution.Dao.OrderDataDao;
import nyansapo.tradesolution.Dao.ValidatedOrderDao;
import nyansapo.tradesolution.Entity.OrderData;
import nyansapo.tradesolution.Entity.RequestOrder;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import nyansapo.tradesolution.Service.OrderDataService;
import nyansapo.tradesolution.Service.ValidatedOrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
public class TradeEngineController {


    private OrderDataService orderDataService = new OrderDataService();

    private OrderDataDao orderDataDao = new OrderDataDao();
    private ValidatedOrderService validatedOrderService = new ValidatedOrderService();
    private ValidatedOrderDao validatedOrderDao = new ValidatedOrderDao();


    private String exchange_Path[] = {"https://exchange.matraining.com", "https://exchange2.matraining.com"};


    @RequestMapping(value = "/m", method = RequestMethod.GET)
    public List<OrderData> serviceGetAllMarketData() {
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
        serviceGetAllMarketData();
        return orderDataService.fetchAllOrderData1();
    }

    @RequestMapping(value = "/sendOrder", method = RequestMethod.POST)
    public Mono<String> sendOrderToExchangeConnectivity(@RequestBody RequestOrder requestOrder) {
        System.out.println(validatedOrderService.postOrder(requestOrder));
        return validatedOrderService.postOrder(requestOrder);

    }

    @RequestMapping(value = "/p", method = RequestMethod.POST)
    public List<ValidatedOrder> controllerGetValidatedOrderEntityList(@RequestBody ValidatedOrder order) {

        System.out.println(order);
        validatedOrderDao.save(order);


        return validatedOrderService.ServiceGetValidatedOrderEntityList();

    }



}
