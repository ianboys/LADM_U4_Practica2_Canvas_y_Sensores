package mx.tecnm.tepic.ladm_u4_practica2_canvas_y_sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var lienzo: Lienzo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        lienzo.fondo = Color.CYAN
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        //Sensor proximidad
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL)

        //Sensor acelerometro
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        when(event.sensor.type){
            Sensor.TYPE_ACCELEROMETER ->{
                if(event.values[2] < 0){
                    lienzo.posX = lienzo.posX-3
                }
                else{
                    lienzo.posX = lienzo.posX+3
                }
            }
            Sensor.TYPE_PROXIMITY -> {
                if (event.values[0] <= 1.5f) {
                    lienzo.fondo = Color.BLUE
                } else {
                    lienzo.fondo = Color.CYAN
                }
            }
        }
        lienzo.postInvalidate()
    }
}