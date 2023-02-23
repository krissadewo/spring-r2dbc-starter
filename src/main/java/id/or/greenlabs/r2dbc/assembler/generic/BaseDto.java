package id.or.greenlabs.r2dbc.assembler.generic;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:09 PM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface BaseDto extends Serializable {
}
