package com.example.lab4;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class IngredientsFragment extends Fragment{
    private static String ARG_RECIPE = "recipe";

    public static IngredientsFragment newInstance(Recipe recipe){
        IngredientsFragment fragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_RECIPE, recipe);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        TextView title = view.findViewById(R.id.recipeTitle);
        TextView ingredients = view.findViewById(R.id.ingredientsText);
        TextView method = view.findViewById(R.id.methodText);
        Bundle args = getArguments();

        if(args != null){
            Recipe recipe = (Recipe) args.getSerializable(ARG_RECIPE);
            if(recipe != null){
                title.setText(recipe.getName());
                StringBuilder ingredientList = new StringBuilder();

                for(String ingredient : recipe.getIngredients()){
                    ingredientList.append(ingredient).append("\n");
                }

                ingredients.setText(ingredientList.toString());
                method.setText(recipe.getMethod());
            }
        }
        return view;
    }
}
