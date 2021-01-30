package cn.herculas.vql.repository;

import cn.herculas.vql.data.DO.Block;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BlockRepository extends MongoRepository<Block, String> {
    Optional<Block> findBlockByNumber(Long number);
    Optional<Block> findBlockByHash(String hash);
}
