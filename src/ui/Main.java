package ui;
import model.MathApp;
import java.util.*;
import java.util.ArrayList;
public class Main{
public static Scanner entrada = new Scanner(System.in);
	public static void main (String[] args){
		MathApp mathApp= new MathApp();
		showMenu();
		chooseMenuOption(mathApp);
	}

	public static void createConjunto(MathApp mathApp){
		String mensaje;
		System.out.println("Ingrese el Nombre del conjunto");
		String name=entrada.nextLine();
		mathApp.addSet(name);
	}
	public static void removeConjunto(MathApp mathApp){
		System.out.println("Ingrese el Nombre del conjunto a eliminar");
		String name=entrada.nextLine();
		mathApp.removeSet(name);
	}
	public static void addElementToConjunto(MathApp mathApp){
		System.out.println("Ingrese el Nombre del conjunto");
		String name=entrada.nextLine();
		System.out.println("Ingrese el numero que desea añadir al conjunto "+name);
		int element=entrada.nextInt();entrada.nextLine();
		mathApp.addElementToSet(name, element);
	}
	public static void removeElementOfConjunto(MathApp mathApp){
		System.out.println("Ingrese el Nombre del conjunto");
		String name=entrada.nextLine();
		System.out.println("Ingrese el numero que desea eliminar del conjunto "+name);
		int element=entrada.nextInt();entrada.nextLine();
		mathApp.removeElementFromSet(name, element);
	}
	public static void showMenu(){
		System.out.println("");
		System.out.println("Digite el numero de la actividad que desea realizar: \n 1. Crear un conjunto \n 2. Mostrar conjuntos \n 3. Eliminar un conjunto\n 4. Añadir elemento a un conjunto\n 5. Eliminar elemento de un conjunto \n 6. Union entre dos conjuntos\n 7. Interseccion entre dos conjuntos\n 8. Diferencia entre dos conjuntos\n 9. Diferencia Simetrica entre dos conjuntos\n 10. Conocer informacion de un conjunto \n 11. Mostrar informacion de todos los conjuntos");
	} 
	public static void chooseMenuOption(MathApp mathApp){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
				createConjunto(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 2:
				showConjuntos(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 3:
				removeConjunto(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 4:
				addElementToConjunto(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 5:
				removeElementOfConjunto(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 6:
				unionEntreConjuntos(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 7:
				interseccionEntreConjuntos(mathApp);
				showMenu();
				chooseMenuOption(mathApp);		
				break;
			case 8:	
				diferenciaEntreConjuntos(mathApp);
				showMenu();
				chooseMenuOption(mathApp);		
				break;
			case 9:
				diferenciaSimetricaEntreConjuntos(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;	
			case 10:
				showInfo(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;
			case 11:
				showAllInfo(mathApp);
				showMenu();
				chooseMenuOption(mathApp);
				break;							
		}
	}
	public static void unionEntreConjuntos(MathApp mathApp){
		ArrayList union=new ArrayList();
		System.out.println("Ingrese el Nombre del primer conjunto");
		String name1=entrada.nextLine();
		System.out.println("Ingrese el Nombre del segundo conjunto");
		String name2=entrada.nextLine();
		System.out.println("Ingrese el Nombre del conjunto que se generara a partir de la union de "+name1+" y "+name2);
		String newName=entrada.nextLine();
		mathApp.union(name1, name2, newName);
		System.out.println("La union entre los conjuntos "+name1+" y "+name2+" es "+ mathApp.returnConjunto(newName).getElements());
	}
	public static void interseccionEntreConjuntos(MathApp mathApp){
		ArrayList interseccion=new ArrayList();
		System.out.println("Ingrese el Nombre del primer conjunto");
		String name1=entrada.nextLine();
		System.out.println("Ingrese el Nombre del segundo conjunto");
		String name2=entrada.nextLine();
		System.out.println("Ingrese el Nombre del conjunto que se generara a partir de la interseccion de "+name1+" y "+name2);
		String newName=entrada.nextLine();
		mathApp.intersection(name1, name2, newName);
		System.out.println("La interseccion entre los conjuntos "+name1+" y "+name2+" es "+mathApp.returnConjunto(newName).getElements());
	}
	public static void diferenciaEntreConjuntos(MathApp mathApp){
		ArrayList diferencia=new ArrayList();
		System.out.println("***  Recuerde que la diferencia entre dos conjuntos A y B esta dado por la operacion A-B");
		System.out.println("Ingrese el Nombre del primer conjunto (A)");
		String name1=entrada.nextLine();
		System.out.println("Ingrese el Nombre del segundo conjunto (B)");
		String name2=entrada.nextLine();
		System.out.println("Ingrese el Nombre del conjunto que se generara a partir de la interseccion de "+name1+" y "+name2);
		String newName=entrada.nextLine();
		mathApp.difference(name1, name2, newName);
		System.out.println("La diferencia dada por la operacion "+name1+"-"+name2+" es "+mathApp.returnConjunto(newName).getElements());
	}
	public static void diferenciaSimetricaEntreConjuntos(MathApp mathApp){
		ArrayList diferencia=new ArrayList();
		System.out.println("Ingrese el Nombre del primer conjunto");
		String name1=entrada.nextLine();
		System.out.println("Ingrese el Nombre del segundo conjunto");
		String name2=entrada.nextLine();
		System.out.println("Ingrese el Nombre del conjunto que se generara a partir de la interseccion de "+name1+" y "+name2);
		String newName=entrada.nextLine();
		mathApp.symetricDifference(name1, name2, newName);
		System.out.println("La diferencia Simetrica entre los conjuntos "+name1+" y "+name2+" es "+mathApp.returnConjunto(newName).getElements());
	}
	public static void showInfo(MathApp mathApp){
		System.out.println("Ingrese el nombre del conjunto del cual desea conocer la informacion");
		String name = entrada.nextLine();
		System.out.println(mathApp.showInfoSet(name));
	}
	public static void showAllInfo(MathApp mathApp){
		for(int i=0;i<mathApp.getAmount();i++){
			if(mathApp.showInfoSets(i)!=""){
			System.out.println(mathApp.showInfoSets(i));
			}
		}
	}

	public static void showConjuntos(MathApp mathApp){
		System.out.println(mathApp.showConjuntos());
	}

}