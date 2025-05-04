#!/bin/bash

# Ten skrypt służy do zapisania w pliku tar.gz woluminu z danymi dla bazy postgres
# Ma na celu zachowanie danych "dużej bazy" w celu odtworzenia kontenera z bazą - z woluminem załadowanym danymi

CNTNR_WITH_VOLUME_SRC="maiordomus-postgres-prod"
NEW_ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
DOCKER_IMAGES_LOCAL_STORAGE_DIR=${DOCKER_IMAGES_USER_STORAGE_DIR}
image_archive_name="maiordomus-img-prod.tar"

echo "Zapisywanie danych woluminu do pliku"


#runs a Docker container to create a compressed archive of a specific volume's data (PostgreSQL database in this case)
# and store it in the current directory
#`-v $(pwd):/backup`:
# - Mounts the current working directory (output of `$(pwd)`) on the host machine to the `/backup` directory inside the Alpine container.
# - This is used to save the final backup archive to the current directory.
docker run --rm \
--volumes-from ${CNTNR_WITH_VOLUME_SRC} \
-v $(pwd):/backup \
alpine \
tar czvf /backup/${NEW_ARCHIVE_FILE_WITH_VOLUME_DATA} /var/lib/postgresql/data

# w sumie to to poniższe nic nie daje
#docker save -o ${image_archive_name} ${CNTNR_WITH_VOLUME_SRC}

echo "Przenoszenie pliku do katalogu: ${NEW_ARCHIVE_FILE_WITH_VOLUME_DATA}"
mv -v ${NEW_ARCHIVE_FILE_WITH_VOLUME_DATA} ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}/

ls -al ${DOCKER_IMAGES_LOCAL_STORAGE_DIR}