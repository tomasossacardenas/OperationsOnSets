package model;
import java.util.*;
import java.util.ArrayList;
public class IntegerSet{
	//atributes
	private String name;
	private int cardinalidad;
	private ArrayList<Integer>elements;

	public IntegerSet(String name){
		this.name=name;
		cardinalidad=0;
		elements=new ArrayList<Integer>();
	}
	public String getName(){
		return name;
	}
	public int getCardinalidad(){
		return cardinalidad;
	}
	public void setCardinalidad(int cardinalidad){
		this.cardinalidad=cardinalidad;
	}
	public ArrayList getElements(){
		return elements;
	}
	public void addElement(int element){
		if(elements.contains(element)==false){
			elements.add(element);
		}
	}
	public void removeElement(int element){
		if(elements.contains(element)==true){
			elements.remove(String.valueOf(element));
		}
	}
	public IntegerSet union(IntegerSet conjunto2, String newName){
		IntegerSet union=new IntegerSet(newName);

		for(int i=0;i<getCardinalidad();i++){
			union.getElements().add(getElements().get(i));
		}

		for(int i=0;i<conjunto2.getCardinalidad();i++){
			union.getElements().add(conjunto2.getElements().get(i));
		}
		//ESTE FOR SIRVE PARA ELIMINAR ELEMENTOS REPETIDOS EN EL ARRAYLIST QUE SURGIO EN LA UNION
		for(int i=0;i<getCardinalidad();i++){
			int element=(int)getElements().get(i);//ELEMENT ES CADA UNO DE LOS ELEMENTOS DEL PRIMER CONJUNTO
			for(int e=0;e<conjunto2.getCardinalidad();e++){//PARA CADA ELEMENTO DEL CONJUNTO 1 SE EVALÚA SI HAY ALGUN ELEMENTO IGUAL EN EL CONJUNTO 2
				if (element==(int)conjunto2.getElements().get(e)){
					union.getElements().remove(union.getElements().lastIndexOf(element));//SI HAY UN ELEMENTO IGUAL ENTONCES LO ELIMINO DE LA ARRAYLIST DE UNION
				}
			}
		}
		return union;	
	}
	public IntegerSet intersection(IntegerSet conjunto2, String newName){
		IntegerSet interseccion=new IntegerSet(newName);

		for(int i=0;i<getCardinalidad();i++){
			int element=(int)getElements().get(i);
			for(int e=0;e<conjunto2.getCardinalidad();e++){
				if (element==(int)conjunto2.getElements().get(e)){
					interseccion.getElements().add(element);
				}
			}
		}
		return interseccion;
	}
	public IntegerSet diference(IntegerSet conjunto2, String newName){
		IntegerSet diferencia=new IntegerSet(newName);

		for(int i=0;i<getCardinalidad();i++){
			diferencia.getElements().add(getElements().get(i));
		}
		for(int i=0;i<getCardinalidad();i++){
			int element=(int)getElements().get(i);
			for(int e=0;e<conjunto2.getCardinalidad();e++){
				if (element==(int)conjunto2.getElements().get(e)){
					diferencia.getElements().remove(i);
				}
			}
		
		}
		return diferencia;
	}
	public IntegerSet simetricDiference(IntegerSet conjunto2, String newName){
		IntegerSet diferencia=new IntegerSet(newName);

		diferencia=union(conjunto2, newName);

		for(int i=0;i<getCardinalidad();i++){
			int element=(int)getElements().get(i);//ELEMENT ES CADA UNO DE LOS ELEMENTOS DEL PRIMER CONJUNTO
			for(int e=0;e<conjunto2.getCardinalidad();e++){//PARA CADA ELEMENTO DEL CONJUNTO 1 SE EVALÚA SI HAY ALGUN ELEMENTO IGUAL EN EL CONJUNTO 2
				if (element==(int)conjunto2.getElements().get(e)){
					diferencia.getElements().remove(i);
				}
			}
		}
		return diferencia;
	}
	public String showContents(){
		String mensaje;
		mensaje="** Nombre: "+getName()+"\n"+
				"** Cardinalidad: "+getCardinalidad()+"\n"+
				"** Elementos: "+getElements();
		return mensaje;
	}

}