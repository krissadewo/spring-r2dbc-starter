package id.or.greenlabs.r2dbc.common;

import id.or.greenlabs.r2dbc.entity.Category;
import id.or.greenlabs.r2dbc.entity.Customer;
import id.or.greenlabs.r2dbc.entity.Item;
import org.springframework.stereotype.Component;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:51 PM
 */
@Component
public class DummyData {

    public Customer customer() {
        Customer entity = new Customer();
        entity.setFirstName("Jhon");
        entity.setLastName("Does");

        return entity;
    }

    public Item item() {
        Item entity = new Item();
        entity.setName("Iphone");
        entity.setCategoryId(1);

        return entity;
    }
}
