package kr.co.chunjae1.service;


import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    @Override
    public void register(BoardDTO boardDTO) {
        boardMapper.insert(boardDTO);
    }

    @Override
    public BoardDTO get(Long bno) {
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardDTO boardDTO) {
        return boardMapper.update(boardDTO) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.getList();
    }
}
