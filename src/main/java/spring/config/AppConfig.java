package spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import spring.filter.EmployeeFilter;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ds);
        factory.setJpaVendorAdapter(adapter);
        factory.setPersistenceXmlLocation("classpath*:resources/META-INF/persistence.xml");
        factory.setPackagesToScan("spring/model");
        factory.setPersistenceUnitName("om");
        return factory;
    }

    @Bean
    public FilterRegistrationBean<EmployeeFilter> loggingFilter() {
        FilterRegistrationBean<EmployeeFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new EmployeeFilter());
        registrationBean.addUrlPatterns("/employee/*");

        return registrationBean;
    }
}
