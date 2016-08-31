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


public class BoggleGame extends Activity {
    Dictionary[] Complete = new Dictionary[26];
    char[][] Letters = new char[6][6];
    HashSet<String> words = new HashSet<>();
    EditText Alpha11,Alpha12,Alpha13,Alpha14,Alpha21,Alpha22,Alpha23,Alpha24,Alpha31,Alpha32,Alpha33,Alpha34,Alpha41,Alpha42,Alpha43,Alpha44;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boggletable);
        FindView();
        setOnClickListeners();
        for (int i=0;i<6 ;i++){
            for (int j=0;j<6;j++) Letters[i][j] ='1';
        }
    }
    private void setOnClickListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()== R.id.boggleTableSubmitButton){
                    transferTheValues();
                        char[][] copy = new char[6][6];
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) copy[i][j] = Letters[i][j];
                        }
                        boolean[][] bool = new boolean[6][6];
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) bool[i][j] = false;
                        }
                        for (int i = 0; i < 6; i++) bool[i][0] = true;
                        for (int i = 0; i < 6; i++) bool[i][5] = true;
                        for (int i = 0; i < 6; i++) bool[0][i] = true;
                        for (int i = 0; i < 6; i++) bool[5][i] = true;
                    fillTheWords(copy, 1, 1, bool, "", words);
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) bool[i][j] = false;
                    }
                    for (int i = 0; i < 6; i++) bool[i][0] = true;
                    for (int i = 0; i < 6; i++) bool[i][5] = true;
                    for (int i = 0; i < 6; i++) bool[0][i] = true;
                    for (int i = 0; i < 6; i++) bool[5][i] = true;
                    fillTheWords(copy, 1, 4, bool, "", words);
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) bool[i][j] = false;
                    }
                    for (int i = 0; i < 6; i++) bool[i][0] = true;
                    for (int i = 0; i < 6; i++) bool[i][5] = true;
                    for (int i = 0; i < 6; i++) bool[0][i] = true;
                    for (int i = 0; i < 6; i++) bool[5][i] = true;
                    fillTheWords(copy, 4, 1, bool, "", words);
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) bool[i][j] = false;
                    }
                    for (int i = 0; i < 6; i++) bool[i][0] = true;
                    for (int i = 0; i < 6; i++) bool[i][5] = true;
                    for (int i = 0; i < 6; i++) bool[0][i] = true;
                    for (int i = 0; i < 6; i++) bool[5][i] = true;
                    fillTheWords(copy, 4, 4, bool, "", words);
                        Intent intent = new Intent(BoggleGame.this, ListNow.class);
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
        Alpha11.setOnClickListener(listener);
        Alpha12.setOnClickListener(listener);
        Alpha13.setOnClickListener(listener);
        Alpha14.setOnClickListener(listener);
        Alpha21.setOnClickListener(listener);
        Alpha22.setOnClickListener(listener);
        Alpha23.setOnClickListener(listener);
        Alpha24.setOnClickListener(listener);
        Alpha31.setOnClickListener(listener);
        Alpha32.setOnClickListener(listener);
        Alpha33.setOnClickListener(listener);
        Alpha34.setOnClickListener(listener);
        Alpha41.setOnClickListener(listener);
        Alpha42.setOnClickListener(listener);
        Alpha43.setOnClickListener(listener);
        Alpha44.setOnClickListener(listener);
        Submit.setOnClickListener(listener);
    }
    private void transferTheValues() {
        char ch;
        ch = Alpha11.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[1][1] = (char) ('A' + ch-'a');
        else Letters[1][1] = ch;
        Complete[Letters[1][1]-'A'] = new Dictionary(send(Letters[1][1]));
        ch = Alpha12.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[1][2] = (char) ('A' + ch-'a');
        else Letters[1][2] = ch;
        Complete[Letters[1][2]-'A'] = new Dictionary(send(Letters[1][2]));
        ch = Alpha13.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[1][3] = (char) ('A' + ch-'a');
        else Letters[1][3] = ch;
        Complete[Letters[1][3]-'A'] = new Dictionary(send(Letters[1][3]));
        ch = Alpha14.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[1][4] = (char) ('A' + ch-'a');
        else Letters[1][4] = ch;
        Complete[Letters[1][4]-'A'] = new Dictionary(send(Letters[1][4]));
        ch = Alpha21.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[2][1] = (char) ('A' + ch-'a');
        else Letters[2][1] = ch;
        Complete[Letters[2][1]-'A'] = new Dictionary(send(Letters[2][1]));
        ch = Alpha22.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[2][2] = (char) ('A' + ch-'a');
        else Letters[2][2] = ch;
        Complete[Letters[2][2]-'A'] = new Dictionary(send(Letters[2][2]));
        ch = Alpha23.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[2][3] = (char) ('A' + ch-'a');
        else Letters[2][3] = ch;
        Complete[Letters[2][3]-'A'] = new Dictionary(send(Letters[2][3]));
        ch = Alpha24.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[2][4] = (char) ('A' + ch-'a');
        else Letters[2][4] = ch;
        Complete[Letters[2][4]-'A'] = new Dictionary(send(Letters[2][4]));
        ch = Alpha31.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[3][1] = (char) ('A' + ch-'a');
        else Letters[3][1] = ch;
        Complete[Letters[3][1]-'A'] = new Dictionary(send(Letters[3][1]));
        ch = Alpha32.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[3][2] = (char) ('A' + ch-'a');
        else Letters[3][2] = ch;
        Complete[Letters[3][2]-'A'] = new Dictionary(send(Letters[3][2]));
        ch = Alpha33.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[3][3] = (char) ('A' + ch-'a');
        else Letters[3][3] = ch;
        Complete[Letters[3][3]-'A'] = new Dictionary(send(Letters[3][3]));
        ch = Alpha34.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[3][4] = (char) ('A' + ch-'a');
        else Letters[3][4] = ch;
        Complete[Letters[3][4]-'A'] = new Dictionary(send(Letters[3][4]));
        ch = Alpha41.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[4][1] = (char) ('A' + ch-'a');
        else Letters[4][1] = ch;
        Complete[Letters[4][1]-'A'] = new Dictionary(send(Letters[4][1]));
        ch = Alpha42.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[4][2] = (char) ('A' + ch-'a');
        else Letters[4][2] = ch;
        Complete[Letters[4][2]-'A'] = new Dictionary(send(Letters[4][2]));
        ch = Alpha43.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[4][3] = (char) ('A' + ch-'a');
        else Letters[4][3] = ch;
        Complete[Letters[4][3]-'A'] = new Dictionary(send(Letters[4][3]));
        ch = Alpha44.getText().charAt(0);
        if((ch>='a')&&(ch<='z')) Letters[4][4] = (char) ('A' + ch-'a');
        else Letters[4][4] = ch;
        Complete[Letters[4][4]-'A'] = new Dictionary(send(Letters[4][4]));
      }
    private boolean fillTheWords(char arr[][],int Row,int Col,boolean check[][],String str,HashSet<String> Collection) {
        if(check[Col-1][Row-1]&&check[Col-1][Row]&&check[Col-1][Row+1]&&check[Col][Row-1]&&check[Col][Row]&&check[Col][Row+1]&&check[Col+1][Row-1]&&check[Col+1][Row]&&check[Col+1][Row+1]) return true;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if(!check[Col-1+i][Row-1+j]) {
                    check[Col-1+i][Row-1+j]=true;
                    String s = str+ arr[Col-1+i][Row-1+j];
                    if(containsPrefix(s)) {
                        if(contains(s)) Collection.add(s);
                        fillTheWords(arr,Row-1+j,Col-1+i,check,s,Collection);
                    }
                    check[Col-1+i][Row-1+j]=false;
                }
            }
        }
        return  true;
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
    public boolean containsPrefix(String str) {
       if(Complete[str.charAt(0)-'A'].ContainsPrefix(str)) return true;
        return false;
    }
    public boolean contains(String str) {
        if(Complete[str.charAt(0)-'A'].Contains(str)) return true;
        return  false;
    }
    private void FindView() {
        Alpha11 = (EditText)findViewById(R.id.Alpha11);
        Alpha12 = (EditText)findViewById(R.id.Alpha12);
        Alpha13 = (EditText)findViewById(R.id.Alpha13);
        Alpha14 = (EditText)findViewById(R.id.Alpha14);
        Alpha21 = (EditText)findViewById(R.id.Alpha21);
        Alpha22 = (EditText)findViewById(R.id.Alpha22);
        Alpha23 = (EditText)findViewById(R.id.Alpha23);
        Alpha24 = (EditText)findViewById(R.id.Alpha24);
        Alpha31 = (EditText)findViewById(R.id.Alpha31);
        Alpha32 = (EditText)findViewById(R.id.Alpha32);
        Alpha33 = (EditText)findViewById(R.id.Alpha33);
        Alpha34 = (EditText)findViewById(R.id.Alpha34);
        Alpha41 = (EditText)findViewById(R.id.Alpha41);
        Alpha42 = (EditText)findViewById(R.id.Alpha42);
        Alpha43 = (EditText)findViewById(R.id.Alpha43);
        Alpha44 = (EditText)findViewById(R.id.Alpha44);
        Submit = (Button)findViewById(R.id.boggleTableSubmitButton);
    }
}
