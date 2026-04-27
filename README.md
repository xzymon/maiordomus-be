# maiordomus-be


## Running
As it contains Liquibase and H2, to run it you probably will need to pass this VM option:
-Dliquibase.secureParsing=false
Without it, Liquibase will complain that it cannot parse its XML configuration (it's SpringBoot - Liquibase inconsistency for H2 : https://github.com/liquibase/liquibase/issues/3072 )

