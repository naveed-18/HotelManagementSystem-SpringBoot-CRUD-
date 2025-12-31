package com.github.naveed18.hotelmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.naveed18.hotelmanagementsystem.entity.ReservationEntity;



public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
