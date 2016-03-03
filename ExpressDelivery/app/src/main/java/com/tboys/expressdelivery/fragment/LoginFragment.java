package com.tboys.expressdelivery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.tboys.expressdelivery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText editText_phone;
    EditText editText_password;
    CheckBox checkBox;
    Button button_login;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editText_phone = (EditText) view.findViewById(R.id.editText_phone);
        editText_password = (EditText) view.findViewById(R.id.editText_psd);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        button_login = (Button) view.findViewById(R.id.button_login);
        String phoneNum = editText_phone.getText().toString();
        String pwd = editText_password.getText().toString();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) {
                    editText_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    editText_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
