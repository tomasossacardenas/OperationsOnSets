package model;
import java.util.*;
import java.util.ArrayList;
public class MathApp{
	//atributes
	private int amount;
	//relations
	public ArrayList<IntegerSet>conjuntos;

	public MathApp(){
		amount=0;
		conjuntos=new ArrayList<IntegerSet>();
	}
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount){
		this.amount=amount;
	}
	public void addSet(String name){
		IntegerSet conjuntox= returnConjunto(name);
		if (conjuntox==null){
			conjuntos.add(new IntegerSet(name));
			setAmount(getAmount()+1);
		}
	}
	public void removeSet(String name){
		IntegerSet conjuntox= returnConjunto(name);
		if (conjuntox!=null){
			conjuntos.remove(conjuntox);
			setAmount(getAmount()-1);		
		}
	}
	public void addElementToSet(String name, int element){
		IntegerSet conjuntox=returnConjunto(name);
		if (conjuntox!=null){
			conjuntox.addElement(element);
			conjuntox.setCardinalidad(conjuntox.getCardinalidad()+1);
		}
	}
	public void removeElementFromSet(String name, int element){
		IntegerSet conjuntox=returnConjunto(name);
		if (conjuntox!=null){
			conjuntox.removeElement(element);
			conjuntox.setCardinalidad(conjuntox.getCardinalidad()-1);
		}
	}
	public IntegerSet returnConjunto(String name){
		IntegerSet conjuntox=null;
		boolean salir=false;
		for(int i=0;i<conjuntos.size() && salir==false;i++){
			if (conjuntos.get(i).getName().equals(name)){
				conjuntox=conjuntos.get(i);
				salir=true;
			}
			
		}

		return conjuntox;
	}
	public String showConjuntos(){
		String mensaje="";
		for(int i=0;i<conjuntos.size();i++){
			mensaje=conjuntos.get(i).getName();
		}
		return mensaje;
	}
	public void union(String name1, String name2, String newName){
		IntegerSet union=returnConjunto(newName);
		IntegerSet conjunto1=returnConjunto(name1);
		IntegerSet conjunto2=returnConjunto(name2);

		if(conjunto1!=null && conjunto2!=null && union==null){
			union=conjunto1.union(conjunto2, newName);
			conjuntos.add(union);
			union.setCardinalidad(union.getElements().size());
			setAmount(getAmount()+1);
		}
	}
	public void intersection(String name1, String name2, String newName){
		IntegerSet interseccion=returnConjunto(newName);
		IntegerSet conjunto1=returnConjunto(name1);
		IntegerSet conjunto2=returnConjunto(name2);

		if(conjunto1!=null && conjunto2!=null && interseccion==null){
			interseccion=conjunto1.intersection(conjunto2, newName);
			conjuntos.add(interseccion);
			interseccion.setCardinalidad(interseccion.getElements().size());
			setAmount(getAmount()+1);
		}
	}
	public void difference(String name1, String name2, String newName){
		IntegerSet diferencia=returnConjunto(newName);
		IntegerSet conjunto1=returnConjunto(name1);
		IntegerSet conjunto2=returnConjunto(name2);

		if(conjunto1!=null && conjunto2!=null && diferencia==null){
			diferencia=conjunto1.diference(conjunto2, newName);
			conjuntos.add(diferencia);
			diferencia.setCardinalidad(diferencia.getElements().size());
			setAmount(getAmount()+1);
		}
	}
	public void symetricDifference(String name1, String name2, String newName){
		IntegerSet diferencia=returnConjunto(newName);
		IntegerSet conjunto1=returnConjunto(name1);
		IntegerSet conjunto2=returnConjunto(name2);

		if(conjunto1!=null && conjunto2!=null && diferencia==null){
			diferencia=conjunto1.simetricDiference(conjunto2, newName);
			conjuntos.add(diferencia);
			diferencia.setCardinalidad(diferencia.getElements().size());
			setAmount(getAmount()+1);
		}
	}
	public String showInfoSet(String name){
		String mensaje;
		IntegerSet conjunto=returnConjunto(name);
		if(conjunto!=null){
			mensaje=conjunto.showContents();
		}
		else{
			mensaje="El conjunto "+name+" no se encontro";
		}
		return mensaje;
	}
	public String showInfoSets(int i){
		String message="";
		if (conjuntos.get(i)!=null){
			message=conjuntos.get(i).showContents();
			
		}
		return message;
	}

}
