package id.or.greenlabs.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:03 PM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Accessors(chain = true)
public class Customer {

    @Id
    private Integer id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

}
