package com.bancolombia.soporte.finacle.screenplay.tasks;

public class palabra {

	public static void main(String[] args) {

		String palabraabuscar = "<MessageDateTime>";
		String loQueQuieroBuscar = "<MessageDateTime>";
		String letra2 = "";

		if (loQueQuieroBuscar.indexOf(palabraabuscar) != -1) {

			int index = loQueQuieroBuscar.indexOf(palabraabuscar);

			for (int i = index + 8; i <= 50; i++) {
				String letra = loQueQuieroBuscar.substring(i, i + 1);

				if (letra.equals("<")) {

					i = 51;
					
				} else {

					letra2 = letra2 + letra;
				}

			}
			System.out.println(letra2);

		}

	}

}
