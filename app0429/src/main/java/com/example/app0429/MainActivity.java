package com.example.app0429;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import aidl.connect.DemoBean;
import aidl.connect.DemoSonBean;
import aidl.connect.IVideo;

public class MainActivity extends AppCompatActivity {

    private TextView send_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_tv = findViewById(R.id.send_tv);
        send_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iVideo!=null) {
                    try {
                        iVideo.basicTypes(0,"你好，Service,我hiActivity！");

                        DemoSonBean bean = new DemoSonBean();
                        bean.setSonName("SonName:jiajia");
                        bean.setSonCode(123);
                        iVideo.getDemoSonBean(bean);

                        DemoBean demoBean = new DemoBean();
                        demoBean.setName("Name:haha");
                        demoBean.setCode(001);
                        List<DemoSonBean> sonBeans = new ArrayList<>();
                        sonBeans.add(bean);
                        demoBean.setSons(sonBeans);
                        iVideo.getDemoBean(demoBean);

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Intent intent = new Intent("com.example.app0423.con_action");
        intent.setPackage("com.example.app0423");
        boolean result = this.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
       System.out.println("bindService result: " + result);
    }



    private IVideo iVideo;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iVideo =  IVideo.Stub.asInterface(service);

            System.out.println("AIDL+++++"+"Main:链接Service成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("AIDL+++++"+"Main:链接Service失败");
        }
    };

}
