package planet.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class UiRestConfiguration {

    @Value("${url.string}")
    private String localhostString;

    @Bean
    public RestTemplate getConfiguredRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setUriTemplateHandler(
                new DefaultUriBuilderFactory(localhostString));

        return restTemplate;

    }
}