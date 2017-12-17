package com.example.nanthakumar.hamburger.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nanthakumar.hamburger.R;
import com.example.nanthakumar.hamburger.utils.UserInfo;
import com.example.nanthakumar.hamburger.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ValueCallback mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginCicked(true);
                if (isValid()) {
                    onLoginCicked(true);
                } else {
                    Toast.makeText(getContext(), "enter proper credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
        view.findViewById(R.id.registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginCicked(false);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onLoginCicked(boolean state) {
        if (mListener != null) {
            mListener.onReceiveValue(state);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ValueCallback) {
            mListener = (ValueCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public boolean isValid() {
        if (null == Utils.mUserInfo) {
            return false;
        }
        EditText editText = null != getView() ? (EditText) getView().findViewById(R.id.loginname) : null;
        EditText password = null != getView() ? (EditText) getView().findViewById(R.id.loginpassword) : null;
        if (null != editText && null != password) {
            String name = editText.getText().toString();
            String pwd = password.getText().toString();
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd) && name.equals(Utils.mUserInfo.getmUserName()) && pwd.equals(Utils.mUserInfo.getmPassword())) {
                return true;
            }
        }
        return false;
    }
}
