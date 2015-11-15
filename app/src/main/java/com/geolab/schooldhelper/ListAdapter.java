package com.geolab.schooldhelper;

/**
 * Created by dalkh on 14-Nov-15.
 */
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geolab.schooldhelper.Data.FormulaObj;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by dalkh on 01-Nov-15.
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<FormulaObj> FormulaObjes;
    private Context context;

    public ListAdapter(Context context, ArrayList<FormulaObj> FormulaObjes) {
        this.context = context;
        this.FormulaObjes = FormulaObjes;
    }

    @Override
    public int getCount() {
        return FormulaObjes.size();
    }

    @Override
    public Object getItem(int position) {
        return this.FormulaObjes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView;
        ViewHolder holder = null;
        if (convertView == null) {
            itemView = View.inflate(context, R.layout.list_item, null);
            ImageView ImageView = (ImageView) itemView.findViewById(R.id.formula);
            TextView DescriptionView = (TextView) itemView.findViewById(R.id.description);
            DescriptionView.setPaintFlags(DescriptionView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            holder = new ViewHolder();
            holder.ImageView = ImageView;
            holder.DescriptionView = DescriptionView;

            itemView.setTag(holder);
        } else {
            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }


        FormulaObj FormulaObj = (FormulaObj) getItem(position);

        Picasso.with(context).load(FormulaObj.getImage()).into(holder.ImageView);
        holder.DescriptionView.setText(FormulaObj.getDescription());



        return itemView;
    }

    private class ViewHolder {
        ImageView ImageView;
        TextView DescriptionView;
    }

}

