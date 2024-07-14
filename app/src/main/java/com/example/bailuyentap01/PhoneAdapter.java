package com.example.bailuyentap01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>{
    private List<Phone> phoneList = null;

    private PhoneViewHolder.OnItemClick onItemClick;

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setOnItemClick(PhoneViewHolder.OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        holder.setData(phoneList.get(position));
        holder.itemView.setOnClickListener(view -> {
            onItemClick.clickItem(phoneList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return phoneList != null ? phoneList.size() : 0;
    }

    //tạo ra 1 viewholder để chứa dữ liệu
    static class PhoneViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPerson, imgPhone, imgMessage;
        private TextView tvName, tvPhoneNumber;
        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPerson = itemView.findViewById(R.id.imgPerson);
            imgPhone = itemView.findViewById(R.id.imgPhone);
            imgMessage = itemView.findViewById(R.id.imgMessage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);

        }

        public void setData(Phone phone){
            tvName.setText(phone.getName());
            tvPhoneNumber.setText(phone.getPhoneNumber());
            imgPerson.setImageResource(phone.getImgPerson());
            imgPhone.setImageResource(phone.getImgPhone());
            imgMessage.setImageResource(phone.getImgMessage());
        }

        interface OnItemClick{
            void clickItem(Phone phone);
        }
    }
}
