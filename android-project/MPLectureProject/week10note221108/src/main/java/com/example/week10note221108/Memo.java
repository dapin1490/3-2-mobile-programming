package com.example.week10note221108;

public class Memo {
	private long id;
	private String str;

	public Memo(long id, String str) {
		this.id = id;
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}
