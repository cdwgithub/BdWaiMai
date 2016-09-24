package com.jkxy.bdwaimai;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jkxy.bdwaimai.controls.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private LinearLayout llHome;//首页
    private LinearLayout llOrder;//订单
    private LinearLayout llMe;//吃啥

    private TextView tvHome;
    private TextView tvOrder;
    private TextView tvMe;

    private ImageView ivHome;
    private ImageView ivOrder;
    private ImageView ivMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMember();
    }

    /**
     * 初始化视图控件
     */
    private void initMember(){
        viewPager=(ViewPager)findViewById(R.id.id_viewpager);

        ivHome=(ImageView)findViewById(R.id.iv_Home);
        ivOrder=(ImageView)findViewById(R.id.iv_Order);
        ivMe=(ImageView)findViewById(R.id.iv_Me);

        tvHome=(TextView)findViewById(R.id.tv_Home);
        tvOrder=(TextView)findViewById(R.id.tv_Order);
        tvMe=(TextView)findViewById(R.id.tv_Me);


        //添加ViewPager子视图
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new HomeFragement());
        list.add(new OrderFragment());
        list.add(new MeFragment());
        //ViewPagerAdapter设置及绑定
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImageViewSrc();
                resetTextViewColor();
                switch (position) {
                    case 0:
                        ivHome.setImageResource(R.drawable.tab_icon_home_selected);
                        tvHome.setTextColor(getResources().getColor(R.color.bottom_text_selected));
                        break;
                    case 1:
                        ivOrder.setImageResource(R.drawable.tab_icon_dingdan_selected);
                        tvOrder.setTextColor(getResources().getColor(R.color.bottom_text_selected));
                        break;
                    case 2:
                        ivMe.setImageResource(R.drawable.tab_icon_me_selected);
                        tvMe.setTextColor(getResources().getColor(R.color.bottom_text_selected));
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        llHome=(LinearLayout)findViewById(R.id.ll_Home);
        llOrder=(LinearLayout)findViewById(R.id.ll_Order);
        llMe=(LinearLayout)findViewById(R.id.ll_Me);

        BottomLayoutListener listener = new BottomLayoutListener();
        llHome.setOnClickListener(listener);
        llOrder.setOnClickListener(listener);
        llMe.setOnClickListener(listener);


    }
    //底部导航栏菜单点击事件
    class BottomLayoutListener implements View.OnClickListener
    {

        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.ll_Home:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id.ll_Order:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id.ll_Me:
                    viewPager.setCurrentItem(2, true);
                    break;

            }
        }
    }
    //复原ImageView的初始图片
    private void resetImageViewSrc(){
        ivHome.setImageResource(R.drawable.tab_icon_home);
        ivOrder.setImageResource(R.drawable.tab_icon_dingdan);
        ivMe.setImageResource(R.drawable.tab_icon_me);
    }
    private void resetTextViewColor(){
        tvHome.setTextColor(getResources().getColor(R.color.bottom_text));
        tvOrder.setTextColor(getResources().getColor(R.color.bottom_text));
        tvMe.setTextColor(getResources().getColor(R.color.bottom_text));
    }
}
