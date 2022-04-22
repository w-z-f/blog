package edu.tjdz.blog.beans.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Uri implements Serializable {

    private int uriId;

    private String uri;

    private int roleId;

}
