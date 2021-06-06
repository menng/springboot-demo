package org.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.demo.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testFindAll() {
        transactionService.save();
    }
}
