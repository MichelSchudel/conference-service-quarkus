package nl.craftsmen.conference.service.quarkus;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.validation.constraints.Size;

@ConfigProperties(prefix = "app")
public class ConferenceConfiguration {

    @ConfigProperty(name = "hellomessage")
    @Size(min= 5)
    public String hellomessage;
}
