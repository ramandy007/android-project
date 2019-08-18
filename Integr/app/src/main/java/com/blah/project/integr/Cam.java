package com.blah.project.integr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



    public class Cam extends AppCompatActivity implements View.OnClickListener {
        private static final int CAMERA_REQUEST = 18;
        ImageView imageView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cam);
            imageView = (ImageView) this.findViewById(R.id.imageView1);
            Button photoButton = (Button) this.findViewById(R.id.button1);
            photoButton.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,CAMERA_REQUEST);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);
                //Toast.makeText(this,String.valueOf(resultCode), Toast.LENGTH_SHORT).show();}}

}}}
