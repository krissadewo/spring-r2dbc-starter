package id.or.greenlabs.r2dbc.common.converter;

import id.or.greenlabs.r2dbc.entity.Customer;
import id.or.greenlabs.r2dbc.entity.Item;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * @author ksadewo
 * @created 07/02/2023 - 10:35 AM
 */
@ReadingConverter
public class ItemRowConverter implements Converter<Row, Item> {

    @Override
    public Item convert(Row source) {
        return Item.builder()
            .id(source.get("id", Integer.class))
            .name(source.get("name", String.class))
            .build();
    }
}
