package edu.vanderbilt.riaps;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.ErrorManager;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class Console {
	private static Console instance = null;
	private MessageConsole mconsole = null;
	private MessageConsoleStream mstream = null;
	static private FileHandler fileHTML;
	static private Formatter formatterHTML;

	protected Console(Boolean ineclipse ) {
		
		if(!ineclipse)
			return;
		
		String name = "RIAPS";

		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				mconsole = (MessageConsole) existing[i];
				break;
			}
		}
		// no console found, so create a new one
		if (mconsole == null) {
			mconsole = new MessageConsole("RIAPS", null);
			conMan.addConsoles(new IConsole[] { mconsole });
		}
		mstream = mconsole.newMessageStream();
		return;
	}

	
	public static synchronized Console getHeadlessInstance() {
		if (instance == null) {
			instance = new Console(false);
		}
		return instance;
	}

	
	public static synchronized Console getInstance() {
		if (instance == null) {
			instance = new Console(true);
		}
		return instance;
	}

	public void log(java.util.logging.Level level, String m) {
		if(mstream!=null)
		{
			mstream.println(m);
			
		}
		else
		{
			System.console().writer().println(m);
			
		}
		
	}
}
