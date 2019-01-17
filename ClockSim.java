public class ClockSim {

  public static double getAngle(double totalSeconds){
    int hours = (int) totalSeconds / 3600;
    double remaining = totalSeconds % 3600;
    double minutes = remaining / 60;
    double seconds = remaining % 60;
    double hourHand = totalSeconds / 120;
    double minuteHand = totalSeconds * 0.1 % 360;
    double innerAngle = Math.abs(minuteHand - hourHand);

    return innerAngle;
  }

  public static Boolean closeAngle(double current, double halfAngle, double enteredAngle) {

    if (enteredAngle > current && enteredAngle < current + halfAngle){
      return true;
    }
    else if (enteredAngle < current && enteredAngle > current - halfAngle){
      return true;
    }
    else {
      return false;
    }
  }

  public static void main (String [] args){

    double timeslice = 60;
    if (args.length == 2) {
      timeslice = Double.parseDouble(args[1]);
    }

    double enteredAngle = Double.parseDouble(args[0]);
    double currentAngle = 0.0;
    String output = "";

    Clock c = new Clock (0, 0, 0.0, timeslice);
    double totalSeconds = c.getSecondsPassed();
    double halfAngle = (getAngle(timeslice))/ 2;

    while (totalSeconds < 43200) {   // seconds in 12 hours
      currentAngle = getAngle(totalSeconds);
      double reverseAngle = (360 - currentAngle);

      if (currentAngle == enteredAngle || reverseAngle == enteredAngle || closeAngle(currentAngle, halfAngle, enteredAngle) == true || closeAngle(reverseAngle, halfAngle, enteredAngle) == true ){
        output += c.toString() + "\n";
      }
      else{
      }
      c.tick();
      totalSeconds += timeslice;
    }
    System.out.println(output);
  }
}
