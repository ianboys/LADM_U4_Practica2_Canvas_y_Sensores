package mx.tecnm.tepic.ladm_u4_practica2_canvas_y_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo (p:MainActivity) : View(p){
    var ave = BitmapFactory.decodeResource(this.resources, R.drawable.ave_180)

    var posX = 300f
    var fondo = 0

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawColor(fondo)

        //Nube Izquierda
        p.color = Color.WHITE
        c.drawCircle(100f,675f,100f,p)
        c.drawCircle(300f,650f,100f,p)
        c.drawCircle(200f,700f,100f,p)
        c.drawCircle(110f,600f,100f,p)
        c.drawCircle(290f,600f,100f,p)
        c.drawCircle(200f,550f,100f,p)

        //Nube Derecha
        p.color = Color.WHITE
        c.drawCircle(600f,275f,100f,p)
        c.drawCircle(800f,250f,100f,p)
        c.drawCircle(700f,300f,100f,p)
        c.drawCircle(610f,200f,100f,p)
        c.drawCircle(790f,200f,100f,p)
        c.drawCircle(700f,150f,100f,p)

        //ave
        c.drawBitmap(ave,posX,1100f,p)
    }
}