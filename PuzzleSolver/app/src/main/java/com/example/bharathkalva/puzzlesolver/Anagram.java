package com.example.bharathkalva.puzzlesolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;

public class Anagram extends Activity {
    Dictionary[] Complete = new Dictionary[26];
    HashSet<String> words = new HashSet<>();
    Button Submit;
    EditText etAnagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anagram);
        Submit = (Button)findViewById(R.id.anagram_Button_Submit);
        etAnagram = (EditText)findViewById(R.id.Anagram_EditText_Anagram);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.anagram_Button_Submit) {
                        String S1 = etAnagram.getText().toString();
                        String Str = S1.toUpperCase();
                        int Len = Str.length();
                        for(int i =0;i<Len;i++) {
                            if(Complete[Str.charAt(i)-'A']==null){
                                Complete[Str.charAt(i)-'A'] = new Dictionary(send(Str.charAt(i)));
                            }
                        }
                        FindOutAnagrams(Str,Len,"",words);
                        Intent intent = new Intent(Anagram.this, ListNow.class);
                        int num = words.size();
                        Iterator<String> it = words.iterator();
                        Bundle bundle = new Bundle();
                        bundle.putInt("0", num);
                        int i = 1;
                        while (it.hasNext()) {
                            bundle.putString("" + i, it.next());
                            i++;
                        }
                        intent.putExtras(bundle);
                        startActivity(intent);
                  }

            }
        };
        Submit.setOnClickListener(listener);
    }


    private String FindOutAnagrams(String str,int length,String InitialPart, HashSet<String> words) {
        if(length==0) return "";
        for (int i=0;i<length;i++){
            String Sk = InitialPart + str.charAt(i);
            String S;
            Log.i("bharath1234",InitialPart);
            if(containsPrefix(InitialPart)){
                Log.i("bharath1234",InitialPart);
                StringBuffer Sb = new StringBuffer(str);
                Sb.deleteCharAt(i);
                String temp = Sb.toString();
                S = Sk+ FindOutAnagrams(temp,length-1,Sk,words);
                if(contains(S)) words.add(S);
            }
        }
        return str;
    }

    public boolean containsPrefix(String str) {
          if(str.length()==0) return true;
          if(Complete[str.charAt(0)-'A'].ContainsPrefix(str)) return true;
        return false;
    }
    public boolean contains(String str) {
           if(str.length()==0) return false;
           if(Complete[str.charAt(0)-'A'].Contains(str)) return true;
           return  false;
    }
    private InputStream send(char ch) {
        InputStream is;
        switch (ch) {
            case 'A':
                is = this.getResources().openRawResource(R.raw.a);
                break;
            case 'B':
                is = this.getResources().openRawResource(R.raw.b);
                break;
            case 'C':
                is = this.getResources().openRawResource(R.raw.c);
                break;
            case 'D':
                is = this.getResources().openRawResource(R.raw.d);
                break;
            case 'E':
                is = this.getResources().openRawResource(R.raw.e);
                break;
            case 'F':
                is = this.getResources().openRawResource(R.raw.f);
                break;
            case 'G':
                is = this.getResources().openRawResource(R.raw.g);
                break;
            case 'H':
                is = this.getResources().openRawResource(R.raw.h);
                break;
            case 'I':
                is = this.getResources().openRawResource(R.raw.i);
                break;
            case 'J':
                is = this.getResources().openRawResource(R.raw.j);
                break;
            case 'K':
                is = this.getResources().openRawResource(R.raw.k);
                break;
            case 'L':
                is = this.getResources().openRawResource(R.raw.l);
                break;
            case 'M':
                is = this.getResources().openRawResource(R.raw.m);
                break;
            case 'N':
                is = this.getResources().openRawResource(R.raw.n);
                break;
            case 'O':
                is = this.getResources().openRawResource(R.raw.o);
                break;
            case 'P':
                is = this.getResources().openRawResource(R.raw.p);
                break;
            case 'Q':
                is = this.getResources().openRawResource(R.raw.q);
                break;
            case 'R':
                is = this.getResources().openRawResource(R.raw.r);
                break;
            case 'S':
                is = this.getResources().openRawResource(R.raw.s);
                break;
            case 'T':
                is = this.getResources().openRawResource(R.raw.t);
                break;
            case 'U':
                is = this.getResources().openRawResource(R.raw.u);
                break;
            case 'V':
                is = this.getResources().openRawResource(R.raw.v);
                break;
            case 'W':
                is = this.getResources().openRawResource(R.raw.w);
                break;
            case 'X':
                is = this.getResources().openRawResource(R.raw.x);
                break;
            case 'Y':
                is = this.getResources().openRawResource(R.raw.y);
                break;
            case 'Z':
                is = this.getResources().openRawResource(R.raw.z);
                break;
            default:  is =this.getResources().openRawResource(R.raw.a);
                break;
        }

        return is;
    }



}