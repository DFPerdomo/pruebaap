package com.example.pruebaap;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class NmListItemView extends AppCompatTextView {

    public NmListItemView(Context context, AttributeSet ats, int ds) {
        super(context, ats, ds);
        init();
    }

    public NmListItemView(Context context) {
        super(context);
        init();
    }

    public NmListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
    }

}