package com.xzymon.maiordomus.scheduler;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduledTask {

    @Scheduled(cron = "0 * * * * *")
    public void performTask() {
        log.info("Zadanie uruchomione: ");
    }
}