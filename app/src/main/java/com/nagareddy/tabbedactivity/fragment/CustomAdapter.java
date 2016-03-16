package com.nagareddy.tabbedactivity.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nagareddy.tabbedactivity.R;

import java.util.ArrayList;

/**
 * Created by keerthichandra on 3/3/2016.
 */
public class CustomAdapter extends BaseAdapter   {


    private static ArrayList<ListviewContactItem> listContact;


    private LayoutInflater mInflater;

  public CustomAdapter(Context photosFragment, ArrayList<ListviewContactItem> results) {
        listContact = results;
        mInflater = LayoutInflater.from(photosFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listContact.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listContact.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


     public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.contact_list, null);
            holder = new ViewHolder();
            holder.txtname = (TextView) convertView.findViewById(R.id.lv_contact_item_name);
         //   holder.txtphone = (TextView) convertView.findViewById(R.id.lv_contact_item_phone);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
       //     holder.deleteView = (ImageView) convertView.findViewById(R.id.delete);
            convertView.setTag(holder);
       }

        else {
          holder = (ViewHolder) convertView.getTag();
       }
        holder.txtname.setText(listContact.get(position).getName());
      // holder.txtphone.setText(Integer.toString(position));
         holder.imageView.setImageResource(listContact.get(position).getImage());
       //  holder.deleteView.setImageResource(listContact.get(position).getImage2());



      /*  holder.deleteView.setOnClickListener(new View.OnClickListener() {

         @Override
           public void onClick(View v) {

               Toast.makeText(v.getContext(), "you Clicked me", Toast.LENGTH_SHORT).show();
           }
       }); */



         return convertView;
     }




    static class ViewHolder {
        TextView txtname ;
       // TextView txtphone ;

        ImageView imageView;


        public ImageView deleteView;

    }




}


