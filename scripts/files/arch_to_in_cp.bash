#!/bin/bash

ARCH_PARENT_DIR=$MAIOR_ARCH_CSV_DATA_UNZIP_DIR
VALORS_LIST_PARENT=$MAIOR_DRIVER_FILES_DIR
IN=$MAIOR_IN
LOG_FILE=$LOGS_PARENT_DIR/maior/arch_cp_dirs.log

# Kopiowanie plików CSV (zawierających dane z jednego dnia) - do katalogu wejściowego dla MAIOR

# Sprawdzenie, czy podano wystarczającą liczbę argumentów
if [ "$#" -lt 2 ]; then
    echo "Użycie: $0 <nazwa_katalogu_pod_unzip_zawierajacego_katalogi_z_plikami_csv> <plik_z_listą_walorów>"
    exit 1
    #Przykład
    # bash arch_to_in_cp.bash 2024 valors_curr
fi

# Argumenty
valor_dir_name="$1"   # katalog o nazwie odpowiadającej nazwie waloru (katalog ma zawierać pliki CSV)
valor_list_file="$2"   # plik z listą dni - dni podane w formacie yyyymmdd

SOURCE_DIR="$ARCH_PARENT_DIR/$valor_dir_name"
VALORS_SOURCE_PARENT="$VALORS_LIST_PARENT/$valor_list_file"

# Sprawdzenie, czy katalog $valor_dir_name istnieje
if [ ! -d $SOURCE_DIR ]; then
    echo "Błąd: Katalog \"$SOURCE_DIR\" nie istnieje."
    exit 2
fi

# Sprawdzenie, czy plik z listą dni istnieje
if [ ! -f $VALORS_SOURCE_PARENT ]; then
    echo "Błąd: Plik z listą walorów \"$VALORS_SOURCE_PARENT\" nie istnieje."
    exit 3
fi

echo "Kopiowanie plików, logowane do logu $LOG_FILE"

#cp -v $SOURCE_PARENT_DIR/$1/br*.png $IN >> $LOG_FILE


# Iterate through the values in the provided valor_list_file
while IFS= read -r valor; do
  echo "Processing valor: $valor"
  files_parent_dir="$SOURCE_DIR/$valor"
  if [ -d "$files_parent_dir" ]; then
    cp -v "$files_parent_dir"/*.csv "$IN/" >> $LOG_FILE
  else
    echo "There is no dir for valor: $valor , skipping"
  fi
done < "$VALORS_SOURCE_PARENT"

chown -v coder:coder "$IN"/*

echo "Po skopiowaniu: katalog $IN zawiera"
ls -1 "$IN" | wc -l
echo "Zakończono dla katalogu $valor_dir_name"

# Zakończ skrypt
exit 0