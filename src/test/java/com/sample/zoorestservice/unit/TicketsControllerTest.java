package com.sample.zoorestservice.unit;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.model.ShowReservation;
import com.sample.zoorestservice.model.VisitReservation;
import com.sample.zoorestservice.repo.ShowReservationRepository;
import com.sample.zoorestservice.repo.VisitReservationRepository;
import com.sample.zoorestservice.rest.TicketController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketsControllerTest {

    @Mock
    private ShowReservationRepository showReservationRepository;

    @Mock
    private VisitReservationRepository visitReservationRepository;

    @InjectMocks
    private TicketController controller;

    @Test
    public void testPostShowReservation(){
        Show show2 = new Show("2", "Dolphins swimming", "Every Tuesday and Friday 11:00");
        ShowReservation showReservation = new ShowReservation("2", show2, "Finn TheHuman", 5,
                LocalDate.of(2019, 12, 27));
        when(showReservationRepository.insert(any(ShowReservation.class))).thenAnswer(i -> i.getArguments()[0]);

        controller.reserveTicketForShow(showReservation);
        verify(showReservationRepository).insert(showReservation);
    }

    @Test
    public void testPostVisitReservation(){
        VisitReservation visitReservation = new VisitReservation("1","John Doe", 2,
                LocalDate.of(2019, 12, 28));

        when(visitReservationRepository.insert(any(VisitReservation.class))).thenAnswer(i -> i.getArguments()[0]);

        controller.reserveTicketForVisit(visitReservation);
        verify(visitReservationRepository).insert(visitReservation);
    }

}
