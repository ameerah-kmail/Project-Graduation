package com.example.a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class acc  extends AppCompatActivity  implements OnClickListener {



    Button go_to_Manual; //
    Button Start_Acc,Stop_Acc,Display_speed,Send; //HIba
    TextView Speed,Speed2;//inputSpeed,DisplaySpeed
    TextView t1;
    String address = null , name=null;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);
        go_to_Manual=findViewById(R.id.go_to_Manual);
        Start_Acc=findViewById(R.id.start);
        Send=findViewById(R.id.send);
        Speed=findViewById(R.id.speed);
       // Speed2=findViewById(R.id.speed2);
        try {setw();} catch (Exception e) {}

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getSpeed=(Speed.getText().toString());
                //int getSpeed=Integer.parseInt(Speed.getText().toString());
                Speed2.setText(getSpeed);
            }});

    } //end onCreate

    public void back_adas(View v){
        Intent intent=new Intent(acc.this,adas.class);
        startActivity( intent );
    }


    public void acc_To_manual(View v){
        Intent intent=new Intent(acc.this,MainActivity.class);
        startActivity( intent );
    }


    @SuppressLint("ClickableViewAccessibility")
    private void setw() throws IOException
    {
        t1=(TextView)findViewById(R.id.textView1);
        bluetooth_connect_device();

        //////////////// hiba1
        Send= (Button) findViewById(R.id.send);
        Send.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send(Speed.getText().toString());}
            //Send(Speed.getText().toString());
            return true;}
        });

        Start_Acc= (Button) findViewById(R.id.start);
        Start_Acc.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send("A");}
            //Send(Speed.getText().toString());
            return true;}
        });

        //////////////// hiba2
        Stop_Acc= (Button) findViewById(R.id.stop);
        Stop_Acc.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send("E");}//"1"
            return true;}
        });
/*
        Display_speed= (Button) findViewById(R.id.display);
        Display_speed.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_UP){Send(Speed.getText().toString());}
            return true;}
        });*/




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

    }

}




