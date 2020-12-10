#!/bin/bash
mvn clean install
# shellcheck disable=SC2164
cd target
java -jar weather-api-1.0.0-SNAPSHOT.jar