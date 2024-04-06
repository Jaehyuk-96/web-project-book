package kr.co.chunjae1.service;

import kr.co.chunjae1.domain.BoardDTO;

import java.util.List;

public interface BoardService {

    public void register(BoardDTO board);
    public BoardDTO get(Long bno);
    public boolean modify(BoardDTO BoardDTO);
    public boolean remove(Long bno);
    public List<BoardDTO> getList();
}
