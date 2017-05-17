package com.han.cityconnection.CityPart.HeardNews.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.han.cityconnection.R;
import com.nineoldandroids.view.ViewHelper;

public class SlidingMenu extends HorizontalScrollView {

    // 屏幕宽度
    private int mScreenWidth;
    //菜单的右边距
    private int mMenuRightPadding;

    // 菜单的宽度
    private int mMenuWidth;
    //
    private int mHalfMenuWidth;

    //菜单打开的标识
    private boolean isOpen;
    //子菜单宽度初始化的标识
    private boolean once;
    //菜单布局
    private ViewGroup mMenu;
    //内容布局
    private ViewGroup mContent;

    //构造方法
    //调用第三个构造方法
    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //使用自定义属性  会调用这个方法
    public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //通过Windows 获取 屏幕的信息
        mScreenWidth = ScreenUtils.getScreenWidth(context);
        Log.d("ssssss", "mScreenWidth:屏幕的宽度" + mScreenWidth);
        //通过TypeArray获取自定义属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.SlidingMenu, defStyle, 0);
        int n = a.getIndexCount();
        Log.d("ssssss", "a:自定义属性的数量" + a);
        //通过遍历自定义属性找到我们需要的rightPadding的属性
        for (int i = 0; i < n; i++) {
            //attr是属性名
            int attr = a.getIndex(i);
            Log.d("SlidingMenu", "attr:属性名" + attr);
            switch (attr) {
                case R.styleable.SlidingMenu_rightPadding:
                    // 默认50

                    //如果没有设置右边距 则设置一个默认值 用TypedValue.ApplyDimension方法，将50dp值转换为像素值
                    //不同设备的density(密度)不同 ，dp和px的转换也不同 。 如果density为1.5，则1dp = 1.5px
                    mMenuRightPadding = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_DIP, 50f,
                                    getResources().getDisplayMetrics()));// 默认为10DP
                    break;
            }
        }
        a.recycle();//用完记得回收
    }

    public SlidingMenu(Context context) {
        this(context, null, 0);
    }

    /**
     * 系统在显示布局之前 要先为每个子View设置宽和高  然后在设置他们的显示位置
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * onMeasure 方法会被系统多次调用  再洗设置只调用一次初始化
         * 显示的设置一个宽度
         */
        if (!once) {
            //自定义View里的第一个View 还记我们用LinearLayout来嵌套他的布局吗？
            LinearLayout wrapper = (LinearLayout) getChildAt(0);
            //LinearLayout里的第一个View菜单
            mMenu = (ViewGroup) wrapper.getChildAt(0);
            //LinearLayout里的第二个View内容
            mContent = (ViewGroup) wrapper.getChildAt(1);
            //设置菜单的宽度=屏幕宽度-我们设置的右边距
            mMenuWidth = mScreenWidth - mMenuRightPadding;

            mHalfMenuWidth = mMenuWidth / 2;
            //菜单布局的宽度 等于菜单的宽度
            mMenu.getLayoutParams().width = mMenuWidth;
            //内容宽度 当然是整个屏幕的宽度
            mContent.getLayoutParams().width = mScreenWidth;

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    /**
     * 设置了子view的宽高后，自然就是它们自己选择在屏幕中的摆放位置啦
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //onLayout也会多点调用
        if (changed) {
            // 将菜单隐藏
            this.scrollTo(mMenuWidth, 0);
              /*
             * 滚动视图有一个固定的坐标系，这个坐标系的原点在一开始它显
             * 示到屏幕中的左上角的位置。原点往左是视图的负坐标，原点往右是视图的正坐标
             * 在这里一开始先显示的是菜单视图，所以菜单的左上角为这个滚动视图的原点，
             * 菜单和内容的边界 x坐标值=菜单的宽度
             * scrollTo(x,0)是把视图坐标系的(x,0)位置移动到屏幕左边界（见示意图）
             */
            once = true;
        }
    }

    /**
     * 通过判断手势实现 滑动多少距离才执行 打开/隐藏
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //得到手势的动作
        int action = ev.getAction();
        //进行循环判断
        switch (action) {

            // 松开（Up）时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏
            case MotionEvent.ACTION_UP:
                //当手指拖动后松开判断此时屏幕左边界位置所在的x坐标值  来 决定显示还是隐藏
                // getScrollX()就是此时屏幕左边界所在的视图的x坐标值，即getScrollX() == x
                int scrollX = getScrollX();
                Log.d("SlidingMenu", "scrollX:" + scrollX);
                // 左边界位置的x值大于菜单宽度的一半，即未显示的菜单宽度大于显示的菜单宽度，此时应该隐藏
                if (scrollX > mHalfMenuWidth) {
                    this.smoothScrollTo(mMenuWidth, 0);
                    isOpen = false;
                    // 左边界位置的x值小于菜单宽度的一半，即显示的菜单宽度大于未显示的菜单宽度，此时应该显示
                } else {
                    // 把视图原点（即菜单左上角）移动至屏幕原点（左上角）
                    this.smoothScrollTo(0, 0);
                    isOpen = true;
                }


                return true;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 打开菜单
     */
    public void openMenu() {
        if (isOpen)
            return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if (isOpen) {
            this.smoothScrollTo(mMenuWidth, 0);
            isOpen = false;
        }
    }

    /**
     * 点击按钮后会调用切换方法
     */
    public void toggle() {
        if (isOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float scale = l * 1.0f / mMenuWidth;
        float leftScale = 1 - 0.3f * scale;
        float rightScale = 0.8f + scale * 0.2f;

        ViewHelper.setScaleX(mMenu, leftScale);
        ViewHelper.setScaleY(mMenu, leftScale);
        ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(mMenu, mMenuWidth * scale * 0.7f);

        ViewHelper.setPivotX(mContent, 0);
        ViewHelper.setPivotY(mContent, mContent.getHeight() / 2);
        ViewHelper.setScaleX(mContent, rightScale);
        ViewHelper.setScaleY(mContent, rightScale);

    }

    int lastDownX;
    int lastDownY;
    boolean isMove;
    boolean isOpCl;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean downInter = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastDownX = x;
                lastDownY = y;
                downInter = false;
                if (x < 30 && y > 0) {
                    isOpCl = true;
                } else {
                    isOpCl = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int currentX = x - lastDownX;
                int currentY = y - lastDownY;
                if (isOpCl) {
                    if (Math.abs(currentX) > Math.abs(currentY)) {
                        downInter = true;
                    } else {
                        downInter = false;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                downInter = false;
                break;
        }
        return downInter;
    }
}
