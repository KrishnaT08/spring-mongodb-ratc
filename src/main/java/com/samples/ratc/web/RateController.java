package com.samples.ratc.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samples.ratc.domain.Rate;

@RestController
@RequestMapping(value = "/rates")
public class RateController {
    private static final Logger logger = LoggerFactory.getLogger(RateController.class);
    private CrudRepository<Rate, String> repository;

    @Autowired
    public RateController(CrudRepository<Rate, String> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Rate> rates() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Rate add(@RequestBody @Valid Rate rate) {
        logger.info("Adding Rate " + rate.getId());
        return repository.save(rate);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rate update(@RequestBody @Valid Rate rate) {
        logger.info("Updating Rate " + rate.getId());
        return repository.save(rate);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rate getById(@PathVariable String id) {
        logger.info("Getting Rate " + id);
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting Rate " + id);
        repository.delete(id);
    }
}