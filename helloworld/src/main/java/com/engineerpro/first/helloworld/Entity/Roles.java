package com.engineerpro.first.helloworld.Entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
import java.util.Set;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "role_name")
    private String roleName;
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "roles")
    private Set<User> listUser;

    public Set<User> getListUser() {
        return listUser;
    }

    public void setListUser(Set<User> listUser) {
        this.listUser = listUser;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
