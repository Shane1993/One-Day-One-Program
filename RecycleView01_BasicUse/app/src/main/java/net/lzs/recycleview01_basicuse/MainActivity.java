package net.lzs.recycleview01_basicuse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView rv;
    private MyAdapter adapter;
    private List<CellData> lists ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
//        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,2));
        lists = new ArrayList<CellData>();

        for (int i = 0; i<6;i++)
        {
            lists.add(new CellData("" + i,"this is " + i));
        }

        adapter = new MyAdapter(lists);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("This is MainActivity : " + position);
            }
        });

        rv.setAdapter(adapter);

    }

}
