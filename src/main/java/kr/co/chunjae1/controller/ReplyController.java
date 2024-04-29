package kr.co.chunjae1.controller;

import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.domain.Criteria;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.domain.ReplyDTO;
import kr.co.chunjae1.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping(value = "/new",
    consumes = "application/json",
    produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyDTO replyDTO){

        log.info("ReplyDTO:" + replyDTO);

        int insertCount = replyService.register(replyDTO);

        log.info("Reply INSERT COUNT:" + insertCount);

        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //삼항 연산자 처리
    }

    @GetMapping(value ="/pages/{bno}/{page}",
    produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_UTF8_VALUE})

    public ResponseEntity<List<ReplyDTO>> getList(
            @PathVariable("page") int page,
            @PathVariable("bno") Long bno){

        log.info("getList...................");
        Criteria criteria = new Criteria(page,10);

        log.info(criteria);

        return new ResponseEntity<>(replyService.getList(criteria, bno), HttpStatus.OK);

    }
}
