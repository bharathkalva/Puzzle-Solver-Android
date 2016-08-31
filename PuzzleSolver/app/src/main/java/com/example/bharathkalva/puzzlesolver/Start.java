package com.example.bharathkalva.puzzlesolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Start extends Activity {
    int[][] mat = new int[10][10];
    boolean Set = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudokutable);
        FindView();
        SetOnClickListener();
        for(int i=1;i<10;i++) {
            for(int j=1;j<10;j++) {
                mat[i][j]=0;

            }
        }
    }
    private void SetOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(view.getId()== R.id.sudokutable_Button_Submit) {
                        transferTheValues();
                        int[][] copy = new int[10][10];
                        for (int i = 1; i < 10; i++) {
                            for (int j = 1; j < 10; j++) copy[i][j] = mat[i][j];
                        }
                        Set = fillTheMatrix(copy, 1, 1, mat);
                        if (Set)setNumber(copy);
                        else {
                            Intent ourIntent = new Intent(Start.this, MainActivity.class);
                            startActivity(ourIntent);
                            for (int i =1; i < 10; i++) {
                                for (int j = 1; j < 10; j++) mat[i][j] = 0;
                            }
                            setNumber(mat);
                        }
                    }
            }
        };
        for (int i=1;i<10;i++) {
            for (int j=1;j<10;j++) Number[i][j].setOnClickListener(listener);
        }
        Submit.setOnClickListener(listener);
    }
    private void transferTheValues() {
          for (int i=1;i<10;i++){
              for(int j=1;j<10;j++) if(Number[i][j].getText().length()>0)mat[i][j] = Number[i][j].getText().charAt(0)-'0';
          }

    }

    private void setCellNumber(int[][] copy,int Col,int Row){
        Number[Col][Row].setText(String.valueOf(copy[Col][Row]));
    }
    private void setNumber(int[][] copy) {
        for(int i=1;i<10;i++) {
            for(int j=1;j<10;j++) Number[i][j].setText(String.valueOf(copy[i][j]));
        }
    }
    private void FindView() {
        Number[1][1] = (EditText)findViewById(R.id.Number11);
        Number[1][2] = (EditText)findViewById(R.id.Number12);
        Number[1][3] = (EditText)findViewById(R.id.Number13);
        Number[1][4] = (EditText)findViewById(R.id.Number14);
        Number[1][5] = (EditText)findViewById(R.id.Number15);
        Number[1][6] = (EditText)findViewById(R.id.Number16);
        Number[1][7] = (EditText)findViewById(R.id.Number17);
        Number[1][8] = (EditText)findViewById(R.id.Number18);
        Number[1][9] = (EditText)findViewById(R.id.Number19);
        Number[2][1] = (EditText)findViewById(R.id.Number21);
        Number[2][2] = (EditText)findViewById(R.id.Number22);
        Number[2][3] = (EditText)findViewById(R.id.Number23);
        Number[2][4] = (EditText)findViewById(R.id.Number24);
        Number[2][5] = (EditText)findViewById(R.id.Number25);
        Number[2][6] = (EditText)findViewById(R.id.Number26);
        Number[2][7] = (EditText)findViewById(R.id.Number27);
        Number[2][8] = (EditText)findViewById(R.id.Number28);
        Number[2][9] = (EditText)findViewById(R.id.Number29);
        Number[3][1] = (EditText)findViewById(R.id.Number31);
        Number[3][2] = (EditText)findViewById(R.id.Number32);
        Number[3][3] = (EditText)findViewById(R.id.Number33);
        Number[3][4] = (EditText)findViewById(R.id.Number34);
        Number[3][5] = (EditText)findViewById(R.id.Number35);
        Number[3][6] = (EditText)findViewById(R.id.Number36);
        Number[3][7] = (EditText)findViewById(R.id.Number37);
        Number[3][8] = (EditText)findViewById(R.id.Number38);
        Number[3][9] = (EditText)findViewById(R.id.Number39);
        Number[4][1] = (EditText)findViewById(R.id.Number41);
        Number[4][2] = (EditText)findViewById(R.id.Number42);
        Number[4][3] = (EditText)findViewById(R.id.Number43);
        Number[4][4] = (EditText)findViewById(R.id.Number44);
        Number[4][5] = (EditText)findViewById(R.id.Number45);
        Number[4][6] = (EditText)findViewById(R.id.Number46);
        Number[4][7] = (EditText)findViewById(R.id.Number47);
        Number[4][8] = (EditText)findViewById(R.id.Number48);
        Number[4][9] = (EditText)findViewById(R.id.Number49);
        Number[5][1] = (EditText)findViewById(R.id.Number51);
        Number[5][2] = (EditText)findViewById(R.id.Number52);
        Number[5][3] = (EditText)findViewById(R.id.Number53);
        Number[5][4] = (EditText)findViewById(R.id.Number54);
        Number[5][5] = (EditText)findViewById(R.id.Number55);
        Number[5][6] = (EditText)findViewById(R.id.Number56);
        Number[5][7] = (EditText)findViewById(R.id.Number57);
        Number[5][8] = (EditText)findViewById(R.id.Number58);
        Number[5][9] = (EditText)findViewById(R.id.Number59);
        Number[6][1] = (EditText)findViewById(R.id.Number61);
        Number[6][2] = (EditText)findViewById(R.id.Number62);
        Number[6][3] = (EditText)findViewById(R.id.Number63);
        Number[6][4] = (EditText)findViewById(R.id.Number64);
        Number[6][5] = (EditText)findViewById(R.id.Number65);
        Number[6][6] = (EditText)findViewById(R.id.Number66);
        Number[6][7] = (EditText)findViewById(R.id.Number67);
        Number[6][8] = (EditText)findViewById(R.id.Number68);
        Number[6][9] = (EditText)findViewById(R.id.Number69);
        Number[7][1] = (EditText)findViewById(R.id.Number71);
        Number[7][2] = (EditText)findViewById(R.id.Number72);
        Number[7][3] = (EditText)findViewById(R.id.Number73);
        Number[7][4] = (EditText)findViewById(R.id.Number74);
        Number[7][5] = (EditText)findViewById(R.id.Number75);
        Number[7][6] = (EditText)findViewById(R.id.Number76);
        Number[7][7] = (EditText)findViewById(R.id.Number77);
        Number[7][8] = (EditText)findViewById(R.id.Number78);
        Number[7][9] = (EditText)findViewById(R.id.Number79);
        Number[8][1] = (EditText)findViewById(R.id.Number81);
        Number[8][2] = (EditText)findViewById(R.id.Number82);
        Number[8][3] = (EditText)findViewById(R.id.Number83);
        Number[8][4] = (EditText)findViewById(R.id.Number84);
        Number[8][5] = (EditText)findViewById(R.id.Number85);
        Number[8][6] = (EditText)findViewById(R.id.Number86);
        Number[8][7] = (EditText)findViewById(R.id.Number87);
        Number[8][8] = (EditText)findViewById(R.id.Number88);
        Number[8][9] = (EditText)findViewById(R.id.Number89);
        Number[9][1] = (EditText)findViewById(R.id.Number91);
        Number[9][2] = (EditText)findViewById(R.id.Number92);
        Number[9][3] = (EditText)findViewById(R.id.Number93);
        Number[9][4] = (EditText)findViewById(R.id.Number94);
        Number[9][5] = (EditText)findViewById(R.id.Number95);
        Number[9][6] = (EditText)findViewById(R.id.Number96);
        Number[9][7] = (EditText)findViewById(R.id.Number97);
        Number[9][8] = (EditText)findViewById(R.id.Number98);
        Number[9][9] = (EditText)findViewById(R.id.Number99);

        Submit =   (Button)findViewById(R.id.sudokutable_Button_Submit);

    }
    private boolean fillTheMatrix(final int arr[][], final int Col, final int Row, int mat[][] ) {
        if(Row>9) return true;
        if(arr[Col][Row]==0) {
            for(int i=1;i<10;i++) {
                if(!(containsBox(arr,Col,Row,i)||containsCol(arr,Col,i)||containsRow(arr,Row,i))) {
                    arr[Col][Row]=i;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        setCellNumber(arr,Col,Row);
                                    }
                                });
                        }
                    },2500);
                    if(Col>=9) {
                        if (fillTheMatrix(arr,1,Row+1,mat)) return true;
                        arr[1][Row+1]=mat[1][Row+1];
                    } else {
                        if(fillTheMatrix(arr,Col+1,Row,mat)) return true;
                        arr[Col+1][Row]=mat[Col+1][Row];
                    }
                }
            }
            return false;
        } else {
            if(Col>=9) {
                if (fillTheMatrix(arr,1,Row+1,mat)) return true;
            }else  if(fillTheMatrix(arr,Col+1,Row,mat)) return true;
        }
        return false;
    }
    private boolean containsBox(int arr[][],int Col,int Row,int num) {
        int x=1;
        if(Col<4) x=1;
        else {if(Col<7) x=4;
        else x=7;}
        int y=1;
        if(Row<4) y=1;
        else {if(Row<7) y=4;
        else y=7;}
        for(int i=x;i<x+3;i++) {
            for(int j=y;j<y+3;j++) if(arr[i][j]==num) return true;
        }
        return false;
    }
    private boolean containsRow(int arr[][],int Row,int num) {
        for(int i=1;i<10;i++) if(arr[i][Row]==num) return true;
        return false;
    }
    private boolean containsCol(int arr[][],int Col,int num) {
        for(int i=1;i<10;i++) if(arr[Col][i]==num) return true;
        return false;
    }
    EditText[][] Number = new EditText[10][10];
    Button Submit;
}
