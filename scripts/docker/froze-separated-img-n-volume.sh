alive_container="maiordomus-postgres"
volume_archive_name="maiordomus-volume.tar.gz"
image_archive_name="maiordomus-image.tar"

echo "Will try to save data separately"
echo "Image data will be saved to tar file"
echo "Volume data will be saved to tar.gz file"

docker run --rm \
--volumes-from ${alive_container} \
-v $(pwd):/backup \
alpine \
tar czvf /backup/${volume_archive_name} /var/lib/postgresql/data

# w sumie to to poniższe nic nie daje
docker save -o ${image_archive_name} ${alive_container}