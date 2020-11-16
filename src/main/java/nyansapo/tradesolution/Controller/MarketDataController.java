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
public class MarketDataController {

    @Autowired
    public MarketDataService marketDataService;


    @RequestMapping(value = "/MarketData1", method = RequestMethod.GET)
    public Flux<MarketDataEntity> getAllMarketData1() {
        Flux<MarketDataEntity> marketDataResponse = this.marketDataService.getAllMarketData1();
        MarketDataDao marketDataDao = new MarketDataDao();
        marketDataResponse.toStream().forEach((MarketDataEntity entity)->{
            marketDataDao.save(entity);
        });
        return marketDataResponse;
    }

    @RequestMapping(value = "/MarketData2", method = RequestMethod.GET)
    public Flux<MarketDataEntity> getAllMarketData2() {
        Flux<MarketDataEntity> marketDataResponse = this.marketDataService.getAllMarketData2();
        MarketDataDao marketDataDao = new MarketDataDao();
        marketDataResponse.toStream().forEach((MarketDataEntity entity)->{
            marketDataDao.save(entity);
        });
        return marketDataResponse;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<MarketDataEntity> collectAllMarketData() {
        return marketDataService.fetchAllMarketData1();
    }

    @RequestMapping(value = "/filter/{ticker}", method = RequestMethod.GET)
    public List<MarketDataEntity> controllerFilterByTicker (@PathVariable("ticker") String ticker) {
        return marketDataService.serviceFilterByTicker(ticker);
    }

    @RequestMapping(value = "buying/{ticker}", method = RequestMethod.GET)
    public Optional<MarketDataEntity> controllerGetBestBuyingValue(@PathVariable("ticker") String ticker) {
        return marketDataService.serviceGetBestBuyingValue(ticker);
    }

    @RequestMapping(value = "selling/{ticker}", method = RequestMethod.GET)
    public Optional<MarketDataEntity> controllerGetBestSellingValue(@PathVariable("ticker") String ticker) {
        return marketDataService.serviceGetBestSellingValue(ticker);
    }




//    public MarketDataEntity controllerGetBestBuyingValue(@PathVariable ("ticker") String ticker) {
//        return marketDataService.serviceGetBestBuyingValue(ticker);
//    }


    // display all market Data with same ticker via Market Data Service
//    @RequestMapping(value = "/{ticker}", method = RequestMethod.GET)
//    public MarketDataEntity getMarketDataByTicker(@PathVariable("ticker") String ticker) {
//        return this.marketDataService.getMarketDataByTicker(ticker);
//    }


}
