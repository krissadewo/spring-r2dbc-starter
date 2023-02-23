package id.or.greenlabs.r2dbc.module.category.repository;

import id.or.greenlabs.r2dbc.common.Mode;
import id.or.greenlabs.r2dbc.entity.Category;
import id.or.greenlabs.r2dbc.entity.Customer;
import id.or.greenlabs.r2dbc.repository.AbstractGenericRepository;
import id.or.greenlabs.r2dbc.repository.FunctionBuildQuery;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 23/02/2023 - 10:30 AM
 */
public class CategoryRepository extends AbstractGenericRepository<Category> {

    @Override
    public Flux<Category> findBy(Category param, int limit, int offset) {
        StringBuilder sql = new StringBuilder("" +
                "SELECT * FROM category cat " +
                "WHERE 1=1 ");

        return buildQuery()
                .apply(sql, param, Mode.FIND)
                .map((row, rowMetadata) -> {
                    Category category = new Category();
                    category.setId(row.get(0, Integer.class));
                    category.setName(row.get(1, String.class));

                    return category;
                })
                .all();
    }

    @Override
    public Mono<Long> count(Category param) {
        return null;
    }

    @Override
    protected FunctionBuildQuery<StringBuilder, Category, Mode, DatabaseClient.GenericExecuteSpec> buildQuery() {
        return (sql, param, mode) -> {
            DatabaseClient.GenericExecuteSpec executeSpec = databaseClient.sql(sql::toString);

            if (param.getName() != null) {
                sql.append("AND cs.firstName= :firstName ");

                executeSpec = executeSpec.bind("firstName", param.getName());
            }

            return executeSpec;
        };
    }
}
