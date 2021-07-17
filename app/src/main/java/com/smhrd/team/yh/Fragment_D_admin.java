package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment_D_admin extends Fragment {

    private View fragment;
    private Button btn_admin_Logout,btn_push;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//언니화이팅 :)



         fragment = inflater.inflate(R.layout.activity_fragment_dadmin, container, false);
        btn_admin_Logout=fragment.findViewById(R.id.btn_admin_Logout);
        btn_admin_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.clear(fragment.getContext());
                Toast.makeText(fragment.getContext(), "로그아웃", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(fragment.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btn_push=fragment.findViewById(R.id.btn_push);
        NotificationCompat.Builder mBulider=new NotificationCompat.Builder(getActivity()).setContentTitle("알림제목")
                .setContentText("알림 내용").setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.ic_baseline_campaign_24);

        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManagerCompat.from(getActivity()).notify(0, mBulider.build());


            }
        });


        return fragment;
    }
}