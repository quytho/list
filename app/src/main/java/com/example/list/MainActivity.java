package com.example.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Facebook", "Zalo", "Instagram", "Youtube"};
    String mDescription[] = {"Facebook Description","Zalo Description","Instagram Description","Youtube Description"};
    int mImages[]={R.drawable.facebook, R.drawable.insta,R.drawable.facebook, R.drawable.insta,R.drawable.facebook};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        MyAdapter adapter= new MyAdapter(this, mTitle, mDescription, mImages);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position== 0){
                    Toast.makeText(MainActivity.this, "FaceBook Description", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Zalo Description", Toast.LENGTH_SHORT).show();
                }
                if(position== 0){
                    Toast.makeText(MainActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];
        MyAdapter(Context c, String title[], String description[],int images[]){
            super(c,R.layout.row,R.id.textView1, title);
            this.context = c;
            this.rTitle= title;
            this.rDescription=description;
            this.rImages=images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle =row.findViewById(R.id.textView1);
            TextView myDescription =row.findViewById(R.id.textView2);
            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
}