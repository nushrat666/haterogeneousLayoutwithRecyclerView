package com.mononsoft.heterogeneouslayoutwithrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Object> objects = new ArrayList<>();
    private ObjectAdapter objectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerView);

        objects.add(new Car(R.drawable.car,"Toyota Corolla","Toyota Corolla"));
        objects.add(new Movie("Terminator3","Action"));
        objects.add(new Car(R.drawable.car,"Mercedes","Mercedes"));
        objects.add(new Movie("Terminator4","Romantic"));
        objects.add(new Car(R.drawable.car,"BMW","BMW"));

        objectAdapter= new ObjectAdapter(this,objects);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mRecyclerView.setAdapter(objectAdapter);
    }
}