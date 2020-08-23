package com.example.cassandra.controller;

import com.example.cassandra.model.CassandraInfo;
import com.example.cassandra.repository.CassandraRepository;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;


import javax.inject.Inject;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CassandraControllerTest {

    @Inject
    CassandraRepository cassandraRepository;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testGetCassandraInfo() {
        CassandraInfo mockCassandraInfo = new CassandraInfo();
        mockCassandraInfo.setClusterName("Test Cluster");
        mockCassandraInfo.setReleaseVersion("3.11");
        when( cassandraRepository.getInfo() )
                .then(invocation -> mockCassandraInfo);

        final CassandraInfo resultCassandraInfo = client.toBlocking()
                .retrieve(HttpRequest.GET("/cassandra/info"), CassandraInfo.class);

        assertEquals(
                mockCassandraInfo,
                resultCassandraInfo
        );
        verify(cassandraRepository).getInfo();
    }

    @MockBean(CassandraRepository.class)
    CassandraRepository cassandraRepository() {
        return mock(CassandraRepository.class);
    }
}
