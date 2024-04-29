package kr.co.chunjae1.service;

import kr.co.chunjae1.domain.Criteria;
import kr.co.chunjae1.domain.PageResponseDTO;
import kr.co.chunjae1.domain.ReplyDTO;
import kr.co.chunjae1.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService{

private final ReplyMapper replyMapper;

    @Override
    public int register(ReplyDTO replyDTO) {
        log.info("register........" + replyDTO);

        return replyMapper.insert(replyDTO);

    }

    @Override
    public ReplyDTO get(Long rno) {
        log.info("register........" + rno);

        return replyMapper.read(rno);
    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        log.info("register........" + replyDTO);

        return replyMapper.update(replyDTO);

    }

    @Override
    public int remove(Long rno) {
        log.info("register........" + rno);

        return replyMapper.delete(rno);
    }

    @Override
    public List<ReplyDTO> getList(Criteria criteria, Long bno) {
        log.info("get Reply List of a Board" + bno);

        return replyMapper.getListWithPaging(criteria, bno);
    }
}
