/*package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class manual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
    }
}*/

package com.example.a;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button go_to_Manual;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_to_Manual=findViewById(R.id.go_to_Manual);

    }
    public void gomaual(View v){
        Intent intent=new Intent(MainActivity.this,Manual.class);
        startActivity( intent );
    }


    public void goAdas(View v){
        Intent intent=new Intent(MainActivity.this,adas.class);
        startActivity( intent );
    }
/*
    @SuppressLint("ClickableViewAccessibility")
    private void setw() throws IOException
    {
        t1=(TextView)findViewById(R.id.textView1);
        bluetooth_connect_device();

        go_to_Manual=(Button) findViewById(R.id.go_to_Manual);
        go_to_Manual.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send("M");}
            return true;}
        });
///////////////////

        go_to_ADAS=(Button) findViewById(R.id.ADAS);
        go_to_ADAS.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send("M");}
            return true;}
        });
    }

    @SuppressLint("MissingPermission")
    private void bluetooth_connect_device() throws IOException
    {
        try
        {
            myBluetooth = BluetoothAdapter.getDefaultAdapter();
            address = myBluetooth.getAddress();
            pairedDevices = myBluetooth.getBondedDevices();
            if (pairedDevices.size()>0)
            {
                for(BluetoothDevice bt : pairedDevices)
                {
                    address=bt.getAddress().toString();name = bt.getName().toString();
                    Toast.makeText(getApplicationContext(),"Connected", Toast.LENGTH_SHORT).show();

                }
            }

        }
        catch(Exception we){}
        myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
        BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
        btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
        btSocket.connect();
        try { t1.setText("Bluetooth Name: "+name+"\nBluetooth Address: "+address); }
        catch(Exception e){}
    }

    @Override
    public void onClick(View v)
    {
        try
        {

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    private void Send(String i)
    {
        try
        {
            if (btSocket!=null)
            {

                btSocket.getOutputStream().write(i.toString().getBytes());
            }

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        finally {

        }*/
    }


