package com.example.administrator.android_widgets_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView salaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        setAdapter();
    }

    /*通过Adapter构建ListView的显示功能*/
    private void setAdapter() {
        /*获取数据源*/
        ArrayList<HashMap<String, Object>> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> user = new HashMap<>();
            user.put("img", R.drawable.user_img);
            user.put("name", "姓名(" + i + ")");
            user.put("salary", (i + 1) * 1000);
            users.add(user);
        }
        /*将数据源一对一绑定到布局文件中
        * 数据源
        * 一一对应
        * ListView每行的布局文件(ListView下的一个控件)
        * */
        SimpleAdapter userAdapter = new SimpleAdapter(this,
                users,//数据源
                R.layout.user,//相当于ListView下的一个控件
                new String[]{"img", "name", "salary"},
                new int[]{R.id.img, R.id.name, R.id.salary});
        /*显示数据*/
        salaryList.setAdapter(userAdapter);
    }

    /*布局文件空间实例化*/
    private void findViewById() {
        salaryList = (ListView) findViewById(R.id.salaryList);
    }
}
