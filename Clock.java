public class Clock {
  private double timeslice;
  private double secondsPassed;

  public Clock (int hours, int minutes, double seconds, double timeslice){
    //throw out invalid entries
    if (hours < 0 | hours > 12 | minutes < 0 | minutes > 60 | seconds < 0 | seconds > 60 | timeslice < 0 | timeslice > 1800.00){
      throw new IllegalArgumentException();
    }
    else {
      this.timeslice = timeslice;
      this.secondsPassed = ((hours * 3600) + (minutes * 60) + seconds);
    }
  }

  public void tick(){
    this.secondsPassed += this.timeslice;
    }

  public int getHours(){
    return (int) this.secondsPassed / 3600;
  }

  public int getMinutes(){
    double extra = this.secondsPassed % 3600;
    return (int) extra / 60;
  }

  public double getSeconds(){
    double extra = this.secondsPassed % 3600;
    return extra % 60;
  }

  public double getSecondsPassed(){
    return this.secondsPassed;
  }

  public String toString(){
    double hours = this.secondsPassed / 3600;
    double leftover = this.secondsPassed % 3600;
    double minutes = leftover / 60;
    double seconds = leftover % 60;
    return ( (int) hours + ":" + (int) minutes + ":" + (double) seconds);
  }

  public static void main (String[] args){

  }
}
