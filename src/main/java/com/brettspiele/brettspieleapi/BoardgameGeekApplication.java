package com.brettspiele.brettspieleapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@OpenAPIDefinition(
        info = @Info(
                title = "Brettspiele API",
                version = "1.0",
                description = "API zur Verwaltung von Brettspiele"
        )
)
@SpringBootApplication
public class BoardgameGeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardgameGeekApplication.class, args);

        try{
            String url = "http://localhost:8081/swagger-ui.html";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Desktop is not supported");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
