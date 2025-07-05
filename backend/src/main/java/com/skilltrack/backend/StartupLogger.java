package com.skilltrack.backend;

import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger {

    private final WebServerApplicationContext serverAppContext;

    public StartupLogger(WebServerApplicationContext serverAppContext) {
        this.serverAppContext = serverAppContext;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logOnStartup() {
        int port = serverAppContext.getWebServer().getPort();
        String contextPath = serverAppContext.getApplicationName();

        System.out.println("\n=============================");
        System.out.println("✅ Server is up and running!");
        System.out.println("🌐 URL: http://localhost:" + port + contextPath + "/users");
        System.out.println("=============================\n");
    }
}
