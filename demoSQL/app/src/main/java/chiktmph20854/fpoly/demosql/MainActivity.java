package chiktmph20854.fpoly.demosql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chiktmph20854.fpoly.demosql.Dao.TbCatDao;
import chiktmph20854.fpoly.demosql.Model.TbCategory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // phần này thử nghiệm ở bước 8
//        DbSqlServer dbSqlServer = new DbSqlServer();
//        Connection conn = dbSqlServer.openConnect();
        TbCatDao catDao = new TbCatDao();

        //======== Thêm mới 1 dòng
        TbCategory newObjCat = new TbCategory();
        newObjCat.setName("Thể loại mới");

        catDao.insertRow(newObjCat);


        // Sửa dữ liệu:
//        TbCategory objCatUpdate = new TbCategory();
//        objCatUpdate.setId(3);
//        objCatUpdate.setName("Dữ liệu đã sửa");
//
//        catDao.updateRow(objCatUpdate);



        // bước 9 thì không cần phần trên, dùng DAO để lấy dữ liệu

        List<TbCategory> listCat = catDao.getAll(); // lấy danh sách cho vào biến

        // duyệt mảng in ra danh sách

        List<String> list = new ArrayList<>();

        for(int i = 0; i<listCat.size(); i++){
            String s = "";
            TbCategory objCat = listCat.get(i);
            Log.d("zzzzz", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getId() + ", name = " + objCat.getName());
            s = " id = " + objCat.getId() + ", name = " + objCat.getName();
            list.add(s);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

    }
}