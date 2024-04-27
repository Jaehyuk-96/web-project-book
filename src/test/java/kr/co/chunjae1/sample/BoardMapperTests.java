package kr.co.chunjae1.sample;



import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.domain.PageRequestDTO;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.mapper.BoardMapper;
import kr.co.chunjae1.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

    @Setter(onMethod_ = @Autowired)
    private BoardService boardService;


    @Test
    public void testGetList() {
        boardMapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void tesInsert() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("새로 작성하는글");
        boardDTO.setContent("새로 작성하는 내용");
        boardDTO.setWriter("newbie");

        boardMapper.insert(boardDTO);
    }

    @Test
    public void testRead() {
        BoardDTO boardDTO = boardMapper.read(1L);

        log.info(boardDTO);
    }

    @Test
    public void testDelete() {
        int result = boardMapper.delete(1L);

        log.info(result);
    }

    @Test
    public void testUdpate() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBno(2L);
        boardDTO.setTitle("수정된 제목");
        boardDTO.setContent("수정된 내용");
        boardDTO.setWriter("user00");

        int result = boardMapper.update(boardDTO);
        log.info("update result:" + result);
    }

    @Test
    public void testSelectList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<BoardDTO> BoardList = boardMapper.selectList(pageRequestDTO);

        BoardList.forEach(DTO -> log.info(DTO));
    }

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.getListWithPaging(pageRequestDTO);

        log.info(pageResponseDTO);

        pageResponseDTO.getDtoList().stream().forEach(boardDTO -> log.info(boardDTO));
    }

    @Test
    public void testSelectSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t", "w"})
                .keyword("안녕")
                .from(LocalDate.of(2024,04,25))
                .to(LocalDate.of(2022,12,31))
                .build();

        List<BoardDTO> boardDTOList = boardMapper.selectList(pageRequestDTO);

        boardDTOList.forEach(boardDTO -> log.info(boardDTO));
    }
}


