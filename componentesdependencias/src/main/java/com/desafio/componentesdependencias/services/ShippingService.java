package com.desafio.componentesdependencias.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

	public Double shippement(Double valorBasico) {

		if (valorBasico < 100.0) {
			return 20.0;
		} else if (valorBasico >= 100.00 && valorBasico < 200.00) {
			return 12.00;
		} else {
			return 0.0;
		}
	}

}
