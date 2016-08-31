package com.example.bharathkalva.puzzlesolver;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

public class ListNow extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int Size=0;
        if(!bundle.isEmpty()) Size = bundle.getInt("0") ;
        String Classes[] = new String[Size];
        if(!bundle.isEmpty()){
            for (int i=1;i<=Size;i++) Classes[i-1]=bundle.getString(""+i);
        }
        setListAdapter(new ArrayAdapter<String>(ListNow.this, android.R.layout.simple_list_item_1,Classes));
    }
}
