package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    private TextView txt;
    private EditText txt_id, txt_pw, txt_pw2, txt_birth, txt_sex, txt_phone;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button btn_photo, btn_ham, btn_pre, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        txt_id = findViewById(R.id.txt_id);
        txt_pw = findViewById(R.id.txt_pw);
        txt_pw2 = findViewById(R.id.txt_pw2);
        txt_birth = findViewById(R.id.txt_birth);
        txt_sex = findViewById(R.id.txt_sex);
        txt_phone = findViewById(R.id.txt_phone);
        txt = findViewById(R.id.txt);
        img_psa = findViewById(R.id.img_psa);
        img_pre1 = findViewById(R.id.img_pre1);
        img_pre2 = findViewById(R.id.img_pre2);
        img_camera = findViewById(R.id.img_camera);
        imgView4 = findViewById(R.id.imageView4);
        btn_photo = findViewById(R.id.btn_photo);
        btn_ham = findViewById(R.id.btn_ham);
        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);

        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입할때 프사(img_psa)에 사진찍어서넣기
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 128);

            }
//            public void doTakeAlbumAction(){
//                // 회원가입할때 프사(img_psa)에 카메라앨범에서넣기
//                Intent intent1 = new Intent(Intent.ACTION_PICK);
//                intent1.setType(MediaStore.Images.Media.CONTENT_TYPE);
//                startActivityForResult(intent1, img_psa);
//
//            }

        });


        btn_ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hamburger.class);
                intent.putExtra("data", "join");
                startActivityForResult(intent, 1004);
                // 햄버거 페이지 넘어가게하기 페이지없다그럤는데 우선 이렇게 만듬
            }
        });


        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 2000);
                // 이전 메인화면으로 돌아가기
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();
                String pw = txt_pw.getText().toString();
                String pw2 = txt_pw2.getText().toString();
                String sex = txt_sex.getText().toString();
                String birth = txt_birth.getText().toString();
                String phone = txt_phone.getText().toString();
                // 유저 정보 보내기
                Intent intent = new Intent(getApplicationContext(), join2.class);
                intent.putExtra("data", "user");
                startActivityForResult(intent, 1004);
                // next 다음버튼 눌러서 회원가입 2번째 창으로 넘어가기
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 128 && resultCode == RESULT_OK) ;
        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");
        img_psa.setImageBitmap(bitmap);
        // 회원가입할때 프사(img_psa) btn_photo 클릭에 사진촬영해서넣기
    }
}