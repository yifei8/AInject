package com.sjtu.yifei.ainject;

import android.util.Log;
import com.sjtu.yifei.annotation.IMethod;
import com.sjtu.yifei.annotation.InjectContract;

/**
 * 类描述：注入到该类
 * 创建人：yifei
 * 创建时间：2019/1/31
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class InjectToClass implements InjectContract {

    private static final String TAG = "InjectToClass";


    @IMethod
    public void startInject() {

    }

    @Override
    public void injectClass(String s) {
        Log.e(TAG, "injectClass:" + s);
    }
}
