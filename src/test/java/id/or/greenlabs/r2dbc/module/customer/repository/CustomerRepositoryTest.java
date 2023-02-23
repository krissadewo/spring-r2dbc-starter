package id.or.greenlabs.r2dbc.module.customer.repository;

import id.or.greenlabs.r2dbc.module.customer.config.BaseTest;
import id.or.greenlabs.r2dbc.entity.Customer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import reactor.test.StepVerifier;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:34 PM
 */
@ContextConfiguration(classes = {
    CustomerRepository.class,
})
class CustomerRepositoryTest extends BaseTest {

    @Autowired
    private CustomerRepository repository;

    private Customer customer;

    @Order(1)
    @Test
    void save() {
        repository.save(dummyData.customer())
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                customer = object;

                return customer.getId() != null;
            })
            .verifyComplete();

    }

    @Order(2)
    @Test
    void findById() {
        repository.findBy(customer.getId())
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                customer = object;

                return customer.getId() != null;
            })
            .verifyComplete();
    }

    @Order(3)
    @Test
    void findBy() {
        repository.findBy(dummyData.customer(), 10, 0)
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                customer = object;

                return customer.getId() != null;
            })
            .verifyComplete();
    }

    @Order(4)
    @Test
    void count() {
        repository.count(customer)
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                return object > 0;
            })
            .verifyComplete();
    }

    @Order(5)
    @Test
    void delete() {
        repository.delete(customer.getId())
            .as(StepVerifier::create)
            .thenConsumeWhile(object -> {
                return object > 0;
            })
            .verifyComplete();
    }
}
