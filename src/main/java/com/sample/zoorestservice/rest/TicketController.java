package com.sample.zoorestservice.rest;

import com.sample.zoorestservice.model.ShowReservation;
import com.sample.zoorestservice.model.VisitReservation;
import com.sample.zoorestservice.repo.ShowReservationRepository;
import com.sample.zoorestservice.repo.VisitReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private ShowReservationRepository showReservationRepository;
    private VisitReservationRepository visitReservationRepository;

    @Autowired
    public TicketController(ShowReservationRepository showReservationRepository,
                            VisitReservationRepository visitReservationRepository) {
        this.showReservationRepository = showReservationRepository;
        this.visitReservationRepository = visitReservationRepository;
    }

    @PostMapping(value = "/tickets/shows")
    public void reserveTicketForShow(@RequestBody ShowReservation showReservation){
        showReservationRepository.insert(showReservation);
    }

    @PostMapping(value = "/tickets/visits")
    public void reserveTicketForVisit(@RequestBody VisitReservation visitReservation){
        visitReservationRepository.insert(visitReservation);
    }
}
