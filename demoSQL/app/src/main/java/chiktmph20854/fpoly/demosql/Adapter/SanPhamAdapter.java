package chiktmph20854.fpoly.demosql.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chiktmph20854.fpoly.demosql.Model.TbKhachHang;
import chiktmph20854.fpoly.demosql.R;
import chiktmph20854.fpoly.demosql.ThongTinTaiKhoan;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{
    private List<TbKhachHang> list;

    public void setData(List<TbKhachHang> mlist){
        this.list = mlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanpham_item,parent,false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        int i = position;
        TbKhachHang obj = list.get(i);
        if (obj == null){
            return;
        }
        holder.kh_ten_item.setText("Tên : "+obj.getTen_khachHang());
        holder.kh_sdt_item.setText("Sđt: "+obj.getSdt_khachHang());
        holder.kh_diachi_item.setText("Địa chỉ: "+obj.getDiaChi());
        holder.kh_username_item.setText("Username: "+obj.getUserName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, ThongTinTaiKhoan.class);
                i.putExtra("id",obj.getId_khachHang());
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder{
        TextView kh_ten_item,kh_sdt_item,kh_diachi_item,kh_username_item;
        CardView layout;
        Context context;
        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            kh_ten_item = itemView.findViewById(R.id.kh_ten_item);
            kh_sdt_item = itemView.findViewById(R.id.kh_sdt_item);
            kh_diachi_item = itemView.findViewById(R.id.kh_diachi_item);
            kh_username_item = itemView.findViewById(R.id.kh_username_item);
            layout = itemView.findViewById(R.id.layout);
            context = itemView.getContext();
        }
    }
}
