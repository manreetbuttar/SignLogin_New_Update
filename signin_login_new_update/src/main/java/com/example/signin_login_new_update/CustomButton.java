package com.example.signin_login_new_update;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomButton extends android.support.v7.widget.AppCompatButton {

    private boolean isRed = true;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void changedesign(int textcolor,String font_path,int textsize) {
        //set text alignment
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
        //set text color
        if(textcolor!=0) {
            setTextColor(getResources().getColor(textcolor));
        }
        setAllCaps(false);
        //set background

        setBackgroundDrawable(null);

        setTextSize(textsize);
        //set font
        if(font_path!=null) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), font_path);
            setTypeface(tf);
        }
    }
    public void set_Height_width(){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
    }

}