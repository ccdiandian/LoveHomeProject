package com.example.administrator.lovehomeproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mind.mine.Mind;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;
    List<Fragment> list = new ArrayList<Fragment>();
    ImageView img1,img2,img3;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new Mind());

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        initView();
        FragmentManager fm = getSupportFragmentManager();
        // 准备你的FragmentPagerAdapter
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(fm) {

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return list.get(arg0);
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 当页面在拖动的过程中

            }

            @Override
            public void onPageSelected(int position) {
                // 当页面切换之后
                img1.setImageResource(R.drawable.home);
                img2.setImageResource(R.drawable.publish);
                img3.setImageResource(R.drawable.wode);
                tv1.setTextColor(Color.rgb(66,66,66));
                tv2.setTextColor(Color.rgb(66,66,66));
                tv3.setTextColor(Color.rgb(66,66,66));
                switch (position){
                    case 0:
                        img1.setImageResource(R.drawable.home_press);
                        tv1.setTextColor(Color.rgb(51,196,76));
                        break;

                    case 1:
                        img2.setImageResource(R.drawable.publish_press);
                        tv2.setTextColor(Color.rgb(51,196,76));
                        break;

                    case 2:
                        img3.setImageResource(R.drawable.wode_press);
                        tv3.setTextColor(Color.rgb(51,196,76));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 当页面在拖动状态发生改变的时候（开始动，停止动）
            }
        });

    }

    private void initView(){

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

    }

    public void pageChange(View v){

        switch (v.getId()){

            case R.id.layout1:
                viewPager.setCurrentItem(0);
                break;

            case R.id.layout2:
                viewPager.setCurrentItem(1);
                break;

            case R.id.layout3:
                viewPager.setCurrentItem(2);
                break;
        }
    }


}
