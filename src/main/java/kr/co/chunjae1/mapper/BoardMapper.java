package kr.co.chunjae1.mapper;

import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.domain.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

//    @Select("select * from tb_board")
    public List<BoardDTO> getList();

    public List<BoardDTO> selectList(PageRequestDTO pageRequestDTO);

    public int getCount(PageRequestDTO pageRequestDTO);
    
    public void insert(BoardDTO boardDTO);

    public BoardDTO read(Long bno);

    public int delete(Long bno);

    public int update(BoardDTO boardDTO);

}
