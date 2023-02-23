package id.or.greenlabs.r2dbc.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:09 PM
 */
public interface BaseRepository<T> {

    Mono<T> save(T entity);

    Mono<Long> delete(Integer id);

    Mono<T> findBy(Integer id);

    Flux<T> findBy(T param, int limit, int offset);

    Mono<Long> count(T param);
}
