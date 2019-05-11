package com.stackwizards.custom.mcq_module;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stackwizards.custom.jsonqeue.JsonObjectParser;
import com.stackwizards.custom.jsonqeue.ObjectHandler;
import com.stackwizards.custom.jsonqeue.UrlRequest;

import java.util.Collections;
import java.util.List;


public class MultpleChoiceQuestionFragment extends Fragment {
    private static Ihandler handler;
    private static ObjectHandler cm;
    static LayoutInflater inflater2;
    private static View view;
    static ViewGroup insertPoint;
    static Context context;
    static List<Question> myTypes;
    int questionIndex = 0;
    ImageView next;

    public static MultpleChoiceQuestionFragment newInstance(Context context, Ihandler ihandler) {
        MultpleChoiceQuestionFragment fragment = new MultpleChoiceQuestionFragment();
        fragment.context = context;
        fragment.handler = ihandler;
        fragment.cm = new handler();
        return fragment;
    }

    static class handler implements ObjectHandler {

        @Override
        public <T> List<T> getObjectList(List<T> objs) {
            myTypes = (List<Question>) objs;
            Collections.shuffle(myTypes);
            com.stackwizards.custom.mcq_module.MultpleChoiceQuestionFragment.handler.fhandle();
            return null;
        }
    }



    public void loadDataObjects() {

        UrlRequest request = new UrlRequest(context);

        JsonObjectParser parser = new JsonObjectParser(Question.class, cm);

        request.jsonParseURL("http://www.stackwizards.org/json/test5.json", parser);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_multiple_choice, container, false);

        insertPoint = view.findViewById(R.id.insert_point);
//        inflater2 = getActivity().getLayoutInflater();
//        insertPoint.removeAllViews();
//        LayoutInflater inflater2 = getActivity().getLayoutInflater();
//        View questionView = inflater2.inflate(R.layout.my_question, null);
//        insertPoint.addView(questionView);

        next =  view.findViewById(R.id.next_question);

                next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater2 = getActivity().getLayoutInflater();
                insertPoint.removeAllViews();
                final Question question = myTypes.get(questionIndex);

                String txt = question.getQuestion_text();
                txt = txt.substring(txt.indexOf(')') + 1);

                ((TextView) view.findViewById(R.id.question_text)).setText(txt );


                Collections.shuffle(question.getAnswer_options());

                for(final String ans : question.getAnswer_options()){
                    View questionView2 = inflater2.inflate(R.layout.my_question, null);
                    final Button ansBtn = ((Button) questionView2.findViewById(R.id.textViewQuestion));

                    String trimAnswer = question.getAnswer().replace("Ans:", "").trim();
                    if (trimAnswer.length() == 1 && ans.substring(0, 3).contains(trimAnswer)) {
                        question.setAnswer(ans);
                    }


                    ansBtn.setText(ans.substring(2));
                    insertPoint.addView(questionView2);

                    ansBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(question.getAnswer().equals(ans)) {
                                Log.i("QQ", "XXX " + ans);
                                ansBtn.setBackgroundColor(0xFFA4C639);
                                next.setVisibility(View.VISIBLE);
                            } else {
                                Log.i("QQ", "ZZZZ " + ans + " --- " + question.getAnswer());
                                ansBtn.setOnClickListener(null);
                                ansBtn.setBackgroundColor(0xF0FFE666);
                            }

                        }
                    });
                }

                if(questionIndex < myTypes.size()-1)
                     questionIndex++;

                next.setVisibility(View.GONE);
//                for (Question q : myTypes) {
//                    View questionView2 = inflater2.inflate(R.layout.my_question, null);
//                    ((TextView)questionView2.findViewById(R.id.textViewQuestion)).setText(q.getQuestion_text());
//                    insertPoint.addView(questionView2);
//                }
            }
        });
        return view;
    }


}