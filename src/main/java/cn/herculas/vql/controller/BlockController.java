package cn.herculas.vql.controller;

import cn.herculas.vql.data.VO.ResponseVO;
import cn.herculas.vql.service.BlockService;
import cn.herculas.vql.util.wrapper.ResponseWrapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/block")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping("/hash/{hash}")
    public ResponseVO<?> getBlockByHash(@PathVariable(name = "hash") String hash) {
        return ResponseWrapper.success(blockService.retrieveBlock(hash));
    }

    @GetMapping("/number/{number}")
    public ResponseVO<?> getBlockByNumber(@PathVariable(name = "number") Long number) {
        return ResponseWrapper.success(blockService.retrieveBlock(number));
    }
}
