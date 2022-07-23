//Manual and Acc
char t;
String content = "";
int intial=0;
#include <SoftwareSerial.h>
SoftwareSerial mySerial(8, 9); // RX | TX

int IN1 = 11;
int IN2 = 10;
int IN3 = 6;
int IN4 = 5;

float d1=100,ds=20;

int pulse; //from sinsor
float d=0;// distance in cm


//Function to get distance from snisor
float readUltrasonicDistance(int triggerPin, int echoPin)
{
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(20);
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(100);
  digitalWrite(triggerPin, LOW);
  pulse = pulseIn(echoPin, HIGH);
  return pulse / 29.387 / 2;;
}//end readUltrasonicDistance

void keepLimit(int s)
{
    analogWrite(IN2,s);//11
    analogWrite(IN4,s);//6
}//end of keepLimit


void reduce(int s)
{
    analogWrite(IN2,s/2);//11
    analogWrite(IN4,s/2);//6
}//end of keepLimit
  
void Stop()
{ 
    analogWrite(10, 0);
    analogWrite(11, 0);
    analogWrite(5, 0);
    analogWrite(6, 0);
    Serial.println("Stop()");
    delay(5000);
   // loop();
 
   //delay(2000);
}//end of stop

void setup() {
  

  Serial.println("setup");
  pinMode(3, INPUT);//Echo //3
  pinMode(2, OUTPUT);//trig //2
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);
  mySerial.begin(9600);
  Serial.begin(9600);
}
void loop() {

//Serial.println("loop");

 if (mySerial.available()){// print from phone
    t =mySerial.read();
    Serial.print(t);
    }
if(t == 'B'){            //move forward(all motors rotate in forward direction)
  analogWrite(IN1, 100);
  analogWrite(IN2, 0);
  analogWrite(IN3, 100);
  analogWrite(IN4, 0);}
   
else if(t == 'F'){      //move reverse (all motors rotate in reverse direction)
   analogWrite(IN1, 0);
  analogWrite(IN2, 100);
  analogWrite(IN3, 0);
  analogWrite(IN4, 100);}
  

else if(t == 'L'){      //turn right (left side motors rotate in forward direction, right side motors doesn't rotate)
  analogWrite(IN1, 0);
  analogWrite(IN2, 0);
  analogWrite(IN3, 0);
  analogWrite(IN4, 100);}

else if(t == 'R'){      //turn left (right side motors rotate in forward direction, left side motors doesn't rotate)
   analogWrite(IN1, 0);
  analogWrite(IN2, 100);
  analogWrite(IN3, 0);
  analogWrite(IN4, 0);}


else if(t == 'S'){      //STOP (all motors stop)
  analogWrite(IN1, 0);
  analogWrite(IN2, 0);
  analogWrite(IN3, 0);
  analogWrite(IN4, 0);
  }


  
else if(t=='A'){
   //delay(1000);
    // intial=100;
    if (mySerial.available()){// print from phone
    content=mySerial.readString();
    intial=content.toInt(); 
    Serial.println(intial);
    delay(1000);
    }
      
  while( t!='E'  ){
  if (mySerial.available()){// print from phone
    t =mySerial.read();
    Serial.print(t);
    }
   d = readUltrasonicDistance(2, 3);
   Serial.println(d);
    delay(200);
    
    if (d> d1){
    keepLimit(intial);}
    else  if (ds<d< d1){
    reduce(intial);
    }  
   if (d< ds) { 
   t='S';
   break;
  }
 }//end while
 Stop();
}
  
}//end void loop()

 



  
