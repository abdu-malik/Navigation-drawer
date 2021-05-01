package com.abdul.quroni_karim.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abdul.quroni_karim.R;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private List<ListItemClass>listItem = new ArrayList<>();
    private Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource,List<ListItemClass> listItem,LayoutInflater inflater) {
        super(context, resource,listItem);
        this.inflater = inflater;
        this.listItem = listItem;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ListItemClass listItemMain = listItem.get(position);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_view_item_1, null, false);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tvName);
            viewHolder.secondName = convertView.findViewById(R.id.tvSecondName);
            convertView.setTag(viewHolder);
            convertView.setTag(viewHolder);
        }
        else
        {
          viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(listItemMain.getName());
        viewHolder.secondName.setText(listItemMain.getSecond_name());


        return convertView;
    }
    private class ViewHolder {
      TextView name;
      TextView secondName;
      ImageView image;
    }
}
