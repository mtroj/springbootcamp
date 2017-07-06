package pl.com.sages.spring.bootcamp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.sages.spring.bootcamp.config.Spring;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
//@ContextConfiguration(classes = Spring.class)
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    public void shouldDoShopping() throws Exception {
        //given

        // when
        applicationService.doShopping();

        // then
        // TODO ...
    }

}