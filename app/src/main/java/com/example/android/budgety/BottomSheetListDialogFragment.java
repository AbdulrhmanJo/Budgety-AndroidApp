package com.example.android.budgety;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import java.util.Calendar;


public class BottomSheetListDialogFragment extends BottomSheetDialogFragment {

    int y,m,d;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_bottomsheet, container, false);
        final TextInputEditText textInputEditText = view.findViewById(R.id.date_box);

        final Calendar calendar = Calendar.getInstance();
        ChipGroup chipGroup = (ChipGroup) view.findViewById(R.id.chip_group);

        MaterialButton b = view.findViewById(R.id.hi);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(ChipGroup group, @IdRes int checkedId) {

                if(checkedId == R.id.add_date){


                y = calendar.get(Calendar.YEAR);
                m = calendar.get(Calendar.MONTH);
                d = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textInputEditText.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }, y, m, d);
                datePickerDialog.show();
                }

        }

        });
        return view;

    }


}
