package kr.ac.mjc.sqlite_example;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    List<Student> studentList;
    Context mContext;

    public StudentAdapter(Context context, List<Student> sl) {
        this.mContext = context;
        this.studentList = sl;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StudentItemLayout itemLayout;
        if(convertView == null) {
            itemLayout = new StudentItemLayout(mContext);
        }
        else {
            itemLayout = (StudentItemLayout) convertView;
        }
        Student student = getItem(position);
        itemLayout.setStudent(student);

        return itemLayout;
    }
}
