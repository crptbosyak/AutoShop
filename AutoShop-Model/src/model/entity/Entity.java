package model.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    public abstract Integer getId();
    public abstract void setId(Integer id);
}