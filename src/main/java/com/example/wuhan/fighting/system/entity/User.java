package com.example.wuhan.fighting.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:11
 * @Version 1.0
 */
@Builder
@Data
@Entity(name = "t_user")
@Table(name="t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    @Column(name="username",length = 200)
    private String username;

    private String address;

    private String mobile;

    private String password;

    private int type;

    private int sex;

    private String street;
}
