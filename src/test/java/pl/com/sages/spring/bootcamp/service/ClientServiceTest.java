package pl.com.sages.spring.bootcamp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.sages.spring.bootcamp.hibernate.model.Client;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ClientServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ClientService clientService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void should_save_client() throws Exception {
        //given
        jdbcTemplate.execute("truncate client");
        Client client = new Client();
        client.setName("Radek");
        client.setDiscount(10d);

        // when
        clientService.save(client);

        // then
        Integer count = jdbcTemplate.queryForObject("select count(*) from client", Integer.class);
        assertThat(count).isEqualTo(1);
    }
}