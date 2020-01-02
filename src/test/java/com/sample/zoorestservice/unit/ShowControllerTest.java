package com.sample.zoorestservice.unit;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ShowRepository;
import com.sample.zoorestservice.rest.ShowController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShowControllerTest {

    @Mock
    private ShowRepository showRepository;

    @InjectMocks
    private ShowController controller;

    @Test
    public void getShowsTest(){
        Show show1 = new Show("1", "Penguins feeding", "Every Saturday 12:00");
        Show show2 = new Show("2", "Dolphins swimming", "Every Tuesday and Friday 11:00");
        List<Show> expected = asList(show1,show2);
        when(showRepository.findAll()).thenReturn(expected);

        List<Show> actual = controller.getShows();
        assertThat("shows returned as expected", actual, containsInAnyOrder(expected.toArray()));
    }
}
