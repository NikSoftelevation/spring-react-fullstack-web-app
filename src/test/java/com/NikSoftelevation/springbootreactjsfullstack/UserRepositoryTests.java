package com.NikSoftelevation.springbootreactjsfullstack;

import com.NikSoftelevation.springbootreactjsfullstack.model.User;
import com.NikSoftelevation.springbootreactjsfullstack.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.MySQLContainer;

import java.util.Properties;
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:8.0")
            .withUsername("root")
            .withPassword("Nikhil@07@18")
            .withDatabaseName("springreactfullstack");

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test", getJpaProperties());
    }

    @After
    public void tearDown() {
        entityManagerFactory.close();
    }


    private Properties getJpaProperties() {
        Properties props = new Properties();
        props.setProperty("database.url", "jdbc:mysql://localhost:3306/springreactfullstack");
        props.setProperty("database.username", "root");
        props.setProperty("database.password", "Nikhil@07@18");
        props.setProperty("database.driver-class-name", "com.mysql.cj.jdbc.Driver");

        props.put("hibernate.hbm2ddl.auto", "create-drop");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return props;
    }

    @Test
    public void save_user_test() {
        User user = User.builder()
                .username("nikhil@07@18")
                .email("nikhil.softelevation@gmail.com")
                .name("Nikhil")
                .surname("Sharma")
                .password("Nikhil@07@18")
                .build();
        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
}