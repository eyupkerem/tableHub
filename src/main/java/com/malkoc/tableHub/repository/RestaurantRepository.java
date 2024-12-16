package com.malkoc.tableHub.repository;

import com.malkoc.tableHub.base.BaseRepository;
import com.malkoc.tableHub.data.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends BaseRepository<Restaurant> {
    Optional<Restaurant> findByName(String name);
}
