package com.bsf.unleashdemo.conf;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.UnleashContextProvider;
import io.getunleash.util.UnleashConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureFlagsConfiguration {
    @Bean
    public UnleashConfig unleashConfig(
            @Value("${unleash.appName}") String appName,
            @Value("${unleash.instanceId}") String instanceId,
            @Value("${unleash.apiUrl}") String apiUrl,
            @Value("${unleash.apiKey}") String apiKey,
            UnleashContextProvider unleashContextProvider) {
        return UnleashConfig.builder()
                .appName(appName)
                .instanceId(instanceId)
                .unleashAPI(apiUrl)
                .unleashContextProvider(unleashContextProvider)
                .apiKey(apiKey)
                .build();
    }

    @Bean
    public Unleash unleash(UnleashConfig unleashConfig) {
        return new DefaultUnleash(unleashConfig);
    }
}
