# maiordomus-be

## UWAGA - WAZNE !!!
INTELLIJ build plan PROD!

Upewnij sie ze przed ladowaniem danych do bazy masz:
1. uruchomiony prawidlowy kontener z baza (ten z prod w nazwie)
2. uruchom maiordomus z PRAWIDLOWEJ konfiguracji -> tzn z MaiordomusBeApplication PROD

Jeżeli uruchomisz z blednej konfiguracji
- to przy zamykaniu kontenera dane zostana usuniete z bazy !!!

## Zaladowane dane - PROD db
| Nazwa Tabela          | Ostatnio Wczytane Dane z Daty |
|-----------------------|-------------------------------|
| `cmc_history`         | `2026-04-18`                  |
| `stock_candle_stq1d`  | `2026-04-18`                  |
| `stock_candle_stq15m` | `2026-03-31`                  |
| `notes`               | brak danych                   |

## SQLe
--select * from note;
--select * from cmc_history order by order_timestamp desc;
--select * from stock_candle_stq1d;
--select * from stock_candle_stq15m order by candle_day desc;
--select * from file_upload_audit order by processed desc;

## Ladowanie danych do tabel
Sa do tego przygotowane skrypty - w katalogu scripts/files:
arch_to_in_cp.bash
cp_csv_files_in.bash
cp_csv_files_in_for_valor.bash

### Rola skryptu - arch_to_in_cp.bash
- wymaga:


### Dane 15m
