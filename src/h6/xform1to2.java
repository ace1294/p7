package h6;

import PrologDB.*;
import java.io.PrintStream;


public class xform1to2 {
    public static void main(String... args) throws Exception {
        if (args.length !=2 || !args[0].endsWith(".sol1.pl") || !args[1].endsWith(".sol2.pl")) {
            System.err.format("Usage: %s <name>.sol1.pl <name>.sol2.pl\n", xform1to2.class.getName());
            System.err.format("       converts .sol1 database into sol2 database\n");
            return;
        }
        
        DB db1 = DB.readDataBase(args[0]);
        DBSchema sol2 = DBSchema.readSchema("Correct/sol2.schema.pl");
        
        Table token = db1.getTableEH("token");
        Table place = db1.getTableEH("place");
        Table tbox  = db1.getTableEH("tbox");
        Table arc   = db1.getTableEH("arc");
        
        DB db2 = new DB("p1",sol2);
        Table plc = db2.getTableEH("place");
        Table tbx = db2.getTableEH("tbox");
        Table ark = db2.getTableEH("arc");
        
        // translate place table -- first copy the unchanging stuff

        // translate tbox table -- same as before
        
        // translate arc table -- same as before
       
        db2.print(new PrintStream(args[1]));
    }
  
}
