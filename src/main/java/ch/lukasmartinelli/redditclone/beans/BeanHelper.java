package ch.lukasmartinelli.redditclone.beans;

import javax.faces.context.FacesContext;

public class BeanHelper {
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
}
