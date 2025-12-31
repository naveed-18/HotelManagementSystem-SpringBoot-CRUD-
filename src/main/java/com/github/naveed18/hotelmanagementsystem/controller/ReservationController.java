package com.github.naveed18.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.naveed18.hotelmanagementsystem.entity.ReservationEntity;
import com.github.naveed18.hotelmanagementsystem.service.ReservationServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/reservations")
public class ReservationController {
    
    private ReservationServices reservationServices;

    public ReservationController(ReservationServices reservationServices) {
        this.reservationServices = reservationServices;
    }

    @PostMapping("/reserve-room")
    public ResponseEntity<ReservationEntity> reserveRoom (@RequestBody ReservationEntity reservationEntity) {
        ReservationEntity savedReservationEntity = reservationServices.reserveRoom(reservationEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReservationEntity);
    }

    @GetMapping("/view-reservations")
    public ResponseEntity<List<ReservationEntity>> viewAllReservations() {
        List<ReservationEntity> reservations = reservationServices.viewReservations();
        return ResponseEntity.ok(reservations);
    }
    
    @PutMapping("update-reservation/{reservationId}")
    public ResponseEntity<ReservationEntity> updateReservation (@PathVariable Long reservationId, @RequestBody ReservationEntity reservationEntity) {
        return ResponseEntity.ok(reservationServices.updateReservation(reservationId, reservationEntity));
    }

    @DeleteMapping("delete-reservation/{reservationId}")
    public ResponseEntity<ReservationEntity> deleteReservation (@PathVariable Long reservationId) {
        ReservationEntity exist = reservationServices.getReservationById(reservationId);
        if (exist == null) {
            return ResponseEntity.notFound().build();
        }
        reservationServices.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }
}
