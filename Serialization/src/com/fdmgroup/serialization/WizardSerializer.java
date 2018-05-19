package com.fdmgroup.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WizardSerializer {

	private String fileName;

	public WizardSerializer(String fileName) {
		this.fileName = fileName;
	}

	public void serialize(Wizard wizard) {
		File file = new File(this.fileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			oos.writeObject(wizard);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Wizard deserialize() {
		Wizard deserializedGame = null;

		File file = new File(this.fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Object readObject = ois.readObject();
			if (readObject instanceof Wizard) {
				deserializedGame = (Wizard) readObject;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return deserializedGame;
	}
}