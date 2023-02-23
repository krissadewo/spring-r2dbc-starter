package id.or.greenlabs.r2dbc.common.converter;

import id.or.greenlabs.r2dbc.entity.Customer;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;

/**
 * @author ksadewo
 * @created 07/02/2023 - 10:35 AM
 */
//@ReadingConverter
public class CustomerRowConverter implements Converter<Row, Customer> {

    @Override
    public Customer convert(Row source) {
     /*   return Customer.builder()
                .id(source.get("id",Long.class))
                .firstName(source.get("first_name",String.class))
                .build();*/

        return null;
    }
}
