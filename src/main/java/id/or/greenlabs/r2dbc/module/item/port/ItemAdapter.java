package id.or.greenlabs.r2dbc.module.item.port;

import id.or.greenlabs.r2dbc.assembler.dto.ItemDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:04 PM
 */
public interface ItemAdapter {

    Mono<ItemDto> save(ItemDto dto);

    Mono<ItemDto> findBy(Integer id);

    Flux<ItemDto> findBy(ItemDto param, int limit, int offset);

    Mono<Long> count(ItemDto param);
}
