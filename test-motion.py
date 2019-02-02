
import pika
import grovepi
import time
import datetime


sensor_gate1 = 7
sensor_gate2 = 4


def send(date,message):
    credentials = pika.PlainCredentials('pi', 'raspberry')
    parameters = pika.ConnectionParameters('192.168.137.1',
                                           5672,
                                           '/',
                                           credentials)
    connection = pika.BlockingConnection(parameters)
    channel = connection.channel()
    channel.queue_declare(queue='hello')
    channel.basic_publish(exchange='',
                          routing_key='hello',
                          body=message)
    print(message)
    connection.close()


while True:
    try:
        i = 0
        j = 0

        if grovepi.digitalRead(sensor_gate1):
  #           print("motion detected sensor 1")
            send(datetime.datetime.now()," Sensor 1 detected a movement First")
            while (i < 30) :
                i += 1
                if grovepi.digitalRead(sensor_gate2):
                    send(datetime.datetime.now()," Sensor 2 detected a movement")
                    break
                if i == 29 :
                    send(datetime.datetime.now(),"rollBack")
                    break
                time.sleep(.1)


        elif  grovepi.digitalRead(sensor_gate2):
#             print("motion detected sensor2")
            send(datetime.datetime.now()," Sensor 2 detected a movement First")
            j = 0
            while (j <= 30):
                j += 1
                if grovepi.digitalRead(sensor_gate1):
                    send(datetime.datetime.now()," Sensor 1 detected a movement ")
                    break
                if j == 30 :
                    send(datetime.datetime.now(),"rollBack")
                    break
                time.sleep(.1)

        else :
            print("...")
       #       time.sleep(1)
        time.sleep(1)
    except IOError:
        print("Error")



