package com.server;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Operation extends ConnectionTCPServer {

	public Operation(int serverPort) throws IOException {
		super(serverPort);

	}

	public void operationCalculator() {
		try {
			String data = this.in.readUTF();
			// String data = "1+2*4/2";
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			Integer hasil = (Integer) engine.eval(data);
			this.out.writeUTF(String.valueOf(hasil));
		} catch (Exception e) {

		}
	}

	public void init() {
		while (true) {
			this.Connection();
			this.operationCalculator();
		}
	}

}
