package id.or.greenlabs.r2dbc.assembler.generic;

import java.util.Collection;
import java.util.List;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:06 PM
 */
public interface Assembler<D, E> {

    D toDto(E object);

    List<D> toDto(List<E> List);

    E toDocument(D dto);

    E toParam(D dto);

    List<E> toDocument(List<D> dtos);
}
