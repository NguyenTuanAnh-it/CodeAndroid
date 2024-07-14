package com.example.bailuyentap01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Phone> phoneList = createPhoneList();

    AppCompatButton btnThem, btnSua, btnXoa;
    EditText edtName, edtPhoneNumber;

    RecyclerView rcvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        edtName = findViewById(R.id.edtHoten);
        edtPhoneNumber = findViewById(R.id.edtSdt);
        rcvData = findViewById(R.id.rcvData);

        PhoneAdapter adapter = new PhoneAdapter(phoneList);
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapter);
        adapter.setOnItemClick(phone -> {
            edtName.setText(phone.getName());
            edtPhoneNumber.setText(phone.getPhoneNumber());
        });

        btnThem.setOnClickListener(view -> {
            String name = edtName.getText().toString().trim();
            String sdt = edtPhoneNumber.getText().toString().trim();
            phoneList.add(phoneList.size(), new Phone(name, sdt,  R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
            adapter.notifyItemChanged(phoneList.size());
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = edtName.getText().toString().trim();
                String newPhoneNumber = edtPhoneNumber.getText().toString().trim();
                for (Phone phone : phoneList){
                    if (phone.getName().equals(newName) || phone.getPhoneNumber().equals(newPhoneNumber)){
                        phone.setName(newName);
                        phone.setPhoneNumber(newPhoneNumber);
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnXoa.setOnClickListener(view -> {
            String newName = edtName.getText().toString().trim();
            String newPhoneNumber = edtPhoneNumber.getText().toString().trim();
            for (Phone phone : phoneList){
                if (phone.getName().equals(newName) && phone.getPhoneNumber().equals(newPhoneNumber)){
                    phoneList.remove(phone);
                    break;
                }
            }
            adapter.notifyDataSetChanged();
            edtName.setText("");
            edtPhoneNumber.setText("");
        });


    }

    private List<Phone> createPhoneList(){
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone("Nguyễn Tuấn Anh", "0981430602", R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
        phoneList.add(new Phone("Đặng Hà Phương", "0866137128", R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
        phoneList.add(new Phone("Đỗ Quốc Khánh", "0876784536", R.drawable.ic_khanh, R.drawable.ic_phone, R.drawable.ic_message));
        phoneList.add(new Phone("Nguyễn Thị Chúc An", "0987647587", R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
        phoneList.add(new Phone("Nguyễn Thanh Hoa", "0356478765", R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
        phoneList.add(new Phone("Lục Chí Cam", "0567489387", R.drawable.ic_person, R.drawable.ic_phone, R.drawable.ic_message));
        return phoneList;
    }
}