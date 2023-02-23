package id.or.greenlabs.r2dbc.assembler.dto;

import id.or.greenlabs.r2dbc.assembler.generic.BaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:13 PM
 */
@Data
@NoArgsConstructor
public class CategoryDto implements BaseDto {

    private Integer id;

    private String name;

    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
