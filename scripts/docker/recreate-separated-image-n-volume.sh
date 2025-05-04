alive_container="maiordomus-postgres"
volume_archive_name="maiordomus-volume.tar.gz"
image_archive_name="maiordomus-image.tar"


docker load -i ${image_archive_name}

docker run --name ${alive_container} \
-d \
-e POSTGRES_PASSWORD=maiordomus-be \
-e POSTGRES_USER=maiordomus \
-e POSTGRES_DB=maiordomus \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v data:/var/lib/postgresql/data \
postgres:17.2-alpine3.20

# Przywrócenie danych:
docker run --rm \
--volumes-from ${alive_container} \
-v $(pwd):/backup \
alpine \
tar xzvf /backup/${volume_archive_name} -C /