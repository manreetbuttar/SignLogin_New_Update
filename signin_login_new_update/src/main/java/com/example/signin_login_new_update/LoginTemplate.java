package com.example.signin_login_new_update;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mylibrary.ButtonModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LoginTemplate {
    static RelativeLayout mainLayout;
    static ImageView logo;
    static String[] editTexthint = {"email", "password", "confirm password"};
    static ArrayList<ButtonModel> temp = new ArrayList<>();
    static String[] buttonName = {"ok"};
    static String text, hint, password;
    static LinearLayout mainLayout_1;
    static ImageView logo_1;
    static CustomEditText edt;
    public static List<CustomEditText> allEds = new ArrayList<CustomEditText>();
    static CustomButton button;
    static RelativeLayout buttonLayout;
    static TextView forgot;
    static int count = 0;
    static ProgressBar progressBar;
    static  String btnName;
    static RelativeLayout.LayoutParams parms_button;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor")
    public static void addLayout(Context context, Boolean logo, ArrayList<EditTextModel> numOfEdittext, Boolean forgot, String buttonName, LinearLayout layout, int edittextcolor, int edit_background, String edit_font, int left, int top, int right, int bottom, int edittextsize,int button_left,int button_top,int button_right,int button_bottom) {
        if (layout != null) {
            if (logo == true) {
                logo_1 = new ImageView(context);
                logo_1.setImageResource(R.drawable.eten_logo);
                layout.addView(logo_1);

            }
            for (int i = 0; i < numOfEdittext.size(); i++) {
                try {
                    addEditText(context, numOfEdittext.get(i).getName(), layout);
                    change_editText(edittextcolor, edit_background, edit_font, numOfEdittext.get(i).getName(), edittextsize);
                    setMargin_Edittext(left, top, right, bottom);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            addforgot(forgot, context, "Forgot Password", layout);
            addButton(context, buttonName, layout, 100,button_left,button_top,button_right,button_bottom);
        }
    }

    public static void setLoader(Context context) {
        if(buttonLayout!=null) {
            progressBar = new ProgressBar(context);
            progressBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
            progressBar.setVisibility(View.GONE);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            buttonLayout.addView(progressBar, params);


        }

    }
    public static void change_Lodear_color(int color){
        if(progressBar!=null){
            progressBar.getIndeterminateDrawable().setColorFilter(0xFFFBA3AC, android.graphics.PorterDuff.Mode.MULTIPLY);
        }
    }
    public static void set_Loader(Context context,Boolean value){
        if(progressBar!=null) {
            if (value == true) {
                progressBar.setVisibility(View.VISIBLE);
                if(button!=null){
                button.setText("");}
            } else {
                progressBar.setVisibility(View.GONE);
                if(!btnName.equals(null)){
                    button.setText(btnName);
                }
            }
        }
    }
    public static void set_Logo_design(int logo_src, int height, int width, int topMargin) {
        if (logo_1 != null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            params.setMargins(0, topMargin, 0, 0);
            logo_1.setLayoutParams(params);
            logo_1.setImageResource(logo_src);
            logo_1.getLayoutParams().height = height;
            logo_1.getLayoutParams().width = width;

        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void addEditText(Context context, final String name, LinearLayout layout) throws NoSuchFieldException, IllegalAccessException {
        count++;
        edt = new CustomEditText(context);
        edt.setBackground(null);
        edt.setCursorVisible(true);
        //set cursor color
        Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
        f.setAccessible(true);
        f.set(edt, R.color.colorPrimaryDark);
        edt.setHint(name);
        layout.addView(edt);
        allEds.add(edt);
        if (count == 1) {
            ((LinearLayout.LayoutParams) edt.getLayoutParams()).setMargins(50, 100, 50, 0);
        } else {
            ((LinearLayout.LayoutParams) edt.getLayoutParams()).setMargins(50, 15, 50, 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void change_editText(int textColor, int button_background, String font_path, String password, int edittextsize) {
        if (edt != null) {
            edt.changedesign(textColor, button_background, font_path, edittextsize);
            edt.changeType(password);
        }
    }

    public static void setMargin_Edittext(int left, int top, int right, int bottom) {
        if (edt != null) {
            edt.set_Margin(left, top, right, bottom);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void change_button(int textColor, int button_background, String font_path, int textsize) {
        if (button != null) {
            buttonLayout.setBackgroundResource(button_background);
            button.changedesign(textColor, font_path, textsize);
            button.set_Height_width();
        }
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void addforgot(Boolean value, final Context context, final String name, LinearLayout linearLayout) {
        if (value == true) {
            forgot = new TextView(context);
            forgot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            forgot.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            linearLayout.addView(forgot);
            forgot.setText(name);
            forgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("DynamicPage");
                    intent.putExtra("BUTTON", name);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });
            ((LinearLayout.LayoutParams) forgot.getLayoutParams()).setMargins(50, 30, 50, 0);

        }
    }

    public static void setforgot_design(Context context, int textcolor, int textsize, String font) {
        if (forgot != null) {
            if (textcolor != 0) {
                forgot.setTextColor(context.getResources().getColor(textcolor));
                forgot.setTextSize(textsize);
                if (font != null) {
                    Typeface tf = Typeface.createFromAsset(context.getAssets(), font);
                    forgot.setTypeface(tf);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void addButton(final Context context, final String name, LinearLayout layout, int height,int left,int top,int right,int bottom) {
        buttonLayout = new RelativeLayout(context);
        parms_button= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        parms_button.setMargins(left, top, right, bottom);
        buttonLayout.setLayoutParams(parms_button);

        setLoader(context);
        button = new CustomButton(context);
        buttonLayout.addView(button);
        btnName=name;
        ((RelativeLayout.LayoutParams) button.getLayoutParams()).height = height;
        layout.addView(buttonLayout);
        //button.setOnClickListener(this);


        button.setText(name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //itemListener.Clicked(v,name);
                Intent intent = new Intent("DynamicPage");
                intent.putExtra("BUTTON", name);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void Background(Context context, Boolean value, ScrollView layout, int color, Drawable picture) {
        if (value == true) {
            if (layout != null) {
                if (picture != null) {

                    layout.setBackground(picture);

                } else {
                    if (color != 0) {
                        layout.setBackgroundColor(context.getResources().getColor(color));
                    }
                }
            }
        }
    }

}
