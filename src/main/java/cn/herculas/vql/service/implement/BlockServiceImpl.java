package cn.herculas.vql.service.implement;

import cn.herculas.vql.data.DO.Block;
import cn.herculas.vql.enumeration.ExceptionEnum;
import cn.herculas.vql.exception.BusinessException;
import cn.herculas.vql.repository.BlockRepository;
import cn.herculas.vql.service.BlockService;

import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public Block retrieveBlock(Long number) {
        return blockRepository
                .findBlockByNumber(number)
                .orElseThrow(() -> new BusinessException(ExceptionEnum.BLOCK_NOT_EXIST));
    }

    @Override
    public Block retrieveBlock(String hash) {
        return blockRepository
                .findBlockByHash(hash)
                .orElseThrow(() -> new BusinessException(ExceptionEnum.BLOCK_NOT_EXIST));
    }
}
