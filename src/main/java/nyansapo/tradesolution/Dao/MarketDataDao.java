package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.MarketDataEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MarketDataDao {

    private static List<MarketDataEntity> marketDataEntity;

    static {
        marketDataEntity = new ArrayList<MarketDataEntity>() {

        };
    }

    public List<MarketDataEntity> getAllMarketData1() {
        return this.marketDataEntity;
    }

    public void save (MarketDataEntity marketDataEntity) {
        if (!this.marketDataEntity.isEmpty() && this.marketDataEntity.size() >= 16) {
            this.marketDataEntity.clear();
        }
        this.marketDataEntity.add(marketDataEntity);

    }

    public List<MarketDataEntity> filterByTicker (String ticker) {
        return marketDataEntity.stream().filter(tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList());
    }


    public Optional<MarketDataEntity> getBestBuyingValue(String ticker) {
        return marketDataEntity.stream().filter(tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList())
                .stream().min(Comparator.comparing(MarketDataEntity::getMax_price_shift));
    }

    public Optional <MarketDataEntity> getBestSellingValue(String ticker) {
        return marketDataEntity.stream().filter(tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList())
                .stream().max(Comparator.comparing(MarketDataEntity::getMax_price_shift));
    }


//return marketDataEntity.stream().filter(tick -> tick.getTicker() == ticker).findFirst();


//    public MarketDataEntity getMarketDataByTicker(String ticker) {
//        return this.marketDataEntity.get();
//    }

}
