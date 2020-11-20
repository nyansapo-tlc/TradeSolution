package nyansapo.tradesolution.Dao;

import nyansapo.tradesolution.Entity.OderData;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderDataDao {

    private static List<OderData> oderDataList;

    static {
        oderDataList = new ArrayList<OderData>() {

        };
    }

    public List<OderData> getAllOrderData() {
        return this.oderDataList;
    }

    public void save (OderData oderData) {
        if (!this.oderDataList.isEmpty() && this.oderDataList.size() >= 8) {
            this.oderDataList.clear();
        }
        this.oderDataList.add(oderData);


    }

    public List<OderData> filterByProductName (String product) {
        return oderDataList.stream().filter(InsProduct -> InsProduct.getProductName().equals(product)).collect(Collectors.toList());
    }


    public Optional<OderData> getBestSellingValue(String product) {
        return filterByProductName(product).stream().min(Comparator.comparing(OderData::getPrice));
    }

    public Optional <OderData> getBestBuyingValue(String product) {
        return filterByProductName(product).stream().max(Comparator.comparing(OderData::getPrice));
    }

//    public double getElement (String productName){
//        return getBestBuyingValue(productName).get().getProductName();
//    }


}
