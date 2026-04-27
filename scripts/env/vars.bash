# Lista zewnętrznych/inicjalnych zmiennych potrzebnych do uruchomienia aplikacji lub skryptów

$MAIOR_ARCH_CSV_DATA_UNZIP_DIR
$MAIOR_DRIVER_FILES_DIR
$MAIOR_IN
$LOGS_PARENT_DIR

# docker/big-database/0_save-container-layers-in-image.bash
DOCKER_CNTNR_SRC=maiordomus-postgres-prod
DOCKER_IMAGE_TARGET_BASE_NAME=maiordomus-cntnr-data-prod
LAST_KNOWN_VERSION=v4
NEW_VERSION=v5

# docker/big-database/1_save-volume.bash
CNTNR_WITH_VOLUME_SRC="maiordomus-postgres-prod"
NEW_ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
image_archive_name="maiordomus-img-prod.tar"

# docker/big-database/2_load-volume.bash
# brak

# docker/big-database/3_recreate-volume.bash
NEW_ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
DOCKER_CNTNR_TARGET="maiordomus-postgres-test"
ARCHIVE_FILE_WITH_VOLUME_DATA="maiordomus-prod-volume.tar.gz"
image_archive_name="maiordomus-img-prod.tar"

# docker/files/arch_to_in_cp.bash
ARCH_PARENT_DIR=$MAIOR_ARCH_CSV_DATA_UNZIP_DIR
VALORS_LIST_PARENT=$MAIOR_DRIVER_FILES_DIR
IN=$MAIOR_IN
LOG_FILE=$LOGS_PARENT_DIR/maior/arch_cp_dirs.log

# docker/files/downloader_b1d.bash
VALORS_PARENT_DIR="/opt/stooq/in"
VALORS_CRYPTO=${VALORS_PARENT_DIR}/valors_crypto
VALORS_CURR=${VALORS_PARENT_DIR}/valors_curr

DOWNLOAD_PARENT_DIR="/opt/stooq/live/1d"
CRYPTO_DIR=${DOWNLOAD_PARENT_DIR}/crypto
CURR_DIR=${DOWNLOAD_PARENT_DIR}/curr

DOMAIN="stooq.pl"
#STQ_API_KEY="HCmP05QkDor3KIJ7RGTMlivVpdNfjzyY"