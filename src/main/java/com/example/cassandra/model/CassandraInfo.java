package com.example.cassandra.model;

import io.micronaut.core.annotation.Introspected;

import java.util.Objects;

@Introspected
public class CassandraInfo {
    private String clusterName;
    private String releaseVersion;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CassandraInfo that = (CassandraInfo) o;
        return Objects.equals(clusterName, that.clusterName) &&
                Objects.equals(releaseVersion, that.releaseVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterName, releaseVersion);
    }
}
