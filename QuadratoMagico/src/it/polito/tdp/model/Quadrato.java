package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Quadrato {

	int n;
	int magic;
	List<Integer> matrice;

	public Quadrato(int n) {
		this.n = n;
		this.magic = n * (n * n + 1) / 2;
		this.matrice = new ArrayList<Integer>();
	}

	public Quadrato(Quadrato q) {
		this.n = q.n;
		this.magic = q.magic;
		this.matrice = new ArrayList<Integer>(q.getMatrice());
	}
	
	private boolean checkRows() {
		for (int i = 0; i< n; i++) {
			int somma = 0;
			for (int j = 0; j < n; j++) {
				somma += matrice.get(i*n+j);
			}
			if (somma != magic) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkColumns() {
		for (int j = 0; j < n; j++) {
			int somma = 0;
			for (int i = 0; i< n; i++) {
				somma += matrice.get(i*n+j);
			}
			if (somma != magic) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkMainDiagonal() {
		int somma = 0;
		for (int i = 0; i < n; i ++) {
			somma += this.matrice.get(i*n+i);
		}
		if (somma != magic) {
			return false;
		}
		return true;
	}
	
	private boolean checkSecondaryDiagonal() {
		int somma = 0;
		for (int i = 0; i < n; i ++) {
			somma += this.matrice.get(i*n+n-1-i);
		}
		if (somma != magic) {
			return false;
		}
		return true;
	}
	
	private boolean checkDiagonals() {
		return checkMainDiagonal() & checkSecondaryDiagonal();
	}
	
	public boolean isValid() {
		// quadrato e' una soluzione valida
		return checkRows() & checkColumns() & checkDiagonals();
	}
	
	public boolean contains(int i) {
		return this.matrice.contains(i);
	}
	
	public void add(int i) {
		this.matrice.add(i);
	}
	
	public void remove(int i) {
		this.matrice.remove(Integer.valueOf(i));
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public List<Integer> getMatrice() {
		return matrice;
	}

	public void setMatrice(List<Integer> matrice) {
		this.matrice = matrice;
	}

	@Override
	public String toString() {
		return this.matrice.toString();
	}
	
	
}
