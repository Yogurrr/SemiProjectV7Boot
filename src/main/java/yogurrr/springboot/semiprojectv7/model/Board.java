package yogurrr.springboot.semiprojectv7.model;

import lombok.Data;

@Data
public class Board {
    private String bno;
    private String title;
    private String userid;
    private String thumbs;
    private String views;
    private String contents;
    private String regdate;
}