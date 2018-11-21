package kr.ac.mjc.sqlite_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    StudentAdapter studentAdapter;
    ListView listView;
    Button addStudentBtn;

    final int REQUEST_ADD_STUDENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button StudentAddButton = findViewById(R.id.std_add_btn);
        ListView listView = findViewById(R.id.listView);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Student> studentList =  realm.where(Student.class).findAll();
        studentAdapter = new StudentAdapter(this, studentList);
        listView.setAdapter(studentAdapter);
        listView.setOnItemClickListener(this);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AddStudentActivity.class);
                startActivityForResult(intent,REQUEST_ADD_STUDENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_ADD_STUDENT && resultCode==RESULT_OK){
            studentAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student=studentAdapter.getItem(position);
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(Student.class)
                .equalTo("studentNumber",student.getStudentNumber())
                .findFirst().deleteFromRealm();
        realm.commitTransaction();
        studentAdapter.notifyDataSetChanged();
    }
}