docker run --name maiordomus-postgres-devel \
-d \
-p 5432:5432 \
-e POSTGRES_PASSWORD=maiordomus-be \
-e POSTGRES_USER=maiordomus \
-e POSTGRES_DB=maiordomus \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v data-devel:/var/lib/postgresql/data \
postgres:17.2-alpine3.20