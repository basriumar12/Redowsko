package com.android.redowsko.anim;

import android.content.Context;
import android.util.AttributeSet;

import com.airbnb.lottie.LottieAnimationView;
import com.android.redowsko.utils.Utils;

/**
 * Created by User on 26/05/2018.
 */

public class ALoadingView extends LottieAnimationView {
    public ALoadingView(Context context) {
        super(context);

    }

    public ALoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ALoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initAnimation();

    }

    private void initAnimation() {

        int size = (int) Utils.getInstance().convertDpToPixel(144);
        setMaxWidth(size);
        setMaxHeight(size);

        if (getLayoutParams() != null) {
            getLayoutParams().width = size;
            getLayoutParams().height = size;
        }
        setAnimation("animation/triangle_loading.json");
        loop(true);
        playAnimation();
    }

}

