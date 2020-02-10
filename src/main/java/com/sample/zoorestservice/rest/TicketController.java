package com.sample.zoorestservice.rest;

import com.sample.zoorestservice.model.Reservation;
import com.sample.zoorestservice.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController extends BaseController {
    private ReservationRepository reservationRepository;

    @Autowired
    public TicketController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping(value = "/shows")
    @ResponseStatus(HttpStatus.CREATED)
    public void reserveTicketForShow(@RequestBody Reservation reservation){
        reservationRepository.insert(reservation);
    }

    @PostMapping(value = "/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public void reserveTicketForVisit(@RequestBody Reservation visitReservation){
        reservationRepository.insert(visitReservation);
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservation(@PathVariable String reservationId){
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return getEntityOrThrow(reservation, format("Reservation %s not found", reservationId));
    }
}
