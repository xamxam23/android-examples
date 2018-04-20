package com.example.maximembabele.test_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class MyGraph extends View {
    Paint paint = new Paint();
    Point[] data;
    Context context;
    Random rand = new Random();

    public MyGraph(Context context) {
        super(context);
        setup(context);
    }

    public MyGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public MyGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    void setup(Context context) {
        this.context = context;
        // create test data
        data = new Point[61];
        for (int i = 0, x = 8; i < data.length; i++, x += 20) {
            data[i] = new Point(x, 200 + rand.nextInt(200));
        }
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setStrokeWidth(4);
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);

        int base = 2 * getMeasuredHeight() / 3;
        Point a = new Point(data[0].x, base);
        path.moveTo(a.x, a.y);
        for (int i = 0; i < data.length; i++) {
            a = new Point(data[i].x, base - data[i].y);
            path.lineTo(a.x, a.y);
        }
        a = new Point(data[data.length - 1].x, base);
        path.lineTo(a.x, a.y);
        path.close();
        canvas.drawPath(path, paint);

        paint.setStrokeWidth(4);
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i + 1 < data.length; i++) {
            a = new Point(data[i].x, base - data[i].y);
            canvas.drawLine(data[i].x, base - data[i].y, data[i + 1].x, base - data[i + 1].y, paint);
        }
    }
}
