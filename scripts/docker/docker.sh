


# poniżej powinno być 2025-03-14 a nie 2025-03-04
docker commit \
-m "Załadowane dane CSV currencies od 2024-10-01 do 2025-03-04 włącznie" \
maiordomus-postgres maiordomus-postgres-loaded:v0001


#
docker run --name maiordomus-postgres-loaded-v0001 \
-d \
-p 5432:5432 \
maiordomus-postgres-loaded:v0001


# zapisanie całego obrazu do pliku
docker save -o maiordomus-postgres-loaded_v0001.tar maiordomus-postgres-loaded:v0001


# załadowanie obrazu z pliku
docker load -i maiordomus-postgres-loaded_v0001.tar


#################################

