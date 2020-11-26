package nyansapo.tradesolution.Service;
import nyansapo.tradesolution.Dao.ValidatedOrderDao;
import nyansapo.tradesolution.Entity.RequestOrder;
import nyansapo.tradesolution.Entity.ValidatedOrder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class ValidatedOrderService {


    private ValidatedOrderDao validatedOrderDao = new ValidatedOrderDao();
    private RequestOrder requestOrder = new RequestOrder();

    public List<ValidatedOrder> ServiceGetValidatedOrderEntityList() {
        return validatedOrderDao.getValidatedOrderList();

    }

    public Mono<String> postOrder (RequestOrder requestOrder) {
        return  WebClient.builder().baseUrl("localhost:8090")
                .build().post()
                .uri("add")
                .body(Mono.just(requestOrder), RequestOrder.class)
                .retrieve()
                .bodyToMono(String.class);
    }

}
