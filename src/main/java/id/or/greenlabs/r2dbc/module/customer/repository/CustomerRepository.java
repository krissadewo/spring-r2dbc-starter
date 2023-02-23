package id.or.greenlabs.r2dbc.module.customer.repository;

import id.or.greenlabs.r2dbc.common.Mode;
import id.or.greenlabs.r2dbc.entity.Customer;
import id.or.greenlabs.r2dbc.repository.AbstractGenericRepository;
import id.or.greenlabs.r2dbc.repository.FunctionBuildQuery;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:10 PM
 */
public class CustomerRepository extends AbstractGenericRepository<Customer> {

    @Override
    public Flux<Customer> findBy(Customer param, int limit, int offset) {
        StringBuilder sql = new StringBuilder("" +
                "SELECT * FROM customer cs " +
                "WHERE 1=1 ");

        return buildQuery()
                .apply(sql, param, Mode.FIND)
                .map((row, rowMetadata) -> {
                    Customer customer = new Customer();
                    customer.setId(row.get(0, Integer.class));
                    customer.setFirstName(row.get(1, String.class));
                    customer.setLastName(row.get(2, String.class));

                    return customer;
                })
                .all();
    }

    @Override
    public Mono<Long> count(Customer param) {
        return null;
    }

    @Override
    protected FunctionBuildQuery<StringBuilder, Customer, Mode, DatabaseClient.GenericExecuteSpec> buildQuery() {
        return (sql, param, mode) -> {
            DatabaseClient.GenericExecuteSpec executeSpec = databaseClient.sql(sql::toString);

            if (param.getFirstName() != null) {
                sql.append("AND cs.firstName= :firstName ");

                executeSpec = executeSpec.bind("firstName", param.getFirstName() + "%");
            }

            if (param.getLastName() != null) {
                sql.append("AND cs.lastName= :lastName ");

                executeSpec = executeSpec.bind("lastName", param.getLastName());
            }

            return executeSpec;
        };
    }

}
