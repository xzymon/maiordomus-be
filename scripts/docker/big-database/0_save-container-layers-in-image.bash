#!/bin/bash

## Ten skrypt dotyczy sytuacji gdy w kontenerze zmieniło się coś poza samymi danymi w bazie
## Z dużym prawdopodobieństwem jego zastosowanie dotyczy jedynie sytuacji gdy:
## 1. zmieniono zmienne w kontenerze lub
## 2. zmieniono (zaktualizowano) wersję obrazu bazowego (czyli PostgreSQLa)

DOCKER_CNTNR_SRC=maiordomus-postgres-prod
DOCKER_IMAGE_TARGET_BASE_NAME=maiordomus-cntnr-data-prod
LAST_KNOWN_VERSION=v3
NEW_VERSION=v4
DOCKER_IMAGE_TARGET="${DOCKER_IMAGE_TARGET_BASE_NAME}:${NEW_VERSION}"
DOCKER_IMAGE_STORAGE_FILE="${DOCKER_IMAGE_TARGET_BASE_NAME}_${NEW_VERSION}.tar"
DOCKER_IMAGES_LOCAL_STORAGE_DIR=${DOCKER_IMAGES_USER_STORAGE_DIR}

echo "Ubijanie kontenera (o ile jest uruchomiony)"
docker stop ${DOCKER_CNTNR_SRC}

echo "Zapisywanie warstw w nowym obrazie"
docker commit ${DOCKER_CNTNR_SRC} ${DOCKER_IMAGE_TARGET}

echo "Nazwa nowego obrazu: ${DOCKER_IMAGE_TARGET}"

echo "Lokalizacja w której składowane są zarchiwizowane obrazy docker: ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}"
echo "Zapisywanie nowego obrazu jako: ${DOCKER_IMAGE_STORAGE_FILE}"
docker save -o ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}/${DOCKER_IMAGE_STORAGE_FILE} ${DOCKER_IMAGE_TARGET}

ls -al ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}

## Żeby wczytać obraz do usługi docker trzeba wykonać
# docker load -i ${DOCKER_IMAGE_STORAGE_FILE}

## Wypychanie obrazu do docker repo
# docker tag ${DOCKER_IMAGE_TARGET} your-docker-repo/${DOCKER_IMAGE_TARGET}
# docker push your-docker-repo/${DOCKER_IMAGE_TARGET}