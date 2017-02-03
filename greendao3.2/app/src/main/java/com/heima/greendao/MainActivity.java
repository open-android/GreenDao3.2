package com.heima.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.heima.greendao.beans.Student;
import com.heima.greendao.dao.StudentDao;
import org.greenrobot.greendao.query.QueryBuilder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    StudentDao studentDao;
    private EditText etId;
    private EditText etName;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnQuery;
    private TextView tvQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        studentDao = GreenDaoUtils.getSingleTon().getmDaoSession().getStudentDao();

        /*新增一条数据*/
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                if (isNotEmpty(id) && isNotEmpty(name)) {
                    QueryBuilder qb = studentDao.queryBuilder();
                    ArrayList<Student> list = (ArrayList<Student>) qb.where(StudentDao.Properties.Id.eq(id)).list();
                    if (list.size() > 0) {
                        Toast.makeText(MainActivity.this, "已经有该id的学生", Toast.LENGTH_SHORT).show();
                    } else {
                        studentDao.insert(new Student(Long.valueOf(id), name));
                        Toast.makeText(MainActivity.this, "插入学生信息成功", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (isEmpty(id) && isNotEmpty(name)) {
                        Toast.makeText(MainActivity.this, "id为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(name) && isNotEmpty(id)) {
                        Toast.makeText(MainActivity.this, "姓名为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(id) && isEmpty(name)) {
                        Toast.makeText(MainActivity.this, "请填写学生信息", Toast.LENGTH_SHORT).show();
                    }

                }
                etId.setText("");
                etName.setText("");
            }
        });

        /*删除指定数据*/
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                if (isNotEmpty(id)) {
                    studentDao.deleteByKey(Long.valueOf(id));
                    QueryBuilder qb = studentDao.queryBuilder();
                    ArrayList<Student> list = (ArrayList<Student>) qb.where(StudentDao.Properties.Id.eq(id)).list();
                    if (list.size() < 1) {
                        Toast.makeText(MainActivity.this, "删除学生数据成功", Toast.LENGTH_SHORT).show();
                        etId.setText("");
                        etName.setText("");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "id为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*查询数据*/
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                if (isNotEmpty(id)) {
                    QueryBuilder qb = studentDao.queryBuilder();
                    ArrayList<Student> list = (ArrayList<Student>) qb.where(StudentDao.Properties.Id.eq(id)).list();
                    if (list.size() > 0) {
                        String text = "";
                        for (Student Student : list) {
                            text = text + "\r\n" + Student.getName();
                        }
                        tvQuery.setText(text);
                    } else {
                        tvQuery.setText("");
                        Toast.makeText(MainActivity.this, "不存在该学生数据", Toast.LENGTH_SHORT).show();
                    }
                    etId.setText("");
                    etName.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "id为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initView() {
        etId = (EditText) findViewById(R.id.etId);
        etName = (EditText) findViewById(R.id.etName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        tvQuery = (TextView) findViewById(R.id.tvQuery);
    }

    private boolean isNotEmpty(String s) {
        if (s != null && !s.equals("") || s.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(String s) {
        if (isNotEmpty(s)) {
            return false;
        } else {
            return true;
        }
    }

}
