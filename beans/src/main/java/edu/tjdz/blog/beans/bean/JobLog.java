package edu.tjdz.blog.beans.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobLog  {


    private Integer id ;
    private Integer jobId;
    private String beanName;
    private String params;
    private Integer status;
    private String error;
    private Integer times;
    private LocalDateTime createTime;

}
