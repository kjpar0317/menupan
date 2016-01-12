package com.rusproject.menupan.bean;

import java.io.Serializable;
import java.util.HashMap;

public class UserBean implements Serializable
{
    private String id;
    private String name;
    private String location;


    public UserBean() {

    }

    public UserBean(HashMap<String, String> param) {

        this.id = (String) param.get("ID");
        this.name = (String) param.get("NAME");
        this.location = (String) param.get("LOCATION");
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("User Info : \n");
        buf.append("#id          : " + this.id + "\n");
        buf.append("#name       : " + this.name + "\n");
        buf.append("#location       : " + this.location + "\n");
        
        return buf.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
