package chiktmph20854.fpoly.demosql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chiktmph20854.fpoly.demosql.Adapter.SanPhamAdapter;
import chiktmph20854.fpoly.demosql.Dao.TbSanPhamDao;
import chiktmph20854.fpoly.demosql.Model.TbSanPham;

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
        TbSanPham newObjCat = new TbSanPham();
        newObjCat.setTen_sanPham("Thể loại mới");

        catDao.insertRow(newObjCat);


         //Sửa dữ liệu:
        TbSanPham objCatUpdate = new TbSanPham();
        objCatUpdate.setId_sanPham(3);
        objCatUpdate.setTen_sanPham("Dép bitis");

        catDao.updateRow(objCatUpdate);



        // bước 9 thì không cần phần trên, dùng DAO để lấy dữ liệu

        List<TbSanPham> listCat = catDao.getAll(); // lấy danh sách cho vào biến

        // duyệt mảng in ra danh sách

        List<TbSanPham> list = new ArrayList<>();

        for(int i = 0; i<listCat.size(); i++){
            TbSanPham obj = listCat.get(i);
            Log.i("TAG", "onCreate: "+obj.getSrcAnh());
            list.add(new TbSanPham(obj.getTen_sanPham(),obj.getSrcAnh(),obj.getGiaNhap(),obj.getGiaBan(),obj.getTonKho()));
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