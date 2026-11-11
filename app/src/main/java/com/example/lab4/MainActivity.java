package com.example.lab4;


import android.content.*;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements RecipesFragment.OnRecipeSelectListener{
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main_landscape);
            isLandscape = true;
        }
        else{
            setContentView(R.layout.activity_main_portrait);
            isLandscape = false;
        }

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new RecipesFragment())
                    .commit();
        }
    }

    @Override
    public void onRecipeSelect(Recipe recipe){
        if(isLandscape){
            Fragment fragmentDetail = IngredientsFragment.newInstance(recipe);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.landscape_detail_container, fragmentDetail)
                    .commit();
        }
        else{
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("selectedRecipe", recipe);
            startActivity(intent);
        }
    }
}