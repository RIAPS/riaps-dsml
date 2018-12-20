package edu.vanderbilt.riaps

import java.io.IOException
import java.util.logging.ConsoleHandler
import java.util.logging.ErrorManager
import java.util.logging.FileHandler
import java.util.logging.Formatter
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import java.util.logging.SimpleFormatter
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsole
import org.eclipse.ui.console.IConsoleManager
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.MessageConsoleStream

class Console {
	static Console instance = null
	MessageConsole mconsole = null
	MessageConsoleStream mstream = null
	static FileHandler fileHTML
	static Formatter formatterHTML

	protected new(Boolean ineclipse_finalParam_) {
		var ineclipse = ineclipse_finalParam_
		if(!ineclipse) return;
		var String name = "RIAPS"
		var ConsolePlugin plugin = ConsolePlugin.getDefault()
		var IConsoleManager conMan = plugin.getConsoleManager()
		var IConsole[] existing = conMan.getConsoles()
		if(mconsole !== null) return;
		for (var int i = 0; i < existing.length; i++) {
			if (name.equals({
				val _rdIndx_existing = i
				existing.get(_rdIndx_existing)
			}.getName())) {
				mconsole = { 
					val _rdIndx_existing = i
					existing.get(_rdIndx_existing)
				} as MessageConsole // break;
			}
		}
		// no console found, so create a new one
		if (mconsole === null) {
			mconsole = new MessageConsole("RIAPS", null)
			conMan.addConsoles(#[mconsole])
		}
		mstream = mconsole.newMessageStream()
		return;
	}

	def static synchronized Console getHeadlessInstance() {
		if (instance === null) {
			instance = new Console(false)
		}
		return instance
	}

	def static synchronized Console getInstance() {
		if (instance === null) {
			instance = new Console(true)
		}
		return instance
	}

	def void log(java.util.logging.Level level, String m) {
		if (mstream !== null) {
			mstream.println(m)
		} else {
			System.console().writer().println(m)
		}
	}
}
