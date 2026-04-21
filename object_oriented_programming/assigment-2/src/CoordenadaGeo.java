public class CoordenadaGeo {

    private double longitude;
    private double latitude;
    
    //Constructor
    public CoordenadaGeo(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getters
    public static double getLatitude(CoordenadaGeo cords)
    {
        return cords.latitude;
    }

     public static double getLongitude(CoordenadaGeo cords)
    {
        return cords.longitude;
    }

    public static CoordenadaGeo getCoordenadas(CoordenadaGeo cords)
    {
        return cords;
    }  

    //Setters
    public void setLatitude(double latitude)
    {
        if (latitude>=-90 && latitude <= 90)
            this.latitude = latitude;
    }

    public  void setLongitude(double longitude)
    {
        if (longitude>=-180 && longitude <= 180)
            this.longitude = longitude;
    }

    public  void setCords(double latitude, double longitude)
    {
        setLatitude(latitude);
        setLongitude(longitude);
    }
    
    // Devolve as cords em string.
    public static String toString(CoordenadaGeo cords)
    {
        return "(" + cords.latitude +", "+ cords.longitude +")";
    }

    public static boolean isNorte(CoordenadaGeo cords)
    {
        if(cords.latitude>0)
            return true;
        else
            return false;
    }

    public static boolean isSul(CoordenadaGeo cords)
    {
        if(cords.latitude<0)
            return true;
        else
            return false;
    }

    public static double fusoHorario(CoordenadaGeo cords)
    {
        //15º=1hr
        return cords.longitude/15;

    }

    //distanciaPara -> retorna em kms a distancia entre duas coords (formula toda lixada)
    public static void distanciaPara()
    {
        
    }


}
