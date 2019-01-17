public class Tuple{

    private int[] tuple;
    private int tupleLength;

    //#1
    public Tuple(int k){
        this.tupleLength = k;
        this.tuple = new int[this.tupleLength];

        for (int count = 0; count < tuple.length; count++){
            this.tuple[count] = 0;
        }
    }

    // #2
    public Tuple(int[] data){
        this.tupleLength = data.length;
        this.tuple = new int[this.tupleLength];

        for(int count = 0; count < tuple.length; count++){
            this.tuple[count] = data[count];
        }
    }


    // #3
   public static Tuple makeTupleFromData (int[] data){
       Tuple result = new Tuple(data);
       return (result);
   }


    // #4
    public Tuple add(Tuple t){
        if (this.tuple.length == t.tuple.length){
            Tuple finalTuple = new Tuple(this.tuple.length);
            for(int count = 0; count < t.tuple.length; count++){
                finalTuple.setElement(count, this.tuple[count] + t.getElement(count));
            }
            return (finalTuple);
        }
        else{
            throw new IllegalArgumentException("Tuples must be the same length");
        }
    }


    // #5
    public Tuple clone(){
        Tuple finalTuple = new Tuple(this.tuple.length);
        for(int count = 0; count < tuple.length; count++){
            finalTuple.setElement(count, tuple[count]);
        }
        return (finalTuple);
    }


    // #6
    public boolean equals (Object obj){
       if (obj instanceof Tuple){
           Tuple objTuple = (Tuple)obj;

           if(objTuple.tuple.length == this.tuple.length){
               for (int count = 0; count < tuple.length; count++){
                   if(objTuple.getElement(count) != tuple[count]){
                       return false;
                   }
                   return true;
               }
           }
           return false;
       }
        return false;
    }

    // #7
    public int getElement (int i){
        if (i < 0 || i > this.tuple.length){
            throw new IllegalArgumentException();
        }
        else{
            return this.tuple[i];
        }
    }

    // #8
    public void setElement (int i, int value){
        if (i < 0 || i > this.tuple.length){
            throw new IllegalArgumentException();
        }
        else{
            this.tuple[i] = value;
        }
    }

    // #9
    public int length(){
        int tupleLength = this.tuple.length;
        return (tupleLength);
    }

    // #10
    public int sum(){
        int sumOfTuple = 0;
        for(int count = 0; count < tuple.length; count++){
            sumOfTuple += this.tuple[count];
        }
        return (sumOfTuple);
    }

    // #11
    public String toString(){
        String output = "[";
        for (int count = 0; count < tuple.length; count++) {
            output += (count > 0 ? "," : "") + this.tuple[count];
        }
        return (output + "]");
    }
}
