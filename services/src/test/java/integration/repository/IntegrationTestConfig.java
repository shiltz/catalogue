package integration.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"za.co.shilton.repository"})
@EnableJpaRepositories(basePackages = { "za.co.shilton.repository" })
@EntityScan("za.co.shilton.entity")
public class IntegrationTestConfig {
}
