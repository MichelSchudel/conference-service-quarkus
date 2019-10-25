package nl.craftsmen.conference.service.quarkus;

import java.util.Collections;
import java.util.List;

public class Fallback {

    public static List<Country> fallback() {
        return Collections.emptyList();
    }

}
