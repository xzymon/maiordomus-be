package com.xzymon.maiordomus.lifecycle;

import com.xzymon.maiordomus.service.DummyService;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ApplicationEventsListener {

    private DummyService dummyService;

    public ApplicationEventsListener(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    // at start 1)
    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent: Kontekst aplikacji został odświeżony.");
        injectEntitiesToDatabase();
        System.out.println("Teraz repo powinno być zainicjalizowane");
    }

    // at start 2)
    @EventListener
    public void handleApplicationStarted(ApplicationStartedEvent event) {
        System.out.println("ApplicationStartedEvent: Aplikacja została uruchomiona.");
    }

    // at start 3)
    @EventListener
    public void handleApplicationReady(ApplicationReadyEvent event) {
        System.out.println("ApplicationReadyEvent: Aplikacja jest gotowa do działania.");
    }

    @EventListener
    public void handleApplicationStarting(ApplicationStartingEvent event) {
        System.out.println("ApplicationStartingEvent: Aplikacja jest uruchamiana.");
    }

    @EventListener
    public void handleEnvironmentPrepared(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("ApplicationEnvironmentPreparedEvent: Środowisko aplikacji zostało przygotowane.");
    }

    @EventListener
    public void handleContextInitialized(ApplicationContextInitializedEvent event) {
        System.out.println("ApplicationContextInitializedEvent: Kontekst aplikacji został zainicjalizowany.");
    }

    @EventListener
    public void handleApplicationPrepared(ApplicationPreparedEvent event) {
        System.out.println("ApplicationPreparedEvent: Kontekst aplikacji został przygotowany.");
    }

    @EventListener
    public void handleApplicationFailed(ApplicationFailedEvent event) {
        System.out.println("ApplicationFailedEvent: Wystąpił błąd aplikacji.");
    }

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent: Kontekst aplikacji został uruchomiony.");
    }

    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
        System.out.println("ContextStoppedEvent: Kontekst aplikacji został zatrzymany.");
    }

    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        System.out.println("ContextClosedEvent: Kontekst aplikacji został zamknięty.");
    }

    @EventListener
    public void handleRequestHandled(RequestHandledEvent event) {
        System.out.println("RequestHandledEvent: Żądanie HTTP zostało obsłużone.");
    }

    // Optional, if you're using Spring MVC and Servlet contexts.
    @EventListener
    public void handleServletRequestHandled(ServletRequestHandledEvent event) {
        System.out.println("ServletRequestHandledEvent: Żądanie Servlet zostało obsłużone.");
    }

    private void injectEntitiesToDatabase() {
        dummyService.initRepo();
    }
}