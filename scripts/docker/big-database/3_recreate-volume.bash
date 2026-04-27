#!/bin/bash

NEW_ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
DOCKER_IMAGES_LOCAL_STORAGE_DIR=${DOCKER_IMAGES_USER_STORAGE_DIR}

DOCKER_CNTNR_TARGET="maiordomus-postgres-test"
ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
image_archive_name="maiordomus-img-prod.tar"

echo "Ubijanie kontenera (o ile jest uruchomiony)"
docker stop ${DOCKER_CNTNR_TARGET}

echo "Kopiowanie pliku archiwum z danymi woluminu - do katalogu bieżącego"
cp -v ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}/${ARCHIVE_FILE_WITH_VOLUME_DATA} .

ls -al

#docker load -i ${image_archive_name}

#docker run --name ${DOCKER_CNTNR_TARGET} \
#-d \
#-e POSTGRES_PASSWORD=maiordomus-be \
#-e POSTGRES_USER=maiordomus \
#-e POSTGRES_DB=maiordomus \
#-e PGDATA=/var/lib/postgresql/data/pgdata \
#-v data:/var/lib/postgresql/data \
#postgres:17.2-alpine3.20

# Przywrócenie danych:
docker run --rm \
--volumes-from ${DOCKER_CNTNR_TARGET} \
-v $(pwd):/backup \
alpine \
tar xzvf /backup/${ARCHIVE_FILE_WITH_VOLUME_DATA} -C /

echo "Teraz dane powinny być przywrócone - uruchom kontener: ${DOCKER_CNTNR_TARGET}"