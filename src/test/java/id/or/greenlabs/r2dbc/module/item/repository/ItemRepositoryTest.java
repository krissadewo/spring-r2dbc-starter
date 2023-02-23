package id.or.greenlabs.r2dbc.module.item.repository;

import id.or.greenlabs.r2dbc.entity.Item;
import id.or.greenlabs.r2dbc.module.item.config.BaseTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import reactor.test.StepVerifier;

import java.util.Objects;

/**
 * @author ksadewo
 * @created 08/02/2023 - 9:17 AM
 */
@ContextConfiguration(classes = {
    ItemRepository.class,
})
class ItemRepositoryTest extends BaseTest {

    @Autowired
    private ItemRepository repository;

    private Item item;

    @Order(1)
    @Test
    void save() {
        repository.save(dummyData.item())
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                item = object;

                return item.getId() != null;
            })
            .verifyComplete();

    }

    @Order(2)
    @Test
    void findById() {
        repository.findBy(1)
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                item = object;

                return item.getId() != null;
            })
            .verifyComplete();
    }

    @Order(3)
    @Test
    void findBy() {
        Item param = dummyData.item();

        repository.findBy(param, 10, 0)
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                item = object;

                return item.getId() != null;
            })
            .verifyComplete();
    }

    @Order(4)
    @Test
    void count() {
        Item param = dummyData.item();

        repository.count(param)
            .as(StepVerifier::create)
            .thenConsumeWhile(Objects::nonNull)
            .verifyComplete();
    }

}
