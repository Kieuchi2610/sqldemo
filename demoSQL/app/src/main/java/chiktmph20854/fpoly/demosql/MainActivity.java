package chiktmph20854.fpoly.demosql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import chiktmph20854.fpoly.demosql.Dao.TbCatDao;
import chiktmph20854.fpoly.demosql.Model.TbCategory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("zzzzz", "onCreate: phần tử thứ ");
        // phần này thử nghiệm ở bước 8
//        DbSqlServer dbSqlServer = new DbSqlServer();
//        Connection conn = dbSqlServer.openConnect();
        TbCatDao catDao = new TbCatDao();

        //======== Thêm mới 1 dòng
        TbCategory newObjCat = new TbCategory();
        newObjCat.setName("Thể loại mới");

        catDao.insertRow(newObjCat);


        // Sửa dữ liệu:
        TbCategory objCatUpdate = new TbCategory();
        objCatUpdate.setId(3);
        objCatUpdate.setName("Dữ liệu đã sửa");

        catDao.updateRow(objCatUpdate);



        // bước 9 thì không cần phần trên, dùng DAO để lấy dữ liệu

        List<TbCategory> listCat = catDao.getAll(); // lấy danh sách cho vào biến

        // duyệt mảng in ra danh sách
        for(int i = 0; i<listCat.size(); i++){
            TbCategory objCat = listCat.get(i);

            Log.d("zzzzz", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getId() + ", name = " + objCat.getName());
        }
    }
}