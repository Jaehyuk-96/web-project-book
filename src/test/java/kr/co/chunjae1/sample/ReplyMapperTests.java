package kr.co.chunjae1.sample;


import kr.co.chunjae1.domain.Criteria;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.domain.ReplyDTO;
import kr.co.chunjae1.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
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

    @Test
    public void testDelete() {
        Long testrno = 1L;
        replyMapper.delete(testrno);
    }

    @Test
    public void testUpdate() {
        Long testRNO = 10L;

        ReplyDTO replyDTO = replyMapper.read(testRNO);

        replyDTO.setReply("Update Reply");

        int count = replyMapper.update(replyDTO);

        log.info("UPDATE COUNT:" + count);
    }

    @Test
    public void testList() {
        Criteria criteria = new Criteria();

        List<ReplyDTO> replyDTOList = replyMapper.getListWithPaging(criteria, bnoArr[0]);

        replyDTOList.forEach(reply -> log.info(reply));
    }
}
