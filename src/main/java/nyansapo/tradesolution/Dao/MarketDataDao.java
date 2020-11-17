package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.MarketDataEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MarketDataDao {

    private static List<MarketDataEntity> marketDataEntityList;

    static {
        marketDataEntityList = new ArrayList<MarketDataEntity>() {

        };
    }

    public List<MarketDataEntity> getAllMarketData1() {
        return this.marketDataEntityList;
    }

    public void save (MarketDataEntity marketDataEntity) {
        if (!this.marketDataEntityList.isEmpty() && this.marketDataEntityList.size() >= 16) {
            this.marketDataEntityList.clear();
        }
        this.marketDataEntityList.add(marketDataEntity);

    }

    public List<MarketDataEntity> filterByTicker (String ticker) {
        return marketDataEntityList.stream().filter(tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList());
    }


    public Optional<MarketDataEntity> getBestBuyingValue(String ticker) {
        return filterByTicker(ticker).stream().min(Comparator.comparing(MarketDataEntity::getMax_price_shift));
    }

    public Optional <MarketDataEntity> getBestSellingValue(String ticker) {
        return filterByTicker(ticker).stream().max(Comparator.comparing(MarketDataEntity::getMax_price_shift));
    }


//return marketDataEntity.stream().filter(tick -> tick.getTicker() == ticker).findFirst();


//    public MarketDataEntity getMarketDataByTicker(String ticker) {
//        return this.marketDataEntity.get();
//    }

}
