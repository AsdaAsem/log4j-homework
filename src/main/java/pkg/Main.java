package pkg;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final Marker TWINKLE = MarkerManager.getMarker("TWINKLE,TWINKLE");
    private static final Marker WONDER = MarkerManager.getMarker("WONDER");


    public static void main(String[] args) {

            String lyrics = """
                        Twinkle, twinkle, little star,
                        How I wonder what you are,
                        Up above the world so high,
                        Like a diamond in the sky, twinkle, twinkle, little star,
                        How I wonder what you are.        
                        Twinkle, twinkle, little star,
                        How I wonder what you are,
                        Up above the world so high,
                        Like a diamond in the sky, twinkle, twinkle, little star,
                        How I wonder what you are.
                    """;

            for(int i=0; i< Integer.parseInt(args[0]); i++){
                ThreadContext.push(String.valueOf(i));

                logger.info("Like a diamond in the sky");
                logger.debug(TWINKLE,"Up above the world so high,");
                logger.fatal(WONDER, "Twinkle, twinkle, little star");
                logger.error("How I wonder what you are.");

                ThreadContext.clearAll();

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }



        }


    }

}
