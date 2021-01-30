package cn.herculas.vql.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Web3TestTest {

    @Test
    public void testT() {
        Web3Test web3Test = new Web3Test();
        web3Test.test();
    }
}