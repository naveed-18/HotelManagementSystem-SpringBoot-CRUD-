package com.github.naveed18.hotelmanagementsystem.controller;

import com.github.naveed18.hotelmanagementsystem.entity.ReservationEntity;
import com.github.naveed18.hotelmanagementsystem.service.ReservationServices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationServices reservationServices;

    public ReservationController(ReservationServices reservationServices) {
        this.reservationServices = reservationServices;
    }

    // VIEW ALL RESERVATIONS
    @GetMapping
    public String viewReservations(Model model) {
        model.addAttribute("reservations",
                reservationServices.viewReservations());
        return "reservations";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new ReservationEntity());
        return "add-reservation";
    }

    // SAVE RESERVATION
    @PostMapping("/save")
    public String saveReservation( @ModelAttribute("reservation") ReservationEntity reservation) {

        reservationServices.reserveRoom(reservation);
        return "redirect:/reservations";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        ReservationEntity reservation =
                reservationServices.getReservationById(id);

        model.addAttribute("reservation", reservation);
        return "edit-reservation";
    }

    // UPDATE RESERVATION
    @PostMapping("/update/{id}")
    public String updateReservation(
            @PathVariable Long id,
            @ModelAttribute("reservation") ReservationEntity reservation) {

        reservationServices.updateReservation(id, reservation);
        return "redirect:/reservations";
    }

    // DELETE RESERVATION
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationServices.deleteReservation(id);
        return "redirect:/reservations";
    }
}
