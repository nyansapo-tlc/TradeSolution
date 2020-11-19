package nyansapo.tradesolution.Controller;

import nyansapo.tradesolution.Dao.MarketDataDao;
import nyansapo.tradesolution.Entity.MarketDataEntity;
import nyansapo.tradesolution.Dao.MarketDataDao;
import nyansapo.tradesolution.Service.MarketDataService;
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

    @Autowired
    public MarketDataService marketDataService;

    @Autowired
    MarketDataDao marketDataDao;


    @RequestMapping(value = "/exchangedata", method = RequestMethod.GET)
    public List<MarketDataEntity> getAllMarketData1() {
        Flux<MarketDataEntity> marketDataResponse = this.marketDataService.getAllMarketData1();
        marketDataResponse.toStream().forEach((MarketDataEntity entity)->{
            marketDataDao.save(entity);
        });

        Flux<MarketDataEntity> marketDataResponse2 = this.marketDataService.getAllMarketData2();
        marketDataResponse.toStream().forEach((MarketDataEntity entity)->{
            marketDataDao.save(entity);
        });
        return marketDataService.fetchAllMarketData1();
    }


    @RequestMapping(value = "data", method = RequestMethod.GET)
    public List<MarketDataEntity> collectAllMarketData() {
        return marketDataService.fetchAllMarketData1();
    }

    @RequestMapping(value = "/filter/{ticker}", method = RequestMethod.GET)
    public List<MarketDataEntity> controllerFilterByTicker (@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return marketDataService.serviceFilterByTicker(ticker);
    }

    @RequestMapping(value = "buying/{ticker}", method = RequestMethod.GET)
    public Optional<MarketDataEntity> controllerGetBestBuyingValue(@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return marketDataService.serviceGetBestBuyingValue(ticker);
    }

    @RequestMapping(value = "selling/{ticker}", method = RequestMethod.GET)
    public Optional<MarketDataEntity> controllerGetBestSellingValue(@PathVariable("ticker") String ticker) {
        getAllMarketData1();
        return marketDataService.serviceGetBestSellingValue(ticker);
    }



}
