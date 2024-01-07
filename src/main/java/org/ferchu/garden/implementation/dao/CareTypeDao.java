package org.ferchu.garden.implementation.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="careType")
public class CareTypeDao {

    /**
     *
     * The care identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;

    /**
     *
     * Care name
     */
    private String name;

    /**
     *
     * Care description
     */
    private String description;
}
