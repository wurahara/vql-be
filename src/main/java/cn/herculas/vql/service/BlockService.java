package cn.herculas.vql.service;

import cn.herculas.vql.data.DO.Block;

public interface BlockService {
    Block retrieveBlock(Long number);
    Block retrieveBlock(String hash);
}
