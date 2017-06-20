package com.jin.testoldperson.permission;


import android.Manifest;
import android.content.Intent;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jin.testoldperson.R;
import com.jin.testoldperson.fileprovider.FileProvider7;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class PermissionFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_permission, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(v);
            }
        });
    }

    public void takePicture(View view) {

       PermissionHandle.requestPermission(getActivity(), 1, new PermissionListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void permissionGrand(int requestCode) {
               Log.e("====","permissionGrand");
               Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                   String filename = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.CHINA)
                           .format(new Date()) + ".png";
                   File file = new File(Environment.getExternalStorageDirectory(), filename);
                   //mCurrentPhotoPath = file.getAbsolutePath();

                   Uri fileUri = FileProvider7.getUriForFile(getActivity(), file);

                   takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                   startActivityForResult(takePictureIntent, 2);
               }
           }

           @Override
           public void permissionDeny(int requestCode) {
               Log.e("====","deny");
           }

           @Override
           public void permissionNeverAsk(int requestCode) {
               Log.e("===="," permissionNeverAsk");
           }

           @Override
           public void permissionTip(int requestCode) {
               Log.e("===="," permissionTip");
           }
       },new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CALL_PHONE});
    }
}
