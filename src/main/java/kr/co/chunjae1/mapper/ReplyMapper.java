package kr.co.chunjae1.mapper;

import kr.co.chunjae1.domain.Criteria;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.domain.ReplyDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyDTO replyDTO);

    public ReplyDTO read(Long rno);

    public int delete(Long rno);

    public int update(ReplyDTO replyDTO);

    public List<ReplyDTO> getListWithPaging(
            @Param("criteria") Criteria criteria,
            @Param("bno") Long bno);
}
