package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList <HashMap <String, String> > arrayList = new ArrayList<>();
    HashMap <String, String > hashMap = new HashMap<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        hMap();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

    }

    private class MyAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.item, parent, false);

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView category = view.findViewById(R.id.category);
            TextView title = view.findViewById(R.id.name);
            ImageView image = view.findViewById(R.id.image);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView description = view.findViewById(R.id.description);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout itemLayout = view.findViewById(R.id.itemLayout);



            HashMap <String, String> hashMap = arrayList.get(position);

            String c = hashMap.get("cat");
            String t = hashMap.get("title");
            String d = hashMap.get("description");
            String i = hashMap.get("image_url");

            Picasso.get().load(i)
                    .placeholder(R.drawable.tech)
                    .into(image);

            category.setText(c);
            title.setText(t);
            description.setText(d);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            category.setBackgroundColor(color);

            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(MainActivity.this, NewsDetails.class));

                }
            });

            return view;
        }
    }

    public void hMap(){

        HashMap <String, String > hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("title", "T বাজারে এল রিয়েলমি’র ৪৫ ওয়াট চার্জিং ক্যাপ্টেন ‘সি৬৩’");
        hashMap.put("description", "আইসিসি মেন’স টি-২০ বিশ্বকাপের এই রোমা কর সময়ে তরুণদের প্রিয় স্মার্টফোন ব্র্যান্ড রিয়েলমি দেশের স্মার্টফোন মার্কেটে কাঙ্খিত ‘রিয়েলমি সি৬৩’ মোবাইল ডিভাইসটি নিয়ে এসেছে; আকর্ষণীয় এই ফোনে রয়েছে অসাধারণ সক্ষমতার ৪৫ ওয়াট ফাস্ট চার্জ ফিচার, যার মাধ্যমে মাত্র ৩মিনিট চার্জের মাধ্যমে ১ ঘণ্টাব্যাপী ক্রিকেট ম্যাচ উপভোগ করা যাবে।\n\n" +
                "সর্বাধুনিক প্রযুক্তির এই স্মার্টফোনে আরো রয়েছে- ৫০০০এমএএইচ ব্যাটারি। এটি ১০ মিনিটেই ২০ শতাংশ, ৩০ মিনিটে ৫০ শতাংশ এবং মাত্র ৭৯ মিনিটে ১০০% অর্থ্যাৎ পূর্ণ চার্জ লাভ করে। এছাড়া, ৬০-সেকেন্ড চার্জে ব্যবহারকারীরা ফোনে কথা বলতে ৬০ মিনিট সময় ধরে। ‘রিয়েলমি সি৬৩’ একমাত্র ফোন যেটি এই সেগমেন্টে প্রথম ‘টিইউভি রেইনল্যান্ড সেফ ফাস্ট-চার্জ সিস্টেম সার্টিফিকেশন’ অর্জন করেছে; এই সার্টিফিকেশন চার্জিং প্রক্রিয়ার নিরাপত্তার গ্যারান্টি দেয় অর্থ্যাৎ সর্বোচ্চ নিরাপত্তা নিশ্চিত করতে বিভিন্ন পর্যায়ে কঠিন সব পরীক্ষা পেরুতে হয়েছে এটিকে।\n\n");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2024/06/C63-Photo.jpeg");
        arrayList.add(hashMap);

    }

}