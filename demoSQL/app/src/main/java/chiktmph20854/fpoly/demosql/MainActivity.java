package chiktmph20854.fpoly.demosql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import chiktmph20854.fpoly.demosql.Adapter.SanPhamAdapter;
import chiktmph20854.fpoly.demosql.Dao.TbSanPhamDao;
import chiktmph20854.fpoly.demosql.Model.TbKhachHang;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // phần này thử nghiệm ở bước 8
//        DbSqlServer dbSqlServer = new DbSqlServer();
//        Connection conn = dbSqlServer.openConnect();
        TbSanPhamDao catDao = new TbSanPhamDao();

        //======== Thêm mới 1 dòng
//        TbSanPham newObj = new TbSanPham();
//        newObj.setTen_sanPham("Quần kaki");
//        newObj.setSrcAnh("https://iili.io/H95yT41.jpg");
//        newObj.setGiaNhap(200);
//        newObj.setGiaBan(250);
//        newObj.setTonKho(135);
//        newObj.setId_danhmuc(2);
//        catDao.insertRow(newObj);

         //Sửa dữ liệu:
//        TbSanPham objCatUpdate = new TbSanPham();
//        objCatUpdate.setId_sanPham(3);
//        objCatUpdate.setTen_sanPham("Dép bitis");
//
//        catDao.updateRow(objCatUpdate);



        // bước 9 thì không cần phần trên, dùng DAO để lấy dữ liệu

        List<TbKhachHang> listCat = catDao.getAll(); // lấy danh sách cho vào biến

        // duyệt mảng in ra danh sách

        List<TbKhachHang> list = new ArrayList<>();

        for(int i = 0; i<listCat.size(); i++){
            TbKhachHang obj = listCat.get(i);
            list.add(new TbKhachHang(obj.getId_khachHang(),obj.getTen_khachHang(),obj.getSdt_khachHang(),obj.getDiaChi(),obj.getUserName()));
        }

        // up lên rsv
        RecyclerView rsv = findViewById(R.id.rsv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rsv.setLayoutManager(linearLayoutManager);

        SanPhamAdapter adapter = new SanPhamAdapter();
        adapter.setData(list);
        rsv.setAdapter(adapter);
    }
}