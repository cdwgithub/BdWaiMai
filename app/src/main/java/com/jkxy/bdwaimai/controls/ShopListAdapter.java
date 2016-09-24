package com.jkxy.bdwaimai.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jkxy.bdwaimai.R;
import com.jkxy.bdwaimai.model.ShopMessage;

import java.util.List;

/**
 * Created by X on 2016/3/26.
 */
public class ShopListAdapter extends BaseAdapter {
    private List<ShopMessage> list = null;
    private Context context;

    public ShopListAdapter(Context mContext, List<ShopMessage> list) {
        this.context = mContext;
        this.list = list;
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        final ShopMessage shopMessage = list.get(i);
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.home_shope_item, null);
            viewHolder.ivShopIcon=(ImageView)view.findViewById(R.id.iv_list_icon_shop);
            viewHolder.rbStarNuber=(RatingBar)view.findViewById(R.id.rb_list_icon_star);
            viewHolder.tvShopeName=(TextView)view.findViewById(R.id.tv_list_shopname);
            viewHolder.tvSales=(TextView)view.findViewById(R.id.tv_list_sales);
            viewHolder.tvDistance=(TextView)view.findViewById(R.id.tv_list_distance);
            viewHolder.tvQisong=(TextView)view.findViewById(R.id.tv_list_qisong);
            viewHolder.tvPeisong=(TextView)view.findViewById(R.id.tv_list_peisong);
            viewHolder.tvTime=(TextView)view.findViewById(R.id.tv_list_time);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.ivShopIcon.setImageResource(shopMessage.getShopIcon());
        viewHolder.rbStarNuber.setRating(shopMessage.getStarNumber());
        viewHolder.tvShopeName.setText(shopMessage.getShopNmae());
        viewHolder.tvSales.setText(shopMessage.getSales());
        viewHolder.tvDistance.setText(shopMessage.getDistance());
        viewHolder.tvQisong.setText(shopMessage.getQisong());
        viewHolder.tvPeisong.setText(shopMessage.getPeisong());
        viewHolder.tvTime.setText(shopMessage.getTime());

        return view;

    }

    final static class ViewHolder {
        ImageView ivShopIcon;
        RatingBar rbStarNuber;
        TextView tvShopeName;
        TextView tvSales;
        TextView tvDistance;
        TextView tvQisong;
        TextView tvPeisong;
        TextView tvTime;
    }
}
