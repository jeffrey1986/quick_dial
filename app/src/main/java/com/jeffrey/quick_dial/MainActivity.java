package com.jeffrey.quick_dial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private GridView mContactGv;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init() {
        mContactGv = findViewById(R.id.gv_contact_list);

        // data
        List<ContactEntity> tmpList = new ArrayList<>();
        ContactEntity contact = new ContactEntity();
        contact.mImageId = R.drawable.guoping;
        contact.mPhoneNumber = "17781481315";
        tmpList.add(contact);

        contact = new ContactEntity();
        contact.mImageId = R.drawable.zhongling;
        contact.mPhoneNumber = "17380466819";
        tmpList.add(contact);

        contact = new ContactEntity();
        contact.mImageId = R.drawable.guoshoucheng;
        contact.mPhoneNumber = "17380466630";
        tmpList.add(contact);

        contact = new ContactEntity();
        contact.mImageId = R.drawable.guobing;
        contact.mPhoneNumber = "17711540427";
        tmpList.add(contact);

        mAdapter = new ContactAdapter(tmpList, this);
        mContactGv.setAdapter(mAdapter);
        mContactGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callContact(mAdapter.getItem(position));
            }
        });
        mContactGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                callContact(mAdapter.getItem(position));
                return true;
            }
        });

    }

    private void callContact(ContactEntity contact) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+contact.mPhoneNumber));
        startActivity(intent);
    }
}



