package kr.ac.mjc.sqlite_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudentItemLayout extends LinearLayout {

    TextView nameTv, studentNoTv, clsTv;

    public StudentItemLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_student, this, true);

        nameTv = rootView.findViewById(R.id.name_tv);
        studentNoTv = rootView.findViewById(R.id.std_no_tv);
        clsTv = rootView.findViewById(R.id.cls_tv);
    }

    public void setStudent(Student student) {
        nameTv.setText(student.getName());
        clsTv.setText(String.format("%d반 ",student.getCls()));
        studentNoTv.setText(student.getStudentNumber());
    }
}
