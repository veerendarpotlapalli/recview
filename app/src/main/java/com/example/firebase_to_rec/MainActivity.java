 package com.example.firebase_to_rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;
    adapter_for_rec adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            recview = findViewById(R.id.recview);
            recview.setLayoutManager(new LinearLayoutManager(this));

            FirebaseRecyclerOptions<model> options =
                    new FirebaseRecyclerOptions.Builder<model>()
                            .setQuery(FirebaseDatabase.
                                    getInstance().getReference().child("users"), model.class) //in query we have to catch the data from firebase which we want to show in recycler view
                            .build();
            adapter = new adapter_for_rec(options);
            recview.setAdapter(adapter);
            // refresh(1000);
        }catch (Exception e){} //try catch
    } //on create

    @Override
    protected void onStart() {
        try{
        super.onStart();
        adapter.startListening();
        }catch (Exception e){} //try catch
    } //onstart
    @Override
    protected void onStop() {
        try{
        super.onStop();
        adapter.stopListening();
        }catch (Exception e){} //try catch
    } //onstop

   /* public void  refresh(int milliseconds)
    {
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        refresh(1000);
                    }
                };
                handler.postDelayed(runnable,milliseconds);
    } //refresh */
} //main
