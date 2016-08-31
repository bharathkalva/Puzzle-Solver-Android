package com.example.bharathkalva.puzzlesolver;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dictionary extends Activity{
    Node nd = new Node('1');
    int i = 0;
    public Dictionary(InputStream is) {
        try{
            String str="";
            StringBuffer buf = new StringBuffer();
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
                while ((str = r.readLine()) != null) {
                    Node Nd = nd;
                    for (int i = 0; i < str.length(); i++) {
                        if (Nd.Contains(str.charAt(i))) Nd = Nd.getNode(str.charAt(i));
                        else {
                            Node temp = new Node(str.charAt(i));
                            Nd.Add(temp);
                            Nd = temp;
                        }
                    }
                    Nd.Add(new Node('['));
                }
            is.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
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
    public boolean Contains(String str) {
        Node temp = nd;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!temp.Contains(ch)) return false;
            temp = temp.getNode(ch);
        }
        if (!temp.Contains('[')) return false;
        return true;
    }
    public boolean ContainsPrefix(String str) {
        Node temp = nd;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!temp.Contains(ch)) return false;
            temp = temp.getNode(ch);
        }
        return true;
    }
}


