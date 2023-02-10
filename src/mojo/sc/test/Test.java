package mojo.sc.test;

import java.util.ArrayList;
import java.util.List;

import mojo.sc.bo.PlantRegrowable;
import mojo.sc.bo.Plante;


public class Test {

	public static void main(String[] args) {
		
		List<Plante> plantes = new ArrayList<>();
		
		plantes.add(new Plante(1, "Panais", 2, 5, 6, 8));
		plantes.add(new PlantRegrowable(2, "Fraise", 2, 5, 6, 8));
		plantes.add(new Plante(3, "Radis", 2, 5, 6, 8));
		plantes.add(new Plante(4, "Carotte", 2, 5, 6, 8));
		plantes.add(new Plante(5, "Melon", 2, 5, 6, 8));
		
		System.out.println(plantes.toString());

	}

}
