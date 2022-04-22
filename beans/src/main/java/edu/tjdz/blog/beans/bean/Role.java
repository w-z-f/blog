package edu.tjdz.blog.beans.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

   private List<Uri> uris;

    private int roleId;

    private String roleName;
}
