package id.or.greenlabs.r2dbc.assembler.wrapper;

import id.or.greenlabs.r2dbc.assembler.dto.CategoryDto;
import id.or.greenlabs.r2dbc.assembler.generic.Assembler;
import id.or.greenlabs.r2dbc.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:14 PM
 */
@Component
public class CategoryWrapper implements Assembler<CategoryDto, Category> {

    @Override
    public CategoryDto toDto(Category object) {
        CategoryDto dto = new CategoryDto();
        dto.setId(object.getId());
        dto.setName(object.getName());

        return dto;
    }

    @Override
    public List<CategoryDto> toDto(List<Category> List) {
        return null;
    }

    @Override
    public Category toDocument(CategoryDto dto) {
        return null;
    }

    @Override
    public Category toParam(CategoryDto dto) {
        return null;
    }

    @Override
    public List<Category> toDocument(List<CategoryDto> dtos) {
        return null;
    }
}
