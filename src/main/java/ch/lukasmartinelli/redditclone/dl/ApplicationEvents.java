package ch.lukasmartinelli.redditclone.dl;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class ApplicationEvents implements SystemEventListener{

	@Override
	public boolean isListenerForSource(Object value) {
		//only for Application
	      return (value instanceof Application);
	}

	public boolean firstStart = true;
	public boolean firstEnd = true;
	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		try{
		      if(event instanceof PostConstructApplicationEvent){
		    	  if(firstStart) {
			    	  DataManager.deserializeX();
			          System.out.println("Application Started. PostConstructApplicationEvent occurred!");
			          firstStart = false;
		    	  }
		      }
		      if(event instanceof PreDestroyApplicationEvent){
		    	  if(firstEnd) {
		    		  DataManager.serializeX();
		    		  System.out.println("PreDestroyApplicationEvent occurred. Application is stopping.");
		    		  firstEnd = false;
		    	  }
		       }
		       System.out.println(DataManager.getData().reddits.size());
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
