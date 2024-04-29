package kr.co.chunjae1.domain;

import lombok.Data;

@Data
public class BoardAttachDTO {

    private String uuid;
    private String uploadPath;
    private String fileName;
    private boolean fileType;

    private Long bno;


}
