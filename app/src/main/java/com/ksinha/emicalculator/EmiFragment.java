package com.ksinha.emicalculator;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class EmiFragment extends Fragment {
    private EditText ed_prin, ed_dura;
    private Spinner loan_type;
    private Button btn_calc;
    private TextView tv_emi, tv_roi;

    private final double[] ROI = {8.75, 7.5, 10.25, 14.5};

    public EmiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emi, container, false);

        ed_prin = view.findViewById(R.id.ed_prin);
        ed_dura = view.findViewById(R.id.ed_dura);
        tv_roi = view.findViewById(R.id.tv_roi);
        tv_emi = view.findViewById(R.id.tv_emi);
        loan_type = view.findViewById(R.id.loan_type);
        btn_calc = view.findViewById(R.id.btn_calc);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.loan_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loan_type.setAdapter(adapter);

        loan_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getContext(), item,Toast.LENGTH_SHORT).show();
                tv_roi.setText(String.valueOf(ROI[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double p = 0.0, r = 0.0, emi;
                int d = 0;

                try {
                    p = Double.parseDouble(String.valueOf(ed_prin.getText()));
                    r = Double.parseDouble(String.valueOf(tv_roi.getText()));
                    d = Integer.parseInt(String.valueOf(ed_dura.getText()));
                } catch (Exception e) {

                }

                emi = (p + p * d/12 * r/100)/d;
                DecimalFormat df = new DecimalFormat("#.##");
                tv_emi.setText(df.format(emi));
                Toast.makeText(getContext(), df.format(emi),Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}