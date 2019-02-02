# SmartRoom
Smart Room
# Smart room is a an IOT project and the Objective is to control the weather of the room automatically according to the weather and the number of people in the room.
I used two motion sensors in an orthogonal way at the door of the room to sense if the people are coming in or out and according to the humidity and temperature of the room created a plan to handle the weather of the room by controlling the ventilation system and the Air conditioner. The plan can be edited to control the heater as well but the project was done in summer.
# The used devices are: RaspberryPi , groovePi with two motion sensors and humidity, temperature sensor, plugwise.
# The backend has been done with Spring boot.
# Frontend has been done with python on the raspberryPi
RabbitMq has been used with two queues to synchronise the messages between the backend and the frontend
