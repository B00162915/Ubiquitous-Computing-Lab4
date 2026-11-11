package com.example.lab4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState == null){
            Recipe recipe = (Recipe) getIntent().getSerializableExtra("selectedRecipe");

            if(recipe != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.detail_container, IngredientsFragment.newInstance(recipe))
                        .commit();
            }
        }
    }
}