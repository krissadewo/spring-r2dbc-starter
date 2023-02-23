package id.or.greenlabs.r2dbc.module.item.service;

import id.or.greenlabs.r2dbc.assembler.dto.ItemDto;
import id.or.greenlabs.r2dbc.assembler.wrapper.ItemWrapper;
import id.or.greenlabs.r2dbc.module.item.port.ItemAdapter;
import id.or.greenlabs.r2dbc.module.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:19 PM
 */
@Service
@RequiredArgsConstructor
public class ItemService implements ItemAdapter {

    private final ItemRepository repository;

    private final ItemWrapper wrapper;

    @Override
    public Mono<ItemDto> save(ItemDto dto) {
        return repository.save(wrapper.toDocument(dto))
                .map(wrapper::toDto);
    }

    @Override
    public Mono<ItemDto> findBy(Integer id) {
        return repository.findBy(id)
                .map(wrapper::toDto);
    }

    @Override
    public Flux<ItemDto> findBy(ItemDto param, int limit, int offset) {
        return repository.findBy(wrapper.toParam(param), limit, offset)
                .map(wrapper::toDto);
    }

    @Override
    public Mono<Long> count(ItemDto param) {
        return repository.count(wrapper.toParam(param));
    }
}
