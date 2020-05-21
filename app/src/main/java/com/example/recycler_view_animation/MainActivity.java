package com.example.recycler_view_animation;


import android.os.Bundle;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    FloatingActionButton add_button;
    ArrayList<String> arrayList = new ArrayList<>();

    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);

        populateData();
        initAdapter();
        runAnimation();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add("New item");
                recyclerViewAdapter.notifyItemInserted(arrayList.size() - 1);
                recyclerView.scheduleLayoutAnimation();
            }
        });
    }

    private void populateData() {

        for (int i = 0; i <6;i++) {
            arrayList.add("Item " + i);
        }
    }

    private void initAdapter() {
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void runAnimation() {
        int animationID=R.anim.layout_animatin_slide_from_right;
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(this, animationID);
        //to re run the application
        // recyclerView.setLayoutAnimation(controller);
    }
}
