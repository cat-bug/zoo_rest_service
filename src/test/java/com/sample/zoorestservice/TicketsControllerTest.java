package com.sample.zoorestservice;

import com.sample.zoorestservice.model.Reservation;
import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ReservationRepository;
import com.sample.zoorestservice.rest.TicketController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketsControllerTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private TicketController controller;

    @BeforeEach
    private void setup(){
        Mockito.reset(reservationRepository);
    }

    @Test
    public void testPostShowReservation(){
        Show show2 = new Show("2", "Dolphins swimming", "Every Tuesday and Friday 11:00");
        Reservation reservation = new Reservation("2", show2, "Finn TheHuman", 5,
                LocalDate.of(2019, 12, 27));
        when(reservationRepository.insert(any(Reservation.class))).thenAnswer(i -> i.getArguments()[0]);

        controller.reserveTicketForShow(reservation);
        verify(reservationRepository).insert(reservation);
    }

    @Test
    public void testPostVisitReservation(){
        Reservation visitReservation = new Reservation("1", null,"John Doe", 2,
                LocalDate.of(2019, 12, 28));

        when(reservationRepository.insert(any(Reservation.class))).thenAnswer(i -> i.getArguments()[0]);

        controller.reserveTicketForVisit(visitReservation);
        verify(reservationRepository).insert(visitReservation);
    }

    @Test
    public void testGetTicketReservation(){
        Reservation visitReservation = new Reservation("1", null,"John Doe", 2,
                LocalDate.of(2019, 12, 28));
        when(reservationRepository.findById("1")).thenAnswer(i -> Optional.of(visitReservation));

        Reservation actual = controller.getReservation("1");
        assertThat("Returned reservation as expected", actual, is(visitReservation));
    }

    @Test
    public void testGetReservations(){
        Reservation showReservation = new Reservation("1", new Show("52", "Snake feeding", "Saturday 13:00"),"John Doe", 2,
                LocalDate.of(2019, 12, 28));
        when(reservationRepository.findById("1")).thenAnswer(i -> Optional.of(showReservation));

        Reservation actual = controller.getReservation("1");
        assertThat("Returned reservation as expected", actual, is(showReservation));
    }

    @Test
    public void getReservationNegative(){
        when(reservationRepository.findById("1")).thenAnswer(i -> Optional.empty());
        assertThrows(ResponseStatusException.class, () -> controller.getReservation("1"));
    }
}
