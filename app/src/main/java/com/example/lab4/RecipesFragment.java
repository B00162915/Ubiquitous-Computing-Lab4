package com.example.lab4;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import java.util.*;

public class RecipesFragment extends Fragment{
    public interface OnRecipeSelectListener{
        void onRecipeSelect(Recipe recipe);
    }

    private OnRecipeSelectListener listener;

    @Override
    public void onAttach(@NonNull Activity activity){
        super.onAttach(activity);

        if(activity instanceof OnRecipeSelectListener){
            listener = (OnRecipeSelectListener) activity;
        }
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        ListView listView = view.findViewById(R.id.recipeList);
        List<Recipe> recipes = JsonReader.readRecipes(requireContext());
        List<String> recipeNames = new ArrayList<>();

        for(Recipe recipe : recipes){
            recipeNames.add(recipe.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.item_recipe, R.id.recipeName, recipeNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, row, position, id) -> {
            Recipe selectedRecipe = recipes.get(position);
            if(listener != null){
                listener.onRecipeSelect(selectedRecipe);
            }
        });
        return view;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }
}
