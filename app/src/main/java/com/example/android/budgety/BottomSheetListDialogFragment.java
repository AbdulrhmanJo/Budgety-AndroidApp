package com.example.android.budgety;

import android.app.DatePickerDialog;
import android.icu.text.DateFormat;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BottomSheetListDialogFragment extends BottomSheetDialogFragment {

    int y, m, d;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottomsheet, container, false);
        final TextInputEditText textInputEditText = view.findViewById(R.id.date_holder);
        final Spinner TransSpinner = view.findViewById(R.id.TransactionSpinner);
        final Calendar calendar = Calendar.getInstance();
        final ChipGroup TranschipGroup = (ChipGroup) view.findViewById(R.id.TransChip_group);

        //make the list of category depend on Transaction method
        TranschipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                String[] list;
                ArrayAdapter<String> spinnerArrayAdapter;
                if (TranschipGroup.getCheckedChipId() == R.id.income) {
                    list = getResources().getStringArray(R.array.incom);
                } else if (TranschipGroup.getCheckedChipId() == R.id.expenses) {
                    list = getResources().getStringArray(R.array.expenses);
                } else {
                    ArrayList<Budget> budgets = MainActivity.account.getBudgets();
                    list = new String[budgets.size()];
                    for (int i = 0; i < list.length; i++) {
                        list[i] = budgets.get(i).getbName();
                    }
                }
                spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item
                        , list);
                TransSpinner.setAdapter(spinnerArrayAdapter);
            }
        });


        final TextView decsText = view.findViewById(R.id.desc_holder);
        final TextView amountText = view.findViewById(R.id.amount_holder);
        final ChipGroup DatechipGroup = (ChipGroup) view.findViewById(R.id.Datechip_group);
        final TextView dateText = view.findViewById(R.id.date_holder);
        final MaterialButton b = view.findViewById(R.id.hi);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Trans_chip_id = TranschipGroup.getCheckedChipId();
                String category = TransSpinner.getSelectedItem().toString();
                String decs = decsText.getText().toString();
                double amount = Double.parseDouble(amountText.getText().toString());
                int Date_chip_id = DatechipGroup.getCheckedChipId();
                Date date = null;
                if (Date_chip_id == R.id.today) {
                    date = new Date();
                } else if (Date_chip_id == R.id.yasterday) {
                    date = new Date();
                } else {
                    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        date = formatter1.parse(dateText.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                FragmentManager fm = getFragmentManager();
                MainActivity.account.makeTransaction(Trans_chip_id, amount, category, decs, date);
                dismiss();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,
                        new home()).commit();

            }
        });

        DatechipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(ChipGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.date) {
                    y = calendar.get(Calendar.YEAR);
                    m = calendar.get(Calendar.MONTH);
                    d = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textInputEditText.setText(dayOfMonth + "/" + month + "/" + year);
                        }
                    }, y, m, d);
                    datePickerDialog.show();
                }
            }

        });
        return view;

    }



}
