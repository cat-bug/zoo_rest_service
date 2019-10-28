package com.sample.zoorestservice;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ShowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DataMongoTest
@EnableAutoConfiguration
public class RepositoryTest {

    @Autowired
    private ShowRepository showRepository;

    @Test
    public void showRepoTest() {
        Show show = new Show("1", "Penguins feeding", "Saturday 11:00");
        showRepository.save(show);
        List<Show> shows = showRepository.findAll();
        assertThat("expected size is returned", shows.size(), is(1));
        assertThat("name of first element as expected", shows.get(0).getName(), is("Penguins feeding"));
    }
}
