package nyansapo.tradesolution.Service;

import nyansapo.tradesolution.Dao.MarketDataDao;
import nyansapo.tradesolution.Entity.MarketDataEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MarketDataService {


    private MarketDataDao marketDataDao = new MarketDataDao();
    private MarketDataEntity marketDataEntity = new MarketDataEntity();

    // return all MDE
    public Flux<MarketDataEntity> getAllMarketData1() {
       return  WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build().get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MarketDataEntity.class);
    }

    public Flux<MarketDataEntity> getAllMarketData2() {
        return  WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build().get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MarketDataEntity.class);
    }


    public List<MarketDataEntity> fetchAllMarketData1() {
        return marketDataDao.getAllMarketData1();
    }

    public List<MarketDataEntity> serviceFilterByTicker (String ticker) {
        return marketDataDao.filterByTicker(ticker);
    }

    public Optional<MarketDataEntity> serviceGetBestBuyingValue(String ticker) {
        return marketDataDao.getBestBuyingValue(ticker);
    }

    public Optional<MarketDataEntity> serviceGetBestSellingValue(String ticker) {
        return marketDataDao.getBestSellingValue(ticker);
    }

    // return MDE by ticker
//    public MarketDataEntity getMarketDataByTicker(String ticker) {
//        return this.marketDataDao.getMarketDataByTicker(ticker);
//    }
}
