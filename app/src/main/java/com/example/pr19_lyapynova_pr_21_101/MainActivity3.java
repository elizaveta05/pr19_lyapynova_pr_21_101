package com.example.pr19_lyapynova_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements Removable {

    private ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main3);
        ListView list = findViewById(R.id.list);
        ArrayList<String> phones = new ArrayList<>();
        phones.add("Google Pixel");
        phones.add("Huawei P9");
        phones.add("LG G5");
        phones.add("Samsung Galaxy S8");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phones);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedPhone = adapter.getItem(position);
                CustomDialogFragment1 dialog = new CustomDialogFragment1();
                Bundle args = new Bundle();
                args.putString("phone", selectedPhone);
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });
    }
    @Override
    public void remove(String name) {
        adapter.remove(name);
    }
}