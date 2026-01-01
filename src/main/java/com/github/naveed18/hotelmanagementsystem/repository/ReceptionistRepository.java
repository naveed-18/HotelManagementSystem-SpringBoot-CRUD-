package com.github.naveed18.hotelmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.github.naveed18.hotelmanagementsystem.entity.ReceptionistEntity;

public interface ReceptionistRepository
        extends CrudRepository<ReceptionistEntity, Long> {

    Optional<ReceptionistEntity> findByEmail(String email);
}