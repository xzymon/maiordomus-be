#!/bin/bash

# Tak naprawdę to chodzi o to że trzeba mieć uruchomiony kontener do którego chcemy ładować dane do woluminu
# Zapewne zwykle będzie chodziło o to by mieć uruchomiony kontener maiordomus-postgres-test
# Jeżeli takowy nie istnieje to trzeba uruchomić skrypt z innego katalogu
# Chodzi o skrypt ../postgres-run-test.bash
# Ale pamiętaj - to tylko o tyle o ile jeszcze nie istnieje kontener do którego chcemy ładować dane.
# Skrypt 3 potrzebuje mieć uruchomiony kontener o nazwie która jest tam wskazana w zmiennej. Jeśli jest uruchomiony to skrypt numer 3 sobie już sam poradzi.