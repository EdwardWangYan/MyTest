package com.ikentop.biz.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : tac
 * @since : 11/09/2017
 */

@Configuration
public class SwaggerConfiguration {
    @Autowired
    private Environment environment;

    @Bean
    @Profile({"dev", "test"})
    public ApiInfo apiInfo() {
        String version = "v0.0.1";
        return new ApiInfoBuilder()
                .title("api docs(" + version + ") - " + Arrays.toString(environment.getActiveProfiles()) + " : uptime - " + new SimpleDateFormat("yyyy-MM-dd hh:MM").format(new Date()))
                .version(version)
                .build();
    }
}
