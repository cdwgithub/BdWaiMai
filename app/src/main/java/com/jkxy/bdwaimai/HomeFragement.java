package com.jkxy.bdwaimai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jkxy.bdwaimai.controls.ShopListAdapter;
import com.jkxy.bdwaimai.model.ShopMessage;

import java.util.ArrayList;

/**
 * Created by X on 2016/3/24.
 */
public class HomeFragement extends Fragment {
    private View view;

    private ShopListAdapter adapter;
    private ListView shopListView;
    private ArrayList<ShopMessage> shopList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        init();
        return view;
    }

    /**
     * 自定义商店列表数据
     */
    public void initShopMessage(){
        ShopMessage shopone=new ShopMessage();
        shopone.setShopIcon(R.drawable.shopone);
        shopone.setStarNumber(3.0f);
        shopone.setShopNmae("必胜客欢乐餐厅（上地华联店）");
        shopone.setSales("已售600份");
        shopone.setDistance("900m");
        shopone.setQisong("起送￥20");
        shopone.setPeisong("配送￥5");
        shopone.setTime("平均40分钟");

        ShopMessage shopentwo=new ShopMessage();
        shopentwo.setShopIcon(R.drawable.shoptwo);
        shopentwo.setStarNumber(4.0f);
        shopentwo.setShopNmae("肯德基（上地华联店）");
        shopentwo.setSales("已售900份");
        shopentwo.setDistance("900m");
        shopentwo.setQisong("起送￥20");
        shopentwo.setPeisong("配送￥5");
        shopentwo.setTime("平均30分钟");

        ShopMessage shopenthree=new ShopMessage();
        shopenthree.setShopIcon(R.drawable.shopthree);
        shopenthree.setStarNumber(2.0f);
        shopenthree.setShopNmae("麦当劳（上地华联店）");
        shopenthree.setSales("已售600份");
        shopenthree.setDistance("900m");
        shopenthree.setQisong("起送￥20");
        shopenthree.setPeisong("配送￥5");
        shopenthree.setTime("平均40分钟");

        ShopMessage shopenfour=new ShopMessage();
        shopenfour.setShopIcon(R.drawable.shopthree);
        shopenfour.setStarNumber(R.drawable.businesslistings_list_icon_star_half);
        shopenfour.setShopNmae("欢果园（上地华联店）");
        shopenfour.setSales("已售600份");
        shopenfour.setDistance("900m");
        shopenfour.setQisong("起送￥20");
        shopenfour.setPeisong("配送￥5");
        shopenfour.setTime("平均40分钟");

        shopList=new ArrayList<ShopMessage>();
        shopList.add(shopone);
        shopList.add(shopentwo);
        shopList.add(shopenthree);
        shopList.add(shopenfour);
    }

    /**
     * 初始化
     */
    public void init(){
        initShopMessage();
        shopListView=(ListView)view.findViewById(R.id.lv_home_shop);
        adapter=new ShopListAdapter(getActivity(),shopList);
        shopListView.setAdapter(adapter);
        setShopListViewHeightBaseOnChildren(shopListView);
    }

    /**
     * 为了在ScrollView中正常显示ListView，动态设置ListView的高度
     * @param listView
     */
    public void setShopListViewHeightBaseOnChildren(ListView listView){
        ListAdapter listAdapter=listView.getAdapter();
        if (listAdapter==null){
            return;
        }
        int totalHeight=0;
        for (int i=0;i<listAdapter.getCount();i++){
            View listItem=listAdapter.getView(i,null,listView);
            listItem.measure(0,0);
            totalHeight+=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height=totalHeight+(listView.getDividerHeight()*(listAdapter.getCount()-1));
        listView.setLayoutParams(params);
    }
}
