package id.or.greenlabs.r2dbc.module.category.port;

import id.or.greenlabs.r2dbc.assembler.dto.CategoryDto;
import reactor.core.publisher.Flux;

/**
 * @author ksadewo
 * @created 23/02/2023 - 10:42 AM
 */
public interface CategoryAdapter {

    Flux<CategoryDto> findBy(CategoryDto param, int limit, int offset);
}
