package com.malkoc.tableHub.data.entity;

import com.malkoc.tableHub.base.BaseEntity;
import com.malkoc.tableHub.data.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = Constants.ENTITY_PREFIX + "order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private RestaurantTable restaurantTable;
    private Long price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String note;
    @OneToOne
    private User waiter;
}
