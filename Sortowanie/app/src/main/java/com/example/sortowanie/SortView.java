package com.example.sortowanie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SortView extends View {

    private int[] array;
    private int highlightIndex = -1;

    private Paint barPaint;
    private Paint highlightPaint;

    public SortView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        barPaint = new Paint();
        barPaint.setColor(Color.BLUE);
        highlightPaint = new Paint();
        highlightPaint.setColor(Color.RED);
    }

    public void setArray(int[] array) {
        this.array = array;
        invalidate();
    }

    public void setHighlightIndex(int index) {
        this.highlightIndex = index;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (array == null) {
            return;
        }

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) ((float) array[i] / 100 * height);
            int left = i * barWidth;
            int top = height - barHeight;
            int right = left + barWidth;
            int bottom = height;

            Paint paint = (i == highlightIndex) ? highlightPaint : barPaint;
            canvas.drawRect(left, top, right, bottom, paint);
        }
    }
}

