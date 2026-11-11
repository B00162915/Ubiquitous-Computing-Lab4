package com.example.lab4;

import java.io.Serializable;
import java.util.*;
public class Recipe implements Serializable {
    private int id;
    private String name;
    private List<String> ingredients;
    private String method;

    public Recipe(int id, String name, List<String> ingredients, String method){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public List<String> getIngredients(){
        return ingredients;
    }
    public String getMethod(){
        return method;
    }
}
