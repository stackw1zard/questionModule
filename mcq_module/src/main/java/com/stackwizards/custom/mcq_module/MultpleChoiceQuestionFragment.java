package com.stackwizards.custom.mcq_module;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stackwizards.custom.jsonqeue.JsonObjectParser;
import com.stackwizards.custom.jsonqeue.ObjectHandler;
import com.stackwizards.custom.jsonqeue.UrlRequest;

import java.util.List;


public class MultpleChoiceQuestionFragment extends Fragment  {
    private static Ihandler handler;
    private static ObjectHandler cm;
    //
    private View view;
    ViewGroup insertPoint;
    static Context context;

    public static MultpleChoiceQuestionFragment newInstance( Context context, Ihandler ihandler){
        MultpleChoiceQuestionFragment fragment = new MultpleChoiceQuestionFragment();
        fragment.context = context;
        fragment.handler = ihandler;
        fragment.cm = new handler();
        return fragment;
    }

    static class handler implements ObjectHandler{

        @Override
        public <T> List<T> getObjectList(List<T> objs) {
            com.stackwizards.custom.mcq_module.MultpleChoiceQuestionFragment.handler.fhandle();
            return null;
        }
    }


//

    public MultpleChoiceQuestionFragment loadDataObjects(){


        UrlRequest request = new UrlRequest(context);

        JsonObjectParser parser = new JsonObjectParser(Question.class,cm);

        request.jsonParseURL("http://www.stackwizards.org/json/test5.json",parser);

        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_multiple_choice, container, false);

        insertPoint = view.findViewById(R.id.insert_point);

        insertPoint.removeAllViews();
        LayoutInflater inflater2 = getActivity().getLayoutInflater();
        View questionView = inflater2.inflate(R.layout.my_question, null);
        insertPoint.addView(questionView);


        return view;
    }


//    @Override
//    public <T> List<T> getObjectList(List<T> objs) {
//        List<Question> myTypes = (List<Question>) objs;
//        Log.i("ABC", myTypes.get(0).getQuestion_text());
//        handler.fhandle();
//        return null;
//    }
}