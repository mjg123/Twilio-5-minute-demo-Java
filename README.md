# Twilio-5-minute-demo-Java

Java code for a 5 minute demo of Twilio using Java. There is a class for responding to initial SMS, and a few choices for how to conclude the demo.

## Prep

![Remove before flight](https://www.aircraftspruce.eu/images/products_max_800x600/13-02818.jpg)

  - Open in IntelliJ:
    - `intro.png`
    - `incoming-sms-diagram-light.png`
    - `RespondToSMS`
    - the `part2` class you want to use
    - `thankyou.png`
  - Set font sizes in editor windows
  - Customise the `message` with the name of the event
  - Open the Twilio console in the browser, head to the "buy a number" page
    - Pre-purchase number if time is gonna be really tight
  - Start Two terminals:
    - `ngrok http -subdomain gilliard 4567`
    - another ready for `http` stuff

## Part 1

  - Show intro
  - Show https://raw.githubusercontent.com/mjg123/Twilio-5-minute-demo-Java/master/twilio-messaging-api.png
  - Purchase a phone number (pre-purchase saves about a 30s)
  - Show `RespondToSMS` class
  - Add the code for responding to SMS (handwritten XML this time)
  - Run & test from localhost
  - Ask people to send an SMS (any message), whoop when they get a reply
  - Remember not to do it yourself if you're using Raffle for pt2
  
## Part 2

  - Add the second callback to the `RespondToSMS` class
  - Switch to the `part2` class you chose
  - Build up the code (TwiML uses builders this time)
  - Using SparkJava again for the callbacks
  - Make sure `ngrok` is still running
  - Run the code
  - Done!
