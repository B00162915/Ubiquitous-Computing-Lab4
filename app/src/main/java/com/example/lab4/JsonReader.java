package com.example.lab4;

import java.io.*;
import java.util.*;
import android.content.*;

import org.json.*;

public class JsonReader {
    public static List<Recipe> readRecipes(Context context){
        List<Recipe> recipes = new ArrayList<>();

        try{
            InputStream inputStream = context.getAssets().open("recipe.json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                jsonBuilder.append(line);
            }

            reader.close();
            inputStream.close();

            String json = jsonBuilder.toString();
            JSONArray recipeArray = new JSONArray(json);

            for(int i = 0; i < recipeArray.length(); i++){
                JSONObject object = recipeArray.getJSONObject(i);

                int id = object.getInt("id");
                String name = object.getString("name");
                String method = object.getString("method");
                JSONArray ingredientArray = object.getJSONArray("ingredients");
                List<String> ingredients = new ArrayList<>();

                for(int j = 0; j < ingredientArray.length(); j++){
                    ingredients.add(ingredientArray.getString(j));
                }

                Recipe recipe = new Recipe(id, name, ingredients, method);

                recipes.add(recipe);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return recipes;
    }
}
