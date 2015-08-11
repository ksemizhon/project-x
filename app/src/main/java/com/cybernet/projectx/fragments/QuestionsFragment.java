package com.cybernet.projectx.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cybernet.projectx.R;
import com.cybernet.projectx.adapters.QuestionsListAdapter;

public class QuestionsFragment extends Fragment {

    private RecyclerView questionsList;
    private RecyclerView.Adapter questionsAdapter;
    private RecyclerView.LayoutManager questionsListLayoutManager;
    private Button nextButton;
    private int currentPhase = 0;
    private int finalPhase = 1;

    public static QuestionsFragment newInstance() {
        QuestionsFragment fragment = new QuestionsFragment();
        return fragment;
    }

    public QuestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_questions, container, false);
        questionsList = (RecyclerView) mainView.findViewById(R.id.questions_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        questionsList.setHasFixedSize(true);

        // use a linear layout manager
        questionsListLayoutManager = new LinearLayoutManager(this.getActivity());
        questionsList.setLayoutManager(questionsListLayoutManager);

        // specify an adapter (see also next example)
        questionsAdapter = new QuestionsListAdapter(getResources().getStringArray(R.array.phase_one_questions));
        questionsList.setAdapter(questionsAdapter);

        nextButton = (Button) mainView.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPhase < finalPhase) {
                    questionsAdapter = new QuestionsListAdapter(getResources().getStringArray(R.array.phase_two_questions));
                    questionsList.setAdapter(questionsAdapter);
                    currentPhase++;
                    if(currentPhase==finalPhase){
                        nextButton.setText("GO");
                    }
                } else {
                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container, VacationPlanFragment.newInstance())
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
}
