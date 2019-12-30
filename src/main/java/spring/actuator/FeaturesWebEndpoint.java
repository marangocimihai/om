package spring.actuator;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeaturesEndpoint {
    private Map<String, Feature> features = new ConcurrentHashMap<>();

    public static class Feature {
        private Boolean enabled;
    }

    @ReadOperation //GET
    public Map<String, Feature> getAll() {
        return features;
    }

    @ReadOperation //GET
    public Feature get(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation //POST
    public void add(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation //DELETE
    public void delete(@Selector String name) {
        features.remove(name);
    }
}
