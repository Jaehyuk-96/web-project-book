package kr.co.chunjae1.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    private List<BoardAttachDTO> attachDTOList;
}
