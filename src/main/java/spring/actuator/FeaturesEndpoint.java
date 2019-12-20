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

    @ReadOperation
    public Map<String, Feature> getAll() {
        return features;
    }

    @ReadOperation
    public Feature get(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void add(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void delete(@Selector String name) {
        features.remove(name);
    }
}
