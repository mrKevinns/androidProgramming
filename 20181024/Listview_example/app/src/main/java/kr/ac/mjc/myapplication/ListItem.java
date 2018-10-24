package kr.ac.mjc.myapplication;

import android.graphics.drawable.Drawable;

public class ListItem  {
    private Drawable image;
    private String title;
    private String data1;
    private String data2;

    public ListItem(Drawable image, String title, String data1, String data2) {

        this.image = image;
        this.title = title;
        this.data1 = data1;
        this.data2 = data2;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}
