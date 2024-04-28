package kr.co.chunjae1.domain;


import lombok.Data;

import java.util.Date;

@Data
public class ReplyDTO {

    private Long rno;
    private Long bno;

    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;


}
