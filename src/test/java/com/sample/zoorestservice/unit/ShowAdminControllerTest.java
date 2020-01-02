package com.sample.zoorestservice.unit;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ShowRepository;
import com.sample.zoorestservice.rest.ShowAdminController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShowAdminControllerTest {

    @Mock
    private ShowRepository showRepository;

    @InjectMocks
    private ShowAdminController controller;

    @Test
    public void postShow(){
        Show show = new Show("11", "Goats petting", "Every Monday 18:00");

        controller.postShow(show);
        verify(showRepository).insert(show);
    }

    @Test
    public void deleteShowTest(){
        Show show1 = new Show("1", "Penguins feeding", "Every Saturday 12:00");
        when(showRepository.findById("1")).thenReturn(Optional.of(show1));

        controller.deleteShow("1");
        verify(showRepository).delete(show1);
    }
}
