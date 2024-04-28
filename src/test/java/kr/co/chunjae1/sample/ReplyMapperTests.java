package kr.co.chunjae1.sample;


import kr.co.chunjae1.domain.ReplyDTO;
import kr.co.chunjae1.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

    private Long[] bnoArr = {49129L,49128L, 49127L, 49126L, 49125L};
    @Setter(onMethod_ = @Autowired)
    private ReplyMapper replyMapper;

    @Test
    public void testMapper(){
        log.info(replyMapper);
    }

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1,10).forEach((i -> {
            ReplyDTO testreplyDTO = new ReplyDTO();

            testreplyDTO.setBno(bnoArr[i % 5]);
            testreplyDTO.setReply("댓글 테스트 " +i);
            testreplyDTO.setReplyer("replyer"+i);

            replyMapper.insert(testreplyDTO);

        }));
    }

    @Test
    public void testRead() {
        Long testRNO = 5L;
        ReplyDTO replyDTO = replyMapper.read(testRNO);
        log.info(replyDTO);
    }
}
