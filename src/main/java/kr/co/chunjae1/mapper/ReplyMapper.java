package kr.co.chunjae1.mapper;

import kr.co.chunjae1.domain.ReplyDTO;

public interface ReplyMapper {

    public int insert(ReplyDTO replyDTO);

    public ReplyDTO read(Long rno);
}
