package id.or.greenlabs.r2dbc.repository;

/**
 * @author ksadewo
 * @created 13/02/2023 - 10:59 AM
 */
@FunctionalInterface
public interface FunctionBuildQuery<P1, P2, P3, R> {

    R apply(P1 sql, P2 param, P3 mode);

}
