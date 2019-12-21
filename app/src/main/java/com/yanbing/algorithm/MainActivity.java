package com.yanbing.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        singleList_1();
    }

    private void singleList_1() {
        Single_list single_list = new Single_list();
        single_list.addNode_Head((Object) 1);
        single_list.addNode_Head((Object) 2);
        single_list.addNode_Head((Object) 3);
        single_list.addNode_Head((Object) 4);
        single_list.addNode_Head((Object) 5);
        single_list.addNote_index((Object)8,4);
        single_list.deleteNoteIndex(4);
        single_list.printListFromHead();
        Log.d(TAG,"length="+single_list.getLength());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
