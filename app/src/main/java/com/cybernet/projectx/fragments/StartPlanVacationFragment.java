package com.cybernet.projectx.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.cybernet.projectx.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartPlanVacationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartPlanVacationFragment extends Fragment {

    private EditText startDate;
    private EditText endDate;
    private Button planButton;

    public static StartPlanVacationFragment newInstance() {
        StartPlanVacationFragment fragment = new StartPlanVacationFragment();
        return fragment;
    }

    public StartPlanVacationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_start_plan_vacation, container, false);
        startDate = (EditText) mainView.findViewById(R.id.start_date);
        endDate = (EditText) mainView.findViewById(R.id.end_date);

        startDate.setOnClickListener(new DatePickLustener(startDate));
        endDate.setOnClickListener(new DatePickLustener(endDate));

        planButton = (Button) mainView.findViewById(R.id.plan_button);
        planButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (endDate.getText().toString().equals("") || startDate.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Pick both start and end date", Toast.LENGTH_LONG).show();
                } else {
                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container, QuestionsFragment.newInstance())
                            .commit();
                }
            }
        });

        return mainView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class DatePickLustener implements View.OnClickListener {

        private final EditText parent;

        private DatePickLustener(EditText parent) {
            this.parent = parent;
        }

        @Override
        public void onClick(View v) {
            final Calendar c = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    parent.setText(monthOfYear + 1 + "/" + dayOfMonth + "/" + year);
                }
            }, c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));

            dialog.getDatePicker().setMinDate(c.get(c.DATE));

            dialog.show();

        }
    }
}
