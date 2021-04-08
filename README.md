# Hotel Booking System API

## Project Description

The Hotel Booking System API, allows the user to add his/her personal information (including the payment info).
Also allowed to them to search by hotel location, by date, and by room category.
Then the user can book his/her room for 1 or several days.
The booking process must be approved by the 'Payment Service API' (which imaginary connected to a credit card company).
Finally, the system will send an email to notify the hotel and the user.

## Technologies Used

 * Java 8
 * PostgreSql 11
 * Spring Framework version 5.2.7
 * JMS Queues
 * JMS Topic
 * REST
 * SOAP
 * JTA
 * JDBC
 * Log4j
 * Apache CFX
 * Tomcat 8.5

## Features

* User can register new account and add payment information
* User can book a room for 1 or several days
* Booking API will check available rooms for a specific hotel on a specific date
* PaymentService will send confirmation about the user payment info (valid or not)
* Sending an email to the user (just a console message for now. But Its ready to send an email using Gmail SMTP)

## TODO List

* Add functionality to send email notifiaction to the hotel
* Continue adding Junit testing to the whole project
* Continue adding logging to the whole project

## Getting Started

git clone https://github.com/2102Mule-Nick/iyad_shobaki_p1.git

