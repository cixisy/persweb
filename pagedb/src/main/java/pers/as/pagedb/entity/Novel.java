package pers.as.pagedb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Novel implements Serializable {


    private Integer id;

    private String novelname;

    private String author;

    private String img;

    private String comments;

    private String description;

}
