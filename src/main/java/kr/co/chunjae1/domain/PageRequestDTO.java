package kr.co.chunjae1.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value=1)
    @Positive
    private int page =  1;

    @Builder.Default
    @Min(value=10)
    @Max(value=100)
    @Positive
    private int size = 10;
    private String link;
    //페이징관련
    private String[] types;
    private String keyword;
    private LocalDate from;
    private LocalDate to;

    //검색관련

    public int getSkip(){
        return (page - 1)*10;
    }

    public String getLink() {
        if(link == null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("page=" + this.page);
            stringBuilder.append("&size=" + this.size);
            //검색때문에 추가

            if(types !=null && types.length>0){
                //types는 배열이고 쿼리 스트링에 추가해줌
                for(int i = 0; i< types.length; i++){
                    stringBuilder.append("&types=" + types[i]);
                }
            }

            if(keyword != null){
                try{
                    stringBuilder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
                }catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(from != null){
                stringBuilder.append("&from=" + from.toString());
            }

            if(to != null){
                stringBuilder.append("&to=" + to.toString());
            }

            return stringBuilder.toString();
        }
        return link;
    }

    public boolean checkType(String type){
        if(types == null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

    public String getFrom() {
        return from != null ? from.toString() : null;
    }

    public void setFrom(String from) {
        this.from = (from != null && !from.isEmpty()) ? LocalDate.parse(from, DateTimeFormatter.ISO_DATE) : null;
    }

    public String getTo() {
        return to != null ? to.toString() : null;
    }

    public void setTo(String to) {
        this.to = (to != null && !to.isEmpty()) ? LocalDate.parse(to, DateTimeFormatter.ISO_DATE) : null;
    }

}
