package com.jenkins.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_test);
    setContentView(new MyView(this));
  }

  class MyView extends View {
    Paint paint;


    public MyView(Context context) {
      super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      paint = new Paint();
      paint.setColor(Color.RED);
      paint.setAntiAlias(true);
      paint.setStyle(Paint.Style.FILL);
      paint.setTextSize(48);
      String text = "你好吗";
      int x = 110;
      int y = 110;
      paint.setTextAlign(Paint.Align.LEFT);
      canvas.drawText(text, x, y, paint);

      int ascent, descent, top, bottom;
      Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
      ascent = fontMetricsInt.ascent;
      descent = fontMetricsInt.descent;
      top = fontMetricsInt.top;
      bottom = fontMetricsInt.bottom;
      Rect rect = new Rect();
      paint.getTextBounds(text, 0, text.length(), rect);

      RectF f = new RectF();
      int padding = 10;
      f.left = x - padding;
      f.right = x + rect.width() + padding;
      f.top = y +padding/2;
      f.bottom = y - rect.height() -padding;
      paint.setStyle(Paint.Style.STROKE);
      paint.setStrokeWidth(5);
      canvas.drawRoundRect(f, 10, 10, paint);

      RectF rectF = new RectF();
      rectF.bottom = 500;
      rectF.top = 300;
      rectF.left = 200;
      rectF.right = 400;
      paint.setStyle(Paint.Style.STROKE);
      paint.setStrokeWidth(10);
      canvas.drawRoundRect(rectF, 10, 40, paint);

      rect = new Rect(200, 500, 400, 800);
      paint.setStrokeWidth(1);
      paint.setColor(Color.BLUE);
      paint.setStyle(Paint.Style.STROKE);
      canvas.drawRect(rect, paint);

      Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
     //Bitmap bitmap =  BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
      Bitmap bitmap = drawableToBitmap(drawable);
     canvas.drawBitmap(bitmap,500,500,null);
    }
  }

  public static Bitmap drawableToBitmap(Drawable drawable){
    Bitmap bitmap = null;
    int width = drawable.getIntrinsicWidth();
    int height = drawable.getIntrinsicHeight();
    // 取 drawable 的颜色格式
    Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
            : Bitmap.Config.RGB_565;
    bitmap = Bitmap.createBitmap(width,height, config);
    Canvas canvas = new Canvas(bitmap);
    drawable.setBounds(0,0,width,height);
    drawable.draw(canvas);
    return bitmap;
  }
}
