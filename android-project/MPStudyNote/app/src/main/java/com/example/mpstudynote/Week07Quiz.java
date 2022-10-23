package com.example.mpstudynote;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// 풀이
//public class Week07Quiz extends AppCompatActivity {
//    ListView list;
//    EditText edt;
//    List<String> ls;
//    ArrayAdapter<String> arradapter;
//    int posi;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.week07_quiz);
//
//        list = findViewById(R.id.list_item);
//        edt = findViewById(R.id.edittext);
//        ls = new ArrayList<>();
//
//        arradapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, ls);
//        list.setAdapter(arradapter);
//        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        list.setOnItemClickListener((adview, view, position, id) -> posi = position);
//    }
//
//    public void onClick(View v) {
//        if (v.getId() == R.id.addbtn) {
//            String txt = edt.getText().toString();
//            if (txt.length() != 0) {
//                ls.add(txt);
//            }
//        } else if (v.getId() == R.id.delbtn) {
//            if (posi != ListView.INVALID_POSITION) {
//                ls.remove(posi);
//                list.clearChoices();
//            }
//        }
//        edt.setText("");
//        posi = ListView.INVALID_POSITION;
//        arradapter.notifyDataSetChanged();
//    }
//}

// 제출 답안 수정 시도
// 자바는 참조 전달이 안 됨. 특정 값을 어딘가에 전달하고 편집하려면 전역변수를 만들어야 함.
public class Week07Quiz extends AppCompatActivity {
    private ArrayList<String> arrlist;
    private ArrayAdapter<String> adapter;
    private EditText edit;
    private ListView listv;
    int posi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week07_quiz);

        listv = findViewById(R.id.list_item);
        edit = findViewById(R.id.edittext);
        arrlist = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arrlist);
        listv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener((adapterView, view, position, id) -> posi = position );
    }

    public void onClick(View v) {
        if (v.getId() == R.id.addbtn) {
            String txt = edit.getText().toString();
            if (txt.length() != 0) {
                arrlist.add(txt);
            }
        } else if (v.getId() == R.id.delbtn) {
            if (posi != ListView.INVALID_POSITION) {
                arrlist.remove(posi);
                listv.clearChoices();
            }
        }
        edit.setText("");
        posi = ListView.INVALID_POSITION;
        adapter.notifyDataSetChanged();
    }
}