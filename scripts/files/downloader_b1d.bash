#!/usr/bin/env bash

VALORS_PARENT_DIR="/opt/stooq/in"
VALORS_CRYPTO=${VALORS_PARENT_DIR}/valors_crypto
VALORS_CURR=${VALORS_PARENT_DIR}/valors_curr

DOWNLOAD_PARENT_DIR="/opt/stooq/live/1d"
CRYPTO_DIR=${DOWNLOAD_PARENT_DIR}/crypto
CURR_DIR=${DOWNLOAD_PARENT_DIR}/curr

DOMAIN="stooq.pl"
#STQ_API_KEY="HCmP05QkDor3KIJ7RGTMlivVpdNfjzyY"

# Inicjalizacja zmiennych
START_DATE=""
END_DATE=""
CRYPTO=false
CURR=false
VALORS_FILE=""
DEST_DIR=""
API_KEY=""

# Funkcja wyświetlająca pomoc
usage() {
    echo "Użycie: $0  [-x | -c] -a <stooq-api-key> -s <data> -e <data>"
    echo "  -x, --crypto          Użyj kryptowalut"
    echo "  -c, --curr            Użyj walut"
    echo "  -a, --stooq-api-key   API KEY"
    echo "  -s, --start-date      Data początkowa, w formacie: yyyyMMdd"
    echo "  -e, --end-date        Data końcowa,    w formacie: yyyyMMdd"
    exit 1
}

# Funkcja walidująca format i poprawność daty (yyyyMMdd)
validate_date() {
    local d=$1
    # Sprawdzenie czy format to dokładnie 8 cyfr
    if [[ ! $d =~ ^[0-9]{8}$ ]]; then
        echo "Błąd: Data $d musi być w formacie yyyyMMdd (8 cyfr)."
        exit 2
    fi

    # Próba konwersji przez polecenie date w celu sprawdzenia poprawności kalendarzowej
    if ! date -d "$d" "+%Y%m%d" >/dev/null 2>&1; then
        echo "Niepoprawna data: $d"
        exit 3
    fi
}

# Parsowanie argumentów
while [[ $# -gt 0 ]]; do
    case "$1" in
        -s|--start-date)
            START_DATE="$2"
            shift 2
            ;;
        -e|--end-date)
            END_DATE="$2"
            shift 2
            ;;
        -x|--crypto)
            CRYPTO=true
            shift
            ;;
        -c|--curr)
            CURR=true
            shift
            ;;
        -a|--stooq-api-key)
            API_KEY="$2"
            shift 2
            ;;
        *)
            echo "Nieznana opcja: $1"
            usage
            ;;
    esac
done

# Walidacja wymaganych parametrów
if [[ -z "$API_KEY" ]]; then
    echo "Błąd: Parametr --stooq-api-key jest wymagany."
    echo "Podpowiedź: może spróbuj z wartością HCmP05QkDor3KIJ7RGTMlivVpdNfjzyY ?"
    usage
fi

# Walidacja wymaganych parametrów
if [[ -z "$START_DATE" || -z "$END_DATE" ]]; then
    echo "Błąd: Parametry --start-date i --end-date są wymagane."
    usage
fi

# Wywołanie walidacji dat
validate_date "$START_DATE"
validate_date "$END_DATE"


# Walidacja wzajemnego wykluczania -x i -c
if [[ "$CRYPTO" == true && "$CURR" == true ]]; then
    echo "Błąd: Opcje --crypto (-x) oraz --curr (-c) wzajemnie się wykluczają."
    usage
fi

# Sprawdzenie czy wybrano chociaż jedną z opcji (opcjonalnie, zależnie od logiki)
if [[ "$CRYPTO" == false && "$CURR" == false ]]; then
    echo "Błąd: Musisz wybrać albo --crypto (-x) albo --curr (-c)."
    usage
fi

# Przypisanie odpowiedniego pliku na podstawie wybranej opcji
if [[ "$CRYPTO" == true ]]; then
    VALORS_FILE="$VALORS_CRYPTO"
    DEST_DIR="$CRYPTO_DIR"
else
    VALORS_FILE="$VALORS_CURR"
    DEST_DIR="$CURR_DIR"
fi

# Sprawdzenie istnienia pliku $VALORS_FILE
if [[ ! -f "$VALORS_FILE" ]]; then
    echo "Błędny namiar na plik z walorami: $VALORS_FILE"
    exit 4
fi

# Sprawdzenie istnienia katalogu docelowego i uprawnień do zapisu
if [[ ! -d "$DEST_DIR" ]]; then
    echo "Błąd: Katalog docelowy nie istnieje: $DEST_DIR"
    exit 5
fi

if [[ ! -w "$DEST_DIR" ]]; then
    echo "Błąd: Brak uprawnień do zapisu w katalogu: $DEST_DIR"
    exit 6
fi

echo "Parametry poprawne:"
echo "Start: $START_DATE, End: $END_DATE, Crypto: $CRYPTO, Curr: $CURR"
echo "Zawartość pliku walorów ($VALORS_FILE):"
cat "$VALORS_FILE"

echo "------------------------------------------"
echo "Rozpoczynam przetwarzanie walorów..."

# Przetwarzanie pliku linia po linii
while IFS= read -r VALOR || [[ -n "$VALOR" ]]; do
    # Pomijamy puste linie, jeśli takie wystąpią
    [[ -z "$VALOR" ]] && continue

    # Użycie awk do wyświetlenia wymaganych informacji
    # Przekazujemy zmienne Basha do awk za pomocą opcji -v
    ##
    ##awk -v valor="$VALOR" -v start="$START_DATE" -v end="$END_DATE" 'BEGIN {
    ##    print "Walor: " valor;
    ##    print "Data końcowa: " end;
    ##    print "Data początkowa: " start;
    ##}'

    # Tworzenie nazwy pliku (złączenie waloru i daty końcowej)
    FILE_NAME="${VALOR}_b1d_${END_DATE}_01.csv"
    DEST_FILE="${DEST_DIR}/${FILE_NAME}"
    URL_PATH="https://${DOMAIN}/q/d/l/?s=${VALOR}&f=$START_DATE&t=${END_DATE}&i=d&apikey=${API_KEY}"

    echo "Wygenerowana nazwa pliku: $FILE_NAME"
    echo "           Plik docelowy: $DEST_FILE"
    echo "---"

    #curl -o BTC.V_b1d_20251005_20260418_01.csv https://stooq.pl/q/d/l/?s=ADA.V&f=20251005&t=20260418&i=d&apikey=HCmP05QkDor3KIJ7RGTMlivVpdNfjzyY
    curl -o ${DEST_FILE} ${URL_PATH}

    echo "Teraz zaśnij na 5 sekund"
    sleep 5

done < "$VALORS_FILE"

ls -al ${DEST_DIR}
ls -1 ${DEST_DIR} | wc -l

echo "Przetwarzanie zakończone."