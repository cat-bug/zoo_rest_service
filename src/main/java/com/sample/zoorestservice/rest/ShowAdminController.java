package com.sample.zoorestservice.rest;

import com.sample.zoorestservice.model.Show;
import com.sample.zoorestservice.repo.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/admin/shows")
public class ShowAdminController {

    private ShowRepository showRepository;

    @Autowired
    public ShowAdminController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @PostMapping
    public void postShow(@RequestBody Show showToAdd) {
        showRepository.insert(showToAdd);
    }

    @DeleteMapping
    public void deleteShow(@RequestParam String id) {
        Optional<Show> show = showRepository.findById(id);
        show.ifPresent(show1 -> showRepository.delete(show1));
    }
}
