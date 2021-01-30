package cn.herculas.vql.client;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class Web3Test {

    public void test() {
        Web3j web3j = Web3j.build(new HttpService("http://158.132.20.116:8545/"));
        try {
            Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
            System.out.println(web3ClientVersion.getWeb3ClientVersion());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
