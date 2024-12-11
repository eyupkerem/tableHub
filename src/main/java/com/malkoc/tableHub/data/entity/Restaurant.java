package com.malkoc.tableHub.data.entity;

import com.malkoc.tableHub.base.BaseEntity;
import com.malkoc.tableHub.data.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = Constants.ENTITY_PREFIX + "restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private int numberOfTable;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "restaurant")
    private List<User> employees;

}
