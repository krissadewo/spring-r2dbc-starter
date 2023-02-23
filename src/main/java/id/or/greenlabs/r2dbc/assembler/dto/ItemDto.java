package id.or.greenlabs.r2dbc.assembler.dto;

import id.or.greenlabs.r2dbc.assembler.generic.BaseDto;
import id.or.greenlabs.r2dbc.entity.Category;
import lombok.Data;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:09 PM
 */
@Data
public class ItemDto implements BaseDto {

    private Integer id;

    private String name;

    private Category category;

}
