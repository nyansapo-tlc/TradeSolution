package nyansapo.tradesolution.Service;

import nyansapo.tradesolution.Dao.ValidatedOrderDao;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ValidatedOrderService {


    private ValidatedOrderDao validatedOrderDao = new ValidatedOrderDao();

    public List<ValidatedOrder> ServiceGetOrderEntityList() {
        return validatedOrderDao.getValidatedOrderList();

    }

    public String tickerName (){
        return validatedOrderDao.getTickerName();
    }
}
