package id.or.greenlabs.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ksadewo
 * @created 08/02/2023 - 9:07 AM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@Accessors(chain = true)
public class Category {

    @Id
    private Integer id;

    private String name;

    public Category(Integer id) {
        this.id = id;
    }
}
