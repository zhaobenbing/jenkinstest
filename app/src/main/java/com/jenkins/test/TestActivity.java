package com.jenkins.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.jenkins.test.base.BaseActivity;
import com.jenkins.test.base.MethodAn;
import com.jenkins.test.base.UI;

@UI(value = R.layout.activity_test, text = "hello world!")
public class TestActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_test);
     setContentView(new MyView(this));
    test();

  }

  @MethodAn(name = "hello world")
  public void test() {

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
      f.top = y + padding / 2;
      f.bottom = y - rect.height() - padding;
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

      canvas.save();
      canvas.clipRect(100,100,1000,1000);
      Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
      // Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
      canvas.rotate(40);
      canvas.scale(0.25f,0.25f);
      Bitmap bitmap = drawableToBitmap(drawable);
      canvas.drawBitmap(bitmap, 1000, 400,paint);
      canvas.restore();
    }
  }

  public static Bitmap drawableToBitmap(Drawable drawable) {
    Bitmap bitmap = null;
    int width = drawable.getIntrinsicWidth();
    int height = drawable.getIntrinsicHeight();
    // 取 drawable 的颜色格式
    Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE
        ? Bitmap.Config.ARGB_8888
        : Bitmap.Config.RGB_565;
    bitmap = Bitmap.createBitmap(width, height, config);
    Canvas canvas = new Canvas(bitmap);
    drawable.setBounds(0, 0, width, height);
    drawable.draw(canvas);
    return bitmap;
  }
}
