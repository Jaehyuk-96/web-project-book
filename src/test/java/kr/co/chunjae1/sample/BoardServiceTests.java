package kr.co.chunjae1.sample;



import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.mapper.BoardMapper;
import kr.co.chunjae1.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = @Autowired)
    private BoardService boardService;

    @Test
    public void testExist() {

        log.info(boardService);
        assertNotNull(boardService);
    }
}
