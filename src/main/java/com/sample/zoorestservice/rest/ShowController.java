package com.sample.zoorestservice.rest;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {

    private ShowRepository showRepository;

    @Autowired
    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping(value = "/shows")
    public List<Show> getShows() {
        return showRepository.findAll();
    }
}
