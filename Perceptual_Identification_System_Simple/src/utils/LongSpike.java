/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axeladn
 */
public class LongSpike<T> implements Serializable{

	private T value;
	private int timing;

	public LongSpike(T value0, int timing0) {
		this.timing = timing0;
		this.value = value0;
	}

	public T getValue() {
		return this.value;
	}
	
	public T getIntensity(){
		return this.getValue();
	}

	public int getTiming() {
		return this.timing;
	}

	public LongSpike(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bStream = new ByteArrayInputStream(bytes);
		ObjectInputStream oStream = new ObjectInputStream(bStream);
		LongSpike spikeAux = (LongSpike) oStream.readObject();
		this.timing = spikeAux.getTiming();
		this.value = (T) spikeAux.getValue();
	}

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();

		ObjectOutputStream oStream = new ObjectOutputStream(bStream);
		oStream.writeObject(this);

		return bStream.toByteArray();
	}

}
