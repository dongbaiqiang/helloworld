package zz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class ApplicationMain {
 //final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

	  static Logger log = LoggerFactory.getLogger(ApplicationMain.class);

	    public static void main(String[] args) {
	        log.info("hello world.");
  }
}



