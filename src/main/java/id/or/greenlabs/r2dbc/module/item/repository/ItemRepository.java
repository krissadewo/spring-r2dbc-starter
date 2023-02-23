package id.or.greenlabs.r2dbc.module.item.repository;

import id.or.greenlabs.r2dbc.common.Mode;
import id.or.greenlabs.r2dbc.entity.Category;
import id.or.greenlabs.r2dbc.entity.Item;
import id.or.greenlabs.r2dbc.repository.AbstractGenericRepository;
import id.or.greenlabs.r2dbc.repository.FunctionBuildQuery;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 08/02/2023 - 9:08 AM
 */
public class ItemRepository extends AbstractGenericRepository<Item> {

    @Override
    public Flux<Item> findBy(Item param, int limit, int offset) {
        StringBuilder sql = new StringBuilder("" +
            "SELECT * FROM item it " +
            "INNER JOIN category ct ON ct.id = it.category_id " +
            "WHERE 1=1 ");

        return buildQuery()
            .apply(sql, param, Mode.FIND)
            .bind("limit", limit)
            .bind("offset", offset)
            .map((row, rowMetadata) -> {
                Item item = new Item();
                item.setId(row.get(0, Integer.class));
                item.setName(row.get(1, String.class));
                item.setCategoryId(row.get(2, Integer.class));

                Category category = new Category();
                category.setId(row.get(3, Integer.class));
                category.setName(row.get(4, String.class));

                item.setCategory(category);

                return item;
            })
            .all();
    }

    @Override
    public Mono<Long> count(Item param) {
        StringBuilder sql = new StringBuilder("" +
            "SELECT COUNT(it.id) AS rows FROM item it " +
            "WHERE 1=1 ");

        return buildQuery()
            .apply(sql, param, Mode.COUNT)
            .fetch()
            .first()
            .map(object -> {
                return (Long) object.get("rows");
            });
    }

    @Override
    protected FunctionBuildQuery<StringBuilder, Item, Mode, DatabaseClient.GenericExecuteSpec> buildQuery() {
        return (sql, param, mode) -> {
            DatabaseClient.GenericExecuteSpec executeSpec = databaseClient.sql(sql::toString);

            if (param.getName() != null) {
                sql.append("AND it.name= :name ");

                executeSpec = executeSpec.bind("name", param.getName());
            }

            if (param.getCategoryId() != null) {
                sql.append("AND it.category_id= :categoryId ");

                executeSpec = executeSpec.bind("categoryId", param.getCategoryId());
            }

            if (mode == Mode.FIND) {
                sql.append("LIMIT :limit OFFSET :offset");
            }

            return executeSpec;
        };
    }
}
