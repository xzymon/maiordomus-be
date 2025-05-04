#!/bin/bash

DOCKER_IMAGE_SRC_BASE_NAME=maiordomus-cntnr-data-prod
IMAGE_VERSION=v3
DOCKER_IMAGE_SRC="${DOCKER_IMAGE_SRC_BASE_NAME}:${IMAGE_VERSION}"
NEW_CNTNR=maiordomus-postgres-test

docker run --name ${NEW_CNTNR} \
-d \
-p 5432:5432 \
-e POSTGRES_PASSWORD=maiordomus-be \
-e POSTGRES_USER=maiordomus \
-e POSTGRES_DB=maiordomus \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v data-test:/var/lib/postgresql/data \
${DOCKER_IMAGE_SRC}