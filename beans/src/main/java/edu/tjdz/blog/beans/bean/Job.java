package edu.tjdz.blog.beans.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    private Integer Id;
    private String beanName;
    private String params;
    private String cronExpression;
    private Integer status;
    private String remark;
    private Integer businessId;
    private Integer creator;
    private LocalDateTime createTime;
    private Integer updater;
    private LocalDateTime updateTime;


}
