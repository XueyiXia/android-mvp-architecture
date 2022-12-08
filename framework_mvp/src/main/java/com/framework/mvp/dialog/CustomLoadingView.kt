package com.framework.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.framework.R;


/**
 * @author xiaxueyi
 * @date: 2021-10-23
 * @time: 17-10
 * @说明: 共同的加载框
 */
public class CustomLoadingView extends RelativeLayout {

    private ProgressBar mProgressBar;   //进度条

    private Context mContext;

    private RelativeLayout rlProgressBar;   //进度布局

    private LinearLayout loading_expression;//异常布局

    private TextView loading_express_msg;//异常布局提示

    private boolean isShowing=false;    //加载框是否显示

    /**
     * this表示当前的，不能使用super
     * @param context
     */
    public CustomLoadingView(Context context) {
        this(context, null);
    }

    public CustomLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public CustomLoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext=context;
        initWidget();
    }


    /**
     * 初始化组件
     */
    private void initWidget(){
        View view= LayoutInflater.from(mContext).inflate( R.layout.custom_loading_view, this, true);
        mProgressBar=(ProgressBar)view.findViewById( R.id.progressbar);
        rlProgressBar=(RelativeLayout)view.findViewById( R.id.rlProgressDialog);
        loading_expression= (LinearLayout) view.findViewById( R.id.loading_expression);
        loading_express_msg= (TextView) view.findViewById( R.id.loading_express_msg);
    }

    /**
     * 设置异常提示
     * @param errorText
     */
    public void setErrorText(String errorText, OnClickListener onClick){
        if (rlProgressBar.getVisibility()== View.VISIBLE){
            rlProgressBar.setVisibility(GONE);
        }
        isShowing=false;
        loading_expression.setVisibility(VISIBLE);
        if (onClick!=null){
            loading_expression.setOnClickListener(onClick);
        }
        loading_express_msg.setText(errorText);
    }

    /**
     * 加载框显示
     */
    public void show(){
        if(!isShowing){
            mProgressBar.setVisibility( View.VISIBLE);
            rlProgressBar.setVisibility( View.VISIBLE);
            if (loading_expression.getVisibility()== View.VISIBLE){
                loading_expression.setVisibility(GONE);
            }
            isShowing=true;
        }
    }

    public void show(int resId){
        if(!isShowing&&resId!=-1){
            mProgressBar.setVisibility( View.VISIBLE);
            rlProgressBar.setVisibility( View.VISIBLE);
            rlProgressBar.setBackgroundResource(resId);
            if (loading_expression.getVisibility()== View.VISIBLE){
                loading_expression.setVisibility(GONE);
            }
            isShowing=true;
        }
    }

    /**
     * 加载框是否显示
     * @return
     */
    public boolean isShowing(){
        return isShowing;
    }

    /**
     *关闭加载框
     */
    public void dismiss(){
        isShowing=false;
        this.setVisibility( View.GONE);
    }
}
