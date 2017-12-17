package com.example.nanthakumar.hamburger.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nanthakumar.hamburger.activity.MainActivity;
import com.example.nanthakumar.hamburger.R;
import com.example.nanthakumar.hamburger.utils.UserInfo;
import com.example.nanthakumar.hamburger.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    Toast.makeText(getContext(), "success", Toast.LENGTH_LONG).show();
                    if(getActivity() instanceof MainActivity){
                        ((MainActivity)getActivity()).removeFragment(RegisterFragment.this);
                    }
                }
            }
        });
        return view;
    }

    public boolean isValid() {
        EditText editText = null != getView() ? (EditText) getView().findViewById(R.id.name) : null;
        EditText password = null != getView() ? (EditText) getView().findViewById(R.id.password) : null;
        if (null != editText && null != password) {
            String name = editText.getText().toString();
            String pwd = password.getText().toString();
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                Utils.setUserInfo(new UserInfo(name, pwd));
            } else {
                Utils.setUserInfo(null);
            }
            return true;
        }
        return false;
    }
}
