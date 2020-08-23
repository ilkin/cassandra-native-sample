# Micronaut Cassandra Graal #

Test application for Micronaut Cassandra and GraalVM.

Build native:
```
./gradlew assemble
./docker-build.sh
```

To run Cassandra in Docker:
```
docker run -p 9042:9042 --rm --name cassandra -d cassandra:3.11
```

To Run Application in Docker:
```
docker build . -t cassandra-native-sample
```

To test the application:

```
curl localhost:8080/cassandra/info
```