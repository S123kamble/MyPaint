package com.felixtechlabs.mypaint;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawingView mDrawingView;
    private ImageButton currPaint, drawButton, eraseButton;
    private float smallBrush, mediumBrush, largeBrush;

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Items> items;
    Context mContext;

    FloatingActionButton btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFloat =  findViewById(R.id.floatingActionButton);
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
//                dialogBuilder.setTitle("hi");
//                dialogBuilder.setMessage("this is my app");
//
////                dialogBuilder.setButton("Continue..", new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int which) {
////                        // here you can add functions
////                    }
////                });
//
//                dialogBuilder.show();  //<-- See This!

                ViewDialog viewDialog = new ViewDialog();
                viewDialog.showDialog(MainActivity.this, "");
            }

        });

        recyclerView = findViewById(R.id.rv_canvas);

        items  =new ArrayList<>();

        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));
        items.add(new Items("Field1","Field2","Field3","Field4","Field5","Field6"));

        CanvasAdapter canvasAdapter = new CanvasAdapter(getApplicationContext(),items);
        layoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(canvasAdapter);





        mDrawingView = (DrawingView) findViewById(R.id.drawing);

        // 0th child is white color, so selecting first child to give black as initial color.
        drawButton = findViewById(R.id.buttonBrush);
        drawButton.setOnClickListener(this);
        eraseButton = findViewById(R.id.buttonErase);
        eraseButton.setOnClickListener(this);


    }


    public void paintClicked(View view) {
        if (view != currPaint) {
            // Update the color
            ImageButton imageButton = (ImageButton) view;
            String colorTag = imageButton.getTag().toString();
            mDrawingView.setColor(colorTag);
            // Swap the backgrounds for last active and currently active image button.
            imageButton.setImageDrawable(getResources().getDrawable(R.drawable.pallet_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.pallet));
            currPaint = (ImageButton) view;
            mDrawingView.setErase(false);
            mDrawingView.setBrushSize(mDrawingView.getLastBrushSize());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonBrush:
                // Show brush size chooser dialog
                showBrushSizeChooserDialog();
                break;
            case R.id.buttonErase:
                // Show eraser size chooser dialog
                showEraserSizeChooserDialog();
                break;

        }
    }

    private void showBrushSizeChooserDialog() {
        final Dialog brushDialog = new Dialog(this);
        brushDialog.setContentView(R.layout.dialog_brush_size);
        brushDialog.setTitle("Brush size:");

    }

    private void showEraserSizeChooserDialog() {
        final Dialog brushDialog = new Dialog(this);
        brushDialog.setTitle("Eraser size:");
        brushDialog.setContentView(R.layout.dialog_brush_size);



        mDrawingView.setColor("#FFFFFF");

        ImageButton largeBtn = brushDialog.findViewById(R.id.large_brush);

        mDrawingView.setErase(false);

        mDrawingView.setColor("#FFFFFF");



    }
}
