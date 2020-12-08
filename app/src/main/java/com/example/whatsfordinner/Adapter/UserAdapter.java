/*package com.example.whatsfordinner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.model.User;

import java.util.ArrayList;
import java.util.List;

//import edu.ualr.roomdatabase.R;
//import edu.ualr.roomdatabase.db.entity.User;
//import edu.ualr.roomdatabase.ui.OnUserSelectedListener;

public class UserAdapter extends RecyclerView.Adapter {

    private List<User> mItems = new ArrayList<>();
    //private OnUserSelectedListener userSelectionListener;

    public void updateItems(List<User> users) {
        this.mItems = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = mItems.get(position);
        UserViewHolder vh = (UserViewHolder) holder;
        vh.firstNameTV.setText(user.getName());
        vh.lastNameTV.setText(user.getLastName());
        vh.streetTV.setText(user.getAddress().getStreet());
        vh.stateTV.setText(user.getAddress().getState());
        vh.cityTV.setText(user.getAddress().getCity());
        vh.postcodeTV.setText(String.valueOf(user.getAddress().getPostCode()));
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public void setUserDeletionListener(OnUserDeletedListener listener) {
        this.userDeletionListener = listener;
    }

    public void setUserSelectionListener(OnUserSelectedListener listener) {
        this.userSelectionListener = listener;
    }

    public interface OnUserDeletedListener {
        void onUserDeleted(User user);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout containerLyt;
        public TextView firstNameTV;
        public TextView lastNameTV;
        public TextView streetTV;
        public TextView stateTV;
        public TextView cityTV;
        public TextView postcodeTV;
        public ImageButton deleteBtn;

        public UserViewHolder(View v) {
            super(v);
            containerLyt = v.findViewById(R.id.container);
            containerLyt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userSelectionListener.onUserSelected(mItems.get(getAdapterPosition()), getAdapterPosition());
                }
            });
            firstNameTV = v.findViewById(R.id.first_name_tv);
            lastNameTV = v.findViewById(R.id.last_name_tv);
            streetTV = v.findViewById(R.id.street_tv);
            stateTV = v.findViewById(R.id.state_tv);
            cityTV = v.findViewById(R.id.city_tv);
            postcodeTV = v.findViewById(R.id.postcode_tv);
            deleteBtn = v.findViewById(R.id.user_delete_btn);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userDeletionListener.onUserDeleted(mItems.get(getAdapterPosition()));
                }
            });
        }
    }
}

 */