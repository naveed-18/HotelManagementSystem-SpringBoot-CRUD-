package com.github.naveed18.hotelmanagementsystem.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.github.naveed18.hotelmanagementsystem.entity.ReservationEntity;
import com.github.naveed18.hotelmanagementsystem.repository.ReservationRepository;

@Service
public class ReservationServices {

    private ReservationRepository reservationRepository;

    public ReservationServices (ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // CREATE
    public ReservationEntity reserveRoom (ReservationEntity reservationEntity) {
        ReservationEntity savedReservationEntity = reservationRepository.save(reservationEntity);
        return savedReservationEntity;
    }

    // READ
    public List<ReservationEntity> viewReservations () {
        return (List<ReservationEntity>) reservationRepository.findAll();
    }

    // UPDATE
    public ReservationEntity updateReservation (Long reservationId, ReservationEntity data) {
        ReservationEntity existing =
            reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));
                    
        existing.setGuestName(data.getGuestName());
        existing.setRoomNumber(data.getRoomNumber());
        existing.setPhoneNumber(data.getPhoneNumber());
        return reservationRepository.save(existing);
    }

    public ReservationEntity getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}