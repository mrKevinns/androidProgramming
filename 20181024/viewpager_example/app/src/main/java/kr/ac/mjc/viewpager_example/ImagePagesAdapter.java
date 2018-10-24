package kr.ac.mjc.viewpager_example;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImagePagesAdapter extends PagerAdapter {
    LayoutInflater inflater;
    Context mContext;
    

    public ImagePagesAdapter(Context context){
        this.mContext=context;
        this.inflater= (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    int[] image = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (View)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_layout,container,false);
        ImageView imageView = rootView.findViewById(R.id.image);
        Drawable drawable = mContext.getResources().getDrawable(image[position]);
        imageView.setImageDrawable(drawable);
        container.addView(rootView);
        return rootView;

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
