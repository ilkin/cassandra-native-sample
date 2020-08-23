package com.example.cassandra.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.example.cassandra.model.CassandraInfo;

import javax.inject.Singleton;

@Singleton
public class CassandraRepository {
    private final CqlSession cqlSession;

    public CassandraRepository(CqlSession cqlSession) {
        this.cqlSession = cqlSession;
    }

    public CassandraInfo getInfo() {
        ResultSet resultSet = cqlSession.execute("select cluster_name, release_version from system.local");
        Row row = resultSet.one();
        CassandraInfo cassandraInfo = new CassandraInfo();
        cassandraInfo.setClusterName(row != null ? row.getString("cluster_name") : null);
        cassandraInfo.setReleaseVersion(row != null ? row.getString("release_version") : null);
        return cassandraInfo;
    }
}
