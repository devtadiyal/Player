package com.example.saffron.player;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends Activity {

    private RecyclerView recyclerView;
    String name,str;
    private RecyclerView.Adapter adapter;
    List l = new ArrayList();
    MediaPlayer mediaPlayer ;
    private List<Getter> list1 =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ItemClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well


                Toast.makeText(Main2Activity.this, "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();

                mediaPlayer = new MediaPlayer();

                try {
                    mediaPlayer.setDataSource("/storage/emulated/0/BIACBAudioRecording.3gp");
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();

                Toast.makeText(Main2Activity.this, "Recording Playing", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(Main2Activity.this, "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));



     /*   // For HardCore value
       */
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
        File[] list = file.listFiles();
       int count = 0;
        for (File f: list){
            name = f.getName();
            if  (name.endsWith(".3gp"))
                count++;
l.add(name);
        }

        System.out.println(l);
        String listString = "";

        for (Object s : l)
        {
            listString += s + "\t";
        }

        System.out.println("AAA "+listString.toString().split(" "));
        String str1 [] = listString.toString().split(" ");


        for(int k=0;k<count;k++)
        {
            Getter listItem = new Getter(name,"Banner Text");
            list1.add(listItem);

        }

        adapter = new AdapterClass(list1,this);
        recyclerView.setAdapter(adapter);


    }
    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ItemClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ItemClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


}