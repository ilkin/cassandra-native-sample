package com.example.cassandra.controller;

import com.example.cassandra.model.CassandraInfo;
import com.example.cassandra.repository.CassandraRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/cassandra")
public class CassandraController {

    private final CassandraRepository cassandraRepository;

    public CassandraController(CassandraRepository cassandraRepository) {
        this.cassandraRepository = cassandraRepository;
    }

    @Get(value="/info", produces = MediaType.APPLICATION_JSON)
    public CassandraInfo getCassandraInfo() {
        return cassandraRepository.getInfo();
    }
}