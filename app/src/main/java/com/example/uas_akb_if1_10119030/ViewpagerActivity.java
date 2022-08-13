package com.example.uas_akb_if1_10119030;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewpagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        //Memasang adapter ke view pager
        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new Adapter(this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
    }

    private class Adapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        // list gambar
        int[] list_img = {
                R.drawable.note_1,
                R.drawable.note_2
        };

        // list judul
        int[] list_title = {
                R.string.judul_1,
                R.string.judul_2
        };

        // list deksripsi
        int[] list_desc = {
                R.string.desk_1,
                R.string.desk_2
        };

        // list color bg
        int[] list_color = {
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white)
        };

        @Override
        public int getCount() {
            return list_title.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_item,container,false);
            LinearLayout linearLayout = view.findViewById(R.id.layout_item);
            ImageView imageView = view.findViewById(R.id.img);
            TextView title = view.findViewById(R.id.title);
            TextView desc = view.findViewById(R.id.desc);

            linearLayout.setBackgroundColor(list_color[position]);
            imageView.setImageResource(list_img[position]);
            title.setText(list_title[position]);
            desc.setText(list_desc[position]);

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout)object);
        }
    }

    public void Lanjutkan(View view) {
        Intent intent = new Intent(ViewpagerActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
