package Epam;

import java.util.Date;

final public class Immutable{
    private final int anInt;
    private final String string;
    private final Date date;
    private final int[] ints;
    private final Object[] objects;

    public Immutable(final int anInt, final String string, final int[] ints, final Object[] objects, final Date date){
        this.anInt = anInt;
        this.string = string;
        this.ints = ints;
        this.objects = objects;
        this.date = date;
    }

    public int getAnInt(){
        return anInt;
    }

    public String getString(){
        return string;
    }

    public Object getDate(){
        return date.clone();
    }

    public int[] getInts(){
        return ints.clone();
    }

    public Object[] getObjects(){
        return objects.clone();
    }

}
