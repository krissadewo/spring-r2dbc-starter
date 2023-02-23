package id.or.greenlabs.r2dbc.assembler.wrapper;

import id.or.greenlabs.r2dbc.assembler.dto.CategoryDto;
import id.or.greenlabs.r2dbc.assembler.dto.ItemDto;
import id.or.greenlabs.r2dbc.assembler.generic.Assembler;
import id.or.greenlabs.r2dbc.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ksadewo
 * @created 13/02/2023 - 2:11 PM
 */
@Component
public class ItemWrapper implements Assembler<ItemDto, Item> {

    @Override
    public ItemDto toDto(Item object) {
        ItemDto dto = new ItemDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setCategory(object.getCategory());

        return dto;
    }

    @Override
    public List<ItemDto> toDto(List<Item> List) {
        return null;
    }

    @Override
    public Item toDocument(ItemDto dto) {
        Item entity = new Item();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCategory(new CategoryWrapper()
            .toDocument(new CategoryDto(dto.getCategory().getId(), dto.getCategory().getName()))
        );

        return entity;
    }

    @Override
    public Item toParam(ItemDto dto) {
        return null;
    }

    @Override
    public List<Item> toDocument(List<ItemDto> dtos) {
        return dtos.stream()
            .map(this::toDocument)
            .collect(Collectors.toList());
    }
}
