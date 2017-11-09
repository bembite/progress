package com.example.bembi.progress;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bembi on 11/10/17.
 */

public class CategoriesAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    String[] rate;
    private static LayoutInflater inflater=null;
    public CategoriesAdapter(Activity Categories, String[] prgmNameList, int[] prgmImages, String[] prgRateList ) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=Categories;
        imageId=prgmImages;
        rate= prgRateList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView rv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.categories_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.name);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.rv=(TextView)rowView.findViewById(R.id.rate);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.rv.setText(result[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
