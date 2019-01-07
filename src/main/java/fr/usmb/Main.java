package fr.usmb;

public class Main {

    public static void main(String[] args)  {
        if(args.length == 2) {
            AppProperties.initProperties(args[0], args[1]);
            todaysBirthdayMessagesSender sender = new todaysBirthdayMessagesSender();
            sender.sendAll();
        }
        else{
            throw new IllegalArgumentException("Missing parameters : CSV_File configuration.properties");
        }
    }

}
