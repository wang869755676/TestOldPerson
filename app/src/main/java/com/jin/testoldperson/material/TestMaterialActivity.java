package com.jin.testoldperson.material;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jin.testoldperson.R;

public class TestMaterialActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_material);
        Aby aby1 = new Aby(1);
        Aby aby2 = null;
        try {
            aby2 = (Aby) aby1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        aby1.i = 2;
       Log.e("copy",aby1.i+"ggg"); //2
        Log.e("copy",aby2.i+"ggg" ); //1

        Aby[] arr = {aby1,aby2};

        Aby[] arr2 = arr.clone();
        arr2[0].i = 3;
        Log.e("copy",arr[0].i+"ggg" );   //3
        Log.e("copy",arr2[0].i+"ggg" );  //3
        Log.e("copy",(arr==arr2)+"ggg" );


        int[] arr3 = {1,45};

        int[] arr4 =  arr3.clone();
        arr4[0] = 3;
        Log.e("copy",arr3[0]+"ggg" );   //3
        Log.e("copy",arr4[0]+"ggg" );  //3
        Log.e("copy",(arr==arr2)+"ggg" );
    }
}
