package cc.procon;

import cc.procon.service.ModifyColumnService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author procon
 * @since 2022-09-20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MySteelApplication.class)
public class MySteelTest {

    @Autowired
    private ModifyColumnService modifyColumnService;

    @Test
    public void modifyTriggerTest(){
        modifyColumnService.modifyTrigger();
   }
}
