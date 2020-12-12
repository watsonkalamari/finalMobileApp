package com.example.whatsfordinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.viewmodel.UserViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends Fragment {

    private static final String USER_INDEX_KEY = "user_index";

    private TextInputEditText emailAddressET;
    private TextInputEditText usernameET;
    private TextInputEditText passwordET;
    private MaterialButton signUpBtn;

    private UserViewModel mViewModel;

    private SignUpActivity(){}

    public static SignUpActivity instance(int index) {
        SignUpActivity instance = new SignUpActivity();
        Bundle arguments = instance.getArguments();
        if (arguments != null) {
            arguments.clear();
        } else {
            arguments = new Bundle();
        }
        arguments.putInt(USER_INDEX_KEY, index);
        instance.setArguments(arguments);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.sign_up_activity, container, false);
        emailAddressET = parent.findViewById(R.id.emailAddress);
        usernameET = parent.findViewById(R.id.userName);
        passwordET = parent.findViewById(R.id.password);
        signUpBtn = parent.findViewById(R.id.signUpButton);
        signUpBtn.setOnClickListener((View.OnClickListener) this);
        return parent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this.getActivity()).get(UserViewModel.class);
        int userIndex = getArguments().getInt(USER_INDEX_KEY);
        User user = mViewModel.getUsers().getValue().get(userIndex);
        emailAddressET.setText(user.getEmailAddress());
        usernameET.setText(user.getUsername());
        passwordET.setText(user.getPassword());
    }

    //@Override
    public void onClick(View view){
        String emailAddress = emailAddressET.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        int userIndex = getArguments().getInt(USER_INDEX_KEY);
        mViewModel.updateUser(emailAddress, username, password, userIndex);
    }
}
