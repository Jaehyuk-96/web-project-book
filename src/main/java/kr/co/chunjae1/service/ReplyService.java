package kr.co.chunjae1.service;

import kr.co.chunjae1.domain.Criteria;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.domain.ReplyDTO;

import java.util.List;

public interface ReplyService {
    public int register(ReplyDTO replyDTO);

    public ReplyDTO get(Long rno);

    public int modify(ReplyDTO replyDTO);

    public int remove(Long rno);

    public List<ReplyDTO> getList(Criteria criteria, Long bno);
}
