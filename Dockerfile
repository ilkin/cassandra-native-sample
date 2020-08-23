FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/cassandra-native-sample
WORKDIR /home/app/cassandra-native-sample

RUN native-image --no-server -cp build/libs/cassandra-native-sample-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/cassandra-native-sample/cassandra-native-sample /app/cassandra-native-sample
ENTRYPOINT ["/app/cassandra-native-sample"]
