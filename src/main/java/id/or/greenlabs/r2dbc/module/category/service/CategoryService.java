package id.or.greenlabs.r2dbc.module.category.service;

import id.or.greenlabs.r2dbc.assembler.dto.CategoryDto;
import id.or.greenlabs.r2dbc.assembler.wrapper.CategoryWrapper;
import id.or.greenlabs.r2dbc.module.category.port.CategoryAdapter;
import id.or.greenlabs.r2dbc.module.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author ksadewo
 * @created 23/02/2023 - 10:43 AM
 */
@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryAdapter {

    private final CategoryRepository repository;

    private final CategoryWrapper wrapper;

    @Override
    public Flux<CategoryDto> findBy(CategoryDto param, int limit, int offset) {
        return repository.findBy(wrapper.toParam(param), limit, offset)
                .map(wrapper::toDto);
    }
}
