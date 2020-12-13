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

public class SignInActivity extends Fragment {

    private static final String USER_INDEX_KEY = "user_index";

    private TextInputEditText usernameInput;
    private TextInputEditText passwordInput;
    private MaterialButton loginBtn;

    private UserViewModel mViewModel;

    private SignInActivity(){}

    public static SignInActivity instance(int index) {
        SignInActivity instance = new SignInActivity();
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
        View parent = inflater.inflate(R.layout.sign_in_activity, container, false);
        usernameInput = parent.findViewById(R.id.userNameInput);
        passwordInput = parent.findViewById(R.id.passwordInput);
        loginBtn = parent.findViewById(R.id.logInButton);
        loginBtn.setOnClickListener((View.OnClickListener) this);
        return parent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this.getActivity()).get(UserViewModel.class);
        int userIndex = getArguments().getInt(USER_INDEX_KEY);
        User user = mViewModel.getUsers().getValue().get(userIndex);
        usernameInput.setText(user.getUsername());
        passwordInput.setText(user.getPassword());
    }

    //@Override
    public void onClick(View view){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        mViewModel.loginUser(username, password);
    }
}
