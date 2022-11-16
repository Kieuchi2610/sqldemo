package chiktmph20854.fpoly.demosql.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chiktmph20854.fpoly.demosql.Model.TbSanPham;
import chiktmph20854.fpoly.demosql.R;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{
    private List<TbSanPham> list;

    public void setData(List<TbSanPham> mlist){
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
        TbSanPham obj = list.get(i);
        if (obj == null){
            return;
        }
        holder.sp_ten_item.setText("Tên sản phẩm: "+obj.getTen_sanPham());
        holder.sp_gianhap_item.setText("Giá nhập: "+obj.getGiaNhap());
        holder.sp_giaban_item.setText("Giá bán: "+obj.getGiaBan());
        holder.sp_tonkho_item.setText("Số lượng trong kho: "+obj.getTonKho());
        Picasso.get().load(obj.getSrcAnh()).fit().into(holder.sp_anh_item);
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder{
        TextView sp_ten_item,sp_giaban_item,sp_gianhap_item,sp_tonkho_item;
        ImageView sp_anh_item;
        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_ten_item = itemView.findViewById(R.id.sp_ten_item);
            sp_giaban_item = itemView.findViewById(R.id.sp_giaban_item);
            sp_gianhap_item = itemView.findViewById(R.id.sp_gianhap_item);
            sp_tonkho_item = itemView.findViewById(R.id.sp_tonkho_item);
            sp_anh_item = itemView.findViewById(R.id.sp_anh_item);
        }
    }
}
