package org.ferchu.garden.implementation.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="care")
public class CareDao {

    /**
     *
     * The care identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private CareTypeDao careTypeDao;

    /**
     *
     * When the care should be applied
     */
    private OffsetDateTime applicationDate;

    /**
     *
     * The time the care should be applied, if that time is consumed
     * the care is expired and the user should be notified
     */
    private Duration applicationDurationRange;
}
