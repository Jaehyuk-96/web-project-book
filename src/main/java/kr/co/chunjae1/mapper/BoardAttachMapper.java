package kr.co.chunjae1.mapper;

import kr.co.chunjae1.domain.BoardAttachDTO;

import java.util.List;

public interface BoardAttachMapper {

    public void insert(BoardAttachDTO boardAttachDTO);

    public void delete(String uuid);

    public List<BoardAttachMapper> findByBno(Long bno);
}
