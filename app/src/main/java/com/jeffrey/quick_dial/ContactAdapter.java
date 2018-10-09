package com.jeffrey.quick_dial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<ContactEntity> mDataList;
    private Context mContext;

    public ContactAdapter(List<ContactEntity> list, Context context) {
        this.mDataList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList == null ? -1 : mDataList.size();
    }

    @Override
    public ContactEntity getItem(int position) {
        if (mDataList != null && position >= 0 && position < mDataList.size())
        {
            return mDataList.get(position);
        } else {
            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.img);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageResource(mDataList.get(position).mImageId);
        holder.phoneNumber.setText(mDataList.get(position).mPhoneNumber);
        return convertView;
    }
}


class ViewHolder {
    ImageView image;
    TextView phoneNumber;
}
