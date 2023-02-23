package id.or.greenlabs.r2dbc.repository;

import id.or.greenlabs.r2dbc.common.Mode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import java.lang.reflect.ParameterizedType;

/**
 * @author ksadewo
 * @created 08/02/2023 - 8:52 AM
 */
@Component
public abstract class AbstractGenericRepository<T> implements BaseRepository<T> {

    @Autowired
    protected DatabaseClient databaseClient;
    private Class<T> type;
    @Autowired
    private R2dbcEntityTemplate template;

    {
        this.type = (Class<T>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public Mono<T> save(T entity) {
        return template.insert(type)
                .using(entity);
    }

    @Override
    public Mono<Long> delete(Integer id) {
        Criteria criteria = Criteria.from(Criteria.where("id").is(id));

        return template.delete(Query.query(criteria), type);
    }


    @Override
    public Mono<T> findBy(Integer id) {
        Criteria criteria = Criteria.from(Criteria.where("id").is(id));

        return template.selectOne(Query.query(criteria).limit(1), type);
    }

    @Override
    public abstract Mono<Long> count(T param);

    protected abstract FunctionBuildQuery<StringBuilder, T, Mode, DatabaseClient.GenericExecuteSpec> buildQuery();
}
