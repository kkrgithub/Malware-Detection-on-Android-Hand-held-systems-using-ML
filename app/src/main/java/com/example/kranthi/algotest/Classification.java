package com.example.kranthi.algotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Classification extends AppCompatActivity {
     TextView out = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.out = (TextView) this.findViewById(R.id.path);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        Intent i = getIntent();
        int[] f = i.getIntArrayExtra("fa");
        //int a1 = f[174];
        //Toast.makeText(this,"OnCreate  "+a1,Toast.LENGTH_LONG).show();
        ide(f);
        //lmt(f);
    }

    public  void ide(int[] arr){
        //Toast.makeText(this,"classify method ",Toast.LENGTH_LONG).show();
        //this.out.setText(" ");
        //int[] array = arr;
        //int[] traversed = new int[14];
        String result = null ;
        String path = "path = ";
        int total =0 ;
        int fp =0;
        double pfp = 0.00 ;
        int event = 444;
        path = path+event;
        while(event != -1){
            path = path+"->"+event;
            switch(event) {
                case 444 :
                    if (arr[444]==1){
                        result = "benign";
                        total = 15;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 431;
                        break;
                    }
                case 431 :
                    if (arr[431]==1){
                        result = "benign";
                        total = 6;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 17;
                        break;
                    }
                case 17 :
                    if (arr[17]==1){
                        result = "benign";
                        total = 5;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 174;
                        break;
                    }
                case 174 :
                    if (arr[174]==1){
                        result = "benign";
                        total = 4;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 182;
                        break;
                    }
                case 182 :
                    if (arr[182]==1){;
                        event = 105;
                        break;
                    }else {
                        event = 422;
                        break;
                    }
                case 105 :
                    if (arr[105]==1){
                        event = 107;
                        break;
                    }else {
                        result = "malware";
                        total = 34;
                        fp =1 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }
                case 107 :
                    if (arr[107]==1){
                        result ="benign";
                        total = 2;
                        fp = 0;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        result = "malware";
                        total = 4;
                        fp = 0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }
                case 422 :
                    if (arr[422]==1){
                        result = "malware";
                        total = 10;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 327;
                        break;
                    }
                case 327 :
                    if (arr[327]==1){
                        event = 390;
                        break;
                    }else {
                        event = 87;
                        break;
                    }
                case 390 :
                    if (arr[390]==1){
                        result = "malware";
                        total = 16;
                        fp =1 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 348;
                        break;
                    }
                case 348 :
                    if (arr[348]==1){
                        result = "malware";
                        total = 4;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        event = 34;
                        break;
                    }
                case 34 :
                    if (arr[34]==1){
                        result = "malware";
                        total = 15;
                        fp =5 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        result = "benign";
                        total = 63;
                        fp =7 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }
                case 87 :
                    if (arr[87]==1){
                        event = 549;
                        break;
                    }else {
                        result = "malware";
                        total = 19;
                        fp = 1 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }
                case 549 :
                    if (arr[549]==1){
                        result = "malware";
                        total = 2;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }else {
                        result = "benign";
                        total = 2;
                        fp =0 ;
                        pfp = fp/total;
                        event = -1;
                        break;
                    }
                default :
                    Toast.makeText(this,"case Missing"+event,Toast.LENGTH_LONG).show();
                    //System.out.println("case missing"+event);
                    event = -1;
                    break;

            }
        }
        Toast.makeText(this,result+" "+total+" "+fp,Toast.LENGTH_LONG).show();
        Toast.makeText(this,"path ="+path,Toast.LENGTH_LONG).show();
        //System.out.println(result);

    }

    public void lmt(int[] vector) {

        int root = 444;
        String travel = "travelled = ";
        while (root != -1) {
            travel = travel + "->" + root;
            switch (root) {
                case 444:
                    if (vector[444] == 1) {
                        lm_4(vector);
                        root = -1;
                        break;
                    } else {
                        root = 431;
                        break;
                    }
                case 431:
                    if (vector[431] == 1) {
                        lm_3(vector);
                        root = -1;
                        break;
                    } else {
                        root = 17;
                        break;

                    }
                case 17:
                    if (vector[17] == 1) {
                        lm_2(vector);
                        root = -1;
                        break;
                    } else {
                        lm_1(vector);
                        root = -1;
                        break;
                    }
                default :
                    Toast.makeText(this,"case Missing"+root,Toast.LENGTH_LONG).show();
                    //System.out.println("case missing"+event);
                    root = -1;
                    break;


            }
        }
        Toast.makeText(this,"path ->"+travel,Toast.LENGTH_LONG).show();
    }

    public void lm_4(int[] lr){
        double class_0 = 16.5 + lr[6] * -0.56 +lr[19] * 1.62 +lr[36] * -1.81 +lr[62] * 0.64 +lr[69] * 1.52 +lr[75] * 1.89 +lr[80] * -1.52 +
                lr[81] * 2.49 +lr[89] * -0.2 +lr[94] * -1.27 +lr[107] * 0.39 +lr[131] * 0.45 +lr[145] * 0.61 +lr[152] * 1.51 +
                lr[158] * 0.36 +lr[178] * 0.99 +lr[184] * -0.59 +lr[222] * 0.06 +lr[241] * 0.21 +lr[270] * -1.67 +lr[276] * -1.52 +
                lr[280] * 1.09 +lr[285] * -0.66 +lr[300] * -0.35 +lr[314] * 0.75 +lr[329] * 2.05 +lr[331] * -0.8 +lr[350] * -0.46 +
                lr[375] * 0.77 +lr[386] * 0.46 +lr[392] * -0.73 +lr[424] * -1.37 +lr[434] * 1.13 +lr[440] * 0.96 +lr[446] * 1.86 +
                lr[452] * -0.35 +lr[457] * 0.93 +lr[506] * 0.6  +lr[525] * 1.06 +lr[542] * 0.26 +lr[561] * 1.58;
        double class_1 = -16.5 + lr[6] * 0.56 +lr[19] * -1.62 +lr[36] * 1.81 +lr[62] * -0.64 +lr[69] * -1.52 +lr[75] * -1.89 +lr[80] * 1.52 +
                lr[81] * -2.49 +lr[89] * 0.2  +lr[94] * 1.27 +lr[107] * -0.39 +lr[131] * -0.45 +lr[145] * -0.61 +lr[152] * -1.51 +
                lr[158] * -0.36 +lr[178] * -0.99 +lr[184] * 0.59 +lr[222] * -0.06 +lr[241] * -0.21 +lr[270] * 1.67 +lr[276] * 1.52 +
                lr[280] * -1.09 +lr[285] * 0.66 +lr[300] * 0.35 +lr[314] * -0.75 +lr[329] * -2.05 +lr[331] * 0.8  +lr[350] * 0.46 +
                lr[375] * -0.77 +lr[386] * -0.46 +lr[392] * 0.73 +lr[424] * 1.37 +lr[434] * -1.13 +lr[440] * -0.96 +lr[446] * -1.86 +
                lr[452] * 0.35 +lr[457] * -0.93 +lr[506] * -0.6 +lr[525] * -1.06 +lr[542] * -0.26 +lr[561] * -1.58;

        if(class_0 > class_1) {
            Toast.makeText(this,"lm_4 app belongs to class_0 with prob = "+class_0,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"lm_4 app belongs to class_1 with prob = "+class_1,Toast.LENGTH_LONG).show();
        }

}

    public void lm_3(int[] lr){
        double class_0 = 15.98 + lr[6] * -0.8 +lr[19] * 2.18 +lr[36] * -2.66 +lr[62] * 2.51 +lr[69] * 1.52 +lr[75] * 2.67 +lr[80] * -2.68 +
                lr[81] * 5.79 +lr[89] * -0.37 +lr[94] * -1.61 +lr[107] * 0.39 +lr[131] * 0.74 +lr[138] * -0.19 +lr[145] * 1.08 +
                lr[152] * 1.51 +lr[158] * 0.36 +lr[178] * 0.99 +lr[184] * -0.59 +lr[241] * 0.38 +lr[256] * 0.59 +lr[270] * -1.67 +
                lr[276] * -1.52 +lr[280] * 2.08 +lr[285] * -0.66 +lr[300] * -0.81 +lr[312] * 2.05 +lr[314] * 1.18 +lr[329] * 2.79 +
                lr[331] * -1.42 +lr[350] * -2.17 +lr[375] * -0.19 +lr[377] * 0.31 +lr[386] * 1.74 +lr[392] * -0.99 +lr[396] * -0.42 +
                lr[424] * -1.77 +lr[434] * 1.13 +lr[440] * 1.52 +lr[446] * 1.86 +lr[447] * -0.32 +lr[452] * -0.35 +lr[457] * 0.93 +
                lr[460] * 0.63 +lr[506] * 0.6  +lr[525] * 1.33 +lr[542] * 1.01 +lr[561] * 1.58;
        double class_1 = -15.98 + lr[6] * 0.8  +lr[19] * -2.18 +lr[36] * 2.66 +lr[62] * -2.51 +lr[69] * -1.52 +lr[75] * -2.67 +
                lr[80] * 2.68 +lr[81] * -5.79 +lr[89] * 0.37 +lr[94] * 1.61 +lr[107] * -0.39 +lr[131] * -0.74 +lr[138] * 0.19 +
                lr[145] * -1.08 +lr[152] * -1.51 +lr[158] * -0.36 +lr[178] * -0.99 +lr[184] * 0.59 +lr[241] * -0.38 +lr[256] * -0.59 +
                lr[270] * 1.67 +lr[276] * 1.52 +lr[280] * -2.08 +lr[285] * 0.66 +lr[300] * 0.81 +lr[312] * -2.05 +lr[314] * -1.18 +
                lr[329] * -2.79 +lr[331] * 1.42 +lr[350] * 2.17 +lr[375] * 0.19 +lr[377] * -0.31 +lr[386] * -1.74 +lr[392] * 0.99 +
                lr[396] * 0.42 +lr[424] * 1.77 +lr[434] * -1.13 +lr[440] * -1.52 +lr[446] * -1.86 +lr[447] * 0.32 +lr[452] * 0.35 +
                lr[457] * -0.93 +lr[460] * -0.63 +lr[506] * -0.6 +lr[525] * -1.33 +lr[542] * -1.01 +lr[561] * -1.58;

        if(class_0 > class_1) {
            Toast.makeText(this,"lm_3 app belongs to class_0 with prob = "+class_0,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"lm_3 app belongs to class_1 with prob = "+class_1,Toast.LENGTH_LONG).show();
        }




    }

    public void lm_2(int[] lr){
        double class_0 = 16.35 + lr[6] * -0.8 +lr[19] * 2.71 +lr[36] * -3.23 +lr[62] * 3.66 +lr[64] * -0.36 +lr[69] * 1.52 +lr[75] * 3.55 +
                lr[80] * -3.68 +lr[81] * 8.66 +lr[83] * -1.1 +lr[89] * -0.37 +lr[94] * -2.13 +lr[107] * 0.05 +lr[131] * 1.03 +
                lr[138] * -0.19 +lr[145] * 1.59 +lr[152] * 1.51 +lr[158] * 0.66 +lr[178] * 0.99 +lr[184] * -0.59 +lr[241] * 0.69 +
                lr[256] * 1.13 +lr[270] * -1.67 +lr[276] * -1.52 +lr[280] * 3.52 +lr[285] * -0.66 +lr[300] * -1.02 +lr[312] * 3.19 +
                lr[314] * 1.54 +lr[329] * 3.28 +lr[331] * -2.42 +lr[350] * -2.6 +lr[375] * -0.9 +lr[377] * 0.31 +lr[379] * 0.02 +
                lr[386] * 2.09 +lr[392] * -1.25 +lr[396] * -0.76 +lr[424] * -2.17 +lr[434] * 1.13 +lr[440] * 1.52 +lr[446] * 1.86 +
                lr[447] * -0.59 +lr[452] * -0.85 +lr[457] * 0.93 +lr[460] * 0.63 +lr[506] * 0.6  +lr[522] * 0.53 +lr[525] * 1.61 +
                lr[542] * 1.79 +lr[561] * 1.58;
        double class_1 = -16.35 + lr[6] * 0.8  +lr[19] * -2.71 +lr[36] * 3.23 +lr[62] * -3.66 +lr[64] * 0.36 +lr[69] * -1.52 +
                lr[75] * -3.55 +lr[80] * 3.68 +lr[81] * -8.66 +lr[83] * 1.1  +lr[89] * 0.37 +lr[94] * 2.13 +lr[107] * -0.05 +
                lr[131] * -1.03 +lr[138] * 0.19 +lr[145] * -1.59 +lr[152] * -1.51 +lr[158] * -0.66 +lr[178] * -0.99 +lr[184] * 0.59 +
                lr[241] * -0.69 +lr[256] * -1.13 +lr[270] * 1.67 +lr[276] * 1.52 +lr[280] * -3.52 +lr[285] * 0.66 +lr[300] * 1.02 +
                lr[312] * -3.19 +lr[314] * -1.54 +lr[329] * -3.28 +lr[331] * 2.42 +lr[350] * 2.6  +lr[375] * 0.9  +lr[377] * -0.31 +
                lr[379] * -0.02 +lr[386] * -2.09 +lr[392] * 1.25 +lr[396] * 0.76 +lr[424] * 2.17 +lr[434] * -1.13 +lr[440] * -1.52 +
                lr[446] * -1.86 +lr[447] * 0.59 +lr[452] * 0.85 +lr[457] * -0.93 +lr[460] * -0.63 +lr[506] * -0.6 +lr[522] * -0.53 +
                lr[525] * -1.61 +lr[542] * -1.79 +lr[561] * -1.58 ;

        if(class_0 > class_1) {
            Toast.makeText(this,"lm_2 app belongs to class_0 with prob = "+class_0,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"lm_2 app belongs to class_1 with prob = "+class_1,Toast.LENGTH_LONG).show();
        }



    }

    public void lm_1(int[] lr){
        double class_0 = -0.83 + lr[6] * -0.8 +
                lr[19] * 2.71 + lr[36] * -3.81 + lr[62] * 5.81 + lr[64] * -0.72 + lr[69] * 1.52 + lr[75] * 4.06 +
                lr[80] * -4.5 + lr[81] * 10.27 + lr[83] * -1.1 + lr[89] * -0.51 + lr[94] * -2.56 + lr[107] * -0.29 +
                lr[108] * 0.44 + lr[126] * -0.52 + lr[131] * 1.27 + lr[138] * -0.19 + lr[145] * 2.09 + lr[152] * 1.51 +
                lr[158] * 0.66 + lr[178] * 0.99 + lr[184] * -0.59 + lr[222] * -0.28 + lr[241] * 0.99 + lr[256] * 1.13 +
                lr[270] * -1.67 + lr[276] * -1.52 + lr[280] * 4.04 + lr[285] * -0.66 + lr[300] * -1.56 + lr[312] * 4.25 +
                lr[314] * 2.19 + lr[329] * 3.7  + lr[331] * -3.39 + lr[350] * -3.86 + lr[375] * -1.09 + lr[377] * 0.6  +
                lr[386] * 3.03 + lr[392] * -1.51 + lr[396] * -0.95 + lr[424] * -2.69 + lr[434] * 1.64 + lr[440] * 1.52 +
                lr[446] * 1.86 + lr[447] * -0.9 + lr[452] * -0.85 + lr[457] * 0.93 + lr[460] * 0.63 + lr[506] * 0.6  +
                lr[522] * 1.59 + lr[525] * 1.82 + lr[542] * 2.36 + lr[551] * 0.15 + lr[561] * 1.58 ;
        double class_1 = 0.83 + lr[6] * 0.8  +lr[19] * -2.71 +lr[36] * 3.81 +lr[62] * -5.81 +lr[64] * 0.72 +lr[69] * -1.52 +
                lr[75] * -4.06 +lr[80] * 4.5  +lr[81] * -10.27 +lr[83] * 1.1  +lr[89] * 0.51 +lr[94] * 2.56 +lr[107] * 0.29 +
                lr[108] * -0.44 +lr[126] * 0.52 +lr[131] * -1.27 +lr[138] * 0.19 +lr[145] * -2.09 +lr[152] * -1.51 +lr[158] * -0.66 +
                lr[178] * -0.99 +lr[184] * 0.59 +lr[222] * 0.28 +lr[241] * -0.99 +lr[256] * -1.13 +lr[270] * 1.67 +lr[276] * 1.52 +
                lr[280] * -4.04 +lr[285] * 0.66 +lr[300] * 1.56 +lr[312] * -4.25 +lr[314] * -2.19 +lr[329] * -3.7 +lr[331] * 3.39 +
                lr[350] * 3.86 +lr[375] * 1.09 +lr[377] * -0.6 +lr[386] * -3.03 +lr[392] * 1.51 +lr[396] * 0.95 +lr[424] * 2.69 +
                lr[434] * -1.64 +lr[440] * -1.52 +lr[446] * -1.86 +lr[447] * 0.9  +lr[452] * 0.85 +lr[457] * -0.93 +lr[460] * -0.63 +
                lr[506] * -0.6 +lr[522] * -1.59 +lr[525] * -1.82 +lr[542] * -2.36 +lr[551] * -0.15 +lr[561] * -1.58 ;

        if(class_0 > class_1) {
            Toast.makeText(this,"lm_1 app belongs to class_0 with prob = "+class_0,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"lm_1 app belongs to class_1 with prob = "+class_1,Toast.LENGTH_LONG).show();
        }



    }
}
