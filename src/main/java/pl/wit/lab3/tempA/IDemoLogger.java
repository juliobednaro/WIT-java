package pl.wit.lab3.tempA;

import org.apache.logging.log4j.Logger;

public interface IDemoLogger {
	/**
	 * Zwraca loggera klasy pochodnej
	 * @return
	 */
	public Logger getLogger();
	/**
	 * Domyślna implementacja logowania w trybie trace
	 * @param message
	 * @param additionalInfo
	 * @param e
	 */
	public default void logTrace(String message,String additionalInfo,Throwable e){
		if(this.getLogger().isTraceEnabled()&&message!=null){
			message = additionalInfo!=null?message.concat(additionalInfo):message;
			if(e!=null)
				this.getLogger().trace(message,e);
			else
				this.getLogger().trace(message);
		}
	}
	public default void logTrace(String message){
		logTrace(message,getAdditionalInfo(),null);
	}
	
	/**
	 * Domyślna implementacja w trybie debug
	 * @param message
	 * @param additionalInfo
	 * @param e
	 */
	public default void logDebug(String message,String additionalInfo,Throwable e){
		if(this.getLogger().isDebugEnabled()&&message!=null){
			message = additionalInfo!=null?message.concat(additionalInfo):message;
			if(e!=null)
				this.getLogger().debug(message,e);
			else
				this.getLogger().debug(message);
		}
	}
	public default void logDebug(String message){
		logDebug(message,getAdditionalInfo(),null);
	}
	/**
	 * Domyślna implementacja w trybie info
	 * @param message
	 * @param additionalInfo
	 * @param e
	 */
	public default void logInfo(String message,String additionalInfo,Throwable e){
		if(this.getLogger().isInfoEnabled()&&message!=null){
			message = additionalInfo!=null?message.concat(additionalInfo):message;
			if(e!=null)
				this.getLogger().info(message,e);
			else
				this.getLogger().info(message);
		}
	}
	public default void logInfo(String message){
		logInfo(message,getAdditionalInfo(),null);
	}
	/**
	 * Domyślna implementacja w trybie error
	 * @param message
	 * @param additionalInfo
	 * @param e
	 */
	public default void logError(String message,String additionalInfo,Throwable e){
		if(message!=null){
			message = additionalInfo!=null?message.concat(additionalInfo):message;
			if(e==null)
				this.getLogger().error(message);
			else
				this.getLogger().error(message,e);
		}
	}
	public default void logError(String message){
		logError(message,getAdditionalInfo(),null);
	}
	/**
	 * Domyslna implementacja w trybie fatal
	 * @param message
	 * @param additionalInfo
	 * @param e
	 */
	public default void logFatal(String message,String additionalInfo,Throwable e){
		if(message!=null){
			message = additionalInfo!=null?message.concat(additionalInfo):message;
			if(e==null)
				this.getLogger().fatal(message);
			else
				this.getLogger().fatal(message,e);
		}
	}
	public default void logFatal(String message){
		logFatal(message,getAdditionalInfo(),null);
	}
	
	public String getAdditionalInfo();
}
