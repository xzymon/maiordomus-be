docker run --name maiordomus-postgres \
-d \
-p 5432:5432 \
-e POSTGRES_PASSWORD=maiordomus-be \
-e POSTGRES_USER=maiordomus \
-e POSTGRES_DB=maiordomus \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v data:/var/lib/postgresql/data \
postgres:17.2-alpine3.20