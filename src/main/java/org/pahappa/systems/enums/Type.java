package org.pahappa.systems.enums;

public enum Type {

	RED_FLAG("Red Flag"),
	INTERVENTION("Intervention");

	private String label;

	Type(String uiName){
		label=uiName;

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
