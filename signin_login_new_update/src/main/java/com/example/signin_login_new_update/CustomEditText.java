package com.example.signin_login_new_update;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    Paint textPaint;

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);

    }

    private void parseAttributes(Context context, AttributeSet attrs) {

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public  void changedesign(int textcolor, int background_shape,String font_path,int edittextsize) {
        //set text color
        setTextColor(getResources().getColor(textcolor));
        //set background
        setBackgroundResource(background_shape);
        //set text in single line
        setSingleLine(true);
        //set font
        if(font_path!=null) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), font_path);
            setTypeface(tf);
        }
        setTextSize(edittextsize);
    }
    public void changeType(String name){
        if(name.equals("password")||name.equals("confirm password"))
        {
            setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
    }
    public void set_Margin(int left,int top,int right,int bottom){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(left,top,right,bottom);
        setLayoutParams(params);
    }

}