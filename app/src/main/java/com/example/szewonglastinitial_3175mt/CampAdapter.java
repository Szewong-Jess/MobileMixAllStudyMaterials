package com.example.szewonglastinitial_3175mt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CampAdapter extends BaseAdapter
{
    List<Camp> CampList;
    int SelectedInd;

    public CampAdapter(List<Camp> campList) {
        CampList = campList;
        SelectedInd = -1;
    }

    public List<Camp> getCampList() {
        return CampList;
    }

    public void setCampList(List<Camp> campList) {
        CampList = campList;
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
    }

    @Override
    public int getCount() {
        return CampList.size();
    }

    @Override
    public Object getItem(int position) {
        return CampList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_campitem,parent,false);

            TextView txtViewCampTime = convertView.findViewById(R.id.txtViewCampTime);
            ImageView imageViewShowTime = convertView.findViewById(R.id.imageViewShowTime);


        }

        return convertView;
    }
}
