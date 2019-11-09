package com.example.android.budgety;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;


public class setting extends Fragment{


    public setting() {
        // Required empty public constructor
    }


    public static setting newInstance(String param1, String param2) {
        setting fragment = new setting();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        Button b = (Button) view.findViewById(R.id.SignOut_Button);


b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        logout(view);
    }
});




    /*
     MaterialCardView AccountCardButton =(MaterialCardView) view.findViewById(R.id.AccountButton_Setting);

     AccountCardButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

           swapFragment();
         }
     });
*/

        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

        return view;
    }


    private void swapFragment( Fragment newFragment){



        //fra newGamefragment = new GameSettingsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, newFragment);
        fragmentTransaction.addToBackStack("setting");
        fragmentTransaction.commit();
    }
    private void setSingleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            final MaterialCardView cardView = (MaterialCardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    if(finalI==0){
                        Information newFragment= new Information();
                        swapFragment(newFragment);
                       // System.out.println("Information");
                    }else if(finalI==1){
                      //  System.out.println("Notifecation");
                        notification newfragment =new notification();
                        swapFragment(newfragment);
                    }else if(finalI==2){
                        //System.out.println("Language");
                        Language newfragment =new Language();
                        swapFragment(newfragment);

                    }else if(finalI==3){
                        Account newFragment = new Account();
                        swapFragment(newFragment);
                       // System.out.println("Account");
                    }else if (finalI==4){
                     //   System.out.println("Currency");
                        Currency newFragment=new Currency();
                        swapFragment(newFragment);
                    }else if(finalI==5){
                       // System.out.println("Privacy");
                        Privacy newfragment =new Privacy();
                        swapFragment(newfragment);
                    }

                    cardView.setCardBackgroundColor(R.color.design_default_color_primary_dark);
                }
            });
        }
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        Signup m = new Signup();
       m.openSignIn();

    }

}
