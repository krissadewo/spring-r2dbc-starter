package id.or.greenlabs.r2dbc.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ksadewo
 * @created 08/02/2023 - 9:06 AM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "item")
@Accessors(chain = true)
public class Item {

    @Id
    private Integer id;

    private String name;

    private Category category;

    @Column("category_id")
    private Integer categoryId;

}
