package com.malkoc.tableHub.data.entity;

import com.malkoc.tableHub.base.BaseEntity;
import com.malkoc.tableHub.data.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = Constants.ENTITY_PREFIX + "food")
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @OneToOne
    private Restaurant restaurant;
    private String description;
    private boolean isAvailable;

}
