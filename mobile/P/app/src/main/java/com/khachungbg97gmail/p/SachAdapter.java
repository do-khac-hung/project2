package com.khachungbg97gmail.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ASUS on 11/22/2017.
 */

public class SachAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Sach> sachList;
    private ArrayList<Sach> arrayList;

    public SachAdapter(Context context, int layout, List<Sach> sachList) {
        this.context = context;
        this.layout = layout;
        this.sachList = sachList;
        this.arrayList=new ArrayList<Sach>();
        this.arrayList.addAll(sachList);
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
    private class ViewHolder{
        TextView SachID,TenSach,TacGia,Soluong,NgayNhap,NhaXB,SoluongCon,GiaTien;
        ImageView imgEdit,imgDelete;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.TenSach=(TextView)view.findViewById(R.id.tvTensach);
            holder.SachID=(TextView)view.findViewById(R.id.tvmasach);
            holder.TacGia=(TextView)view.findViewById(R.id.tvtacgia);
            holder.Soluong=(TextView)view.findViewById(R.id.tvslsach);
            holder.NgayNhap=(TextView)view.findViewById(R.id.tvngaynhap);
            holder.NhaXB=(TextView)view.findViewById(R.id.tvNhaXB);
            holder.SoluongCon=(TextView)view.findViewById(R.id.tvslsachcon);
            holder.GiaTien=(TextView)view.findViewById(R.id.tvGiaTien);
//            holder.imgDelete=(ImageView)view.findViewById(R.id.imageViewdelete);
//            holder.imgEdit=(ImageView)view.findViewById(R.id.imageViewedit);
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }
        Sach sach=sachList.get(i);
        holder.TenSach.setText(sach.getTenSach());
        holder.SachID.setText("Mã:"+sach.getSachID());
        holder.TacGia.setText("Tác Giả:"+sach.getTacGia());
        holder.Soluong.setText("Số Lượng:"+sach.getSoLuong());
        holder.NgayNhap.setText("Nhập:"+sach.getNgayNhap());
        holder.NhaXB.setText("NXB:"+sach.getNhaXB());
        holder.SoluongCon.setText("Còn:"+sach.getSoLuongCon());
        holder.GiaTien.setText("Giá:"+sach.getGiaTien());
        return view;
    }
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        sachList.clear();
        if (charText.length() == 0) {
            sachList.addAll(arrayList);
        } else {
            for (Sach wp : arrayList) {
                if (wp.getTenSach().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    sachList.add(wp);
                }
                else if(wp.getTacGia().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    sachList.add(wp);
                }
                else if(wp.getNhaXB().toLowerCase(Locale.getDefault()).contains(charText)){
                    sachList.add(wp);

                }
            }
        }
        notifyDataSetChanged();
    }

}
