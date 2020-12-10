package com.example.whatsfordinner.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "directions")
public class Direction {
    @PrimaryKey(autoGenerate = true)
    private Integer did;
    private String description;


    public Direction(Integer did, String description){
        this.did=did;
        this.description = description;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
