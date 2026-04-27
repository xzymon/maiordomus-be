# to (tzn. tą funkcję) najlepiej dodać do .bashrc
# wtedy można w ten sposób prosto zmodyfikować nazwę pliku - tak by w jego nazwie został doklejony czas modyfikacji zawartości
# - przydatne zwłaszcza do przezywania właśnie wygenerowanego pliku zawierającego zrzut zawartości woluminu z danymi z postgresql
# takie przezwanie robi się tak:
# $ file_add_timestamp maiordomus-postgres-prod.tar.gz

file_add_timestamp() {
    local FILE="$1"
    if [ -f "$FILE" ]; then
        # Pobierz sformatowaną datę modyfikacji
        local TS=$(date -d "@$(stat -c %Y "$FILE")" +%Y%m%dT%H%M%S)
        
        # %.* usuwa tylko ostatnie rozszerzenie (.gz)
        # %%.* usuwa wszystko od pierwszej kropki (.tar.gz)
        local NAME="${FILE%%.*}"
        
        # Wyciągamy całe rozszerzenie (wszystko po pierwszej kropce)
        # Używamy #*., aby usunąć nazwę pliku i zostać z resztą
        local EXT="${FILE#*.}"
        
        # Zmień nazwę: nazwa_timestamp.tar.gz
        mv "$FILE" "${NAME}_${TS}.${EXT}"
        echo "Zmieniono nazwę na: ${NAME}_${TS}.${EXT}"
    else
        echo "Plik nie istnieje!"
    fi
}
