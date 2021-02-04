#!/bin/bash

./gradlew :integration:run &
./gradlew :github:run &
./gradlew :twitter:run &

