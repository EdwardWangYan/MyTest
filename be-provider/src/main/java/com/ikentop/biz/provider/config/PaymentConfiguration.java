package com.ikentop.biz.provider.config;

import com.ikentop.biz.provider.domain.payment.PaymentProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author tac
 * @since 04/01/2018
 */
@Configuration
@EnableConfigurationProperties(PaymentProperties.class)
public class PaymentConfiguration {
}
