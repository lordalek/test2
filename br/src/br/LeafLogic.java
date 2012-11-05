package br;

import java.awt.Color;


public class LeafLogic {
	private final int sizeOfTree = 6;
	private Integer[] arrayOfValues;
	private Color color = Color.BLUE;
	public LeafLogic(){
		generateRandomValuesForNodes();

	}

	private void generateRandomValuesForNodes(){
		arrayOfValues = new Integer[sizeOfTree];
		for(int i = 0; i < sizeOfTree; i++){
			Integer value = new Integer((int) (Math.random()*1000)+1);
			arrayOfValues[i] = value;
		}
	}


	
	public Integer[] getNumbers(){
		return arrayOfValues;
	}
	
	public int getSize(){
		return sizeOfTree;
	}
	
	public boolean checkIfLeavesAreMarked(GraphicNode[] nodes){
		if(nodes[2].getColor() == color && nodes[3].getColor() == color && nodes[5].getColor() == color && nodes[0].getColor() != color
				&& nodes[1].getColor() != color && nodes[4].getColor() != color){
			return true;
		}
		else return false;
	}
}
