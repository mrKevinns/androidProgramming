package kr.ac.mjc.hj.fragment_example;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class viewerFragment extends Fragment{

    int[] imageList = {R.drawable.image1, R.drawable.image2};
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_selector, container, false);
        imageView = rootView.findViewById(R.id.image);
        return rootView;
    }
    public void setIage(int index) {
        imageView.setImageResource(imageList[index]);
    }
}
