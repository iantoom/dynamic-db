package id.bts.dynamicdb.config;

import java.util.List;

import javax.activation.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({DataSourceList.class})
public class Config {

}
