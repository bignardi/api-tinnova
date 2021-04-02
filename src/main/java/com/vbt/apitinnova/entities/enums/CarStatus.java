package com.vbt.apitinnova.entities.enums;

public enum CarStatus {

	SOLD(true), UNSOLD(false);

	private boolean status;

	// Contrutor para tipos booleanos, no caso a verificação dos enums
	private CarStatus(Boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public static CarStatus valueOf(boolean status) {
		for (CarStatus value : CarStatus.values()) {
			if (value.getStatus() == status) {
				return value;
			}
		}

		// Caso o code procurado do enum seja inválido ou inexistente
		throw new IllegalArgumentException("Invalid CarStatus code!");
	}
}
